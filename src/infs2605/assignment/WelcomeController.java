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
import java.sql.*;
import javafx.stage.Stage;

/**
 *
 * @author paulstrasser
 * @author edHopkins
 */
public class WelcomeController implements Initializable {
    
    @FXML
    private Button welcome;
    Stage stage;
    Parent root;

    @FXML
    private void welcomeButton(ActionEvent event) throws Exception{ //Goes from Welcome Screen to Sign In Screen
        DBController thisTest = new DBController();
        System.out.println(thisTest.returnName(1));
        
        stage=(Stage) welcome.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("Sign In.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }
     
}

