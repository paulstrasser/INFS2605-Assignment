/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infs2605.assignment;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author paulstrasser
 */
public class YourOffersController implements Initializable {

    @FXML
    Stage stage;
    Parent root;
    
    @FXML
    private Text Name;
    
    @FXML
    private Button Signout, Back;
    
    @FXML
    private MenuButton Seek, Offer, Matches;
    
    @FXML
    private MenuItem SeekaRide, YourSeeks, OfferaRide, YourOffers;
     
    @FXML
    private MenuItem AdjustmentRequests;
    
    @FXML
    private MenuItem AgreementRequests;
    
    @FXML
    private TableView<Offer> yourOffers;
    
    @FXML
    private TableColumn<Offer, String> offerIDCol;
    
    @FXML
    private TableColumn<Offer, String> offererIDCol;
    
    @FXML
    private TableColumn<Offer, String> strtSuburbCol;
    
    @FXML    
    private TableColumn<Offer, String> strtPostCodeCol;    
    
    @FXML    
    private TableColumn<Offer, String> strtStreetNoCol; 
    
    @FXML
    private TableColumn<Offer, String> strtStreetNameCol;
    
    @FXML
    private TableColumn<Offer, String> endSuburbCol;
    
    @FXML
    private TableColumn<Offer, String> endPostCodeCol;
    
    @FXML
    private TableColumn<Offer, String> endStreetNoCol;
    
    @FXML
    private TableColumn<Offer, String> endStreetNameCol;
    
    @FXML
    private TableColumn<Offer, String> dateCol;
    
    @FXML
    private TableColumn<Offer, String> priceCol;
    
    @FXML
    private TableColumn<Offer, String> pickUpTimeCol;
    
    @FXML
    private TableColumn<Offer, String> dateCreatedCol;
    
    @FXML
    private TableColumn<Offer, String> statusCol;
    
    @FXML
    private TableColumn<Offer, String> numSeatsAvailableCol; 
    
    DBController d = new DBController(); //Establish a connection to the db
    
    ArrayList<Offer> offersList = new ArrayList<>(); //Creates the array list
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {     
        int type = Integer.parseInt(d.returnSingleQuery("SELECT USERTYPE AS ANSWER FROM USER WHERE USERNAME LIKE '" + SignInController.getUser() + "'"));
        if (type == 1) {
            Offer.setDisable(true);
            
        }
        else if (type == 2) {
            Seek.setDisable(true);
        }
        
        Name.setText(d.returnSingleQuery("SELECT FNAME AS ANSWER FROM USER WHERE USERNAME LIKE '" + SignInController.getUser() + "'"));
        
        offerIDCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getOfferIDProperty().toString()));
        
        offererIDCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getOffererIDProperty().toString()));
        
        strtSuburbCol.setCellValueFactory(cellData -> cellData.getValue().getStrtSuburbProperty());
        
        strtPostCodeCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getStrtPostCodeProperty().toString()));

        strtStreetNoCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getStrtStreetNoProperty().toString()));
        
        strtStreetNameCol.setCellValueFactory(cellData -> cellData.getValue().getStrtStreetNameProperty());
        
        endSuburbCol.setCellValueFactory(cellData -> cellData.getValue().getEndSuburbProperty());
        
        endPostCodeCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEndPostCodeProperty().toString()));

        endStreetNoCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEndStreetNoProperty().toString()));
        
        endStreetNameCol.setCellValueFactory(cellData -> cellData.getValue().getEndStreetNameProperty());
        
        dateCol.setCellValueFactory(cellData -> cellData.getValue().getDateProperty());
        
        priceCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPriceProperty().toString()));
        
        pickUpTimeCol.setCellValueFactory(cellData -> cellData.getValue().getPickUpTimeProperty());
        
        dateCreatedCol.setCellValueFactory(cellData -> cellData.getValue().getDateCreatedProperty());
        
        statusCol.setCellValueFactory(cellData -> cellData.getValue().getStatusProperty());
        
        numSeatsAvailableCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNumSeatsAvailableProperty().toString()));
        getOffers();
        
        yourOffers.setItems(FXCollections.observableArrayList(offersList));
          
        //Table.getSelectionModel().selectedItemProperty().addListener(
                //(observable, oldValue, newValue) -> showOffer(newValue));
    }
    
     public void getOffers() {
        try {
            offersList.clear();
            ResultSet rs = d.getResultSet("SELECT * FROM OFFER WHERE OFFERERID = (SELECT USERID FROM USER WHERE USERNAME = '" + SignInController.getUser() + "')");
            while (rs.next()) {
                offersList.add(new Offer(rs.getLong("OFFERID"), rs.getLong("OFFERERID"), rs.getString("STRTSUBURB"), rs.getInt("STRTPOSTCODE"), rs.getInt("STRTSTREETNO"), rs.getString("STRTSTREETNAME"), rs.getString("ENDSUBURB"), rs.getInt("ENDPOSTCODE"), rs.getInt("ENDSTREETNO"), rs.getString("ENDSTREETNAME"), rs.getString("DATE"), rs.getDouble("PRICE"), rs.getString("PICKUPTIME"), rs.getString("DATECREATED"), rs.getString("STATUS"), rs.getInt("NUMSEATSREQUIRED")));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(SeekARideController.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
     
    @FXML
    public void Back(ActionEvent event) throws Exception {
        stage=(Stage) Matches.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("Offer a Ride.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
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

