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
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TitledPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author paulstrasser
 */
public class ProfilePageController implements Initializable {

    @FXML
    Stage stage;
    Parent root;
    
    @FXML
    private Button Signout;
    
    @FXML
    private MenuButton Seek, Offer;
    
    @FXML
    private MenuItem SeekaRide, YourSeeks, OfferaRide;
    
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
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Makes all the titledPanes not able to be collapsed
        AccountInformation.setCollapsible(false);
        Addresses.setCollapsible(false);
        CarDetails.setCollapsible(false);
        LicenseDetails.setCollapsible(false);
        Payment.setCollapsible(false); 
    }   
    
    @FXML
    private void SignOut(ActionEvent event) throws Exception { //Goes Back to Sign in Screen

        stage=(Stage) Signout.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("Sign In.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
    }
    
    @FXML
    private void SeekARide(ActionEvent event) throws Exception { //Goes to 'Seek a Ride' screen

        stage=(Stage) Seek.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("Seek a Ride.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
    }
    
    @FXML
    private void OfferARide(ActionEvent event) throws Exception { //Goes to 'Seek a Ride' screen

        stage=(Stage) Offer.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("Offer a Ride.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    private void YourSeeks(ActionEvent event) throws Exception { //Goes to 'Seek a Ride' screen

        stage=(Stage) Seek.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("Your Seeks.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
    }
    
     
    
}
