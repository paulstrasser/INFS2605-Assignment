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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
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
public class StaffMatchesController implements Initializable {

    @FXML
    Stage stage;
    Parent root;
    
    @FXML
    private Button Signout;
    
    @FXML
    private Button NormalMembers;
    
    @FXML
    private Button CorporateMembers;
    
    @FXML
    private Button Staff;
    
    @FXML
    private Button Offers;
    
    @FXML
    private Button Seeks;
    
    @FXML
    private Button Matches;
    
    @FXML
    private TableView<Agreement> Table;
    
    @FXML
    private TableColumn<Agreement, String> agreementIDCol;
    
    @FXML
    private TableColumn<Agreement, String> seekIDCol;

    @FXML
    private TableColumn<Agreement, String> seekerIDCol;

    @FXML
    private TableColumn<Agreement, String> offerIDCol;

    @FXML
    private TableColumn<Agreement, String> offererIDCol;

    @FXML
    private TableColumn<Agreement, String> strtSuburbCol;
    
    @FXML
    private TableColumn<Agreement, String> strtPostCodeCol;
    
    @FXML
    private TableColumn<Agreement, String> strtStreetNoCol;
    
    @FXML
    private TableColumn<Agreement, String> strtStreetNameCol;
    
    @FXML
    private TableColumn<Agreement, String> endSuburbCol;
    
    @FXML
    private TableColumn<Agreement, String> endPostCodeCol;
    
    @FXML
    private TableColumn<Agreement, String> endStreetNoCol;
    
    @FXML
    private TableColumn<Agreement, String> endStreetNameCol;
    
    @FXML
    private TableColumn<Agreement, String> dateCol;
    
    @FXML
    private TableColumn<Agreement, String> priceCol;
    
    @FXML
    private TableColumn<Agreement, String> pickUpTimeCol;
    
    @FXML
    private TableColumn<Agreement, String> dateCreatedCol;
    
    @FXML
    private TableColumn<Agreement, String> statusCol;
    
    @FXML
    private TableColumn<Agreement, String> paymentIDCol;
    
    @FXML
    private TableColumn<Agreement, String> numSeatsRequiredCol;
    
    @FXML
    private ComboBox SearchBy;
    
    @FXML
    private TextField SearchValue;
    
    @FXML
    private DatePicker SearchDate;
    
    @FXML
    private ComboBox SearchCombo;
    
    @FXML
    private AnchorPane refreshSearch;
    
    @FXML
    private Button Search;
    
    @FXML
    private AnchorPane Single;
    
    @FXML
    private Label agreementID;
    
    @FXML
    private Label seekID;
    
    @FXML
    private Label seekerID;
    
    @FXML
    private Label offerID;
    
    @FXML
    private Label offererID;
    
    @FXML
    private Label dateCreated;
    
    @FXML
    private Label status;
    
    @FXML
    private Label strtStreetNo;
    
    @FXML
    private Label strtStreet;
    
    @FXML
    private Label strtSuburb;
    
    @FXML
    private Label strtPostCode;
    
    @FXML
    private Label endStreetNo;
    
    @FXML
    private Label endStreet;
    
    @FXML
    private Label endSuburb;
    
    @FXML
    private Label endPostCode;
    
    @FXML
    private Label date;
    
    @FXML
    private Label price;
    
    @FXML
    private Label pickUpTime;
    
    @FXML
    private Label numberOfSeats;
    
    @FXML
    private Button Back;
    
    @FXML
    private Text Name;
    
    
    @FXML
    private void SignOut(ActionEvent event) throws Exception { //Goes Back to Sign in Screen

        stage=(Stage) Signout.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("Sign In.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
    }

    @FXML
    private void NormalMembers(ActionEvent event) throws Exception { //Goes to 'Normal Members' screen

        stage=(Stage) NormalMembers.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("StaffNormalMembers.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
    }
    
    @FXML
    private void CorporateMembers(ActionEvent event) throws Exception { //Goes to 'Corporate Members' screen

        stage=(Stage) CorporateMembers.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("StaffCorporateMembers.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
    }
    
    @FXML
    private void Staff(ActionEvent event) throws Exception { //Goes to 'Staff' screen

        stage=(Stage) Staff.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("StaffViewStaff.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
    }
    
    @FXML
    private void Offers(ActionEvent event) throws Exception { //Goes to 'Offers' screen

        stage=(Stage) Offers.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("StaffOffers.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
    }
    
    @FXML
    private void Seeks(ActionEvent event) throws Exception { //Goes to 'Seeks' screen

        stage=(Stage) Seeks.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("StaffSeeks.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
    }
    
    @FXML
    private void Matches(ActionEvent event) throws Exception { //Goes to 'Matches' screen

        stage=(Stage) Matches.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("StaffMatches.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
    }
    
    DBController d = new DBController(); //Establish a connection to the db
    
    ArrayList<Agreement> matchList = new ArrayList<>(); //Creates the array list
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Name.setText(d.returnSingleQuery("SELECT FNAME AS ANSWER FROM STAFF WHERE USERNAME LIKE '" + SignInController.getUser() + "'"));
        
        Single.setVisible(false);
        
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
        
        getMatches();
        
        Table.setItems(FXCollections.observableArrayList(matchList));
        
        Table.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showMatch(newValue));
        
        SearchBy.getItems().addAll("ID", "Seek ID", "Seeker ID", "Offer ID", "Offerer ID", "Starting Suburb", "Ending Suburb", "Date", "Date Created", "Price", "Status", "Number of Seats");
        SearchCombo.getItems().addAll("Pending", "Matched, Completed, Paid");
        SearchValue.setVisible(true);
        SearchDate.setVisible(false);
        SearchCombo.setVisible(false);
    }   
    
    public void getMatches() {
        try {
            matchList.clear();
            ResultSet rs = d.getResultSet("SELECT * FROM AGREEMENT");
            while (rs.next()) {
                matchList.add(new Agreement(rs.getLong("AGREEMENTID"), rs.getLong("SEEKID"), rs.getLong("SEEKERID"), rs.getLong("OFFERID"), rs.getLong("OFFERERID"), rs.getString("STRTSUBURB"), rs.getInt("STRTPOSTCODE"), rs.getInt("STRTSTREETNO"), rs.getString("STRTSTREETNAME"), rs.getString("ENDSUBURB"), rs.getInt("ENDPOSTCODE"), rs.getInt("ENDSTREETNO"), rs.getString("ENDSTREETNAME"), rs.getString("DATE"), rs.getDouble("PRICE"), rs.getString("PICKUPTIME"), rs.getString("DATECREATED"), rs.getString("STATUS"), rs.getLong("PAYMENTID"), rs.getInt("NUMSEATSREQUIRED")));
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(StaffMatchesController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void showMatch(Agreement agreement) {
        Single.setVisible(true);
        agreementID.setText(agreement.getAgreementID());
        seekID.setText(agreement.getSeekID());
        seekerID.setText(agreement.getSeekerID());
        offerID.setText(agreement.getOfferID());
        offererID.setText(agreement.getOffererID());
        dateCreated.setText(agreement.getDateCreated());
        status.setText(agreement.getStatus());
        strtStreetNo.setText(agreement.getStrtStreetNo());
        strtStreet.setText(agreement.getStrtStreetName());
        strtSuburb.setText(agreement.getStrtSuburb());
        strtPostCode.setText(agreement.getStrtPostCode());
        endStreetNo.setText(agreement.getEndStreetNo());
        endStreet.setText(agreement.getEndStreetName());
        endSuburb.setText(agreement.getEndSuburb());
        endPostCode.setText(agreement.getEndPostCode());
        date.setText(agreement.getDate());
        price.setText(agreement.getPrice());
        pickUpTime.setText(agreement.getPickUpTime());
        numberOfSeats.setText(agreement.getNumSeatsRequired());
    }
    
    @FXML
    private void Back(ActionEvent event) throws Exception {
        Single.setVisible(false);
    }
    
    @FXML
    private void ComboBoxChoice(ActionEvent event) throws Exception {
        String SearchByType = (String) SearchBy.getSelectionModel().getSelectedItem();
       
        if (SearchByType.equals("ID")) {
            SearchValue.setVisible(true);
            SearchDate.setVisible(false);
            SearchCombo.setVisible(false);
        }
        else if (SearchByType.equals("Seek ID")) {
            SearchValue.setVisible(true);
            SearchDate.setVisible(false);
            SearchCombo.setVisible(false);
        }
        else if (SearchByType.equals("Seeker ID")) {
            SearchValue.setVisible(true);
            SearchDate.setVisible(false);
            SearchCombo.setVisible(false);
        }
        else if (SearchByType.equals("Offer ID")) {
            SearchValue.setVisible(true);
            SearchDate.setVisible(false);
            SearchCombo.setVisible(false);
        }
        else if (SearchByType.equals("Offerer ID")) {
            SearchValue.setVisible(true);
            SearchDate.setVisible(false);
            SearchCombo.setVisible(false);
        }
        else if (SearchByType.equals("Starting Suburb")) {
            SearchValue.setVisible(true);
            SearchDate.setVisible(false);
            SearchCombo.setVisible(false);
        }
        else if (SearchByType.equals("End Suburb")) {
            SearchValue.setVisible(true);
            SearchDate.setVisible(false);
            SearchCombo.setVisible(false);
        }
        else if (SearchByType.equals("Date")) {
            SearchDate.setVisible(true);
            SearchValue.setVisible(false);
            SearchCombo.setVisible(false);
        }
        else if (SearchByType.equals("Date Created")) {
            SearchDate.setVisible(true);
            SearchValue.setVisible(false);
            SearchCombo.setVisible(false);
        }
        else if (SearchByType.equals("Price")) {
            SearchValue.setVisible(true);
            SearchDate.setVisible(false);
            SearchCombo.setVisible(false);
        }
        else if (SearchByType.equals("Status")) {
            SearchValue.setVisible(false);
            SearchDate.setVisible(false);
            SearchCombo.setVisible(true);
        }
        else if (SearchByType.equals("Number of Seats")) {
            SearchValue.setVisible(true);
            SearchDate.setVisible(false);
            SearchCombo.setVisible(false);
        }
    }
    
    @FXML
    private void Search(ActionEvent event) throws Exception { //Goes to 'Staff' screen
        
        String SearchByType = (String) SearchBy.getSelectionModel().getSelectedItem();        
        
        matchList.clear();
        try {
            ResultSet rs;
            switch (SearchByType) {
                case "ID":
                    rs = d.getResultSet("SELECT * "
                            + "FROM AGREEMENT "
                            + "WHERE AGREEMENTID  = '" + SearchValue.getText() + "'");
                    while (rs.next()) {
                        matchList.add(new Agreement(rs.getLong("AGREEMENTID"), rs.getLong("SEEKID"), rs.getLong("SEEKERID"), rs.getLong("OFFERID"), rs.getLong("OFFERERID"), rs.getString("STRTSUBURB"), rs.getInt("STRTPOSTCODE"), rs.getInt("STRTSTREETNO"), rs.getString("STRTSTREETNAME"), rs.getString("ENDSUBURB"), rs.getInt("ENDPOSTCODE"), rs.getInt("ENDSTREETNO"), rs.getString("ENDSTREETNAME"), rs.getString("DATE"), rs.getDouble("PRICE"), rs.getString("PICKUPTIME"), rs.getString("DATECREATED"), rs.getString("STATUS"), rs.getLong("PAYMENTID"), rs.getInt("NUMSEATSREQUIRED")));
                    }
                    break;
                case "Seek ID":
                    rs = d.getResultSet("SELECT * "
                            + "FROM AGREEMENT "
                            + "WHERE SEEKID  = '" + SearchValue.getText() + "'");
                    while (rs.next()) {
                        matchList.add(new Agreement(rs.getLong("AGREEMENTID"), rs.getLong("SEEKID"), rs.getLong("SEEKERID"), rs.getLong("OFFERID"), rs.getLong("OFFERERID"), rs.getString("STRTSUBURB"), rs.getInt("STRTPOSTCODE"), rs.getInt("STRTSTREETNO"), rs.getString("STRTSTREETNAME"), rs.getString("ENDSUBURB"), rs.getInt("ENDPOSTCODE"), rs.getInt("ENDSTREETNO"), rs.getString("ENDSTREETNAME"), rs.getString("DATE"), rs.getDouble("PRICE"), rs.getString("PICKUPTIME"), rs.getString("DATECREATED"), rs.getString("STATUS"), rs.getLong("PAYMENTID"), rs.getInt("NUMSEATSREQUIRED")));
                    }
                    break;
                case "Seeker ID":
                    rs = d.getResultSet("SELECT * "
                            + "FROM AGREEMENT "
                            + "WHERE SEEKERID  = '" + SearchValue.getText() + "'");
                    while (rs.next()) {
                        matchList.add(new Agreement(rs.getLong("AGREEMENTID"), rs.getLong("SEEKID"), rs.getLong("SEEKERID"), rs.getLong("OFFERID"), rs.getLong("OFFERERID"), rs.getString("STRTSUBURB"), rs.getInt("STRTPOSTCODE"), rs.getInt("STRTSTREETNO"), rs.getString("STRTSTREETNAME"), rs.getString("ENDSUBURB"), rs.getInt("ENDPOSTCODE"), rs.getInt("ENDSTREETNO"), rs.getString("ENDSTREETNAME"), rs.getString("DATE"), rs.getDouble("PRICE"), rs.getString("PICKUPTIME"), rs.getString("DATECREATED"), rs.getString("STATUS"), rs.getLong("PAYMENTID"), rs.getInt("NUMSEATSREQUIRED")));
                    }
                    break;
                case "Offer ID":
                    rs = d.getResultSet("SELECT * "
                            + "FROM AGREEMENT "
                            + "WHERE OFFERID  = '" + SearchValue.getText() + "'");
                    while (rs.next()) {
                        matchList.add(new Agreement(rs.getLong("AGREEMENTID"), rs.getLong("SEEKID"), rs.getLong("SEEKERID"), rs.getLong("OFFERID"), rs.getLong("OFFERERID"), rs.getString("STRTSUBURB"), rs.getInt("STRTPOSTCODE"), rs.getInt("STRTSTREETNO"), rs.getString("STRTSTREETNAME"), rs.getString("ENDSUBURB"), rs.getInt("ENDPOSTCODE"), rs.getInt("ENDSTREETNO"), rs.getString("ENDSTREETNAME"), rs.getString("DATE"), rs.getDouble("PRICE"), rs.getString("PICKUPTIME"), rs.getString("DATECREATED"), rs.getString("STATUS"), rs.getLong("PAYMENTID"), rs.getInt("NUMSEATSREQUIRED")));
                    }
                    break;
                case "OFFERER ID":
                    rs = d.getResultSet("SELECT * "
                            + "FROM AGREEMENT "
                            + "WHERE OFFERERID  = '" + SearchValue.getText() + "'");
                    while (rs.next()) {
                        matchList.add(new Agreement(rs.getLong("AGREEMENTID"), rs.getLong("SEEKID"), rs.getLong("SEEKERID"), rs.getLong("OFFERID"), rs.getLong("OFFERERID"), rs.getString("STRTSUBURB"), rs.getInt("STRTPOSTCODE"), rs.getInt("STRTSTREETNO"), rs.getString("STRTSTREETNAME"), rs.getString("ENDSUBURB"), rs.getInt("ENDPOSTCODE"), rs.getInt("ENDSTREETNO"), rs.getString("ENDSTREETNAME"), rs.getString("DATE"), rs.getDouble("PRICE"), rs.getString("PICKUPTIME"), rs.getString("DATECREATED"), rs.getString("STATUS"), rs.getLong("PAYMENTID"), rs.getInt("NUMSEATSREQUIRED")));
                    }
                    break;
                case "Starting Suburb":
                    rs = d.getResultSet("SELECT * "
                            + "FROM AGREEMENT "
                            + "WHERE STRTSUBURB  LIKE '%" + SearchValue.getText() + "%'");
                    while (rs.next()) {
                        matchList.add(new Agreement(rs.getLong("AGREEMENTID"), rs.getLong("SEEKID"), rs.getLong("SEEKERID"), rs.getLong("OFFERID"), rs.getLong("OFFERERID"), rs.getString("STRTSUBURB"), rs.getInt("STRTPOSTCODE"), rs.getInt("STRTSTREETNO"), rs.getString("STRTSTREETNAME"), rs.getString("ENDSUBURB"), rs.getInt("ENDPOSTCODE"), rs.getInt("ENDSTREETNO"), rs.getString("ENDSTREETNAME"), rs.getString("DATE"), rs.getDouble("PRICE"), rs.getString("PICKUPTIME"), rs.getString("DATECREATED"), rs.getString("STATUS"), rs.getLong("PAYMENTID"), rs.getInt("NUMSEATSREQUIRED")));
                    }
                    break;
                case "End Suburb":
                    rs = d.getResultSet("SELECT * "
                            + "FROM AGREEMENT "
                            + "WHERE ENDSUBURB  LIKE '%" + SearchValue.getText() + "%'");
                    while (rs.next()) {
                        matchList.add(new Agreement(rs.getLong("AGREEMENTID"), rs.getLong("SEEKID"), rs.getLong("SEEKERID"), rs.getLong("OFFERID"), rs.getLong("OFFERERID"), rs.getString("STRTSUBURB"), rs.getInt("STRTPOSTCODE"), rs.getInt("STRTSTREETNO"), rs.getString("STRTSTREETNAME"), rs.getString("ENDSUBURB"), rs.getInt("ENDPOSTCODE"), rs.getInt("ENDSTREETNO"), rs.getString("ENDSTREETNAME"), rs.getString("DATE"), rs.getDouble("PRICE"), rs.getString("PICKUPTIME"), rs.getString("DATECREATED"), rs.getString("STATUS"), rs.getLong("PAYMENTID"), rs.getInt("NUMSEATSREQUIRED")));
                    }
                    break;
                case "Date":
                    rs = d.getResultSet("SELECT * "
                            + "FROM AGREEMENT "
                            + "WHERE DATE  = '" + SearchDate.getValue().toString() + "'");
                    while (rs.next()) {
                        matchList.add(new Agreement(rs.getLong("AGREEMENTID"), rs.getLong("SEEKID"), rs.getLong("SEEKERID"), rs.getLong("OFFERID"), rs.getLong("OFFERERID"), rs.getString("STRTSUBURB"), rs.getInt("STRTPOSTCODE"), rs.getInt("STRTSTREETNO"), rs.getString("STRTSTREETNAME"), rs.getString("ENDSUBURB"), rs.getInt("ENDPOSTCODE"), rs.getInt("ENDSTREETNO"), rs.getString("ENDSTREETNAME"), rs.getString("DATE"), rs.getDouble("PRICE"), rs.getString("PICKUPTIME"), rs.getString("DATECREATED"), rs.getString("STATUS"), rs.getLong("PAYMENTID"), rs.getInt("NUMSEATSREQUIRED")));
                    }
                    break;
                case "Date Created":
                    rs = d.getResultSet("SELECT * "
                            + "FROM AGREEMENT "
                            + "WHERE DATECREATED  = '" + SearchDate.getValue().toString() + "'");
                    while (rs.next()) {
                        matchList.add(new Agreement(rs.getLong("AGREEMENTID"), rs.getLong("SEEKID"), rs.getLong("SEEKERID"), rs.getLong("OFFERID"), rs.getLong("OFFERERID"), rs.getString("STRTSUBURB"), rs.getInt("STRTPOSTCODE"), rs.getInt("STRTSTREETNO"), rs.getString("STRTSTREETNAME"), rs.getString("ENDSUBURB"), rs.getInt("ENDPOSTCODE"), rs.getInt("ENDSTREETNO"), rs.getString("ENDSTREETNAME"), rs.getString("DATE"), rs.getDouble("PRICE"), rs.getString("PICKUPTIME"), rs.getString("DATECREATED"), rs.getString("STATUS"), rs.getLong("PAYMENTID"), rs.getInt("NUMSEATSREQUIRED")));
                    }
                    break;
                case "Price":
                    rs = d.getResultSet("SELECT * "
                            + "FROM AGREEMENT "
                            + "WHERE PRICE  = '" + SearchValue.getText() + "'");
                    while (rs.next()) {
                        matchList.add(new Agreement(rs.getLong("AGREEMENTID"), rs.getLong("SEEKID"), rs.getLong("SEEKERID"), rs.getLong("OFFERID"), rs.getLong("OFFERERID"), rs.getString("STRTSUBURB"), rs.getInt("STRTPOSTCODE"), rs.getInt("STRTSTREETNO"), rs.getString("STRTSTREETNAME"), rs.getString("ENDSUBURB"), rs.getInt("ENDPOSTCODE"), rs.getInt("ENDSTREETNO"), rs.getString("ENDSTREETNAME"), rs.getString("DATE"), rs.getDouble("PRICE"), rs.getString("PICKUPTIME"), rs.getString("DATECREATED"), rs.getString("STATUS"), rs.getLong("PAYMENTID"), rs.getInt("NUMSEATSREQUIRED")));
                    }
                    break;
                case "Status":
                    rs = d.getResultSet("SELECT * "
                            + "FROM AGREEMENT "
                            + "WHERE STATUS  = '" + SearchCombo.getSelectionModel().getSelectedItem().toString() + "'");
                    while (rs.next()) {
                        matchList.add(new Agreement(rs.getLong("AGREEMENTID"), rs.getLong("SEEKID"), rs.getLong("SEEKERID"), rs.getLong("OFFERID"), rs.getLong("OFFERERID"), rs.getString("STRTSUBURB"), rs.getInt("STRTPOSTCODE"), rs.getInt("STRTSTREETNO"), rs.getString("STRTSTREETNAME"), rs.getString("ENDSUBURB"), rs.getInt("ENDPOSTCODE"), rs.getInt("ENDSTREETNO"), rs.getString("ENDSTREETNAME"), rs.getString("DATE"), rs.getDouble("PRICE"), rs.getString("PICKUPTIME"), rs.getString("DATECREATED"), rs.getString("STATUS"), rs.getLong("PAYMENTID"), rs.getInt("NUMSEATSREQUIRED")));
                    }
                    break;
                case "Number of Seats":
                    rs = d.getResultSet("SELECT * "
                            + "FROM AGREEMENT "
                            + "WHERE NUMSEATSREQUIRED  = '" + SearchValue.getText() + "'");
                    while (rs.next()) {
                        matchList.add(new Agreement(rs.getLong("AGREEMENTID"), rs.getLong("SEEKID"), rs.getLong("SEEKERID"), rs.getLong("OFFERID"), rs.getLong("OFFERERID"), rs.getString("STRTSUBURB"), rs.getInt("STRTPOSTCODE"), rs.getInt("STRTSTREETNO"), rs.getString("STRTSTREETNAME"), rs.getString("ENDSUBURB"), rs.getInt("ENDPOSTCODE"), rs.getInt("ENDSTREETNO"), rs.getString("ENDSTREETNAME"), rs.getString("DATE"), rs.getDouble("PRICE"), rs.getString("PICKUPTIME"), rs.getString("DATECREATED"), rs.getString("STATUS"), rs.getLong("PAYMENTID"), rs.getInt("NUMSEATSREQUIRED")));
                    }
                    break;        
                default:
                    break;
            }

            Table.setItems(FXCollections.observableArrayList(matchList));
            SearchDate.getEditor().clear();
            SearchValue.clear();
            SearchCombo.getEditor().clear();    
        }
        catch (SQLException ex) {
            Logger.getLogger(StaffMatchesController.class.getName()).log(Level.SEVERE, null, ex);
        }

        }
    
    @FXML
    private void clearSearch(MouseEvent event) throws Exception {
         refreshTable();
    }
    
    
    public void refreshTable() {
        matchList.clear();
        getMatches();
        Table.setItems(FXCollections.observableArrayList(matchList));
    }
   
}    

  
    

