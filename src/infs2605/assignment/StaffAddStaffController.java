package infs2605.assignment;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author paulstrasser
 */
public class StaffAddStaffController implements Initializable {

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
    private TextField tfEmail;
    
    @FXML
    private TextField tfRole;
    
    @FXML
    private DatePicker dpDOB;
    
    @FXML
    private Text Name;
            
    @FXML
    private void Cancel(ActionEvent event) throws Exception { //Goes to 'Matches' screen

        stage=(Stage) Cancel.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("StaffViewStaff.fxml"));
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
        Name.setText(d.returnSingleQuery("SELECT FNAME AS ANSWER FROM STAFF WHERE USERNAME LIKE '" + SignInController.getUser() + "'"));
    }    
    
    @FXML
    private void Add(ActionEvent event) throws Exception {
        String AddUsername = tfUsername.getText();
        String AddPassword = tfPassword.getText();
        String AddFName = tfFName.getText();
        String AddLName = tfLName.getText();
        LocalDate AddDOB = dpDOB.getValue();
        String AddEmail = tfEmail.getText();
        String AddRole = tfRole.getText();        
        int thisPK = Integer.parseInt(d.returnSingleQuery("SELECT MAX(STAFFID) AS ANSWER FROM STAFF"))+1;

        
        
        if (AddUsername.isEmpty() || AddPassword.isEmpty()) {
            System.out.println("EMPTY");
        }
        else {
            try {
               d.Insert("INSERT INTO STAFF (STAFFID, USERNAME, PASSWORD, FNAME, LNAME, DOB, EMAIL, ROLE) VALUES (" + thisPK + ", '" + AddUsername + "', '" + AddPassword + "', '" + AddFName + "', '" + AddLName + "', PARSEDATETIME('"+AddDOB+"', 'YYYY-MM-DD'), '" + AddEmail + "', '" + AddRole + "')");               
               stage=(Stage) Add.getScene().getWindow();
               root = FXMLLoader.load(getClass().getResource("StaffViewStaff.fxml"));
               Scene scene = new Scene(root);
               stage.setScene(scene);
               stage.show(); 
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
               
        }
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Action Processed");
        alert.setHeaderText(null);
        alert.setContentText("Staff Added!");

        alert.showAndWait();
    }
    
    
}

