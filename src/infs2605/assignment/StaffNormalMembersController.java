/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infs2605.assignment;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author paulstrasser
 */
public class StaffNormalMembersController implements Initializable {

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
    private Button Edit;
    
    @FXML
    private Button Search;
    
    @FXML
    private TableView<NormalMember> Table;

    @FXML
    private TableColumn<NormalMember, String> USERIDCol;

    @FXML
    private TableColumn<NormalMember, String> FNAMECol;

    @FXML
    private TableColumn<NormalMember, String> LNAMECol;
    
    @FXML
    private TextField filterField;
    
    @FXML
    private TextField LNAME;
    
    @FXML
    private AnchorPane clickAway;
        
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
        root = FXMLLoader.load(getClass().getResource("StaffAddNormalMembers.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
    }
    
    
    DBController d = new DBController(); //Establish a connection to the db
    
    ArrayList<NormalMember> normalMembersList = new ArrayList<>(); //Creates the array list
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        USERIDCol.setCellValueFactory(cellData -> cellData.getValue().getUSERIDProperty());
        FNAMECol.setCellValueFactory(cellData -> cellData.getValue().getFNAMEProperty());
        FNAMECol.setCellFactory(
                TextFieldTableCell.forTableColumn());

        FNAMECol.setOnEditCommit(
                (TableColumn.CellEditEvent<NormalMember, String> t) ->
                    ( t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).setFNAME(t.getNewValue())
                );
                
        LNAMECol.setCellValueFactory(cellData -> cellData.getValue().getLNAMEProperty());
        getNormalMembers();
        
        
        Table.setItems(FXCollections.observableArrayList(normalMembersList));
        Table.setEditable(true);
        
        /*FilteredList<NormalMember> filteredData = new FilteredList<>(FXCollections.observableArrayList(normalMembersList), p -> true);
        filterField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(normalMember -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                
                String lowerCaseFilter = newValue.toLowerCase();
                
                if (normalMember.getFNAME().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                }
                else if (normalMember.getLNAME().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                }
                return false; 
            });
        });*/
 
    }

    public void getNormalMembers() {
        try {
            ResultSet rs = d.getResultSet("SELECT USERID, FNAME, LNAME " 
                    + "FROM USER");
            while (rs.next()) {
                normalMembersList.add(new NormalMember(rs.getString("USERID"),rs.getString("FNAME"),rs.getString("LNAME")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(StaffNormalMembersController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void Search(ActionEvent event) throws Exception { //Goes to 'Staff' screen
        String SearchLNAME = LNAME.getText();
        normalMembersList.clear();
        try {
            ResultSet rs = d.getResultSet("SELECT USERID, FNAME, LNAME "
                + "FROM USER "
                + "WHERE LNAME = '" + SearchLNAME + "'");
            while (rs.next()) {
                normalMembersList.add(new NormalMember(rs.getString("USERID"),rs.getString("FNAME"),rs.getString("LNAME")));
            }
            Table.setItems(FXCollections.observableArrayList(normalMembersList));            
        }
        catch (SQLException ex) {
            Logger.getLogger(StaffNormalMembersController.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
    
    @FXML
    private void clearSearch(MouseEvent event) throws Exception {
        normalMembersList.clear();
        getNormalMembers();
        Table.setItems(FXCollections.observableArrayList(normalMembersList));  
    }
    
}   
    





