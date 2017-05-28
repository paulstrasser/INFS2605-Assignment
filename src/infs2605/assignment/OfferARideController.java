/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infs2605.assignment;

//import static infs2605.assignment.SignInController.loggedInUser;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author edhopkins
 */
public class OfferARideController implements Initializable {

     @FXML
    Stage stage;
    Parent root;
    
    @FXML
    private Button Signout, Search, Post;
    
    @FXML
    private Text Name, errorText, notifyText, name;
    
    @FXML
    private TextField startNum, startStreet, startSub, startPC, endNum, endStreet, endSub, endPC, pickupTime, maxPrice; 
    
    @FXML
    private RadioButton startHome, startWork, startOther, endHome, endWork, endOther;
    
    @FXML
    private DatePicker pickupDate;
    
    @FXML
    private ComboBox numPass;
    
    @FXML
    private MenuButton Seek, Offer, Matches;
    
    @FXML
    private MenuItem SeekaRide, YourSeeks, OfferaRide, YourOffers, AgreementRequests;
    
    @FXML
    private MenuItem AdjustmentRequests;
    
    @FXML
    private TableView<Seek> Seeks;
    
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
    
    @FXML
    private AnchorPane SingleSeek;
    
    @FXML
    private Label seekID;
    
    @FXML
    private Label seekID2;
    
    @FXML
    private Label seekerID;
    
    @FXML
    private Label dateCreated;
    
    @FXML
    private Label status;
    
    @FXML
    private Label strtStreetNo;
    
    @FXML
    private Label strtStreetName;
    
    @FXML
    private Label strtSuburb;
    
    @FXML
    private Label strtPostCode;
    
    @FXML
    private Label endStreetNo;
    
    @FXML
    private Label endStreetName;
    
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
    private TitledPane searchResultsTitledPane;
    
    DBController d = new DBController(); //Establish a connection to the db
    
    ArrayList<Seek> seeksList = new ArrayList<>(); //Creates the array list
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        name.setText(d.returnSingleQuery("SELECT FNAME AS ANSWER FROM USER WHERE USERNAME LIKE '" + SignInController.getUser() + "'"));
        
        searchResultsTitledPane.setCollapsible(false); 
        SingleSeek.setVisible(false);
        numPass.getItems().addAll("1", "2", "3","4");
        numPass.getSelectionModel().selectFirst();
        
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
        
        Seeks.setItems(FXCollections.observableArrayList(seeksList));
          
        Seeks.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showSeek(newValue));
    }
     public void getSeeks() {
        try {
            seeksList.clear();
            ResultSet rs = d.getResultSet("SELECT * FROM SEEK");
            while (rs.next()) {
                seeksList.add(new Seek(rs.getLong("SEEKID"), rs.getLong("SEEKERID"), rs.getString("STRTSUBURB"), rs.getInt("STRTPOSTCODE"), rs.getInt("STRTSTREETNO"), rs.getString("STRTSTREETNAME"), rs.getString("ENDSUBURB"), rs.getInt("ENDPOSTCODE"), rs.getInt("ENDSTREETNO"), rs.getString("ENDSTREETNAME"), rs.getString("DATE"), rs.getDouble("PRICE"), rs.getString("PICKUPTIME"), rs.getString("DATECREATED"), rs.getString("STATUS"), rs.getInt("NUMSEATSREQUIRED")));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(OfferARideController.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
    public void showSeek(Seek seek) {
        SingleSeek.setVisible(true);
        seekID2.setText(seek.getSeekID());
        seekID.setText(seek.getSeekID());
        seekerID.setText(seek.getSeekerID());
        dateCreated.setText(seek.getDateCreated());
        status.setText(seek.getStatus());
        strtStreetNo.setText(seek.getStrtStreetNo());
        strtStreetName.setText(seek.getStrtStreetName());
        strtSuburb.setText(seek.getStrtSuburb());
        strtPostCode.setText(seek.getStrtPostCode());
        endStreetNo.setText(seek.getEndStreetNo());
        endStreetName.setText(seek.getEndStreetName());
        endSuburb.setText(seek.getEndSuburb());
        endPostCode.setText(seek.getEndPostCode());
        date.setText(seek.getDate());
        price.setText(seek.getPrice());
        pickUpTime.setText(seek.getPickUpTime());
        numberOfSeats.setText(seek.getNumSeatsRequired());
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
    private void Profile(MouseEvent event) throws Exception {

        stage=(Stage) Name.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("Profile Page.fxml"));
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
    
    @FXML //this method makes the address fields enabled
    private void RBbuttonPressed(ActionEvent event) throws Exception {
        if (startOther.isSelected()){
            startNum.setDisable(false);
            startStreet.setDisable(false);
            startSub.setDisable(false);
            startPC.setDisable(false);
        }
        else{
            startNum.setDisable(true);
            startStreet.setDisable(true);
            startSub.setDisable(true);
            startPC.setDisable(true);
        }
        if (endOther.isSelected()){
            endNum.setDisable(false);
            endStreet.setDisable(false);
            endSub.setDisable(false);
            endPC.setDisable(false);
        }
        else{
            endNum.setDisable(true);
            endStreet.setDisable(true);
            endSub.setDisable(true);
            endPC.setDisable(true);
        }
    }
    
    @FXML //HAMISH THIS IS WHERE THE RESULT SET IS
    private void makeSearch(ActionEvent event) throws Exception {
        if (verifySeek() == false){
            DBController db1 = new DBController();
            String startPCX;
            String endPCX;
            LocalDate dateX = pickupDate.getValue();
            String timeX = pickupTime.getText();
            String PriceX = maxPrice.getText();
            String StatusX = "Pending";
            String[] temp = maxPrice.getText().split(":");
            int time1 = Integer.parseInt(temp[0]); //hour
            int time2 = Integer.parseInt(temp[0]) - 1; //hour - 1
            int time3 = Integer.parseInt(temp[0]) + 1; //hour + 1
            //Seats in the INSERT statement
            
            //determining address
            if (startHome.isSelected()){
                startPCX = db1.returnSingleQuery("SELECT HPOSTCODE AS ANSWER FROM USER WHERE USERNAME = '" + SignInController.getUser() + "'");
            }
            else if (startWork.isSelected()){
                startPCX = db1.returnSingleQuery("SELECT WPOSTCODE AS ANSWER FROM USER WHERE USERNAME = '" + SignInController.getUser() + "'");
            }
            else{
                startPCX = startPC.getText();
            }
            
            if (endHome.isSelected()){
                endPCX = db1.returnSingleQuery("SELECT HPOSTCODE AS ANSWER FROM USER WHERE USERNAME = '" + SignInController.getUser() + "'");
            }
            else if (endWork.isSelected()){
                endPCX = db1.returnSingleQuery("SELECT WPOSTCODE AS ANSWER FROM USER WHERE USERNAME = '" + SignInController.getUser() + "'");
            }
            else{
                endPCX = startPC.getText();
            }

            //Search conditions: same start + end suburbs, price window and time window
            ResultSet searchResults = db1.getResultSet("SELECT CONCAT_WS(' ',u.FNAME,u.LNAME) AS Seeker, o.STRTSUBURB AS StartingSuburb, o.ENDSUBURB AS DestinationSuburb, o.DATE AS Date, o.PICKUPTIME AS Time, o.PRICE AS MinimumPrice FROM USER u, SEEK o WHERE u.USERID = o.SEEKERID AND o.STRTPOSTCODE = '" + startPCX + "' AND o.ENDPOSTCODE = '" + endPCX + "' AND CAST(o.PRICE AS INT) > " + PriceX + " AND o.DATE = PARSEDATETIME('"+dateX+"', 'YYYY-MM-DD') AND o.STATUS = '"+ StatusX+"' AND (o.PICKUPTIME LIKE '"+time1+"%' OR o.PICKUPTIME LIKE '"+time2+"%' OR o.PICKUPTIME LIKE '"+time3+"%')");
            System.out.println(searchResults); //this is to test if it works
            //HAMISH - ADD DISPLAY LOGIC HERE
        }
    }
    
    @FXML //this method makes the address fields enabled
    private void postOffer(ActionEvent event) throws Exception {
        if (verifySeek() == false){
            DBController db1 = new DBController();
            int thisPK = Integer.parseInt(db1.returnSingleQuery("SELECT MAX(OFFERID) AS ANSWER FROM OFFER"))+1;
            int OffererPK = Integer.parseInt(db1.returnSingleQuery("SELECT USERID AS ANSWER FROM USER WHERE USERNAME = '" + SignInController.getUser() + "'"));
            String startNumX;
            String startStreetX;
            String startSubX;
            String startPCX;
            String endNumX;
            String endStreetX;
            String endSubX;
            String endPCX;
            LocalDate dateX = pickupDate.getValue();
            String timeX = pickupTime.getText();
            LocalDate rightNow = LocalDate.now();
            String PriceX = maxPrice.getText();
            String StatusX = "Pending";
            //Seats in the INSERT statement
            
            //determining address
            if (startHome.isSelected()){
                startNumX = db1.returnSingleQuery("SELECT HNUM AS ANSWER FROM USER WHERE USERNAME = '" + SignInController.getUser() + "'");
                startStreetX = db1.returnSingleQuery("SELECT HSTREET AS ANSWER FROM USER WHERE USERNAME = '" + SignInController.getUser() + "'");
                startSubX = db1.returnSingleQuery("SELECT HSUBURB AS ANSWER FROM USER WHERE USERNAME = '" + SignInController.getUser() + "'");
                startPCX = db1.returnSingleQuery("SELECT HPOSTCODE AS ANSWER FROM USER WHERE USERNAME = '" + SignInController.getUser() + "'");
            }
            else if (startWork.isSelected()){
                startNumX = db1.returnSingleQuery("SELECT WNUM AS ANSWER FROM USER WHERE USERNAME = '" + SignInController.getUser() + "'");
                startStreetX = db1.returnSingleQuery("SELECT WSTREET AS ANSWER FROM USER WHERE USERNAME = '" + SignInController.getUser() + "'");
                startSubX = db1.returnSingleQuery("SELECT WSUBURB AS ANSWER FROM USER WHERE USERNAME = '" + SignInController.getUser() + "'");
                startPCX = db1.returnSingleQuery("SELECT WPOSTCODE AS ANSWER FROM USER WHERE USERNAME = '" + SignInController.getUser() + "'");
            }
            else{
                startNumX = startNum.getText();
                startStreetX = startStreet.getText();
                startSubX = startSub.getText();
                startPCX = startPC.getText();
            }
            
            if (endHome.isSelected()){
                endNumX = db1.returnSingleQuery("SELECT HNUM AS ANSWER FROM USER WHERE USERNAME = '" + SignInController.getUser() + "'");
                endStreetX = db1.returnSingleQuery("SELECT HSTREET AS ANSWER FROM USER WHERE USERNAME = '" + SignInController.getUser() + "'");
                endSubX = db1.returnSingleQuery("SELECT HSUBURB AS ANSWER FROM USER WHERE USERNAME = '" + SignInController.getUser() + "'");
                endPCX = db1.returnSingleQuery("SELECT HPOSTCODE AS ANSWER FROM USER WHERE USERNAME = '" + SignInController.getUser() + "'");
            }
            else if (endWork.isSelected()){
                endNumX = db1.returnSingleQuery("SELECT WNUM AS ANSWER FROM USER WHERE USERNAME = '" + SignInController.getUser() + "'");
                endStreetX = db1.returnSingleQuery("SELECT WSTREET AS ANSWER FROM USER WHERE USERNAME = '" + SignInController.getUser() + "'");
                endSubX = db1.returnSingleQuery("SELECT WSUBURB AS ANSWER FROM USER WHERE USERNAME = '" + SignInController.getUser() + "'");
                endPCX = db1.returnSingleQuery("SELECT WPOSTCODE AS ANSWER FROM USER WHERE USERNAME = '" + SignInController.getUser() + "'");
            }
            else{
                endNumX = endNum.getText();
                endStreetX = startStreet.getText();
                endSubX = startSub.getText();
                endPCX = startPC.getText();
            }
            
            String insertStatement = "INSERT INTO OFFER (OFFERID,OFFERERID,STRTSTREETNO,STRTSTREETNAME,STRTSUBURB,STRTPOSTCODE,ENDSTREETNO,ENDSTREETNAME,ENDSUBURB,ENDPOSTCODE,DATE,PRICE,PICKUPTIME,DATECREATED,STATUS,NUMSEATSREQUIRED) VALUES ("+thisPK+","+OffererPK+",'"+startNumX+"','"+startStreetX+"','"+startSubX+"','"+startPCX+"','"+endNumX+"','"+endStreetX+"','"+endSubX+"','"+endPCX+"',"+"PARSEDATETIME('"+dateX+"', 'YYYY-MM-DD'),'"+PriceX+"','"+timeX+"',"+"PARSEDATETIME('"+rightNow+"', 'YYYY-MM-DD'),'"+StatusX+"','"+numPass.getValue()+"')";
            //System.out.println(insertStatement);
            db1.Insert(insertStatement);
            notifyText.setText("            Your Offer has been posted successfully!");
            errorText.setVisible(false);
            
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Action Processed");
            alert.setHeaderText(null);
            alert.setContentText("Offer Posted Successfully!");

            alert.showAndWait();
        }
    }
   
    public boolean isNumeric(String s) {  
        return s != null && s.matches("[-+]?\\d*\\.?\\d+");  
    }
    
    //this method verifies a new seek
    private boolean verifySeek()  {
        notifyText.setText("If there are insufficient Search results, Post an Offer!");
        
        //CHECK FOR EMPTY AND SPECIAL TEXT
        //Date
        if (pickupTime.getText().equals("")){
            errorText.setText("Pick Up Time field is empty");
            errorText.setVisible(true);
            return true;
        }
        if (pickupTime.getText().length() != 5){
            errorText.setText("Pick Up Time in an invalid time");
            errorText.setVisible(true);
            return true;
        }
        DateFormat formatter = new SimpleDateFormat("HH:mm");
        try{
            java.sql.Time timeValue = new java.sql.Time(formatter.parse(pickupTime.getText()).getTime());
        }
        catch (ParseException ex){
            errorText.setText("Pick Up Time in an invalid time");
            errorText.setVisible(true);
            return true;
        }
        String[] temp = pickupTime.getText().split(":");
        if (Integer.parseInt(temp[0]) > 23 || Integer.parseInt(temp[1]) > 59){
            errorText.setText("Pick Up Time in an invalid - use 24 hour time");
            errorText.setVisible(true);
            return true;
        }
        
        //Currency
        if (maxPrice.getText().equals("")){
            errorText.setText("      Max Price field is empty");
            errorText.setVisible(true);
            return true;
        }
        if (isNumeric(maxPrice.getText()) == false){
            errorText.setText("Max Price field is invalid - use full dollars");
            errorText.setVisible(true);
            return true;
        }
        if ((maxPrice.getText()).contains(".")){
            errorText.setText("Max Price field is invalid - use full dollars");
            errorText.setVisible(true);
            return true;
        }
        
        //Other text
        if (startOther.isSelected()){
            TextField[] startText = {startNum, startStreet, startSub, startPC};
            String startTextName[] = {"   Start Number", "     Start Street", "   Start Suburb", "Start Postcode"};

            for (int i =0; i < (startText.length); i++){
                if ((startText[i].getText()).equals("")){
                    errorText.setText(startTextName[i] + " field is empty");
                    errorText.setVisible(true);
                    return true;
                }

                Pattern p = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
                Matcher m = p.matcher(startText[i].getText());
                boolean b = m.find();

                if (b) {
                    errorText.setText(startTextName[i] + " field has special character");
                    errorText.setVisible(true);
                    return true;
                }
                if (i==0 || i==3){
                    if (isNumeric(startText[i].getText()) == false){
                        errorText.setText(startTextName[i] + " must be numeric");
                        errorText.setVisible(true);
                        return true;
                    }
                    if (i==3){
                        if (startText[i].getText().length() != 4){
                            errorText.setText("Postcode must be 4 numbers");
                            errorText.setVisible(true);
                            return true;
                        }
                    }
                }
            }

        }
        if (endOther.isSelected()){
            TextField[] endText = {endNum, endStreet, endSub, endPC};
            String endTextName[] = {"Destination Number", "Destination Street", "Destination Suburb", "Destination Postcode"};

            for (int i =0; i < (endText.length); i++){
                if ((endText[i].getText()).equals("")){
                    errorText.setText(endTextName[i] + " field is empty");
                    errorText.setVisible(true);
                    return true;
                }

                Pattern p = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
                Matcher m = p.matcher(endText[i].getText());
                boolean b = m.find();

                if (b) {
                    errorText.setText(endTextName[i] + " field has special character");
                    errorText.setVisible(true);
                    return true;
                }
            }

        }
        
        //Date Picker
        if (pickupDate.getValue() == null) {
                errorText.setText("   Pick Up date is not set");
                errorText.setVisible(true);
                return true;
        }

        LocalDate localDate = LocalDate.now();
        
        if (pickupDate.getValue().isBefore(localDate)){
            errorText.setText("Pick today or a future date for pick up");
            errorText.setVisible(true);
            return true;
        }
        
        if ((startWork.isSelected() && endWork.isSelected()) || (startHome.isSelected() && endHome.isSelected())){
            errorText.setText("Start and destination must be different");
            errorText.setVisible(true);
            return true;
        }
        
        return false;
    }
    @FXML
    private void Back(ActionEvent event) throws Exception {
        SingleSeek.setVisible(false);
    }
    /*@FXML
    private void findResults(ActionEvent event) throws Exception {
    //If no results are found, put a button there that allows user to create a new seek
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                Label test = new Label("Hello");
                results.add(test,i,j);
            }
        }
    }*/ 
    
}
