/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infs2605.assignment;

import static infs2605.assignment.SignInController.loggedInUser;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author paulstrasser
 */
public class OfferARideController implements Initializable {

    @FXML
    Stage stage;
    Parent root;
    
    @FXML
    private Text Name;
    
    @FXML
    private Button Signout, Post;
    
    @FXML
    private MenuButton Seek, Offer, Matches;
    
    @FXML
    private MenuItem SeekaRide, YourSeeks, OfferaRide, YourOffers, AgreementRequests;
    
    @FXML
    private MenuItem AdjustmentRequests;
         
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Name.setText(loggedInUser);
        Name.setTextAlignment(TextAlignment.CENTER);
    }

     
    
    @FXML
    private void SignOut(ActionEvent event) throws Exception {

        stage=(Stage) Signout.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("Sign In.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
    }
    
    @FXML
    private void Profile(MouseEvent event) throws Exception {

        stage=(Stage) Name.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("Profile Page.fxml"));
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
    private void YourSeeks(ActionEvent event) throws Exception { //Goes to 'Seek a Ride' screen

        stage=(Stage) Seek.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("Your Seeks.fxml"));
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
    private void YourOffers(ActionEvent event) throws Exception { //Goes to 'Seek a Ride' screen

        stage=(Stage) Offer.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("Your Offers.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    private void AgreementRequests(ActionEvent event) throws Exception { //Goes to 'Seek a Ride' screen

        stage=(Stage) Matches.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("Agreement Requests.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    private void AdjustmentRequests(ActionEvent event) throws Exception { //Goes to 'Seek a Ride' screen

        stage=(Stage) Matches.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("Adjustment Requests.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}    
    

