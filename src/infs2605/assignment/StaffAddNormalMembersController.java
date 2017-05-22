/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infs2605.assignment;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author paulstrasser
 */
public class StaffAddNormalMembersController implements Initializable {

    @FXML
    Stage stage;
    Parent root;
    
    @FXML
    private Button Cancel;
    
    @FXML
    private Button Add;
    
    @FXML
    private Button Signout;
    
    @FXML
    private Button NormalMembers;
    
    @FXML
    private Button CorporateMembers;
    
    @FXML
    private Button Staff;
    
    @FXML
    private Button Offers;
    
    @FXML
    private Button Seeks;
    
    @FXML
    private Button Matches;
    
    @FXML
    private TextField Username;
    
    @FXML
    private TextField Password;
    
    @FXML
    private TextField USERID;
    
    @FXML
    private TextField FName;
    
    @FXML
    private TextField LName;
    
    @FXML
    private TextField HPhone;
    
    @FXML
    private TextField WPhone;
    
    @FXML
    private TextField MPhone;
    
    @FXML
    private TextField Email;
    
    @FXML
    private TextField HNum;
    
    @FXML
    private TextField HStreet;
    
    @FXML
    private TextField HSuburb;
    
    @FXML
    private TextField HPostCode;
    
    @FXML
    private TextField WNum;
    
    @FXML
    private TextField WStreet;
    
    @FXML
    private TextField WSuburb;
    
    @FXML
    private TextField WPostCode;
    
    @FXML
    private TextField Make;
    
    @FXML
    private TextField Model;
    
    @FXML
    private TextField Year;
    
    @FXML
    private TextField Colour;
    
    @FXML
    private TextField Registration;
    
    @FXML
    private TextField Seats;
    
    @FXML
    private TextField LicenseNumber;
    
    @FXML
    private TextField NameOnCard;
    
    @FXML
    private TextField CardNumber;
    
    @FXML
    private TextField CVV;
    
    @FXML
    private ComboBox UserType;
    
    @FXML
    private ComboBox Gender;
    
    @FXML
    private ComboBox HCity;
    
    @FXML
    private ComboBox WCity;
    
    @FXML
    private DatePicker DOB;
    
    @FXML
    private DatePicker LExpiryDate;
    
    @FXML
    private DatePicker CExpiryDate;
    
    
    DBController d = new DBController();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        UserType.getItems().addAll("Seeker", "Offerer", "Both");
        Gender.getItems().addAll("Male", "Female", "Unspecified");
        HCity.getItems().addAll("Sydney", "Melbourne", "Brisbane", "Perth", "Darwin", "Adelaide", "Hobart");
        HCity.setEditable(true);
        WCity.getItems().addAll("Sydney", "Melbourne", "Brisbane", "Perth", "Darwin", "Adelaide", "Hobart");
        WCity.setEditable(true);
                

    }  
            
    @FXML
    private void Cancel(ActionEvent event) throws Exception { //Goes to 'Matches' screen

        stage=(Stage) Cancel.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("StaffNormalMembers.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
    }
    
    @FXML 
    private void Add(ActionEvent event) throws IOException {
        String AddUsername = Username.getText();
        String AddPassword = Password.getText();
        String AddFNAME = FName.getText();
        String AddLNAME = LName.getText();
        long AddUSERID = Long.parseLong(USERID.getText());
        String utype = (String) UserType.getSelectionModel().getSelectedItem();
        String AddUserType;
        if (utype.equals("Seeker")) {
                AddUserType = "1";
        
        } else if (utype.equals("Offerer")) {
                AddUserType = "2";
        } else {
            AddUserType = "3";
        }
        
        
        String AddGender = (String) Gender.getSelectionModel().getSelectedItem();
        String AddEmail = Email.getText();
        LocalDate AddDOB = DOB.getValue();
        long AddHPhone = Long.parseLong(HPhone.getText()); //This is supposed to be a long
        long AddWPhone = Long.parseLong(WPhone.getText());
        long AddMPhone = Long.parseLong(MPhone.getText());
        int AddHNum = Integer.parseInt(HNum.getText());
        String AddHStreet = HStreet.getText();
        String AddHSuburb = HSuburb.getText();
        String AddHCity = (String) HCity.getSelectionModel().getSelectedItem();
        int AddHPostCode = Integer.parseInt(HPostCode.getText()); //Supposed to be an int
        int AddWNum = Integer.parseInt(WNum.getText());
        String AddWStreet = WStreet.getText();
        String AddWSuburb = WSuburb.getText();
        String AddWCity = (String) WCity.getSelectionModel().getSelectedItem();
        int AddWPostCode = Integer.parseInt(WPostCode.getText());
        String AddMake = Make.getText();
        String AddModel = Model.getText();
        String AddYear = Year.getText();
        String AddColour = Colour.getText();
        String AddRegistration = Registration.getText();
        int AddSeats = Integer.parseInt(Seats.getText());
        long AddLicenseNumber = Long.parseLong(LicenseNumber.getText());
        LocalDate AddLExpiryDate = LExpiryDate.getValue();
        String AddNameOnCard = NameOnCard.getText();
        long AddCardNumber = Long.parseLong(CardNumber.getText());
        LocalDate AddCExpiryDate = CExpiryDate.getValue();
        int AddCVV = Integer.parseInt(CVV.getText());

        if (AddFNAME.isEmpty() || AddLNAME.isEmpty()) {
            System.out.println("EMPTY");
        }
        else {
            try {
               d.Insert("INSERT INTO USER (USERNAME, PASSWORD, FNAME, LNAME, USERID, USERTYPE, GENDER, DOB, HPHONE, WPHONE, MPHONE, EMAIL, HNUM, HSTREET, HSUBURB, HCITY, HPOSTCODE, WNUM, WSTREET, WSUBURB, WCITY, WPOSTCODE, MAKE, MODEL, YEARMADE, COLOUR, REGISTRATION, NUMOFSEATS, LICENSENUM, EXPDATE, NAMEONCARD, CARDNUM, CARDEXPIRY, CVV) VALUES ('" + AddUsername+ "', '" + AddPassword + "', '" + AddFNAME + "', '" + AddLNAME + "', " + AddUSERID + ", '" + AddUserType + "', '" + AddGender + "', '" + AddDOB + "', " + AddHPhone + ", " + AddWPhone + ", " + AddMPhone + ", '" + AddEmail + "', " + AddHNum + ", '" + AddHStreet + "', '" + AddHSuburb + "', '" + AddHCity + "', " + AddHPostCode + ", " + AddWNum + ", '" + AddWStreet + "', '" + AddWSuburb + "', '" + AddWCity + "', " + AddWPostCode + ", '" + AddMake + "', '" + AddModel + "', '" + AddYear + "', '" + AddColour + "', '" + AddRegistration + "', " + AddSeats + ", " + AddLicenseNumber + ", '" + AddLExpiryDate + "', '" + AddNameOnCard + "', " + AddCardNumber + ", '" + AddCExpiryDate + "', " + AddCVV + ")");               
               stage=(Stage) Add.getScene().getWindow();
               root = FXMLLoader.load(getClass().getResource("StaffNormalMembers.fxml"));
               Scene scene = new Scene(root);
               stage.setScene(scene);
               stage.show(); 
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
               
        }
    }
    
    
        @FXML
    private void SignOut(ActionEvent event) throws Exception { //Goes Back to Sign in Screen

        stage=(Stage) Signout.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("Sign In.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
    }

    @FXML
    private void NormalMembers(ActionEvent event) throws Exception { //Goes to 'Normal Members' screen

        stage=(Stage) NormalMembers.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("StaffNormalMembers.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
    }
    
    @FXML
    private void CorporateMembers(ActionEvent event) throws Exception { //Goes to 'Corporate Members' screen

        stage=(Stage) CorporateMembers.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("StaffCorporateMembers.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
    }
    
    @FXML
    private void Staff(ActionEvent event) throws Exception { //Goes to 'Staff' screen

        stage=(Stage) Staff.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("StaffViewStaff.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
    }
    
    @FXML
    private void Offers(ActionEvent event) throws Exception { //Goes to 'Offers' screen

        stage=(Stage) Offers.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("StaffOffers.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
    }
    
    @FXML
    private void Seeks(ActionEvent event) throws Exception { //Goes to 'Seeks' screen

        stage=(Stage) Seeks.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("StaffSeeks.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
    }
    
    @FXML
    private void Matches(ActionEvent event) throws Exception { //Goes to 'Matches' screen

        stage=(Stage) Matches.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("StaffMatches.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
    }
    
      
    
}
