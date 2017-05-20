/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infs2605.assignment;

import java.net.URL;
import java.util.ResourceBundle;
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
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.scene.layout.AnchorPane;
import java.util.ArrayList;

/**
 * FXML Controller class
 *
 * @author paulstrasser
 */
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

    @FXML //First anchor Pane
    public TextField username, firstName, lastname, email, homePhone, mobilePhone, workPhone;
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
    public TextField cardName, cardNum, cvv;
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
    
    //IMPORTANT
    //This code is INEFFICIENT but FX doesn't play nice with arrays,
    //Meaning FOR statements couldn't be used
    //IMPORTANT
    
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
        if (checkEmpty() == true){
            stage=(Stage) left.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("Profile Page.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        else {
            emptyFieldError.setVisible(true);
        }
    }
    
    public boolean checkEmpty (){
        //EXCLUDES CAR DETAILS
        TextField[] allText = {username, firstName, lastname, email, homePhone, mobilePhone, workPhone, homeNum, homeStreet, homeSub, homeCity, homePC, workNum, workStreet, workSub, workCity, workPC, cardName, cardNum, cvv};
        for (int i =0; i < (allText.length); i++){
            if ((allText[i].getText()).equals("")){
                return false;
            }
        }
        System.out.println("FLAG1");
        return true;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle resources) {
        
    }    
    
}