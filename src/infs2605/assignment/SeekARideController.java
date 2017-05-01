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
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author paulstrasser
 */
public class SeekARideController implements Initializable {

    @FXML
    private Button Signout;
    
    @FXML
    private Text Name;
    
    @FXML
    private GridPane results;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        addResults();
    } 
    
    
    private void SignOut(ActionEvent event) throws Exception {
        Stage stage;
        Parent root;
        
        stage=(Stage) Signout.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("Sign In.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
    }
    
    private void Profile(MouseEvent event) throws Exception {
        Stage stage;
        Parent root;
        
        stage=(Stage) Name.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("Profile Page.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    private void addResults() {
        Label test = new Label("Hello");      
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                results.add(test,i,j);
            }
        }
    }
    
    
    
    
       
    
}
