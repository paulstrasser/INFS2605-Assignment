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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
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
public class StaffViewStaffController implements Initializable {

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
    private TableView<Staff> Table;

    @FXML
    private TableColumn<Staff, String> staffIdCol;

    @FXML
    private TableColumn<Staff, String> usernameCol;

    @FXML
    private TableColumn<Staff, String> passwordCol;
    
    @FXML
    private TableColumn<Staff, String> fNameCol;
    
    @FXML
    private TableColumn<Staff, String> lNameCol;
    
    @FXML
    private TableColumn<Staff, String> DOBCol;
    
    @FXML
    private TableColumn<Staff, String> emailCol;
    
    @FXML
    private TableColumn<Staff, String> RoleCol;
    
    @FXML
    private TextField tfStaffId;
    
    @FXML
    private TextField tfUsername;
    
    @FXML
    private TextField tfPassword;
    
    @FXML
    private TextField tfFName;
    
    @FXML
    private TextField tfLName;
    
    @FXML
    private DatePicker dpDOB;
    
    @FXML
    private TextField tfEmail;
    
    @FXML
    private TextField tfRole;
    
    @FXML
    private AnchorPane EditPane;
    
    @FXML
    private AnchorPane ViewPane;
    
    @FXML
    private Button Cancel;
    
    @FXML
    private Button Update;
    
    @FXML
    private Button Delete;
    
    @FXML
    private TextField SearchValue;
    
    @FXML
    private DatePicker SearchDate;
   
    @FXML
    private ComboBox SearchBy;
    
    @FXML
    private Button Search;
    
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
    
    @FXML
    private void Add(ActionEvent event) throws Exception { //Goes to 'Add' screen

        stage=(Stage) Add.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("StaffAddStaff.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
    }
    
    DBController d = new DBController(); //Establish a connection to the db
    
    ArrayList<Staff> staffList = new ArrayList<>(); //Creates the array list
   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Name.setText(d.returnSingleQuery("SELECT FNAME AS ANSWER FROM STAFF WHERE USERNAME LIKE '" + SignInController.getUser() + "'"));
        
        EditPane.setVisible(false);
        staffIdCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getStaffIdProperty().toString()));
        
        usernameCol.setCellValueFactory(cellData -> cellData.getValue().getUsernameProperty());
        
        passwordCol.setCellValueFactory(cellData -> cellData.getValue().getPasswordProperty());

        fNameCol.setCellValueFactory(cellData -> cellData.getValue().getFNameProperty());
        
        lNameCol.setCellValueFactory(cellData -> cellData.getValue().getLNameProperty());
        
        DOBCol.setCellValueFactory(cellData -> cellData.getValue().getDOBProperty());

        emailCol.setCellValueFactory(cellData -> cellData.getValue().getEmailProperty());

        RoleCol.setCellValueFactory(cellData -> cellData.getValue().getRoleProperty());

        getStaff();
        
        Table.setItems(FXCollections.observableArrayList(staffList));

        Table.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showStaffDetails(newValue));
        
        SearchValue.setVisible(true);
        SearchDate.setVisible(false);
        SearchBy.getItems().addAll("ID", "First Name", "Last Name", "Date of Birth", "Role");
        tfStaffId.setEditable(false);
    }    
    
    public void getStaff() {
        try {
            staffList.clear();
            ResultSet rs = d.getResultSet("SELECT STAFFID, USERNAME, PASSWORD, FNAME, LNAME, DOB, EMAIL, ROLE " 
                    + "FROM STAFF");
            while (rs.next()) {
                staffList.add(new Staff(rs.getLong("STAFFID"), rs.getString("USERNAME"), rs.getString("PASSWORD"), rs.getString("FNAME"), rs.getString("LNAME"), rs.getString("DOB"), rs.getString("EMAIL"), rs.getString("ROLE")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(StaffViewStaffController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void showStaffDetails(Staff staff) {
        EditPane.setVisible(true);
        tfStaffId.setText(staff.getStaffId());
        tfUsername.setText(staff.getUsername());
        tfPassword.setText(staff.getPassword());
        tfFName.setText(staff.getFName());
        tfLName.setText(staff.getLName());
        LocalDate dob = LocalDate.parse(staff.getDOB());
        dpDOB.setValue(dob);
        tfEmail.setText(staff.getEmail());
        tfRole.setText(staff.getRole());  
    }     
    
    public void refreshTable() {
        System.out.println("r1");
        staffList.clear();
        System.out.println("r2");
        getStaff();
        System.out.println("r3");
        Table.setItems(FXCollections.observableArrayList(staffList));
        System.out.println("r4");
    }
    
    
    @FXML
    private void Cancel(ActionEvent event) throws Exception {
        EditPane.setVisible(false);
    }
    
    @FXML
    private void UpdateAndGoToView(ActionEvent event) throws Exception {
        long NewStaffId = Long.parseLong(tfStaffId.getText());
        String NewUsername = tfUsername.getText();
        String NewPassword = tfPassword.getText();
        String NewFName = tfFName.getText();
        String NewLName = tfLName.getText();
        LocalDate NewDOB = dpDOB.getValue();
        String NewEmail = tfEmail.getText();
        String NewRole = tfRole.getText();
        
        System.out.println("1");
        d.Insert("UPDATE STAFF "
                + "SET STAFFID = " + NewStaffId + ", USERNAME = '" + NewUsername + "', PASSWORD = '" + NewPassword + "', FNAME = '" + NewFName + "', LNAME = '" + NewLName + "', DOB = PARSEDATETIME('"+NewDOB+"', 'YYYY-MM-DD'), EMAIL = '" + NewEmail + "', ROLE = '" + NewRole + "'"
                + "WHERE STAFFID = " + Long.parseLong(tfStaffId.getText()));
        System.out.println("2");
        EditPane.setVisible(false);
        System.out.println("3");
        refreshTable();
        System.out.println("4");
    }
    
    @FXML
    private void DeleteRow(ActionEvent event) throws Exception {
        d.Insert("DELETE FROM STAFF WHERE USERID = " + Long.parseLong(tfStaffId.getText()));
        EditPane.setVisible(false);
        refreshTable();
    }
    
    @FXML
    private void ComboBoxChoice(ActionEvent event) throws Exception {
        String SearchByType = (String) SearchBy.getSelectionModel().getSelectedItem();
       
        if (SearchByType.equals("ID")) {
            SearchValue.setVisible(true);
            SearchDate.setVisible(false);
        }
        else if (SearchByType.equals("First Name")) {
            SearchValue.setVisible(true);
            SearchDate.setVisible(false);
        }
        else if (SearchByType.equals("Last Name")) {
            SearchValue.setVisible(true);
            SearchDate.setVisible(false);
        }
        else if (SearchByType.equals("Date of Birth")) {
            SearchDate.setVisible(true);
            SearchValue.setVisible(false);
        }
        else if (SearchByType.equals("Role")) {
            SearchDate.setVisible(false);
            SearchValue.setVisible(true);
        }
    }
    
    @FXML
    private void Search(ActionEvent event) throws Exception { //Goes to 'Staff' screen
        
        String SearchByType = (String) SearchBy.getSelectionModel().getSelectedItem();        
        
        staffList.clear();
        try {
            ResultSet rs;
            switch (SearchByType) {
                case "ID":
                    rs = d.getResultSet("SELECT * "
                            + "FROM STAFF "
                            + "WHERE STAFFID  = '" + SearchValue.getText() + "'");
                    while (rs.next()) {
                        staffList.add(new Staff(rs.getLong("STAFFID"), rs.getString("USERNAME"), rs.getString("PASSWORD"), rs.getString("FNAME"), rs.getString("LNAME"), rs.getString("DOB"), rs.getString("EMAIL"), rs.getString("ROLE")));
                    }
                    break;
                case "First Name":
                    rs = d.getResultSet("SELECT * "
                            + "FROM STAFF "
                            + "WHERE FNAME  LIKE '%" + SearchValue.getText() + "%'");
                    while (rs.next()) {
                        staffList.add(new Staff(rs.getLong("STAFFID"), rs.getString("USERNAME"), rs.getString("PASSWORD"), rs.getString("FNAME"), rs.getString("LNAME"), rs.getString("DOB"), rs.getString("EMAIL"), rs.getString("ROLE")));
                    }
                    break;
                case "Last Name":
                    rs = d.getResultSet("SELECT * "
                            + "FROM STAFF "
                            + "WHERE LNAME  LIKE '%" + SearchValue.getText() + "%'");
                    while (rs.next()) {
                        staffList.add(new Staff(rs.getLong("STAFFID"), rs.getString("USERNAME"), rs.getString("PASSWORD"), rs.getString("FNAME"), rs.getString("LNAME"), rs.getString("DOB"), rs.getString("EMAIL"), rs.getString("ROLE")));
                    }
                    break;
                case "Date of Birth":
                    rs = d.getResultSet("SELECT * "
                            + "FROM STAFF "
                            + "WHERE DOB  = '" + SearchDate.getValue().toString() + "'");
                    while (rs.next()) {
                        staffList.add(new Staff(rs.getLong("STAFFID"), rs.getString("USERNAME"), rs.getString("PASSWORD"), rs.getString("FNAME"), rs.getString("LNAME"), rs.getString("DOB"), rs.getString("EMAIL"), rs.getString("ROLE")));
                    }
                    break;
                case "Role":
                    rs = d.getResultSet("SELECT * "
                            + "FROM STAFF "
                            + "WHERE ROLE  LIKE '%" + SearchValue.getText() + "%'");
                    while (rs.next()) {
                        staffList.add(new Staff(rs.getLong("STAFFID"), rs.getString("USERNAME"), rs.getString("PASSWORD"), rs.getString("FNAME"), rs.getString("LNAME"), rs.getString("DOB"), rs.getString("EMAIL"), rs.getString("ROLE")));
                    }
                    break;        
                default:
                    break;
            }

            Table.setItems(FXCollections.observableArrayList(staffList));
            SearchDate.getEditor().clear();
            SearchValue.clear();
            
            
        
        }
        catch (SQLException ex) {
            Logger.getLogger(StaffViewStaffController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    @FXML
    private void clearSearch(MouseEvent event) throws Exception {
        refreshTable();
    }
}   

