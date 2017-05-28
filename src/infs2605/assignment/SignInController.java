/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infs2605.assignment;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

import javafx.stage.Stage;

/**
 *
 * @author edhopkins
 */
public class SignInController implements Initializable {
    
    @FXML
    Stage stage;
    Parent root;

    @FXML
    private Button SignUp, SignIn;
    
    @FXML 
    private ImageView home;
    
    @FXML
    private TextField username;
    
    @FXML
    private PasswordField password;
    
    @FXML
    private RadioButton NormalMember;
    
    @FXML
    private RadioButton Staff;
    
    @FXML
    private Text SignInError, InjectionError;
    
    @FXML
    private Text UserTypeError;
    
    public static String loggedInUser;
    
    public static int userType;

    DBController d = new DBController(); //Establish a connection to the db

    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        
    } 
    
    
    @FXML
    private void SignUpButton(ActionEvent event) throws Exception{
        stage=(Stage) SignUp.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("Sign Up 1.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
 
    }
    
    @FXML
    private void SignInButton(ActionEvent event) throws Exception{
        ToggleGroup group = new ToggleGroup();
        NormalMember.setToggleGroup(group);
        Staff.setToggleGroup(group);
        DBController auth = new DBController();
        SignInError.setVisible(false);
        InjectionError.setVisible(false);
        
        if (auth.sanitise(username.getText(), password.getText())){
            //InjectionError.setVisible(false);
            if (group.getSelectedToggle() == Staff){
                if (auth.authenticate(username.getText(), password.getText(), true)){
                    loggedInUser = username.getText();
                    //userType = Integer.parseInt(d.returnSingleQuery("SELECT USERTYPE FROM USER WHERE USERNAME LIKE '" + loggedInUser + "'"));
                    loadNext("StaffNormalMembers.fxml"); //putting it to 'Seek a Ride' for now, before we know what type of user each person is

                }
                else {
                    SignInError.setVisible(true);
                }
            }
            else{
                if (auth.authenticate(username.getText(), password.getText(), false)){
                    loggedInUser = username.getText();
                    loadNext("Seek a Ride.fxml"); //putting it to 'Seek a Ride' for now, before we know what type of user each person is

                }
                else {
                    SignInError.setVisible(true);
                } 
            }
        }
        else {
            InjectionError.setVisible(true);
        }

    }
    
    //Saves duplicates
    public void loadNext(String destination){
        SignInError.setVisible(false);
        stage=(Stage) SignUp.getScene().getWindow();
        try {
            root = FXMLLoader.load(getClass().getResource(destination)); //putting it to 'Seek a Ride' for now, before we know what type of user each person is
        } catch (IOException ex) {
            Logger.getLogger(SignInController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    private void homeButton(MouseEvent event) throws Exception {

        stage=(Stage) home.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("Welcome.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    public static String getUser(){
        return loggedInUser;
    } 
    
    public static int getUserType() {
        return userType;
    }
}
