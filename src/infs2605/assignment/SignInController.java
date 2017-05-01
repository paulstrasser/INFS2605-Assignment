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
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import javafx.stage.Stage;

/**
 *
 * @author paulstrasser
 */
public class SignInController implements Initializable {
    
    @FXML
    private Button SignUp;
    
    @FXML 
    private ImageView home;
    
    @FXML
    private TextField username;
    
    @FXML
    private PasswordField password;

    @FXML
    private void SignUpButton(ActionEvent event) throws Exception{
        Stage stage;
        Parent root;
        
        stage=(Stage) SignUp.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("Sign Up 1.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
 
    }
    
    @FXML
    private void homeButton(MouseEvent event) throws Exception {
        Stage stage;
        Parent root;
        
        stage=(Stage) home.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("Welcome.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    } 
    
}
