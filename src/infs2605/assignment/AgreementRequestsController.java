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
public class AgreementRequestsController implements Initializable {

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
    private MenuItem AgreementRequests;
    
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
    private AnchorPane Single;
    
    @FXML
    private Label agreementID;
    
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
    private Button Complete;
    
    @FXML
    private Button Submit;
    
    @FXML
    private Button Pay;
    
    @FXML
    private Button CompletePay;
    
    @FXML
    private AnchorPane PayPane;
    
    @FXML
    private TextField PSeekerID;
    
    @FXML
    private TextField POffererID;
    
    @FXML
    private TextField NameOnCard;
    
    @FXML
    private TextField CardNum;
    
    @FXML
    private DatePicker CardExpiry;
    
    @FXML
    private TextField CVV;
    
    @FXML
    private Label Amount;
    
    @FXML
    private Button Back;
    
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
    
    ArrayList<Agreement> agreementList = new ArrayList<>();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Name.setText(d.returnSingleQuery("SELECT FNAME AS ANSWER FROM USER WHERE USERNAME LIKE '" + SignInController.getUser() + "'"));
        Single.setVisible(false);
        PayPane.setVisible(false);
        tfSeekID.setVisible(false);
        tfOfferID.setVisible(false);
        tfSeekerID.setEditable(false);
        tfOffererID.setEditable(false);
        dateCreated.setEditable(false);
        status.setEditable(false);

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
        
        Table.setItems(FXCollections.observableArrayList(agreementList));
        
        Table.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showMatch(newValue));
        
        /*SearchBy.getItems().addAll("ID", "Seek ID", "Seeker ID", "Offer ID", "Offerer ID", "Starting Suburb", "Ending Suburb", "Date", "Date Created", "Price", "Status", "Number of Seats");
        SearchCombo.getItems().addAll("Pending", "Matched");
        SearchValue.setVisible(true);
        SearchDate.setVisible(false);
        SearchCombo.setVisible(false);*/
        
    
    } 
    
    public void getMatches() {
        try {
            agreementList.clear();
            ResultSet rs = d.getResultSet("SELECT * FROM AGREEMENT");
            while (rs.next()) {
                agreementList.add(new Agreement(rs.getLong("AGREEMENTID"), rs.getLong("SEEKID"), rs.getLong("SEEKERID"), rs.getLong("OFFERID"), rs.getLong("OFFERERID"), rs.getString("STRTSUBURB"), rs.getInt("STRTPOSTCODE"), rs.getInt("STRTSTREETNO"), rs.getString("STRTSTREETNAME"), rs.getString("ENDSUBURB"), rs.getInt("ENDPOSTCODE"), rs.getInt("ENDSTREETNO"), rs.getString("ENDSTREETNAME"), rs.getString("DATE"), rs.getDouble("PRICE"), rs.getString("PICKUPTIME"), rs.getString("DATECREATED"), rs.getString("STATUS"), rs.getLong("PAYMENTID"), rs.getInt("NUMSEATSREQUIRED")));
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(StaffMatchesController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void showMatch(Agreement agreement) {
        Single.setVisible(true);
        agreementID.setText(agreement.getAgreementID());
        tfSeekID.setText(agreement.getSeekID());
        tfSeekerID.setText(agreement.getSeekerID());
        tfOfferID.setText(agreement.getOfferID());
        tfOffererID.setText(agreement.getOffererID());
        LocalDate dateC = LocalDate.parse(agreement.getDateCreated());
        dateCreated.setValue(dateC);
        status.setText(agreement.getStatus());
        tfStrtStreetNo.setText(agreement.getStrtStreetNo());
        tfStrtStreet.setText(agreement.getStrtStreetName());
        tfStrtSuburb.setText(agreement.getStrtSuburb());
        tfStrtPostCode.setText(agreement.getStrtPostCode());
        tfEndStreetNo.setText(agreement.getEndStreetNo());
        tfEndStreet.setText(agreement.getEndStreetName());
        tfEndSuburb.setText(agreement.getEndSuburb());
        tfEndPostCode.setText(agreement.getEndPostCode());
        LocalDate date2 = LocalDate.parse(agreement.getDate());
        date.setValue(date2);
        price.setText(agreement.getPrice());
        pickUpTime.setText(agreement.getPickUpTime());
        numOfSeats.setText(agreement.getNumSeatsRequired());
        String status = d.returnSingleQuery("SELECT STATUS AS ANSWER FROM AGREEMENT WHERE AGREEMENTID = " + agreementID.getText());
        int thisUser = Integer.parseInt(d.returnSingleQuery("SELECT USERID AS ANSWER FROM USER WHERE USERNAME LIKE '" + SignInController.getUser() + "'"));

        if (status.equals("Completed") && thisUser == Integer.parseInt(tfSeekerID.getText())) {
            Pay.setVisible(true);
        }
        else {
            Pay.setVisible(false);
        }
    }
    
    public void Cancel(ActionEvent event) throws Exception {
        Single.setVisible(false);
    }
    
    public void Complete(ActionEvent event) throws Exception {
        d.Insert("UPDATE AGREEMENT "
                + "SET STATUS = 'Completed' "
                + "WHERE AGREEMENTID = " + Long.parseLong(agreementID.getText()));
        
        Single.setVisible(false);
        refreshTable();
    }
    
    public void Submit(ActionEvent event) throws Exception {
        long AddAgreementID = Long.parseLong(agreementID.getText());
        long AddSeekerID = Long.parseLong(tfSeekerID.getText());
        long AddOffererID = Long.parseLong(tfOffererID.getText());
        long AddSeekID = Long.parseLong(tfSeekID.getText());
        long AddOfferID = Long.parseLong(tfOfferID.getText());
        String AddStrtSuburb = tfStrtSuburb.getText();
        String AddStrtPostCode = tfStrtPostCode.getText();
        String AddStrtStreetNo = tfStrtStreetNo.getText();
        String AddStrtStreet = tfStrtStreet.getText();
        String AddEndSuburb = tfEndSuburb.getText();
        String AddEndPostCode = tfEndPostCode.getText();
        String AddEndStreetNo = tfEndStreetNo.getText();
        String AddEndStreet = tfEndStreet.getText();
        LocalDate AddDate = date.getValue();
        double AddPrice = Double.parseDouble(price.getText());
        String AddPickUpTime = pickUpTime.getText();
        LocalDate AddDateCreated = dateCreated.getValue();
        String AddStatus = "Pending";
        int AddNumOfSeats = Integer.parseInt(numOfSeats.getText());
        
        int thisPK = Integer.parseInt(d.returnSingleQuery("SELECT MAX(ADJUSTMENTID) AS ANSWER FROM ADJUSTMENT"))+1;
        System.out.println("0");
        long thisUser = Long.parseLong(d.returnSingleQuery("SELECT USERID AS ANSWER FROM USER WHERE USERNAME LIKE '" + SignInController.getUser() + "'"));
        
        long AddPaymentID = 0;
        
        
        System.out.println("1");
            try {
               d.Insert("INSERT INTO ADJUSTMENT(ADJUSTMENTID, AGREEMENTID, SEEKERID, OFFERERID, SEEKID, OFFERID, STRTSUBURB, STRTPOSTCODE, STRTSTREETNO, STRTSTREETNAME, ENDSUBURB, ENDPOSTCODE, ENDSTREETNO, ENDSTREETNAME, DATE, PRICE, PICKUPTIME, DATECREATED, STATUS, PAYMENTID, NUMSEATSREQUIRED, ADJUSTEDBY) VALUES (" + thisPK + ", " + AddAgreementID + ", " + AddSeekerID + ", " + AddOffererID + ", " + AddSeekID + ", " + AddOfferID + ", '" + AddStrtSuburb + "', " + AddStrtPostCode + ", " + AddStrtStreetNo + ", '" + AddStrtStreet + "', '" + AddEndSuburb + "', " + AddEndPostCode + ", " + AddEndStreetNo + ", '" + AddEndStreet + "', PARSEDATETIME('" + AddDate + "', 'YYYY-MM-DD'), " + AddPrice + ", '" + AddPickUpTime + "', PARSEDATETIME('" + AddDateCreated + "', 'YYYY-MM-DD'), '" + AddStatus + "', " + AddPaymentID + ", " + AddNumOfSeats + ", " + thisUser + ")");
                System.out.println("2");
               Single.setVisible(false);
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    
    @FXML
    public void Pay(ActionEvent event) throws Exception {
        PayPane.setVisible(true);
        PSeekerID.setText(tfSeekerID.getText());
        POffererID.setText(tfOffererID.getText());
        NameOnCard.setText(d.returnSingleQuery("SELECT NAMEONCARD AS ANSWER FROM USER WHERE USERID = '" + PSeekerID.getText() + "'"));
        CardNum.setText(d.returnSingleQuery("SELECT CARDNUM AS ANSWER FROM USER WHERE USERID = '" + PSeekerID.getText() + "'"));
        LocalDate exp = LocalDate.parse(d.returnSingleQuery("SELECT EXPDATE AS ANSWER FROM USER WHERE USERID = '" + PSeekerID.getText() + "'"));
        CardExpiry.setValue(exp);
        CVV.setText(d.returnSingleQuery("SELECT CVV AS ANSWER FROM USER WHERE USERID = '" + PSeekerID.getText() + "'"));
        Amount.setText(price.getText());
    }
    
    
    @FXML
    public void CompletePayment(ActionEvent event) throws Exception {
        int thisPK = Integer.parseInt(d.returnSingleQuery("SELECT MAX(PAYMENTID) AS ANSWER FROM PAYMENT"))+1;
        long AddSeekerID = Long.parseLong(PSeekerID.getText());
        long AddOffererID = Long.parseLong(POffererID.getText());
        LocalDate AddDate = LocalDate.now();
        String AddPaymentMethod = "Card";
        double AddAmount = Double.parseDouble(price.getText());
        d.Insert("INSERT INTO PAYMENT(PAYMENTID, SEEKERID, OFFERERID, DATE, PAYMENTMETHOD, AMOUNT) VALUES(" + thisPK + ", " + AddSeekerID + ", " + AddOffererID + ", PARSEDATETIME('" + AddDate + "', 'YYYY-MM-DD'), '" + AddPaymentMethod + "', " + AddAmount + ")");
        d.Insert("UPDATE AGREEMENT SET PAYMENTID = " + thisPK);
        d.Insert("UPDATE AGREEMENT SET STATUS = 'Paid'");
        PayPane.setVisible(false);
        Single.setVisible(false);
        
        
    }
    
    @FXML
    public void Back(ActionEvent event) throws Exception {
        PayPane.setVisible(false);
    }
    
               
    
    
    
    
    public void refreshTable() {
        agreementList.clear();
        getMatches();
        Table.setItems(FXCollections.observableArrayList(agreementList));
    }
    
    
}

