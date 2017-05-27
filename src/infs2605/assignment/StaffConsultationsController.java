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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author paulstrasser
 */
public class StaffConsultationsController implements Initializable {

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
    private Button Add;
    
    @FXML
    private Button GoBack;
    
    @FXML
    private Button Update;
    
    @FXML
    private Button Delete;
    
    @FXML
    private TableView<Consultation> Table;

    @FXML
    private TableColumn<Consultation, String> consultIDCol;

    @FXML
    private TableColumn<Consultation, String> StaffIDCol;

    @FXML
    private TableColumn<Consultation, String> CorporateMemberIDCol;
    
    @FXML
    private TableColumn<Consultation, String> priceCol;
    
    @FXML
    private TableColumn<Consultation, String> openDateCol;
    
    @FXML
    private TableColumn<Consultation, String> closedDateCol;
    
    @FXML
    private TableColumn<Consultation, String> statusCol;
    
    @FXML
    private TextField tfConsultID;
    
    @FXML
    private TextField tfStaffID;
    
    @FXML
    private TextField tfMemberID;
    
    @FXML
    private TextField tfPrice;
    
    @FXML
    private ComboBox cbStatus;
    
    @FXML
    private DatePicker dpDateOpened;
    
    @FXML
    private DatePicker dpDateClosed;
    
    @FXML
    private AnchorPane EditPane;
    
    @FXML
    private TextField SearchValue;
    
    @FXML
    private DatePicker SearchDate;
    
    @FXML
    private ComboBox SearchCombo;
    
    @FXML
    private ComboBox SearchBy;
    
    @FXML
    private Button Search;
    
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
    
    
    @FXML
    private void Add(ActionEvent event) throws Exception { //Goes to 'Add' screen

        stage=(Stage) Add.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("StaffAddConsultation.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
    }
    
    
    @FXML
    private void GoBack(ActionEvent event) throws Exception { //Goes to 'Add' screen

        stage=(Stage) Add.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("StaffCorporateMembers.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
    }
    
     
    
    DBController d = new DBController(); //Establish a connection to the db
    
    ArrayList<Consultation> consultationList = new ArrayList<>(); //Creates the array list
   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        EditPane.setVisible(false);
        tfConsultID.setVisible(false);
        consultIDCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getConsultIDProperty().toString()));
        
        StaffIDCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getStaffIDProperty().toString()));
        
        CorporateMemberIDCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCorporateMemberIDProperty().toString()));

        priceCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPriceProperty().toString()));
        
        openDateCol.setCellValueFactory(cellData -> cellData.getValue().getOpenDateProperty());
        
        closedDateCol.setCellValueFactory(cellData -> cellData.getValue().getClosedDateProperty());

        statusCol.setCellValueFactory(cellData -> cellData.getValue().getStatusProperty());

        getConsultations();
        
        Table.setItems(FXCollections.observableArrayList(consultationList));

        Table.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showConsultations(newValue));
    
        
        SearchBy.getItems().addAll("ID","Staff ID","Corporate Member ID", "Price", "Status", "Date Opened", "Date Closed"); 
        SearchCombo.getItems().addAll("Open", "Closed");
        SearchValue.setVisible(true);
        SearchDate.setVisible(false);
        SearchCombo.setVisible(false);    
    }    
    
    public void getConsultations() {
        try {
            consultationList.clear();
            ResultSet rs = d.getResultSet("SELECT CONSULTID, STAFFID, CORPORATEMEMBERID, PRICE, OPENDATE, CLOSEDDATE, STATUS " 
                    + "FROM CONSULTATION");
            while (rs.next()) {
                consultationList.add(new Consultation(rs.getLong("CONSULTID"), rs.getLong("STAFFID"), rs.getLong("CORPORATEMEMBERID"), rs.getDouble("PRICE"), rs.getString("OPENDATE"), rs.getString("CLOSEDDATE"), rs.getString("STATUS")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(StaffConsultationsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void showConsultations(Consultation consultation) {
        EditPane.setVisible(true);
        tfConsultID.setText(consultation.getConsultID());
        tfStaffID.setText(consultation.getStaffID());
        tfMemberID.setText(consultation.getCorporateMemberID());
        tfPrice.setText(consultation.getPrice());
        cbStatus.setValue(consultation.getStatus());
        LocalDate dateOpened = LocalDate.parse(consultation.getOpenDate());
        dpDateOpened.setValue(dateOpened);
        LocalDate dateClosed = LocalDate.parse(consultation.getClosedDate());
        dpDateClosed.setValue(dateClosed);

    }    
    
    public void refreshTable() {
        consultationList.clear();
        getConsultations();
        Table.setItems(FXCollections.observableArrayList(consultationList));
    }
    
    @FXML
    private void Cancel(ActionEvent event) throws Exception {
        EditPane.setVisible(false);
    }
    
    @FXML
    private void UpdateAndGoToView(ActionEvent event) throws Exception {
        long NewConsultID = Long.parseLong(tfConsultID.getText());
        long NewStaffID = Long.parseLong(tfStaffID.getText());
        long NewCorporateMemberID = Long.parseLong(tfMemberID.getText());
        double NewPrice = Double.parseDouble(tfPrice.getText());
        String NewStatus = (String) cbStatus.getSelectionModel().getSelectedItem();
        LocalDate NewDateOpened = dpDateOpened.getValue();
        LocalDate NewDateClosed = dpDateClosed.getValue();

        d.Insert("UPDATE CONSULTATION "
                + "SET CONSULTID = " + NewConsultID + ", STAFFID = '" + NewStaffID + "', CORPORATEMEMBERID = '" + NewCorporateMemberID + "', PRICE = '" + NewPrice + "', STATUS = '" + NewStatus + "', OPENDATE = PARSEDATETIME('"+NewDateOpened+"', 'YYYY-MM-DD'), CLOSEDDATE = PARSEDATETIME('"+NewDateClosed+"', 'YYYY-MM-DD')"
                + "WHERE CONSULTID = " + Long.parseLong(tfConsultID.getText()));
        EditPane.setVisible(false);
        refreshTable();
    }
    
    @FXML
    private void DeleteRow(ActionEvent event) throws Exception {
        d.Insert("DELETE FROM CONSULTATION WHERE CONSULTID = " + Long.parseLong(tfConsultID.getText()));
        EditPane.setVisible(false);
        refreshTable();
    }
    
    @FXML
    private void ComboBoxChoice(ActionEvent event) throws Exception {
        String SearchByType = (String) SearchBy.getSelectionModel().getSelectedItem();
       
        switch (SearchByType) {
            case "ID":
                SearchValue.setVisible(true);
                SearchDate.setVisible(false);
                SearchCombo.setVisible(false);
                break;
            case "Staff ID":
                SearchValue.setVisible(true);
                SearchDate.setVisible(false);
                SearchCombo.setVisible(false);
                break;
            case "Corporate Member ID":
                SearchValue.setVisible(true);
                SearchDate.setVisible(false);
                SearchCombo.setVisible(false);
                break;
            case "Price":
                SearchValue.setVisible(true);
                SearchDate.setVisible(false);
                SearchCombo.setVisible(false);
                break;
            case "Status":
                SearchValue.setVisible(false);
                SearchDate.setVisible(false);
                SearchCombo.setVisible(true);
                break;
            case "Date Opened":
                SearchValue.setVisible(false);
                SearchDate.setVisible(true);
                SearchCombo.setVisible(false);
                break;
            case "Date Closed":
                SearchValue.setVisible(false);
                SearchDate.setVisible(true);
                SearchCombo.setVisible(false);
                break;
            default:
                break;
        }
        
    }
    
    @FXML
    private void Search(ActionEvent event) throws Exception { //Goes to 'Staff' screen
        
        String SearchByType = (String) SearchBy.getSelectionModel().getSelectedItem();        
        
        consultationList.clear();
        try {
            ResultSet rs;
            switch (SearchByType) {
                case "ID":
                    rs = d.getResultSet("SELECT * " 
                    + "FROM CONSULTATION "
                    + "WHERE CONSULTID = '" + SearchValue.getText() + "'" );
                    while (rs.next()) {
                        consultationList.add(new Consultation(rs.getLong("CONSULTID"), rs.getLong("STAFFID"), rs.getLong("CORPORATEMEMBERID"), rs.getDouble("PRICE"), rs.getString("OPENDATE"), rs.getString("CLOSEDDATE"), rs.getString("STATUS")));
                    }
                    break;
                case "Staff ID":
                    rs = d.getResultSet("SELECT * " 
                    + "FROM CONSULTATION "
                    + "WHERE STAFFID = '" + SearchValue.getText() + "'" );
                    while (rs.next()) {
                        consultationList.add(new Consultation(rs.getLong("CONSULTID"), rs.getLong("STAFFID"), rs.getLong("CORPORATEMEMBERID"), rs.getDouble("PRICE"), rs.getString("OPENDATE"), rs.getString("CLOSEDDATE"), rs.getString("STATUS")));
                    }
                    break;
                case "Corporate Member ID":
                    rs = d.getResultSet("SELECT * " 
                    + "FROM CONSULTATION "
                    + "WHERE CORPORATEMEMBERID = '" + SearchValue.getText() + "'" );
                    while (rs.next()) {
                        consultationList.add(new Consultation(rs.getLong("CONSULTID"), rs.getLong("STAFFID"), rs.getLong("CORPORATEMEMBERID"), rs.getDouble("PRICE"), rs.getString("OPENDATE"), rs.getString("CLOSEDDATE"), rs.getString("STATUS")));
                    }
                    break;
                case "Price":
                    rs = d.getResultSet("SELECT * " 
                    + "FROM CONSULTATION "
                    + "WHERE PRICE LIKE '%" + SearchValue.getText() + "%'" );
                    while (rs.next()) {
                        consultationList.add(new Consultation(rs.getLong("CONSULTID"), rs.getLong("STAFFID"), rs.getLong("CORPORATEMEMBERID"), rs.getDouble("PRICE"), rs.getString("OPENDATE"), rs.getString("CLOSEDDATE"), rs.getString("STATUS")));
                    }
                    break;
                case "Status":
                    rs = d.getResultSet("SELECT * " 
                    + "FROM CONSULTATION "
                    + "WHERE STATUS = '" + SearchCombo.getSelectionModel().getSelectedItem().toString() + "'" );
                    while (rs.next()) {
                        consultationList.add(new Consultation(rs.getLong("CONSULTID"), rs.getLong("STAFFID"), rs.getLong("CORPORATEMEMBERID"), rs.getDouble("PRICE"), rs.getString("OPENDATE"), rs.getString("CLOSEDDATE"), rs.getString("STATUS")));
                    }
                    break;
                case "Date Opened":
                    rs = d.getResultSet("SELECT * " 
                    + "FROM CONSULTATION "
                    + "WHERE OPENDATE = '" + SearchDate.getValue().toString() + "'" );
                    while (rs.next()) {
                        consultationList.add(new Consultation(rs.getLong("CONSULTID"), rs.getLong("STAFFID"), rs.getLong("CORPORATEMEMBERID"), rs.getDouble("PRICE"), rs.getString("OPENDATE"), rs.getString("CLOSEDDATE"), rs.getString("STATUS")));
                    }
                    break;
                case "Date Closed":
                    rs = d.getResultSet("SELECT * " 
                    + "FROM CONSULTATION "
                    + "WHERE CLOSEDDATE = '" + SearchDate.getValue().toString() + "'" );
                    while (rs.next()) {
                        consultationList.add(new Consultation(rs.getLong("CONSULTID"), rs.getLong("STAFFID"), rs.getLong("CORPORATEMEMBERID"), rs.getDouble("PRICE"), rs.getString("OPENDATE"), rs.getString("CLOSEDDATE"), rs.getString("STATUS")));
                    }
                    break; 
                default:
                    break; 
            }
            Table.setItems(FXCollections.observableArrayList(consultationList));
            SearchDate.getEditor().clear();
            SearchValue.clear();
            SearchCombo.getEditor().clear();   
        }
        catch (SQLException ex) {
            Logger.getLogger(StaffConsultationsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
    
