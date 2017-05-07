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
    public Label startText;
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
        System.out.println(currPage);
        if (currPage == 1){
            stage=(Stage) right.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("Sign In.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        else {
            switch (currPage){
                case 2: goPage1();
                case 3: goPage2();
                case 4: goPage3();
                case 5: goPage4();
            }
        }
        System.out.println(currPage);
    }
    
    @FXML
    public void moveRight(MouseEvent event) throws Exception {
        System.out.println(currPage);
        if (currPage == 5){
            stage=(Stage) left.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("Profile Page.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        else {
            switch (currPage){
                case 1: goPage2();
                case 2: goPage3();
                case 3: goPage4();
                case 4: goPage5();
                default: goPage2();
            }
        }
        System.out.println(currPage);
    }
    
    @FXML
    public void Start(MouseEvent event) throws Exception {
 
        stage=(Stage) StartCircle.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("Profile Page.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
    }
    
    //IMPORTANT
    //This code is INEFFICIENT but FX doesn't play nice with arrays,
    //Meaning FOR statements couldn't be used
    //IMPORTANT
    
    @FXML
    public void circle1(MouseEvent event) throws Exception {
        goPage1();
    }
    
    public void goPage1(){
        currPage = 1;
        
        beginSelect.setVisible(true);
        typeSelect.setVisible(false);
        addressSelect.setVisible(false);
        PaymentSelect.setVisible(false);
        startSelect.setVisible(false);
        
        beginPane.setVisible(true);
        typePane.setVisible(false);
        addPane.setVisible(false);
        cardPane.setVisible(false);
        lastPane.setVisible(false);
    }
    
    //IMPORTANT
    //This code is INEFFICIENT but FX doesn't play nice with arrays,
    //Meaning FOR statements couldn't be used
    //IMPORTANT
    
    @FXML
    public void circle2(MouseEvent event) throws Exception {
        goPage2();
    }
    
    public void goPage2(){
        currPage = 2;
        
        beginSelect.setVisible(false);
        typeSelect.setVisible(true);
        addressSelect.setVisible(false);
        PaymentSelect.setVisible(false);
        startSelect.setVisible(false);
        
        beginPane.setVisible(false);
        typePane.setVisible(true);
        addPane.setVisible(false);
        cardPane.setVisible(false);
        lastPane.setVisible(false);
    }
    
    //IMPORTANT
    //This code is INEFFICIENT but FX doesn't play nice with arrays,
    //Meaning FOR statements couldn't be used
    //IMPORTANT
    
    @FXML
    public void circle3(MouseEvent event) throws Exception {
        goPage3();
    }
    
    public void goPage3(){
        currPage = 3;
        
        beginSelect.setVisible(false);
        typeSelect.setVisible(false);
        addressSelect.setVisible(true);
        PaymentSelect.setVisible(false);
        startSelect.setVisible(false);
        
        beginPane.setVisible(false);
        typePane.setVisible(false);
        addPane.setVisible(true);
        cardPane.setVisible(false);
        lastPane.setVisible(false);
    }
    
    //IMPORTANT
    //This code is INEFFICIENT but FX doesn't play nice with arrays,
    //Meaning FOR statements couldn't be used
    //IMPORTANT
    
    @FXML
    public void circle4(MouseEvent event) throws Exception {
        goPage4();
    }
    
    public void goPage4(){
        currPage = 4;
        
        beginSelect.setVisible(false);
        typeSelect.setVisible(false);
        addressSelect.setVisible(false);
        PaymentSelect.setVisible(true);
        startSelect.setVisible(false);
        
        beginPane.setVisible(false);
        typePane.setVisible(false);
        addPane.setVisible(false);
        cardPane.setVisible(true);
        lastPane.setVisible(false);
    }
    
    //IMPORTANT
    //This code is INEFFICIENT but FX doesn't play nice with arrays of objects,
    //Meaning FOR statements couldn't be used
    //IMPORTANT
    
    @FXML
    public void circle5(MouseEvent event) throws Exception {
        goPage5();
    }
    
    public void goPage5(){
        currPage = 5;
        
        beginSelect.setVisible(false);
        typeSelect.setVisible(false);
        addressSelect.setVisible(false);
        PaymentSelect.setVisible(false);
        startSelect.setVisible(true);
        
        beginPane.setVisible(false);
        typePane.setVisible(false);
        addPane.setVisible(false);
        cardPane.setVisible(false);
        lastPane.setVisible(true);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle resources) {
        
    }    
    
}


