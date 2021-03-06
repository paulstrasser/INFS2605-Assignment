/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infs2605.assignment;


import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author paulstrasser
 */
public class ProfilePageController implements Initializable {
    @FXML
    Stage stage;
    Parent root;
    
    @FXML
    private Button Signout;
    
    @FXML
    private MenuButton Seek, Offer, Matches;
    
    @FXML
    private MenuItem SeekaRide, OfferaRide;
    
    @FXML
    private MenuItem YourSeeks, YourOffers;
    
    @FXML
    private MenuItem AgreementtRequests;
    
    @FXML
    private MenuItem AdjustmentRequests;
    
    @FXML
    private TitledPane AccountInformation;
    
    @FXML
    private TitledPane Addresses;
    
    @FXML
    private TitledPane CarDetails;
    
    @FXML
    private TitledPane LicenseDetails;
    
    @FXML
    private TitledPane Payment;
    
    @FXML
    private TextField fName;
    
    @FXML
    private TextField lName;
    
    @FXML
    private DatePicker dob;
    
    @FXML
    private TextField hPhone;
    
    @FXML
    private TextField wPhone;
    
    @FXML
    private TextField mPhone;
    
    @FXML
    private TextField email;
    
    @FXML
    private TextField hNum;
    
    @FXML
    private TextField hStreet;
    
    @FXML
    private TextField hSuburb;
    
    @FXML
    private TextField hCity;
    
    @FXML
    private TextField hPostCode;
    
    @FXML
    private TextField wNum;
    
    @FXML
    private TextField wStreet;
    
    @FXML
    private TextField wSuburb;
    
    @FXML
    private TextField wCity;
    
    @FXML
    private TextField wPostCode;
    
    @FXML
    private TextField make;
    
    @FXML
    private TextField model;
    
    @FXML
    private ComboBox colour;
        
    @FXML
    private TextField yearMade;
    
    @FXML
    private TextField registration;
    
    @FXML
    private ComboBox numOfSeats;
    
    @FXML
    private TextField licenseNum;
    
    @FXML
    private DatePicker expDate;
    
    @FXML
    private TextField userName;
    
    @FXML
    private PasswordField passWord;
    
    @FXML
    private TextArea description;
    
    @FXML
    private TextField nameOnCard;
    
    @FXML
    private TextField cardNum;
    
    @FXML
    private DatePicker cardExpiry;
    
    @FXML
    private TextField cVV;
    
    @FXML
    private Text userType;    
    
    @FXML
    private Text Name;
    
    @FXML
    private Label Name2;
    
    @FXML
    private Button Update;
    
    DBController d = new DBController();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Makes all the titledPanes not able to be collapsed
        
        
        AccountInformation.setCollapsible(false);
        Addresses.setCollapsible(false);
        CarDetails.setCollapsible(false);
        LicenseDetails.setCollapsible(false);
        Payment.setCollapsible(false); 
        Name2.setText(d.returnSingleQuery("SELECT CONCAT(FNAME, ' ', LNAME) AS ANSWER FROM USER WHERE USERNAME LIKE '" + SignInController.getUser() + "'"));
        Name.setText(d.returnSingleQuery("SELECT FNAME AS ANSWER FROM USER WHERE USERNAME LIKE '" + SignInController.getUser() + "'"));
        fName.setText(d.returnSingleQuery("SELECT FNAME AS ANSWER FROM USER WHERE USERNAME LIKE '" + SignInController.getUser() + "'"));
        description.setText(d.returnSingleQuery("SELECT DESCRIPTION AS ANSWER FROM USER WHERE USERNAME LIKE '" + SignInController.getUser() + "'"));
        lName.setText(d.returnSingleQuery("SELECT LNAME AS ANSWER FROM USER WHERE USERNAME LIKE '" + SignInController.getUser() + "'"));
        
        int type = Integer.parseInt(d.returnSingleQuery("SELECT USERTYPE AS ANSWER FROM USER WHERE USERNAME LIKE '" + SignInController.getUser() + "'"));
        if (type == 1) {
            userType.setText("Seeker");
            Offer.setDisable(true);
            
        }
        else if (type == 2) {
            userType.setText("Offerer");
            Seek.setDisable(true);
        }
        else {
            userType.setText("Both Seeker and Offerer");
        }
        LocalDate DOB = LocalDate.parse(d.returnSingleQuery("SELECT DOB AS ANSWER FROM USER WHERE USERNAME LIKE '" + SignInController.getUser() + "'"));
        dob.setValue(DOB);
        hPhone.setText(d.returnSingleQuery("SELECT HPHONE AS ANSWER FROM USER WHERE USERNAME LIKE '" + SignInController.getUser() + "'"));
        wPhone.setText(d.returnSingleQuery("SELECT WPHONE AS ANSWER FROM USER WHERE USERNAME LIKE '" + SignInController.getUser() + "'"));
        mPhone.setText(d.returnSingleQuery("SELECT MPHONE AS ANSWER FROM USER WHERE USERNAME LIKE '" + SignInController.getUser() + "'"));
        email.setText(d.returnSingleQuery("SELECT EMAIL AS ANSWER FROM USER WHERE USERNAME LIKE '" + SignInController.getUser() + "'"));
        hNum.setText(d.returnSingleQuery("SELECT HNUM AS ANSWER FROM USER WHERE USERNAME LIKE '" + SignInController.getUser() + "'"));
        hStreet.setText(d.returnSingleQuery("SELECT HSTREET AS ANSWER FROM USER WHERE USERNAME LIKE '" + SignInController.getUser() + "'"));
        hSuburb.setText(d.returnSingleQuery("SELECT HSUBURB AS ANSWER FROM USER WHERE USERNAME LIKE '" + SignInController.getUser() + "'"));
        hCity.setText(d.returnSingleQuery("SELECT HCITY AS ANSWER FROM USER WHERE USERNAME LIKE '" + SignInController.getUser() + "'"));
        hPostCode.setText(d.returnSingleQuery("SELECT HPOSTCODE AS ANSWER FROM USER WHERE USERNAME LIKE '" + SignInController.getUser() + "'"));
        wNum.setText(d.returnSingleQuery("SELECT WNUM AS ANSWER FROM USER WHERE USERNAME LIKE '" + SignInController.getUser() + "'"));
        wStreet.setText(d.returnSingleQuery("SELECT WSTREET AS ANSWER FROM USER WHERE USERNAME LIKE '" + SignInController.getUser() + "'"));
        wSuburb.setText(d.returnSingleQuery("SELECT WSUBURB AS ANSWER FROM USER WHERE USERNAME LIKE '" + SignInController.getUser() + "'"));
        wCity.setText(d.returnSingleQuery("SELECT WCITY AS ANSWER FROM USER WHERE USERNAME LIKE '" + SignInController.getUser() + "'"));
        wPostCode.setText(d.returnSingleQuery("SELECT WPOSTCODE AS ANSWER FROM USER WHERE USERNAME LIKE '" + SignInController.getUser() + "'"));
        make.setText(d.returnSingleQuery("SELECT MAKE AS ANSWER FROM USER WHERE USERNAME LIKE '" + SignInController.getUser() + "'"));
        model.setText(d.returnSingleQuery("SELECT MODEL AS ANSWER FROM USER WHERE USERNAME LIKE '" + SignInController.getUser() + "'"));
        colour.setValue(d.returnSingleQuery("SELECT COLOUR AS ANSWER FROM USER WHERE USERNAME LIKE '" + SignInController.getUser() + "'"));
        yearMade.setText(d.returnSingleQuery("SELECT YEARMADE AS ANSWER FROM USER WHERE USERNAME LIKE '" + SignInController.getUser() + "'"));
        registration.setText(d.returnSingleQuery("SELECT REGISTRATION AS ANSWER FROM USER WHERE USERNAME LIKE '" + SignInController.getUser() + "'"));
        numOfSeats.setValue(d.returnSingleQuery("SELECT NUMOFSEATS AS ANSWER FROM USER WHERE USERNAME LIKE '" + SignInController.getUser() + "'"));
        licenseNum.setText(d.returnSingleQuery("SELECT LICENSENUM AS ANSWER FROM USER WHERE USERNAME LIKE '" + SignInController.getUser() + "'"));
        LocalDate ExpiryDate = LocalDate.parse(d.returnSingleQuery("SELECT EXPDATE AS ANSWER FROM USER WHERE USERNAME LIKE '" + SignInController.getUser() + "'"));
        expDate.setValue(ExpiryDate);
        userName.setText(d.returnSingleQuery("SELECT USERNAME AS ANSWER FROM USER WHERE USERNAME LIKE '" + SignInController.getUser() + "'"));
        passWord.setText(d.returnSingleQuery("SELECT PASSWORD AS ANSWER FROM USER WHERE USERNAME LIKE '" + SignInController.getUser() + "'"));
        nameOnCard.setText(d.returnSingleQuery("SELECT NAMEONCARD AS ANSWER FROM USER WHERE USERNAME LIKE '" + SignInController.getUser() + "'"));
        cardNum.setText(d.returnSingleQuery("SELECT CARDNUM AS ANSWER FROM USER WHERE USERNAME LIKE '" + SignInController.getUser() + "'"));
        LocalDate CardExpiry = LocalDate.parse(d.returnSingleQuery("SELECT CARDEXPIRY AS ANSWER FROM USER WHERE USERNAME LIKE '" + SignInController.getUser() + "'"));
        cardExpiry.setValue(CardExpiry);
        cVV.setText(d.returnSingleQuery("SELECT CVV AS ANSWER FROM USER WHERE USERNAME LIKE '" + SignInController.getUser() + "'"));
        colour.getItems().addAll("Blue", "Red", "Green", "Black", "Silver", "White", "Orange");
        numOfSeats.getItems().addAll("1", "2", "3", "4", "5", "6");
    }  
    
    @FXML
    private void Update(ActionEvent event) throws Exception {
        String NewDescription = description.getText();
        String NewFNAME = fName.getText();
        String NewLNAME = lName.getText();
        LocalDate NewDOB = dob.getValue();
        long NewHPHONE = Long.parseLong(hPhone.getText());
        long NewWPHONE = Long.parseLong(wPhone.getText());
        long NewMPHONE = Long.parseLong(mPhone.getText());
        String NewEMAIL = email.getText();
        int NewHNUM = Integer.parseInt(hNum.getText());
        String NewHSTREET = hStreet.getText();
        String NewHSUBURB = hSuburb.getText();
        String NewHCITY = hCity.getText();
        int NewHPOSTCODE = Integer.parseInt(hPostCode.getText());
        int NewWNUM = Integer.parseInt(wNum.getText());
        String NewWSTREET = wStreet.getText();
        String NewWSUBURB = wSuburb.getText();
        String NewWCITY = wCity.getText();
        int NewWPOSTCODE = Integer.parseInt(wPostCode.getText());
        String NewMAKE = make.getText();
        String NewMODEL = model.getText();
        String NewCOLOUR = colour.getSelectionModel().getSelectedItem().toString();
        String NewYEARMADE = yearMade.getText();
        String NewREGISTRATION = registration.getText();
        String NewSeats = (String) numOfSeats.getSelectionModel().getSelectedItem();
        long NewLICENSENUM = Long.parseLong(licenseNum.getText());
        LocalDate NewEXPDATE = expDate.getValue();
        String NewUSERNAME = userName.getText();
        String NewPASSWORD = passWord.getText();
        String NewNAMEONCARD = nameOnCard.getText();
        long NewCARDNUM = Long.parseLong(cardNum.getText());
        LocalDate NewCARDEXPIRY = cardExpiry.getValue();
        int NewCVV = Integer.parseInt(cVV.getText());

        d.Insert("UPDATE USER "
                + "SET DESCRIPTION = '" + NewDescription + "', FNAME = '" + NewFNAME + "', LNAME = '" + NewLNAME + "', DOB = PARSEDATETIME('"+NewDOB+"', 'YYYY-MM-DD'), HPHONE = " + NewHPHONE + ", WPHONE = " + NewWPHONE + ", MPHONE = " + NewMPHONE + ", EMAIL = '" + NewEMAIL + "', HNUM = " + NewHNUM + ", HSTREET = '" + NewHSTREET + "', HSUBURB = '" + NewHSUBURB + "', HCITY = '" + NewHCITY + "', HPOSTCODE = " + NewHPOSTCODE + ", WNUM = " + NewWNUM + ", WSTREET = '" + NewWSTREET + "', WSUBURB = '" + NewWSUBURB + "', WCITY = '" + NewWCITY + "', WPOSTCODE = " + NewWPOSTCODE + ", MAKE = '" + NewMAKE + "', MODEL = '" + NewMODEL + "', COLOUR = '" + NewCOLOUR + "', YEARMADE = '" + NewYEARMADE + "', REGISTRATION = '" + NewREGISTRATION + "', NUMOFSEATS = " + NewSeats + ", LICENSENUM = " + NewLICENSENUM + ", EXPDATE = PARSEDATETIME('"+NewEXPDATE+"', 'YYYY-MM-DD'), USERNAME = '" + NewUSERNAME + "', PASSWORD = '" + NewPASSWORD + "', NAMEONCARD = '" + NewNAMEONCARD + "', CARDNUM = " + NewCARDNUM + ", CARDEXPIRY = PARSEDATETIME('"+NewCARDEXPIRY+"', 'YYYY-MM-DD'), CVV = " + NewCVV
                + "WHERE USERNAME LIKE '" + SignInController.getUser() + "'");
        
        stage=(Stage) Update.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("Profile Page.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Action Processed");
        alert.setHeaderText(null);
        alert.setContentText("Your profile has been updated!");

        alert.showAndWait();
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
    private void SeekARide(ActionEvent event) throws Exception { //Goes to 'Seek a Ride' screen

        stage=(Stage) Seek.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("Seek a Ride.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
    }
    
    @FXML
    private void OfferARide(ActionEvent event) throws Exception { //Goes to 'Offer a Ride' screen

        stage=(Stage) Offer.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("Offer a Ride.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    private void YourSeeks(ActionEvent event) throws Exception { //Goes to 'Your Seeks' screen

        stage=(Stage) Seek.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("Your Seeks.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
    }
    
    @FXML
    private void YourOffers(ActionEvent event) throws Exception { //Goes to 'Seek a Ride' screen

        stage=(Stage) Offer.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("Your Offers.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    private void AgreementRequests(ActionEvent event) throws Exception { //Goes to 'Seek a Ride' screen

        stage=(Stage) Matches.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("Agreement Requests.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    private void AdjustmentRequests(ActionEvent event) throws Exception { //Goes to 'Seek a Ride' screen

        stage=(Stage) Matches.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("Adjustment Requests.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}