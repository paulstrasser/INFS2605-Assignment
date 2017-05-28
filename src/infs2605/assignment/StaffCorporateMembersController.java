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
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author paulstrasser
 */
public class StaffCorporateMembersController implements Initializable {

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
    private Button GoToConsultations;
    
    @FXML
    private Button Add;
    
    @FXML
    private TableView<CorporateMember> Table;

    @FXML
    private TableColumn<CorporateMember, String> corporateMemberIdCol;

    @FXML
    private TableColumn<CorporateMember, String> companyNameCol;

    @FXML
    private TableColumn<CorporateMember, String> cStreetNumCol;
    
    @FXML
    private TableColumn<CorporateMember, String> cStreetNameCol;
    
    @FXML
    private TableColumn<CorporateMember, String> cSuburbCol;
    
    @FXML
    private TableColumn<CorporateMember, String> cCityCol;
    
    @FXML
    private TableColumn<CorporateMember, String> cPostCodeCol;
    
    @FXML
    private TableColumn<CorporateMember, String> companyPhoneNumCol;
    
    @FXML
    private TableColumn<CorporateMember, String> ABNCol;
    
    @FXML
    private TextField CorporateMemberID;
    
    @FXML
    private TextField CompanyName;
    
    @FXML
    private TextField CStreetNum;
    
    @FXML
    private TextField CStreetName;
    
    @FXML
    private TextField CSuburb;
    
    @FXML
    private ComboBox CCity;
    
    @FXML
    private TextField CPostCode;
    
    @FXML
    private TextField CompanyPhoneNum;
    
    @FXML
    private TextField ABN;
    
    @FXML
    private Text Name;
    
    @FXML
    private AnchorPane EditPane;
    
    @FXML
    private TextField SearchValue;
   
    @FXML
    private ComboBox SearchBy;
    
    @FXML
    private ComboBox SearchCombo;
    
    @FXML
    private Button Search;
    
    @FXML
    private Button Update;
    
    @FXML
    private Button Cancel;
    
    @FXML
    private AnchorPane ThisPane;
    
    
    
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
    private void GoToConsultations(ActionEvent event) throws Exception { //Goes to 'Matches' screen

        stage=(Stage) GoToConsultations.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("StaffConsultations.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
    }
    
    @FXML
    private void Add(ActionEvent event) throws Exception { //Goes to 'Add' screen

        stage=(Stage) Add.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("StaffAddCorporateMember.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
    }
    
    DBController d = new DBController();
    
    ArrayList<CorporateMember> corporateMembersList = new ArrayList<>(); //Creates the array list

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Name.setText(d.returnSingleQuery("SELECT FNAME AS ANSWER FROM STAFF WHERE USERNAME = '" + SignInController.getUser() + "'"));
        
        EditPane.setVisible(false);
        
        CorporateMemberID.setVisible(false);
        
        corporateMemberIdCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCorporateMemberIdProperty().toString()));
        
        companyNameCol.setCellValueFactory(cellData -> cellData.getValue().getCompanyNameProperty());

        cStreetNumCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCStreetNumProperty().toString()));
        
        cStreetNameCol.setCellValueFactory(cellData -> cellData.getValue().getCStreetNameProperty());

        cSuburbCol.setCellValueFactory(cellData -> cellData.getValue().getCSuburbProperty());
        
        cCityCol.setCellValueFactory(cellData -> cellData.getValue().getCCityProperty());
        
        cPostCodeCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCPostCodeProperty().toString()));

        companyPhoneNumCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCompanyPhoneNumProperty().toString()));
        
        ABNCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getABNProperty().toString()));
        
        getCorporateMembers();
        
        Table.setItems(FXCollections.observableArrayList(corporateMembersList));
        SearchCombo.getItems().addAll("Sydney", "Melbourne", "Brisbane", "Perth", "Darwin", "Adelaide", "Hobart");
        SearchCombo.setVisible(false);
        
        CCity.getItems().addAll("Sydney", "Melbourne", "Brisbane", "Perth", "Darwin", "Adelaide", "Hobart");
        SearchBy.getItems().addAll("ID", "Name", "City");
        Table.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showCorporateMembers(newValue));
    
    }    
    
    public void getCorporateMembers() {
        try {
            corporateMembersList.clear();
            ResultSet rs = d.getResultSet("SELECT * " 
                    + "FROM CORPORATEMEMBER");
            while (rs.next()) {
                corporateMembersList.add(new CorporateMember(rs.getLong("CORPORATEMEMBERID"), rs.getString("COMPANYNAME"), rs.getInt("CSTREETNUM"), rs.getString("CSTREETNAME"), rs.getString("CSUBURB"), rs.getString("CCITY"), rs.getInt("CPOSTCODE"), rs.getLong("COMPANYPHONENUM"), rs.getLong("ABN")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(StaffCorporateMembersController.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    public void showCorporateMembers(CorporateMember corporateMember) {
        EditPane.setVisible(true);
        CorporateMemberID.setText(corporateMember.getCorporateMemberId());
        CompanyName.setText(corporateMember.getCompanyName());
        CStreetNum.setText(corporateMember.getCStreetNum());
        CStreetName.setText(corporateMember.getCStreetName());
        CSuburb.setText(corporateMember.getCSuburb());
        CCity.setValue(corporateMember.getCCity());
        CPostCode.setText(corporateMember.getCPostCode());
        CompanyPhoneNum.setText(corporateMember.getCompanyPhoneNum());
        ABN.setText(corporateMember.getABN());
    }
    
    public void refreshTable() {
        corporateMembersList.clear();
        getCorporateMembers();
        Table.setItems(FXCollections.observableArrayList(corporateMembersList));
    }
    
    @FXML
    private void Cancel(ActionEvent event) throws Exception {
        EditPane.setVisible(false);
    }
    
    @FXML
    private void UpdateAndGoToView(ActionEvent event) throws Exception {
        long NewCorporateMemberID = Long.parseLong(CorporateMemberID.getText());
        String NewCompanyName = CompanyName.getText();
        int NewCStreetNum = Integer.parseInt(CStreetNum.getText());
        String NewCStreetName = CStreetName.getText();
        String NewCSuburb = CSuburb.getText();
        String NewCCity = (String) CCity.getSelectionModel().getSelectedItem();
        int NewCPostCode = Integer.parseInt(CPostCode.getText());
        long NewCompanyPhoneNum = Long.parseLong(CompanyPhoneNum.getText());
        long NewABN = Long.parseLong(ABN.getText());

        d.Insert("UPDATE CORPORATEMEMBER "
                + "SET CORPORATEMEMBERID = " + NewCorporateMemberID + ", COMPANYNAME = '" + NewCompanyName + "', CSTREETNUM = " + NewCStreetNum + ", CSTREETNAME = '" + NewCStreetName + "', CSUBURB = '" + NewCSuburb + "', CCITY = '" + NewCCity + "', CPOSTCODE = " + NewCPostCode + ", COMPANYPHONENUM = " + NewCompanyPhoneNum + ", ABN = " + NewABN + " "
                + "WHERE CORPORATEMEMBERID = " + Long.parseLong(CorporateMemberID.getText()));
        EditPane.setVisible(false);
        refreshTable();
    }
    
    @FXML
    private void DeleteRow(ActionEvent event) throws Exception {
        d.Insert("DELETE FROM CORPORATEMEMBER WHERE CORPORATEMEMBERID = " + Long.parseLong(CorporateMemberID.getText()));
        EditPane.setVisible(false);
        refreshTable();
    }
    
    @FXML
    private void ComboBoxChoice(ActionEvent event) throws Exception {
        String SearchByType = (String) SearchBy.getSelectionModel().getSelectedItem();
       
        if (SearchByType.equals("ID")) {
            SearchValue.setVisible(true);
            SearchCombo.setVisible(false);
        }
        else if (SearchByType.equals("Name")) {
            SearchValue.setVisible(true);
            SearchCombo.setVisible(false);
        }
        else if (SearchByType.equals("City")) {
            SearchValue.setVisible(false);
            SearchCombo.setVisible(true);
        }
    }
    
    @FXML
    private void Search(ActionEvent event) throws Exception { //Goes to 'Staff' screen
        
        String SearchByType = (String) SearchBy.getSelectionModel().getSelectedItem();        
        
        corporateMembersList.clear();
        try {
            ResultSet rs;
            switch (SearchByType) {
                case "ID":
                    rs = d.getResultSet("SELECT * "
                            + "FROM CORPORATEMEMBER "
                            + "WHERE CORPORATEMEMBERID  = '" + SearchValue.getText() + "'");
                    while (rs.next()) {
                        corporateMembersList.add(new CorporateMember(rs.getLong("CORPORATEMEMBERID"), rs.getString("COMPANYNAME"), rs.getInt("CSTREETNUM"), rs.getString("CSTREETNAME"), rs.getString("CSUBURB"), rs.getString("CCITY"), rs.getInt("CPOSTCODE"), rs.getLong("COMPANYPHONENUM"), rs.getLong("ABN")));
                    }
                    break;
                case "Name":
                    rs = d.getResultSet("SELECT * "
                            + "FROM CORPORATEMEMBER  "
                            + "WHERE COMPANYNAME  LIKE '%" + SearchValue.getText() + "%'");
                    while (rs.next()) {
                        corporateMembersList.add(new CorporateMember(rs.getLong("CORPORATEMEMBERID"), rs.getString("COMPANYNAME"), rs.getInt("CSTREETNUM"), rs.getString("CSTREETNAME"), rs.getString("CSUBURB"), rs.getString("CCITY"), rs.getInt("CPOSTCODE"), rs.getLong("COMPANYPHONENUM"), rs.getLong("ABN")));
                    }
                    break;
                case "City":
                    rs = d.getResultSet("SELECT * "
                            + "FROM CORPORATEMEMBER "
                            + "WHERE CCITY = '" + SearchCombo.getSelectionModel().getSelectedItem().toString() + "'");
                    while (rs.next()) {
                        corporateMembersList.add(new CorporateMember(rs.getLong("CORPORATEMEMBERID"), rs.getString("COMPANYNAME"), rs.getInt("CSTREETNUM"), rs.getString("CSTREETNAME"), rs.getString("CSUBURB"), rs.getString("CCITY"), rs.getInt("CPOSTCODE"), rs.getLong("COMPANYPHONENUM"), rs.getLong("ABN")));
                    }
                    break;        
                default:
                    break;
            }

            Table.setItems(FXCollections.observableArrayList(corporateMembersList));
            SearchCombo.getEditor().clear();
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

