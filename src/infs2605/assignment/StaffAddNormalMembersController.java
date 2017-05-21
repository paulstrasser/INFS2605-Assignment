/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infs2605.assignment;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Date;
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
import javafx.scene.control.SingleSelectionModel;
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
        String AddUSERID = USERID.getText();
        SingleSelectionModel AddUserType = UserType.getSelectionModel();
        //How do i do combo boxes? String AddUserType = UserType.getSelectionModel();
        //same for gender
        SingleSelectionModel AddGender = Gender.getSelectionModel();

        
        LocalDate AddDOB = DOB.getValue();
        String AddHPhone = HPhone.getText(); //This is supposed to be a long
        String AddWPhone = WPhone.getText();
        String AddMPhone = MPhone.getText();
        String AddHNum = HNum.getText();
        String AddHStreet = HStreet.getText();
        String AddHSuburb = HSuburb.getText();
        //City combo box String AddHCity = HCity.getText();
        String AddHPostCode = HPostCode.getText(); //Supposed to be an int
        String AddWNum = WNum.getText();
        String AddWStreet = WStreet.getText();
        String AddWSuburb = WSuburb.getText();
        //City combo box String AddWCity = WCity.getText();
        String AddHWostCode = WPostCode.getText();
        String AddMake = Make.getText();
        String AddModel = Model.getText();
        String AddYear = Year.getText();
        String AddColour = Colour.getText();
        String AddRegistration = Registration.getText();
        //int AddSeats = Seats.get
        String AddLicenseNumber = LicenseNumber.getText();
        LocalDate AddLExpiryDate = LExpiryDate.getValue();
        String AddNameOnCard = NameOnCard.getText();
        String AddCardNumber = CardNumber.getText();
        LocalDate AddCExpiryDate = CExpiryDate.getValue();
        String AddCVV = CVV.getText();

        if (AddFNAME.isEmpty() || AddLNAME.isEmpty() || AddUSERID.isEmpty()) {
            System.out.println("EMPTY");
        }
        else {
            try {
               d.Insert("INSERT INTO USER (USERNAME, PASSWORD, FNAME, LNAME, USERID, USERTYPE, GENDER, DOB, HPHONE, WPHONE, MPHONE, HNUM, HSTREET, HSUBURB, HPOSTCODE, WNUM, WSTREET, WSUBURB, WPOSTCODE, MAKE, MODEL, YEAR, COLOUR, REGISTRATION, LICENSENUMBER, EXPDATE, NAMEONCARD, CARDNUM, CARDEXPIRY, CVV) VALUES ('" + AddUsername+ "', '" + AddPassword + "', '" + AddFNAME + "', '" + AddLNAME + "', '" + AddUSERID + "', '" + AddUserType + "', '" + AddGender + "', '" + AddDOB + "', '" + AddHPhone + "', '" + AddWPhone + "', '" + AddMPhone + "', '" + AddHNum + "', '" + AddHStreet + "', '" + AddHSuburb + "', '" + /*AddHCity + "', '" + AddPostCode + "', '" + */AddWNum + "', '" + AddWStreet + "', '" + AddWSuburb + "', '" + /*AddWPostCode + "', '" + */AddMake + "', '" + AddModel + "', '" + AddYear + "', '" + AddColour + "', '" + AddRegistration + "', '" + AddLicenseNumber + "', '" + AddLExpiryDate + "', '" + AddNameOnCard + "', '" + AddCardNumber + "', '" + AddCExpiryDate + "', '" + AddCVV + "')");               stage=(Stage) Add.getScene().getWindow();
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
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
