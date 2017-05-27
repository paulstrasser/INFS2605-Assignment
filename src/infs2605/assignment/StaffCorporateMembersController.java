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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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
        Name.setText(d.returnSingleQuery("SELECT FNAME AS ANSWER FROM STAFF WHERE USERNAME LIKE '" + SignInController.getUser() + "'"));
        
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
        //SearchCITY.getItems().addAll("Sydney", "Melbourne", "Brisbane", "Perth", "Darwin", "Adelaide", "Hobart");
    }    
    
    public void getCorporateMembers() {
        try {
            corporateMembersList.clear();
            ResultSet rs = d.getResultSet("SELECT * " 
                    + "FROM CORPORATEMEMBER");
            while (rs.next()) {
                corporateMembersList.add(new CorporateMember(rs.getInt("CORPORATEMEMBERID"), rs.getString("COMPANYNAME"), rs.getInt("CSTREETNUM"), rs.getString("CSTREETNAME"), rs.getString("CSUBURB"), rs.getString("CCITY"), rs.getInt("CPOSTCODE"), rs.getLong("COMPANYPHONENUM"), rs.getLong("ABN")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(StaffCorporateMembersController.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
}


