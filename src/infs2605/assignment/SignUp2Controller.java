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
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author paulstrasser
 */
public class SignUp2Controller implements Initializable {

    @FXML
    public ImageView home;
    
    @FXML 
    public ImageView right;
    
    @FXML 
    public ImageView left;
    
    @FXML
    public Circle beginCircle;
    
    @FXML
    public Circle TypeOfUserCircle;
    
    @FXML
    public Circle AddressesCircle;
    
    @FXML
    public Circle PaymentCircle;
    
    @FXML
    public Circle StartCircle;
    
    @FXML
    public void homeButton(MouseEvent event) throws Exception {
        Stage stage;
        Parent root;
        
        stage=(Stage) home.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("Welcome.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    public void leftOrRight(MouseEvent event) throws Exception {
        Stage stage;
        Parent root;
        
        if (event.getSource()==right) {
            stage=(Stage) right.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("Sign Up 3.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        else if (event.getSource()==left) {
            stage=(Stage) left.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("Sign Up 1.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
            
    }
    
    
    
    /**@FXML
    public void goLeft(MouseEvent event) throws Exception {
        Stage stage;
        Parent root;
        stage=(Stage) left.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("Sign Up 1.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    public void goRight(MouseEvent event) throws Exception {
        Stage stage;
        Parent root;
        stage=(Stage) right.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("Sign Up 3.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
    }**/
    
    @FXML
    public void circles(MouseEvent event) throws Exception {
        Stage stage;
        Parent root;
        
        if (event.getSource()==beginCircle) {
            stage=(Stage) beginCircle.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("Sign Up 1.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        else if (event.getSource()==TypeOfUserCircle) {
            stage=(Stage) TypeOfUserCircle.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("Sign Up 2.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        else if (event.getSource()==AddressesCircle) {
            stage=(Stage) AddressesCircle.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("Sign Up 3.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        else if (event.getSource()==PaymentCircle) {
            stage=(Stage) PaymentCircle.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("Sign Up 4.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        else {
            stage=(Stage) StartCircle.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("Sign Up 5.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        
    }

    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
