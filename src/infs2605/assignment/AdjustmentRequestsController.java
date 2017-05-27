/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infs2605.assignment;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author paulstrasser
 */
public class AdjustmentRequestsController implements Initializable {

    @FXML
    Stage stage;
    Parent root;
    
    @FXML
    private Text Name;
    
    @FXML
    private Button Signout;
    
    @FXML
    private MenuButton Seek, Offer, Matches;
    
    @FXML
    private MenuItem SeekaRide, YourSeeks, OfferaRide, YourOffers;
     
    @FXML
    private MenuItem AdjustmentRequests;
    
    @FXML
    private TableView<Adjustment> Table;
    
    @FXML
    private TableColumn<Adjustment, String> adjustmentIDCol;
    
    @FXML
    private TableColumn<Adjustment, String> agreementIDCol;
    
    @FXML
    private TableColumn<Adjustment, String> seekIDCol;

    @FXML
    private TableColumn<Adjustment, String> seekerIDCol;

    @FXML
    private TableColumn<Adjustment, String> offerIDCol;

    @FXML
    private TableColumn<Adjustment, String> offererIDCol;

    @FXML
    private TableColumn<Adjustment, String> strtSuburbCol;
    
    @FXML
    private TableColumn<Adjustment, String> strtPostCodeCol;
    
    @FXML
    private TableColumn<Adjustment, String> strtStreetNoCol;
    
    @FXML
    private TableColumn<Adjustment, String> strtStreetNameCol;
    
    @FXML
    private TableColumn<Adjustment, String> endSuburbCol;
    
    @FXML
    private TableColumn<Adjustment, String> endPostCodeCol;
    
    @FXML
    private TableColumn<Adjustment, String> endStreetNoCol;
    
    @FXML
    private TableColumn<Adjustment, String> endStreetNameCol;
    
    @FXML
    private TableColumn<Adjustment, String> dateCol;
    
    @FXML
    private TableColumn<Adjustment, String> priceCol;
    
    @FXML
    private TableColumn<Adjustment, String> pickUpTimeCol;
    
    @FXML
    private TableColumn<Adjustment, String> dateCreatedCol;
    
    @FXML
    private TableColumn<Adjustment, String> statusCol;
    
    @FXML
    private TableColumn<Adjustment, String> paymentIDCol;
    
    @FXML
    private TableColumn<Adjustment, String> numSeatsRequiredCol;
    
    @FXML
    private TableColumn<Adjustment, String> adjustedByCol;
    
    @FXML
    private AnchorPane Single;
    
    @FXML
    private Label adjustmentID;
    
    @FXML
    private TextField agreementID;
    
    @FXML
    private TextField tfSeekID;
    
    @FXML
    private TextField tfOfferID;
    
    @FXML
    private TextField tfSeekerID;
    
    @FXML
    private TextField tfOffererID;
    
    @FXML
    private TextField tfStrtStreetNo;
    
    @FXML
    private TextField tfStrtStreet;
    
    @FXML
    private TextField tfStrtSuburb;
    
    @FXML
    private TextField tfStrtPostCode;
    
    @FXML
    private TextField tfEndStreetNo;
    
    @FXML
    private TextField tfEndStreet;
    
    @FXML
    private TextField tfEndSuburb;
    
    @FXML
    private TextField tfEndPostCode;
    
    @FXML
    private DatePicker dateCreated;
    
    @FXML
    private TextField status;
    
    @FXML
    private DatePicker date;
    
    @FXML
    private TextField price;
    
    @FXML
    private TextField pickUpTime;
    
    @FXML
    private TextField numOfSeats;
    
    @FXML
    private Button Cancel;
    
    @FXML
    private Button Accept;
    
    
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
    
    DBController d = new DBController(); //Establish a connection to the db
    
    ArrayList<Adjustment> adjustmentList = new ArrayList<>();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Name.setText(d.returnSingleQuery("SELECT FNAME AS ANSWER FROM USER WHERE USERNAME LIKE '" + SignInController.getUser() + "'"));
        Single.setVisible(false);
        agreementID.setVisible(false);
        tfSeekID.setVisible(false);
        tfOfferID.setVisible(false);
        tfSeekerID.setEditable(false);
        tfOffererID.setEditable(false);
        dateCreated.setEditable(false);
        status.setEditable(false);
        
        
        adjustmentIDCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getAdjustmentIDProperty().toString()));
        
        agreementIDCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getAgreementIDProperty().toString()));

        offerIDCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getOfferIDProperty().toString()));
        
        offererIDCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getOffererIDProperty().toString()));

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
        
        paymentIDCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPaymentIDProperty().toString()));
       
        adjustedByCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getAdjustedByProperty().toString()));

        
        
        getAdjustments();
        
        Table.setItems(FXCollections.observableArrayList(adjustmentList));
        
        Table.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showMatch(newValue));
        
        /*SearchBy.getItems().addAll("ID", "Seek ID", "Seeker ID", "Offer ID", "Offerer ID", "Starting Suburb", "Ending Suburb", "Date", "Date Created", "Price", "Status", "Number of Seats");
        SearchCombo.getItems().addAll("Pending", "Matched");
        SearchValue.setVisible(true);
        SearchDate.setVisible(false);
        SearchCombo.setVisible(false);*/
        
    
    } 
    
    public void getAdjustments() {
        try {
            adjustmentList.clear();
            long thisUser = Long.parseLong(d.returnSingleQuery("SELECT USERID AS ANSWER FROM USER WHERE USERNAME LIKE '" + SignInController.getUser() + "'"));

            ResultSet rs = d.getResultSet("SELECT * FROM Adjustment WHERE STATUS IN ('Pending') AND ADJUSTEDBY != " + thisUser);
            while (rs.next()) {
                adjustmentList.add(new Adjustment(rs.getLong("ADJUSTMENTID"), rs.getLong("AGREEMENTID"), rs.getLong("SEEKID"), rs.getLong("SEEKERID"), rs.getLong("OFFERID"), rs.getLong("OFFERERID"), rs.getString("STRTSUBURB"), rs.getInt("STRTPOSTCODE"), rs.getInt("STRTSTREETNO"), rs.getString("STRTSTREETNAME"), rs.getString("ENDSUBURB"), rs.getInt("ENDPOSTCODE"), rs.getInt("ENDSTREETNO"), rs.getString("ENDSTREETNAME"), rs.getString("DATE"), rs.getDouble("PRICE"), rs.getString("PICKUPTIME"), rs.getString("DATECREATED"), rs.getString("STATUS"), rs.getLong("PAYMENTID"), rs.getInt("NUMSEATSREQUIRED"), rs.getLong("ADJUSTEDBY")));
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(AdjustmentRequestsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void showMatch(Adjustment adjustment) {
        Single.setVisible(true);
        adjustmentID.setText(adjustment.getAdjustmentID());
        agreementID.setText(adjustment.getAgreementID());
        tfSeekID.setText(adjustment.getSeekID());
        tfSeekerID.setText(adjustment.getSeekerID());
        tfOfferID.setText(adjustment.getOfferID());
        tfOffererID.setText(adjustment.getOffererID());
        LocalDate dateC = LocalDate.parse(adjustment.getDateCreated());
        dateCreated.setValue(dateC);
        status.setText(adjustment.getStatus());
        tfStrtStreetNo.setText(adjustment.getStrtStreetNo());
        tfStrtStreet.setText(adjustment.getStrtStreetName());
        tfStrtSuburb.setText(adjustment.getStrtSuburb());
        tfStrtPostCode.setText(adjustment.getStrtPostCode());
        tfEndStreetNo.setText(adjustment.getEndStreetNo());
        tfEndStreet.setText(adjustment.getEndStreetName());
        tfEndSuburb.setText(adjustment.getEndSuburb());
        tfEndPostCode.setText(adjustment.getEndPostCode());
        LocalDate date2 = LocalDate.parse(adjustment.getDate());
        date.setValue(date2);
        price.setText(adjustment.getPrice());
        pickUpTime.setText(adjustment.getPickUpTime());
        numOfSeats.setText(adjustment.getNumSeatsRequired());
    }
    
    public void Cancel(ActionEvent event) throws Exception {
        Single.setVisible(false);
    }
    
    public void Accept(ActionEvent event) throws Exception {
        String agStrtSuburb = d.returnSingleQuery("SELECT STRTSUBURB AS ANSWER FROM AGREEMENT WHERE AGREEMENTID = '" + agreementID.getText()  + "'");
        int agStrtPostCode = Integer.parseInt(d.returnSingleQuery("SELECT STRTPOSTCODE AS ANSWER FROM AGREEMENT WHERE AGREEMENTID = '" + agreementID.getText()  + "'"));
        int agStrtStreetNo = Integer.parseInt(d.returnSingleQuery("SELECT STRTSTREETNO AS ANSWER FROM AGREEMENT WHERE AGREEMENTID = '" + agreementID.getText()  + "'"));
        String agStrtStreetName = d.returnSingleQuery("SELECT STRTSTREETNAME AS ANSWER FROM AGREEMENT WHERE AGREEMENTID = '" + agreementID.getText()  + "'");
        String agEndSuburb = d.returnSingleQuery("SELECT ENDSUBURB AS ANSWER FROM AGREEMENT WHERE AGREEMENTID = '" + agreementID.getText()  + "'");
        int agEndPostCode = Integer.parseInt(d.returnSingleQuery("SELECT ENDPOSTCODE AS ANSWER FROM AGREEMENT WHERE AGREEMENTID = '" + agreementID.getText()  + "'"));
        int agEndStreetNo = Integer.parseInt(d.returnSingleQuery("SELECT ENDSTREETNO AS ANSWER FROM AGREEMENT WHERE AGREEMENTID = '" + agreementID.getText()  + "'"));
        String agEndStreetName = d.returnSingleQuery("SELECT ENDSTREETNAME AS ANSWER FROM AGREEMENT WHERE AGREEMENTID = '" + agreementID.getText()  + "'");
        String agDate = d.returnSingleQuery("SELECT DATE AS ANSWER FROM AGREEMENT WHERE AGREEMENTID = '" + agreementID.getText()  + "'");
        double agPrice = Double.parseDouble(d.returnSingleQuery("SELECT PRICE AS ANSWER FROM AGREEMENT WHERE AGREEMENTID = '" + agreementID.getText()  + "'"));
        String agPickUpTime = d.returnSingleQuery("SELECT PICKUPTIME AS ANSWER FROM AGREEMENT WHERE AGREEMENTID = '" + agreementID.getText()  + "'");
        long agPaymentID = Long.parseLong(d.returnSingleQuery("SELECT PAYMENTID AS ANSWER FROM AGREEMENT WHERE AGREEMENTID = '" + agreementID.getText()  + "'"));
        int agNumSeatsRequired = Integer.parseInt(d.returnSingleQuery("SELECT PAYMENTID AS ANSWER FROM AGREEMENT WHERE AGREEMENTID = '" + agreementID.getText()  + "'")); 
    
        String adStrtSuburb = d.returnSingleQuery("SELECT STRTSUBURB AS ANSWER FROM ADJUSTMENT WHERE ADJUSTMENTID = '" + adjustmentID.getText()  + "'");
        int adStrtPostCode = Integer.parseInt(d.returnSingleQuery("SELECT STRTPOSTCODE AS ANSWER FROM ADJUSTMENT WHERE ADJUSTMENTID = '" + adjustmentID.getText()  + "'"));
        int adStrtStreetNo = Integer.parseInt(d.returnSingleQuery("SELECT STRTSTREETNO AS ANSWER FROM ADJUSTMENT WHERE ADJUSTMENTID = '" + adjustmentID.getText()  + "'"));
        String adStrtStreetName = d.returnSingleQuery("SELECT STRTSTREETNAME AS ANSWER FROM ADJUSTMENT WHERE ADJUSTMENTID = '" + adjustmentID.getText()  + "'");
        String adEndSuburb = d.returnSingleQuery("SELECT ENDSUBURB AS ANSWER FROM ADJUSTMENT WHERE ADJUSTMENTID = '" + adjustmentID.getText()  + "'");
        int adEndPostCode = Integer.parseInt(d.returnSingleQuery("SELECT ENDPOSTCODE AS ANSWER FROM ADJUSTMENT WHERE ADJUSTMENTID = '" + adjustmentID.getText()  + "'"));
        int adEndStreetNo = Integer.parseInt(d.returnSingleQuery("SELECT ENDSTREETNO AS ANSWER FROM ADJUSTMENT WHERE ADJUSTMENTID = '" + adjustmentID.getText()  + "'"));
        String adEndStreetName = d.returnSingleQuery("SELECT ENDSTREETNAME AS ANSWER FROM ADJUSTMENT WHERE ADJUSTMENTID = '" + adjustmentID.getText()  + "'");
        String adDate = d.returnSingleQuery("SELECT DATE AS ANSWER FROM ADJUSTMENT WHERE ADJUSTMENTID = '" + adjustmentID.getText()  + "'");
        double adPrice = Double.parseDouble(d.returnSingleQuery("SELECT PRICE AS ANSWER FROM ADJUSTMENT WHERE ADJUSTMENTID = '" + adjustmentID.getText()  + "'"));
        String adPickUpTime = d.returnSingleQuery("SELECT PICKUPTIME AS ANSWER FROM ADJUSTMENT WHERE ADJUSTMENTID = '" + adjustmentID.getText()  + "'");
        long adPaymentID = Long.parseLong(d.returnSingleQuery("SELECT PAYMENTID AS ANSWER FROM ADJUSTMENT WHERE ADJUSTMENTID = '" + adjustmentID.getText()  + "'"));
        int adNumSeatsRequired = Integer.parseInt(d.returnSingleQuery("SELECT PAYMENTID AS ANSWER FROM ADJUSTMENT WHERE ADJUSTMENTID = '" + adjustmentID.getText()  + "'"));
    
        if (!agStrtSuburb.equals(adStrtSuburb)) {
            d.Insert("UPDATE AGREEMENT "
                + "SET STRTSUBURB = '" + adStrtSuburb + "'"
                + "WHERE AGREEMENTID = '" + agreementID.getText() + "'");   
        }
        
        if (agStrtPostCode != adStrtPostCode) {
            d.Insert("UPDATE AGREEMENT "
                + "SET STRTPOSTCODE = '" + adStrtPostCode + "'"
                + "WHERE AGREEMENTID = '" + agreementID.getText() + "'");   
        }
        
        if (agStrtStreetNo != adStrtStreetNo) {
            d.Insert("UPDATE AGREEMENT "
                + "SET STRTSTREETNO = '" + adStrtStreetNo + "'"
                + "WHERE AGREEMENTID = '" + agreementID.getText() + "'");   
        }
        
        if (!agStrtStreetName.equals(adStrtStreetName)) {
            d.Insert("UPDATE AGREEMENT "
                + "SET STRTSTREETNAME = '" + adStrtStreetName + "'"
                + "WHERE AGREEMENTID = '" + agreementID.getText() + "'");   
        }
        
        if (!agEndSuburb.equals(adEndSuburb)) {
            d.Insert("UPDATE AGREEMENT "
                + "SET ENDSUBURB = '" + adEndSuburb + "'"
                + "WHERE AGREEMENTID = '" + agreementID.getText() + "'");   
        }
        
        if (agEndPostCode != adEndPostCode) {
            d.Insert("UPDATE AGREEMENT "
                + "SET ENDPOSTCODE = '" + adEndPostCode + "'"
                + "WHERE AGREEMENTID = '" + agreementID.getText() + "'");   
        }
        
        if (agEndStreetNo != adEndStreetNo) {
            d.Insert("UPDATE AGREEMENT "
                + "SET ENDSTREETNO = '" + adEndStreetNo + "'"
                + "WHERE AGREEMENTID = '" + agreementID.getText() + "'");   
        }
        
        if (!agEndStreetName.equals(adEndStreetName)) {
            d.Insert("UPDATE AGREEMENT "
                + "SET ENDSTREETNAME = '" + adEndStreetName + "'"
                + "WHERE AGREEMENTID = '" + agreementID.getText() + "'");   
        }
        
        if (!agDate.equals(adDate)) {
            d.Insert("UPDATE AGREEMENT "
                + "SET DATE = '" + adDate + "'"
                + "WHERE AGREEMENTID = '" + agreementID.getText() + "'");   
        }
        
        if (agPrice != adPrice) {
            d.Insert("UPDATE AGREEMENT "
                + "SET PRICE = '" + adPrice + "' "
                + "WHERE AGREEMENTID = '" + agreementID.getText() + "'");   
        }
        
        if (!agPickUpTime.equals(adPickUpTime)) {
            d.Insert("UPDATE AGREEMENT "
                + "SET PICKUPTIME = '" + adPickUpTime + "'"
                + "WHERE AGREEMENTID = '" + agreementID.getText() + "'");   
        }
        
        
        if (agPaymentID != adPaymentID) {
            d.Insert("UPDATE AGREEMENT "
                + "SET PAYMENTID = '" + adPaymentID + "'"
                + "WHERE AGREEMENTID = '" + agreementID.getText() + "'");   
        }
        
        if (agNumSeatsRequired != adNumSeatsRequired) {
            d.Insert("UPDATE AGREEMENT "
                + "SET NUMSEATSREQUIRED = '" + adNumSeatsRequired + "'"
                + "WHERE AGREEMENTID = '" + agreementID.getText() + "'");   
        }
        
        d.Insert("UPDATE ADJUSTMENT SET STATUS = 'Approved' WHERE ADJUSTMENTID = '" + adjustmentID.getText() + "'");
        refreshTable();
        Single.setVisible(false);
    }
    
    public void refreshTable() {
        adjustmentList.clear();
        getAdjustments();
        Table.setItems(FXCollections.observableArrayList(adjustmentList));
    }
}


