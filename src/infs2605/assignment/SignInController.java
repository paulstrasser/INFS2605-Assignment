/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infs2605.assignment;


import java.net.URL;
import java.util.ResourceBundle;
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
 * @author paulstrasser
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
    private Text SignInError;
    
    @FXML
    private Text UserTypeError;

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
        
        
        if (group.getSelectedToggle() == NormalMember) {
            stage=(Stage) SignUp.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("Seek a Ride.fxml")); //putting it to 'Seek a Ride' for now, before we know what type of user each person is
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        else if (group.getSelectedToggle() == Staff) {
            stage=(Stage) SignUp.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("StaffNormalMembers.fxml")); //putting it to 'Seek a Ride' for now, before we know what type of user each person is
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        else if (group.getSelectedToggle() == null) {
            UserTypeError.setVisible(true);
        }
        
        

        
 
    }
    
    @FXML
    private void homeButton(MouseEvent event) throws Exception {

        stage=(Stage) home.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("Welcome.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    
    
}
