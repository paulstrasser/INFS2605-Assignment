/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infs2605.assignment;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author paulstrasser
 */
public class StaffAddCorporateMemberController implements Initializable {

    @FXML
    Stage stage;
    Parent root;
    
    @FXML
    private Button Cancel;
    
    @FXML
    private Button Add;
    
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
    private TextField CorporateMemberId;
    
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
    private void Cancel(ActionEvent event) throws Exception { //Goes to 'Matches' screen

        stage=(Stage) Cancel.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("StaffCorporateMembers.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
    }
    
    
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
    
    DBController d = new DBController();

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //HCity.getItems().addAll("Sydney", "Melbourne", "Brisbane", "Perth", "Darwin", "Adelaide", "Hobart");

    }

    @FXML 
    private void Add(ActionEvent event) throws IOException {
        String AddCompanyName = CompanyName.getText();
        int AddCStreetNum = Integer.parseInt(CStreetNum.getText());
        String AddCStreetName = CStreetName.getText();
        String AddCSuburb = CSuburb.getText();
        String AddCCity = (String) CCity.getSelectionModel().getSelectedItem();
        int AddCPostCode = Integer.parseInt(CPostCode.getText());
        long AddCompanyPhoneNum = Long.parseLong(CompanyPhoneNum.getText());
        long AddABN = Long.parseLong(ABN.getText());
        int thisPK = Integer.parseInt(d.returnSingleQuery("SELECT MAX(CORPORATEMEMBERID) AS ANSWER FROM CORPORATEMEMBER"))+1;

        
        
        if (AddCompanyName.isEmpty()) {
            System.out.println("EMPTY");
        }
        
        else {
            try {
               d.Insert("INSERT INTO CORPORATEMEMBERS (CORPORATEMEMBERID, COMPANYNAME, CSTREETNUM, CSTREETNAME, CSUBURB, CCITY, CPOSTCODE, COMPANYPHONENUM, ABN) VALUES (" + thisPK + ", '" + AddCompanyName + "', " + AddCStreetNum + ", '" + AddCStreetName + "', '" + AddCSuburb + "', '" + AddCCity + "', " + AddCPostCode + ", " + AddCompanyPhoneNum + ", " + AddABN + ")");               
               stage=(Stage) Add.getScene().getWindow();
               root = FXMLLoader.load(getClass().getResource("StaffCorporateMembers.fxml"));
               Scene scene = new Scene(root);
               stage.setScene(scene);
               stage.show(); 
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
               
        }
    }
        
    
}

