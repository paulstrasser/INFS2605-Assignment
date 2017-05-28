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
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TitledPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
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
    private TableView<Seek> yourSeeks;
    
    @FXML
    private TableColumn<Seek, String> seekIDCol;
    
    @FXML
    private TableColumn<Seek, String> seekerIDCol;
    
    @FXML
    private TableColumn<Seek, String> strtSuburbCol;
    
    @FXML    
    private TableColumn<Seek, String> strtPostCodeCol;    
    
    @FXML    
    private TableColumn<Seek, String> strtStreetNoCol; 
    
    @FXML
    private TableColumn<Seek, String> strtStreetNameCol;
    
    @FXML
    private TableColumn<Seek, String> endSuburbCol;
    
    @FXML
    private TableColumn<Seek, String> endPostCodeCol;
    
    @FXML
    private TableColumn<Seek, String> endStreetNoCol;
    
    @FXML
    private TableColumn<Seek, String> endStreetNameCol;
    
    @FXML
    private TableColumn<Seek, String> dateCol;
    
    @FXML
    private TableColumn<Seek, String> priceCol;
    
    @FXML
    private TableColumn<Seek, String> pickUpTimeCol;
    
    @FXML
    private TableColumn<Seek, String> dateCreatedCol;
    
    @FXML
    private TableColumn<Seek, String> statusCol;
    
    @FXML
    private TableColumn<Seek, String> numSeatsRequiredCol;
    
    DBController d = new DBController(); //Establish a connection to the db
    
    ArrayList<Seek> seeksList = new ArrayList<>(); //Creates the array list
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Name.setText(d.returnSingleQuery("SELECT FNAME AS ANSWER FROM USER WHERE USERNAME LIKE '" + SignInController.getUser() + "'"));
        
        seekIDCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getSeekIDProperty().toString()));
        
        seekerIDCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getSeekerIDProperty().toString()));
        
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
        
        numSeatsRequiredCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNumSeatsRequiredProperty().toString()));
        getSeeks();
        
        yourSeeks.setItems(FXCollections.observableArrayList(seeksList));
          
        //Seeks.getSelectionModel().selectedItemProperty().addListener(
                //(observable, oldValue, newValue) -> showSeek(newValue));
    }
     public void getSeeks() {
        try {
            seeksList.clear();
            ResultSet rs = d.getResultSet("SELECT * FROM SEEK WHERE SEEKERID = (SELECT USERID FROM USER WHERE USERNAME = '" + SignInController.getUser() + "')");
            while (rs.next()) {
                seeksList.add(new Seek(rs.getLong("SEEKID"), rs.getLong("SEEKERID"), rs.getString("STRTSUBURB"), rs.getInt("STRTPOSTCODE"), rs.getInt("STRTSTREETNO"), rs.getString("STRTSTREETNAME"), rs.getString("ENDSUBURB"), rs.getInt("ENDPOSTCODE"), rs.getInt("ENDSTREETNO"), rs.getString("ENDSTREETNAME"), rs.getString("DATE"), rs.getDouble("PRICE"), rs.getString("PICKUPTIME"), rs.getString("DATECREATED"), rs.getString("STATUS"), rs.getInt("NUMSEATSREQUIRED")));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(OfferARideController.class.getName()).log(Level.SEVERE, null, ex);
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
