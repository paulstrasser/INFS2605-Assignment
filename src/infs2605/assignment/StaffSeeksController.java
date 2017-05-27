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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author paulstrasser
 */
public class StaffSeeksController implements Initializable {

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
    private Button Search;
    
    @FXML
    private TableView<Seek> Table;

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
    
    ArrayList<Seek> seekList = new ArrayList<>(); //Creates the array list
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
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
        
        Table.setItems(FXCollections.observableArrayList(seekList));
        
        SearchBy.getItems().addAll("ID", "Starting Suburb", "Ending Suburb", "Date", "Date Created", "Price", "Status", "Number of Seats");
        SearchCombo.getItems().addAll("Pending", "Matched");
        SearchValue.setVisible(true);
        SearchDate.setVisible(false);
        SearchCombo.setVisible(false);
    }   
    
    public void getSeeks() {
        try {
            seekList.clear();
            ResultSet rs = d.getResultSet("SELECT * FROM SEEK");
            while (rs.next()) {
                seekList.add(new Seek(rs.getLong("SEEKID"), rs.getLong("SEEKERID"), rs.getString("STRTSUBURB"), rs.getInt("STRTPOSTCODE"), rs.getInt("STRTSTREETNO"), rs.getString("STRTSTREETNAME"), rs.getString("ENDSUBURB"), rs.getInt("ENDPOSTCODE"), rs.getInt("ENDSTREETNO"), rs.getString("ENDSTREETNAME"), rs.getString("DATE"), rs.getDouble("PRICE"), rs.getString("PICKUPTIME"), rs.getString("DATECREATED"), rs.getString("STATUS"), rs.getInt("NUMSEATSREQUIRED")));
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(StaffSeeksController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void ComboBoxChoice(ActionEvent event) throws Exception {
        String SearchByType = (String) SearchBy.getSelectionModel().getSelectedItem();
       
        if (SearchByType.equals("ID")) {
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
        
        seekList.clear();
        try {
            ResultSet rs;
            switch (SearchByType) {
                case "ID":
                    rs = d.getResultSet("SELECT * "
                            + "FROM SEEK "
                            + "WHERE SEEKID  = '" + SearchValue.getText() + "'");
                    while (rs.next()) {
                        seekList.add(new Seek(rs.getLong("SEEKID"), rs.getLong("SEEKERID"), rs.getString("STRTSUBURB"), rs.getInt("STRTPOSTCODE"), rs.getInt("STRTSTREETNO"), rs.getString("STRTSTREETNAME"), rs.getString("ENDSUBURB"), rs.getInt("ENDPOSTCODE"), rs.getInt("ENDSTREETNO"), rs.getString("ENDSTREETNAME"), rs.getString("DATE"), rs.getDouble("PRICE"), rs.getString("PICKUPTIME"), rs.getString("DATECREATED"), rs.getString("STATUS"), rs.getInt("NUMSEATSREQUIRED")));
                    }
                    break;
                case "Starting Suburb":
                    rs = d.getResultSet("SELECT * "
                            + "FROM SEEK "
                            + "WHERE STRTSUBURB  LIKE '%" + SearchValue.getText() + "%'");
                    while (rs.next()) {
                        seekList.add(new Seek(rs.getLong("SEEKID"), rs.getLong("SEEKERID"), rs.getString("STRTSUBURB"), rs.getInt("STRTPOSTCODE"), rs.getInt("STRTSTREETNO"), rs.getString("STRTSTREETNAME"), rs.getString("ENDSUBURB"), rs.getInt("ENDPOSTCODE"), rs.getInt("ENDSTREETNO"), rs.getString("ENDSTREETNAME"), rs.getString("DATE"), rs.getDouble("PRICE"), rs.getString("PICKUPTIME"), rs.getString("DATECREATED"), rs.getString("STATUS"), rs.getInt("NUMSEATSREQUIRED")));
                    }
                    break;
                case "End Suburb":
                    rs = d.getResultSet("SELECT * "
                            + "FROM SEEK "
                            + "WHERE ENDSUBURB  LIKE '%" + SearchValue.getText() + "%'");
                    while (rs.next()) {
                        seekList.add(new Seek(rs.getLong("SEEKID"), rs.getLong("SEEKERID"), rs.getString("STRTSUBURB"), rs.getInt("STRTPOSTCODE"), rs.getInt("STRTSTREETNO"), rs.getString("STRTSTREETNAME"), rs.getString("ENDSUBURB"), rs.getInt("ENDPOSTCODE"), rs.getInt("ENDSTREETNO"), rs.getString("ENDSTREETNAME"), rs.getString("DATE"), rs.getDouble("PRICE"), rs.getString("PICKUPTIME"), rs.getString("DATECREATED"), rs.getString("STATUS"), rs.getInt("NUMSEATSREQUIRED")));
                    }
                    break;
                case "Date":
                    rs = d.getResultSet("SELECT * "
                            + "FROM SEEK "
                            + "WHERE DATE  = '" + SearchDate.getValue().toString() + "'");
                    while (rs.next()) {
                        seekList.add(new Seek(rs.getLong("SEEKID"), rs.getLong("SEEKERID"), rs.getString("STRTSUBURB"), rs.getInt("STRTPOSTCODE"), rs.getInt("STRTSTREETNO"), rs.getString("STRTSTREETNAME"), rs.getString("ENDSUBURB"), rs.getInt("ENDPOSTCODE"), rs.getInt("ENDSTREETNO"), rs.getString("ENDSTREETNAME"), rs.getString("DATE"), rs.getDouble("PRICE"), rs.getString("PICKUPTIME"), rs.getString("DATECREATED"), rs.getString("STATUS"), rs.getInt("NUMSEATSREQUIRED")));
                    }
                    break;
                case "Date Created":
                    rs = d.getResultSet("SELECT * "
                            + "FROM SEEK "
                            + "WHERE DATECREATED  = '" + SearchDate.getValue().toString() + "'");
                    while (rs.next()) {
                        seekList.add(new Seek(rs.getLong("SEEKID"), rs.getLong("SEEKERID"), rs.getString("STRTSUBURB"), rs.getInt("STRTPOSTCODE"), rs.getInt("STRTSTREETNO"), rs.getString("STRTSTREETNAME"), rs.getString("ENDSUBURB"), rs.getInt("ENDPOSTCODE"), rs.getInt("ENDSTREETNO"), rs.getString("ENDSTREETNAME"), rs.getString("DATE"), rs.getDouble("PRICE"), rs.getString("PICKUPTIME"), rs.getString("DATECREATED"), rs.getString("STATUS"), rs.getInt("NUMSEATSREQUIRED")));
                    }
                    break;
                case "Price":
                    rs = d.getResultSet("SELECT * "
                            + "FROM SEEK "
                            + "WHERE PRICE  = '" + SearchValue.getText() + "'");
                    while (rs.next()) {
                        seekList.add(new Seek(rs.getLong("SEEKID"), rs.getLong("SEEKERID"), rs.getString("STRTSUBURB"), rs.getInt("STRTPOSTCODE"), rs.getInt("STRTSTREETNO"), rs.getString("STRTSTREETNAME"), rs.getString("ENDSUBURB"), rs.getInt("ENDPOSTCODE"), rs.getInt("ENDSTREETNO"), rs.getString("ENDSTREETNAME"), rs.getString("DATE"), rs.getDouble("PRICE"), rs.getString("PICKUPTIME"), rs.getString("DATECREATED"), rs.getString("STATUS"), rs.getInt("NUMSEATSREQUIRED")));
                    }
                    break;
                case "Status":
                    rs = d.getResultSet("SELECT * "
                            + "FROM SEEK "
                            + "WHERE STATUS  = '" + SearchCombo.getSelectionModel().getSelectedItem().toString() + "'");
                    while (rs.next()) {
                        seekList.add(new Seek(rs.getLong("SEEKID"), rs.getLong("SEEKERID"), rs.getString("STRTSUBURB"), rs.getInt("STRTPOSTCODE"), rs.getInt("STRTSTREETNO"), rs.getString("STRTSTREETNAME"), rs.getString("ENDSUBURB"), rs.getInt("ENDPOSTCODE"), rs.getInt("ENDSTREETNO"), rs.getString("ENDSTREETNAME"), rs.getString("DATE"), rs.getDouble("PRICE"), rs.getString("PICKUPTIME"), rs.getString("DATECREATED"), rs.getString("STATUS"), rs.getInt("NUMSEATSREQUIRED")));
                    }
                    break;
                case "Number of Seats":
                    rs = d.getResultSet("SELECT * "
                            + "FROM SEEK "
                            + "WHERE NUMSEATSREQUIRED  = '" + SearchValue.getText() + "'");
                    while (rs.next()) {
                        seekList.add(new Seek(rs.getLong("SEEKID"), rs.getLong("SEEKERID"), rs.getString("STRTSUBURB"), rs.getInt("STRTPOSTCODE"), rs.getInt("STRTSTREETNO"), rs.getString("STRTSTREETNAME"), rs.getString("ENDSUBURB"), rs.getInt("ENDPOSTCODE"), rs.getInt("ENDSTREETNO"), rs.getString("ENDSTREETNAME"), rs.getString("DATE"), rs.getDouble("PRICE"), rs.getString("PICKUPTIME"), rs.getString("DATECREATED"), rs.getString("STATUS"), rs.getInt("NUMSEATSREQUIRED")));
                    }
                    break;        
                default:
                    break;
            }
            System.out.println("5");
            System.out.println("6");
            Table.setItems(FXCollections.observableArrayList(seekList));
            System.out.println("7");
            SearchDate.getEditor().clear();
            SearchValue.clear();
            SearchCombo.getEditor().clear();    
        }
        catch (SQLException ex) {
            Logger.getLogger(StaffSeeksController.class.getName()).log(Level.SEVERE, null, ex);
        }

        }
    
    @FXML
    private void clearSearch(MouseEvent event) throws Exception {
         refreshTable();
    }
    
    
    public void refreshTable() {
        seekList.clear();
        getSeeks();
        Table.setItems(FXCollections.observableArrayList(seekList));
    }
   
}    

