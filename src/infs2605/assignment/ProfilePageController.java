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
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TitledPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author paulstrasser
 */
public class ProfilePageController implements Initializable {

    @FXML
    private Button Signout;
    
    @FXML 
    private SplitMenuButton Seek;
    
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
    private void SignOut(ActionEvent event) throws Exception {
        Stage stage;
        Parent root;
        
        stage=(Stage) Signout.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("Sign In.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
    }
    
    @FXML
    private void SeekARide(ActionEvent event) throws Exception {
        Stage stage;
        Parent root;
        
        stage=(Stage) Seek.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("Seek a Ride.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        AccountInformation.setCollapsible(false);
        Addresses.setCollapsible(false);
        CarDetails.setCollapsible(false);
        LicenseDetails.setCollapsible(false);
        Payment.setCollapsible(false);
    }    
    
}
