/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infs2605.assignment;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import java.util.Date;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.TabPane;
//import java.util.ArrayList;

public class SignUp1Controller implements Initializable {
    
    int currPage = 1;
    
    @FXML
    Stage stage;
    Parent root;
    
    @FXML
    public ImageView home, right, left;
    
    @FXML //Big circles
    public Circle beginCircle, TypeOfUserCircle, AddressesCircle, PaymentCircle, StartCircle;

    @FXML //Small circle
    public Circle beginSelect, typeSelect, addressSelect, PaymentSelect, startSelect;

    @FXML //Anchor panes
    public AnchorPane beginPane, typePane, addPane, cardPane, lastPane;
    
    @FXML
    public TabPane tabP;

    @FXML //First anchor Pane
    public TextField username, firstName, lastName, email, homePhone, mobilePhone, workPhone;
    @FXML
    public PasswordField password, passwordVerification;
    @FXML
    public DatePicker DOB;
    @FXML
    public ComboBox Gender;
    
    @FXML //Second Pane
    public ComboBox userType, carColor, carSeats;
    @FXML
    public TextField carRego, carMake, carModel, carYear, licenseNum;
    @FXML
    public DatePicker expDate;
    
    @FXML //Third Pane
    public TextField homeNum, homeStreet, homeSub, homeCity, homePC, workNum, workStreet, workSub, workCity, workPC;
    
    @FXML //Fourth Pane
    public TextField cardName, cardNum, Cvv;
    @FXML
    public DatePicker cardExp;
    
    @FXML //Fifth Pane
    public Label startText, emptyFieldError;
    @FXML
    public Circle startCircle;
    
    
    @FXML
    public void homeButton(MouseEvent event) throws Exception {

        stage=(Stage) home.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("Welcome.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    public void moveLeft(MouseEvent event) throws Exception {
        if (currPage == 1) {
            emptyFieldError.setVisible(false);
            stage=(Stage) right.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("Sign In.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        else if (currPage == 2) {
            changePage(1);
        }
        else if (currPage == 3) {
            changePage(2);
        }
        else if (currPage == 4) {
            changePage(3);
        }
        else if (currPage ==5) {
            changePage(4);
        }

    }
    
    @FXML
    public void moveRight(MouseEvent event) throws Exception {
        
        if (currPage == 1) {
            changePage(2);//goPage2();
        }
        else if (currPage == 2) {
            changePage(3);//goPage3();
        }
        else if (currPage == 3) {
            changePage(4);//goPage4();
        }
        else if (currPage == 4) {
           changePage(5); //goPage5();
        }
        else if (currPage ==5) {
            addUser();
        }
    }
    
    public void changePage(int Page){
        currPage = Page;
        Circle[] smallC = {beginSelect, typeSelect, addressSelect, PaymentSelect, startSelect};
        AnchorPane[] allPanes = {beginPane, typePane, addPane, cardPane, lastPane};
        
        for (int i = 1; i < 6; i++){
            if (i== currPage){
                smallC[i-1].setVisible(true);
                allPanes[i-1].setVisible(true);
            }
            else{
                smallC[i-1].setVisible(false);
                allPanes[i-1].setVisible(false);
            }
        }   
    }
    
    @FXML
    public void Start(MouseEvent event) throws Exception {
 
        addUser();
        
    }
    
    @FXML
    public void userType() throws Exception {
        if (userType.getValue() == "Passenger"){
            tabP.setVisible(false);
        }
        else{
            tabP.setVisible(true);
        }       
    }
    
    @FXML
    public void circle1(MouseEvent event) throws Exception {
        changePage(1);
        
    }
    
    @FXML
    public void circle2(MouseEvent event) throws Exception {
        changePage(2);
    }
    
    @FXML
    public void circle3(MouseEvent event) throws Exception {
        changePage(3);
    }
    
    @FXML
    public void circle4(MouseEvent event) throws Exception {
        changePage(4);
    }
    
    @FXML
    public void circle5(MouseEvent event) throws Exception {
        changePage(5);
    }
    
    public void addUser() throws Exception{
        if (checkValid() == false){
            DBController db1 = new DBController();
            int PK = Integer.parseInt(db1.GetUserPK()) + 1;
            String insertStatement;
            if (userType.getValue() == "Passenger"){ //DRIVING
                insertStatement = "INSERT INTO USER (USERID,FNAME,LNAME,USERTYPE,GENDER,MPHONE,HPHONE,WPHONE,HNUM,HSTREET,HSUBURB,HCITY,HPOSTCODE,WNUM,WSTREET,WSUBURB,WCITY,WPOSTCODE,USERNAME,PASSWORD,NAMEONCARD,CARDNUM,CARDEXPIRY,CVV,DOB,EMAIL) VALUES ("+PK+",'"+firstName.getText()+"','"+lastName.getText()+"',"+1+",'"+Gender.getValue()+"','"+mobilePhone.getText()+"','"+homePhone.getText()+"','"+workPhone.getText()+"','"+homeNum.getText()+"','"+homeStreet.getText()+"','"+homeSub.getText()+"','"+homeCity.getText()+"','"+homePC.getText()+"','"+workNum.getText()+"','"+workStreet.getText()+"','"+workSub.getText()+"','"+workCity.getText()+"','"+workPC.getText()+"','"+username.getText()+"','"+password.getText()+"','"+cardName.getText()+"','"+cardNum.getText()+"',"+"PARSEDATETIME('"+cardExp.getValue()+"', 'YYYY-MM-DD')" +",'"+Cvv.getText()+"',"+"PARSEDATETIME('"+DOB.getValue()+"', 'YYYY-MM-DD')" + ",'"+email.getText()+"');";
            }
            else if (userType.getValue() == "Driver"){
                insertStatement = "INSERT INTO USER (USERID,FNAME,LNAME,USERTYPE,GENDER,MPHONE,HPHONE,WPHONE,HNUM,HSTREET,HSUBURB,HCITY,HPOSTCODE,WNUM,WSTREET,WSUBURB,WCITY,WPOSTCODE,MAKE,MODEL,COLOR,YEARMADE,REGISTRATION,NUMOFSEATS,LICENSENUM,EXPDATE,USERNAME,PASSWORD,NAMEONCARD,CARDNUM,CARDEXPIRY,CVV,DOB,EMAIL) VALUES ("+PK+",'"+firstName.getText()+"','"+lastName.getText()+"',"+2+",'"+Gender.getValue()+"','"+mobilePhone.getText()+"','"+homePhone.getText()+"','"+workPhone.getText()+"','"+homeNum.getText()+"','"+homeStreet.getText()+"','"+homeSub.getText()+"','"+homeCity.getText()+"','"+homePC.getText()+"','"+workNum.getText()+"','"+workStreet.getText()+"','"+workSub.getText()+"','"+workCity.getText()+"','"+workPC.getText()+"','"+carMake.getText()+"','"+carModel.getText()+"','"+carColor.getValue()+"','"+carYear.getText()+"','"+carRego.getText()+"','"+carSeats.getValue()+"','"+licenseNum.getText()+"',"+"PARSEDATETIME('"+expDate.getValue()+"', 'YYYY-MM-DD')" +",'"+username.getText()+"','"+password.getText()+"','"+cardName.getText()+"','"+cardNum.getText()+"',"+"PARSEDATETIME('"+cardExp.getValue()+"', 'YYYY-MM-DD')" +",'"+Cvv.getText()+"',"+"PARSEDATETIME('"+DOB.getValue()+"', 'YYYY-MM-DD')" + ",'"+email.getText()+"');";
            }
            else{
                insertStatement = "INSERT INTO USER (USERID,FNAME,LNAME,USERTYPE,GENDER,MPHONE,HPHONE,WPHONE,HNUM,HSTREET,HSUBURB,HCITY,HPOSTCODE,WNUM,WSTREET,WSUBURB,WCITY,WPOSTCODE,MAKE,MODEL,COLOR,YEARMADE,REGISTRATION,NUMOFSEATS,LICENSENUM,EXPDATE,USERNAME,PASSWORD,NAMEONCARD,CARDNUM,CARDEXPIRY,CVV,DOB,EMAIL) VALUES ("+PK+",'"+firstName.getText()+"','"+lastName.getText()+"',"+3+",'"+Gender.getValue()+"','"+mobilePhone.getText()+"','"+homePhone.getText()+"','"+workPhone.getText()+"','"+homeNum.getText()+"','"+homeStreet.getText()+"','"+homeSub.getText()+"','"+homeCity.getText()+"','"+homePC.getText()+"','"+workNum.getText()+"','"+workStreet.getText()+"','"+workSub.getText()+"','"+workCity.getText()+"','"+workPC.getText()+"','"+carMake.getText()+"','"+carModel.getText()+"','"+carColor.getValue()+"','"+carYear.getText()+"','"+carRego.getText()+"','"+carSeats.getValue()+"','"+licenseNum.getText()+"',"+"PARSEDATETIME('"+expDate.getValue()+"', 'YYYY-MM-DD')" +",'"+username.getText()+"','"+password.getText()+"','"+cardName.getText()+"','"+cardNum.getText()+"',"+"PARSEDATETIME('"+cardExp.getValue()+"', 'YYYY-MM-DD')" +",'"+Cvv.getText()+"',"+"PARSEDATETIME('"+DOB.getValue()+"', 'YYYY-MM-DD')" + ",'"+email.getText()+"');";
            }
            System.out.println(insertStatement);
            db1.Insert(insertStatement);
            emptyFieldError.setVisible(false);
            stage=(Stage) left.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("Profile Page.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }
    
    public boolean checkValid (){
        //CHECK FOR EMPTY AND SPECIAL TEXT
        TextField[] allText = {username, firstName, lastName, email, homePhone, mobilePhone, workPhone, homeNum, homeStreet, homeSub, homeCity, homePC, workNum, workStreet, workSub, workCity, workPC, cardName, cardNum, Cvv};
        String allTextName[] = {"Username", "First Name", "Last Name", "Email", "Home Phone", "Mobile Phone", "Work Phone", "Home Number", "Home Street", "Home Suburb", "Home City", "Home Postcode", "Work Number", "Work Street", "Work Suburb", "Work City", "Work Postcode", "Card Name", "Card Number", "CVV"};
        
        for (int i =0; i < (allText.length); i++){
            if ((allText[i].getText()).equals("")){
                emptyFieldError.setText(allTextName[i] + " field is empty");
                emptyFieldError.setVisible(true);
                return true;
            }
            
            Pattern p = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
            Matcher m = p.matcher(allText[i].getText());
            boolean b = m.find();

            if (b && allTextName[i] != "Email") {
                emptyFieldError.setText(allTextName[i] + " field has special character");
                emptyFieldError.setVisible(true);
                return true;
            }
        }
        
        if (Cvv.getText().length() != 3){
            emptyFieldError.setText("CVV must be 3 Numbers");
            emptyFieldError.setVisible(true);
            return true;
        }
        
        //CHECK FOR EMPTY AND SPECIAL PASSWORDS
        PasswordField[] allPass = {password, passwordVerification};
        String allPassText[] = {"Password", "Password Verification"};
        
        for (int i =0; i < (allPass.length); i++){
            if ((allPass[i].getText()).equals("")){
                emptyFieldError.setText(allPassText[i] + " field is empty");
                emptyFieldError.setVisible(true);
                return true;
            }
            Pattern p = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
            Matcher m = p.matcher(allPass[i].getText());
            boolean b = m.find();

            if (b) {
                emptyFieldError.setText(allPassText[i] + " field has special character");
                emptyFieldError.setVisible(true);
                return true;
            }
        }
        
        if (!allPass[0].getText().equals(allPass[1].getText())){
           emptyFieldError.setText("Passwords do not match");
           emptyFieldError.setVisible(true);
           return true; 
        }
        
        //CHECK FOR EMPTY AND SPECIAL DATES
        DatePicker[] allDates = {DOB, cardExp};
        String[] allDateNames = {"Birthday", "Card Expiry"};
        for (int i = 0; i < 2; i++){
            if (allDates[i].getValue() == null) {
                emptyFieldError.setText(allDateNames[i] + " date is not set");
                emptyFieldError.setVisible(true);
                return true;
            }
        }

        LocalDate localDate = LocalDate.now();
        
        if (cardExp.getValue().isBefore(localDate)){
            emptyFieldError.setText("Credit card is expired");
            emptyFieldError.setVisible(true);
            return true;
        }
        
        if ((LocalDate.now().getYear() - DOB.getValue().getYear()) < 17){
            emptyFieldError.setText("You must be over 18 to use SuBer");
            emptyFieldError.setVisible(true);
            return true;
        }
        
        //CHECK FOR NONNUMERICS
        TextField[] allNums = {homePhone, mobilePhone, workPhone, homeNum, homePC, workNum, workPC, cardNum, Cvv};
        String[] allNumsName = {"Home Phone", "Mobile Phone", "Work Phone", "Home Number", "Home Postcode", "Work Number", "Work Postcode", "Card Number", "CVV"};
        
        for (int i =0; i < (allNums.length); i++){
            if (isNumeric(allNums[i].getText()) == false){
                emptyFieldError.setText(allNumsName[i] + " must be numeric");
                emptyFieldError.setVisible(true);
                return true;
            }
        }
        
        //IF DRIVING
        if (userType.getValue() != "Passenger"){ 
            //Check text
            TextField[] drivText = {carRego, carMake, carModel, carYear, licenseNum};
            String[] drivTextName = {"Registration", "Car Make", "Car Model", "Car Year", "License"};
            for (int i =0; i < (drivText.length); i++){
                if ((drivText[i].getText()).equals("")){
                    emptyFieldError.setText(drivTextName[i] + " field is empty");
                    emptyFieldError.setVisible(true);
                    return true;
                }
                Pattern p = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
                Matcher m = p.matcher(drivText[i].getText());
                boolean b = m.find();

                if (b) {
                    emptyFieldError.setText(allTextName[i] + " field has special character");
                    emptyFieldError.setVisible(true);
                    return true;
                }
            }
            
            //CHECK FOR NONNUMERICS
            TextField[] allNumsDrive = {carYear, licenseNum};
            String[] allNumsNameDrive = {"Car Year", "License"};

            for (int i =0; i < (allNumsDrive.length); i++){
                if (isNumeric(allNumsDrive[i].getText()) == false){
                    emptyFieldError.setText(allNumsNameDrive[i] + " must be numeric");
                    emptyFieldError.setVisible(true);
                    return true;
                }
            }
            
            if (expDate.getValue() == null){
                emptyFieldError.setText("Car Expiry field is empty");
                emptyFieldError.setVisible(true);
                return true;
            }
            
            if (expDate.getValue().isBefore(localDate)){
                emptyFieldError.setText("License is expired");
                emptyFieldError.setVisible(true);
                return true;
            }
            
            if (carYear.getText().length() != 4){
                emptyFieldError.setText("Car Year is invalid");
                emptyFieldError.setVisible(true);
                return true;
            }
        }
        
        return false;
    }
    
    public boolean isNumeric(String s) {  
        return s != null && s.matches("[-+]?\\d*\\.?\\d+");  
    }  
    
    @Override
    public void initialize(URL url, ResourceBundle resources) {
        Gender.getItems().addAll("Male", "Female");
        userType.getItems().addAll("Driver", "Passenger", "Both");
        carColor.getItems().addAll("Red", "Blue", "Green", "Yellow", "Orange", "Pink", "Purple", "Silver", "White", "Black");
        carSeats.getItems().addAll("2", "4", "5");
        Gender.getSelectionModel().selectFirst();
        userType.getSelectionModel().selectFirst();
        carColor.getSelectionModel().selectFirst();
        carSeats.getSelectionModel().selectFirst();

    }    
    
}