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
import javafx.scene.control.ListView;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TitledPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author paulstrasser
 */
public class YourSeeksController implements Initializable {

    @FXML
    Stage stage;
    Parent root;
    
    @FXML
    private Text Name;
    
    @FXML
    private Button Signout;
    
    @FXML
    private MenuButton Seek, Offer;
    
    @FXML
    private MenuItem SeekaRide, YourSeeks, OfferaRide;
     
    @FXML
    private ListView yourSeeksList;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Add code here that feeds data into the listview
        
    
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
}
