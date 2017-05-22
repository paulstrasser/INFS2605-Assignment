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
    private Button Update;
    
    @FXML
    private Button Cancel;
    
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
    private TableColumn<NormalMember, String> USERTYPECol;
    
    @FXML
    private TableColumn<NormalMember, String> GENDERCol;
    
    /*@FXML
    private TableColumn<NormalMember, String> DOBCol;
    */
    
    @FXML
    private TableColumn<NormalMember, String> HPHONECol;
    
    @FXML
    private TableColumn<NormalMember, String> WPHONECol;
    
    @FXML
    private TableColumn<NormalMember, String> MPHONECol;
    
    @FXML
    private TableColumn<NormalMember, String> EMAILCol;
    
    @FXML
    private TableColumn<NormalMember, String> HNUMCol;
    
    @FXML
    private TableColumn<NormalMember, String> HSTREETCol;
    
    @FXML
    private TableColumn<NormalMember, String> HSUBURBCol;
    
    @FXML
    private TableColumn<NormalMember, String> HCITYCol;
    
    @FXML
    private TableColumn<NormalMember, String> HPOSTCODECol;
    
    @FXML
    private TableColumn<NormalMember, String> WNUMCol;
    
    @FXML
    private TableColumn<NormalMember, String> WSTREETCol;
    
    @FXML
    private TableColumn<NormalMember, String> WSUBURBCol;
    
    @FXML
    private TableColumn<NormalMember, String> WCITYCol;
    
    @FXML
    private TableColumn<NormalMember, String> WPOSTCODECol;
    
    @FXML
    private TableColumn<NormalMember, String> MAKECol;
    
    @FXML
    private TableColumn<NormalMember, String> MODELCol;
    
    @FXML
    private TableColumn<NormalMember, String> COLOURCol;
    
    @FXML
    private TableColumn<NormalMember, String> YEARMADECol;
    
    @FXML
    private TableColumn<NormalMember, String> REGISTRATIONCol;
    
    @FXML
    private TableColumn<NormalMember, String> NUMOFSEATSCol;
    
    @FXML
    private TableColumn<NormalMember, String> LICENSENUMCol;
    
    @FXML
    private TableColumn<NormalMember, String> USERNAMECol;
    
    @FXML
    private TableColumn<NormalMember, String> PASSWORDCol;
    
    @FXML
    private TableColumn<NormalMember, String> DESCRIPTIONCol;
    
    @FXML
    private TableColumn<NormalMember, String> NAMEONCARDCol;
    
    @FXML
    private TableColumn<NormalMember, String> CARDNUMCol;
    
    @FXML
    private TableColumn<NormalMember, String> CVVCol;
    
    @FXML
    private TextField Value;
    
    @FXML
    private ComboBox SearchBy;
        
    @FXML
    private AnchorPane ViewNormalMembersPane;
    
    @FXML
    private AnchorPane EditNormalMembersPane;
    
    @FXML
    private TextField Username;
    
    @FXML
    private TextField Password;
    
    @FXML
    private TextField USERID;
    
    @FXML
    private TextField FName;
    
    @FXML
    private TextField LName;
    
    @FXML
    private TextField HPhone;
    
    @FXML
    private TextField WPhone;
    
    @FXML
    private TextField MPhone;
    
    @FXML
    private TextField Email;
    
    @FXML
    private TextField HNum;
    
    @FXML
    private TextField HStreet;
    
    @FXML
    private TextField HSuburb;
    
    @FXML
    private TextField HPostCode;
    
    @FXML
    private TextField WNum;
    
    @FXML
    private TextField WStreet;
    
    @FXML
    private TextField WSuburb;
    
    @FXML
    private TextField WPostCode;
    
    @FXML
    private TextField Make;
    
    @FXML
    private TextField Model;
    
    @FXML
    private TextField Year;
    
    @FXML
    private TextField Colour;
    
    @FXML
    private TextField Registration;
    
    @FXML
    private TextField Seats;
    
    @FXML
    private TextField LicenseNumber;
    
    @FXML
    private TextField NameOnCard;
    
    @FXML
    private TextField CardNumber;
    
    @FXML
    private TextField CVV;
    
    @FXML
    private ComboBox UserType;
    
    @FXML
    private ComboBox Gender;
    
    @FXML
    private ComboBox HCity;
    
    @FXML
    private ComboBox WCity;
    
    @FXML
    private DatePicker DOB;
    
    @FXML
    private DatePicker LExpiryDate;
    
    @FXML
    private DatePicker CExpiryDate;
        
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
        ViewNormalMembersPane.setVisible(true);
        EditNormalMembersPane.setVisible(false);
        USERIDCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getUSERIDProperty().toString()));
        
        FNAMECol.setCellValueFactory(cellData -> cellData.getValue().getFNAMEProperty());
        
        LNAMECol.setCellValueFactory(cellData -> cellData.getValue().getLNAMEProperty());
        
        USERTYPECol.setCellValueFactory(cellData -> cellData.getValue().getUSERTYPEProperty());

        GENDERCol.setCellValueFactory(cellData -> cellData.getValue().getGENDERProperty());
        
        //DOBCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDOBProperty()));
        
        HPHONECol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getHPHONEProperty().toString()));
        
        WPHONECol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getWPHONEProperty().toString()));

        MPHONECol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMPHONEProperty().toString()));
        
        EMAILCol.setCellValueFactory(cellData -> cellData.getValue().getEMAILProperty());
        
        HNUMCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getHNUMProperty().toString()));
        
        HSTREETCol.setCellValueFactory(cellData -> cellData.getValue().getHSTREETProperty());
        
        HSUBURBCol.setCellValueFactory(cellData -> cellData.getValue().getHSUBURBProperty());
        
        HCITYCol.setCellValueFactory(cellData -> cellData.getValue().getHCITYProperty());
        
        HPOSTCODECol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getHPOSTCODEProperty().toString()));
        
        WNUMCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getWNUMProperty().toString()));
        
        WSTREETCol.setCellValueFactory(cellData -> cellData.getValue().getWSTREETProperty());
        
        WSUBURBCol.setCellValueFactory(cellData -> cellData.getValue().getWSUBURBProperty());
        
        WCITYCol.setCellValueFactory(cellData -> cellData.getValue().getWCITYProperty());
        
        WPOSTCODECol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getWPOSTCODEProperty().toString()));
        
        MAKECol.setCellValueFactory(cellData -> cellData.getValue().getMAKEProperty());
        
        MODELCol.setCellValueFactory(cellData -> cellData.getValue().getMODELProperty());
        
        COLOURCol.setCellValueFactory(cellData -> cellData.getValue().getCOLOURProperty());
        
        YEARMADECol.setCellValueFactory(cellData -> cellData.getValue().getYEARMADEProperty());
        
        REGISTRATIONCol.setCellValueFactory(cellData -> cellData.getValue().getREGISTRATIONProperty());
        
        NUMOFSEATSCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNUMOFSEATSProperty().toString()));
        
        LICENSENUMCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getLICENSENUMProperty().toString()));
        
        USERNAMECol.setCellValueFactory(cellData -> cellData.getValue().getUSERNAMEProperty());
        
        PASSWORDCol.setCellValueFactory(cellData -> cellData.getValue().getPASSWORDProperty());
        
        DESCRIPTIONCol.setCellValueFactory(cellData -> cellData.getValue().getDESCRIPTIONProperty());
        
        NAMEONCARDCol.setCellValueFactory(cellData -> cellData.getValue().getNAMEONCARDProperty());
        
        CARDNUMCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCARDNUMProperty().toString()));
        
        CVVCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCVVProperty().toString()));
        getNormalMembers();
        
        
        Table.setItems(FXCollections.observableArrayList(normalMembersList));
        Table.setEditable(true);
        SearchBy.getItems().addAll("USERID","FNAME","LNAME", "USERTYPE", "GENDER", "HSUBURB", "HCITY", "WSUBURB", "WCITY", "USERNAME"); 
        Table.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showNormalMemberDetails(newValue));
    }
    
    public void showNormalMemberDetails(NormalMember normalMember) {
        EditNormalMembersPane.setVisible(true);
        USERID.setText(normalMember.getUSERID());
        FName.setText(normalMember.getFNAME());
        LName.setText(normalMember.getLNAME());
        UserType.setValue(normalMember.getUSERTYPE());
        Gender.setValue(normalMember.getGENDER());
        HPhone.setText(normalMember.getHPHONE());
        WPhone.setText(normalMember.getWPHONE());
        MPhone.setText(normalMember.getMPHONE());
        Email.setText(normalMember.getEMAIL());
        HNum.setText(normalMember.getHNUM());
        HStreet.setText(normalMember.getHSTREET());
        HSuburb.setText(normalMember.getHSUBURB());
        HCity.setValue(normalMember.getHCITY());
        HPostCode.setText(normalMember.getHPOSTCODE());
        WNum.setText(normalMember.getWNUM());
        WStreet.setText(normalMember.getWSTREET());
        WSuburb.setText(normalMember.getWSUBURB());
        WCity.setValue(normalMember.getWCITY());
        WPostCode.setText(normalMember.getWPOSTCODE());
        Make.setText(normalMember.getMAKE());
        Model.setText(normalMember.getMODEL());
        Colour.setText(normalMember.getCOLOUR());
        Year.setText(normalMember.getYEARMADE());
        Registration.setText(normalMember.getREGISTRATION());
        Seats.setText(normalMember.getNUMOFSEATS());
        LicenseNumber.setText(normalMember.getLICENSENUM());
        Username.setText(normalMember.getUSERNAME());
        Password.setText(normalMember.getPASSWORD());
        NameOnCard.setText(normalMember.getNAMEONCARD());
        CardNumber.setText(normalMember.getCARDNUM());
        CVV.setText(normalMember.getCVV());        
    }                
    

    public void getNormalMembers() {
        try {
            normalMembersList.clear();
            ResultSet rs = d.getResultSet("SELECT USERID, FNAME, LNAME, USERTYPE, GENDER, HPHONE, WPHONE, MPHONE, EMAIL, HNUM, HSTREET, HSUBURB, HCITY, HPOSTCODE, WNUM, WSTREET, WSUBURB, WCITY, WPOSTCODE, MAKE, MODEL, COLOUR, YEARMADE, REGISTRATION, NUMOFSEATS, LICENSENUM, USERNAME, PASSWORD, DESCRIPTION, NAMEONCARD, CARDNUM, CVV " 
                    + "FROM USER");
            while (rs.next()) {
                normalMembersList.add(new NormalMember(rs.getLong("USERID"), rs.getString("FNAME"), rs.getString("LNAME"), rs.getString("USERTYPE"), rs.getString("GENDER"), /*rs.getString("DOB"), */rs.getLong("HPHONE"), rs.getLong("WPHONE"), rs.getLong("MPHONE"), rs.getString("EMAIL"), rs.getInt("HNUM"), rs.getString("HSTREET"), rs.getString("HSUBURB"), rs.getString("HCITY"), rs.getInt("HPOSTCODE"), rs.getInt("WNUM"), rs.getString("WSTREET"), rs.getString("WSUBURB"), rs.getString("WCITY"), rs.getInt("WPOSTCODE"), rs.getString("MAKE"), rs.getString("MODEL"), rs.getString("COLOUR"), rs.getString("YEARMADE"), rs.getString("REGISTRATION"), rs.getInt("NUMOFSEATS"), rs.getLong("LICENSENUM"), rs.getString("USERNAME"), rs.getString("PASSWORD"), rs.getString("DESCRIPTION"), rs.getString("NAMEONCARD"), rs.getLong("CARDNUM"), rs.getInt("CVV")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(StaffNormalMembersController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void Search(ActionEvent event) throws Exception { //Goes to 'Staff' screen
        String search = (String) SearchBy.getSelectionModel().getSelectedItem();
        normalMembersList.clear();
        try {
            
            ResultSet rs = d.getResultSet("SELECT USERID, FNAME, LNAME, USERTYPE, GENDER, HPHONE, WPHONE, MPHONE, EMAIL, HNUM, HSTREET, HSUBURB, HCITY, HPOSTCODE, WNUM, WSTREET, WSUBURB, WCITY, WPOSTCODE, MAKE, MODEL, COLOUR, YEARMADE, REGISTRATION, NUMOFSEATS, LICENSENUM, USERNAME, PASSWORD, DESCRIPTION, NAMEONCARD, CARDNUM, CVV " 
                + "FROM USER "
                + "WHERE " + search + " = '" + Value.getText() + "'");
            while (rs.next()) {
                normalMembersList.add(new NormalMember(rs.getLong("USERID"), rs.getString("FNAME"), rs.getString("LNAME"), rs.getString("USERTYPE"), rs.getString("GENDER"), /*rs.getString("DOB"), */rs.getLong("HPHONE"), rs.getLong("WPHONE"), rs.getLong("MPHONE"), rs.getString("EMAIL"), rs.getInt("HNUM"), rs.getString("HSTREET"), rs.getString("HSUBURB"), rs.getString("HCITY"), rs.getInt("HPOSTCODE"), rs.getInt("WNUM"), rs.getString("WSTREET"), rs.getString("WSUBURB"), rs.getString("WCITY"), rs.getInt("WPOSTCODE"), rs.getString("MAKE"), rs.getString("MODEL"), rs.getString("COLOUR"), rs.getString("YEARMADE"), rs.getString("REGISTRATION"), rs.getInt("NUMOFSEATS"), rs.getLong("LICENSENUM"), rs.getString("USERNAME"), rs.getString("PASSWORD"), rs.getString("DESCRIPTION"), rs.getString("NAMEONCARD"), rs.getLong("CARDNUM"), rs.getInt("CVV")));
            }
            Table.setItems(FXCollections.observableArrayList(normalMembersList));            
        }
        catch (SQLException ex) {
            Logger.getLogger(StaffNormalMembersController.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
    
    @FXML
    private void clearSearch(MouseEvent event) throws Exception {
         refreshTable();
    }
    
    public void refreshTable() {
        normalMembersList.clear();
        getNormalMembers();
        Table.setItems(FXCollections.observableArrayList(normalMembersList));
    }
    
    @FXML
    private void Cancel(ActionEvent event) throws Exception {
        EditNormalMembersPane.setVisible(false);

    }
   
    
    @FXML
    private void UpdateAndGoToView(ActionEvent event) throws Exception {
        long NewUSERID = Long.parseLong(USERID.getText());
        String NewFNAME = FName.getText();
        String NewLNAME = LName.getText();
        String NewUSERTYPE = (String) UserType.getSelectionModel().getSelectedItem();
        String NewGENDER = (String) Gender.getSelectionModel().getSelectedItem();
        long NewHPHONE = Long.parseLong(HPhone.getText());
        long NewWPHONE = Long.parseLong(WPhone.getText());
        long NewMPHONE = Long.parseLong(MPhone.getText());
        String NewEMAIL = Email.getText();
        int NewHNUM = Integer.parseInt(HNum.getText());
        String NewHSTREET = HStreet.getText();
        String NewHSUBURB = HSuburb.getText();
        String NewHCITY = (String) HCity.getSelectionModel().getSelectedItem();
        int NewHPOSTCODE = Integer.parseInt(HPostCode.getText());
        int NewWNUM = Integer.parseInt(WNum.getText());
        String NewWSTREET = WStreet.getText();
        String NewWSUBURB = WSuburb.getText();
        String NewWCITY = (String) WCity.getSelectionModel().getSelectedItem();
        int NewWPOSTCODE = Integer.parseInt(WPostCode.getText());
        String NewMAKE = Make.getText();
        String NewMODEL = Model.getText();
        String NewCOLOUR = Colour.getText();
        String NewYEARMADE = Year.getText();
        String NewREGISTRATION = Registration.getText();
        int NewNUMOFSEATS = Integer.parseInt(Seats.getText());
        long NewLICENSENUM = Long.parseLong(LicenseNumber.getText());
        String NewUSERNAME = Username.getText();
        String NewPASSWORD = Password.getText();
        String NewNAMEONCARD = NameOnCard.getText();
        long NewCARDNUM = Long.parseLong(CardNumber.getText());
        int NewCVV = Integer.parseInt(CVV.getText());

        d.Insert("UPDATE USER "
                + "SET USERID = " + NewUSERID + ", FNAME = '" + NewFNAME + "', LNAME = '" + NewLNAME + "', USERTYPE = '" + NewUSERTYPE + "', GENDER = '" + NewGENDER + "', HPHONE = " + NewHPHONE + ", WPHONE = " + NewWPHONE + ", MPHONE = " + NewMPHONE + ", EMAIL = '" + NewEMAIL + "', HNUM = " + NewHNUM + ", HSTREET = '" + NewHSTREET + "', HSUBURB = '" + NewHSUBURB + "', HCITY = '" + NewHCITY + "', HPOSTCODE = " + NewHPOSTCODE + ", WNUM = " + NewWNUM + ", WSTREET = '" + NewWSTREET + "', WSUBURB = '" + NewWSUBURB + "', WCITY = '" + NewWCITY + "', WPOSTCODE = " + NewWPOSTCODE + ", MAKE = '" + NewMAKE + "', MODEL = '" + NewMODEL + "', COLOUR = '" + NewCOLOUR + "', YEARMADE = '" + NewYEARMADE + "', REGISTRATION = '" + NewREGISTRATION + "', NUMOFSEATS = " + NewNUMOFSEATS + ", LICENSENUM = " + NewLICENSENUM + ", USERNAME = '" + NewUSERNAME + "', PASSWORD = '" + NewPASSWORD + "', NAMEONCARD = '" + NewNAMEONCARD + "', CARDNUM = " + NewCARDNUM + ", CVV = " + NewCVV
                + "WHERE USERID = " + Long.parseLong(USERID.getText()));
        
        EditNormalMembersPane.setVisible(false);
        refreshTable();
    }
}   
    





