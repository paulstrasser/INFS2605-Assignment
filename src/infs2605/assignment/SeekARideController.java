/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infs2605.assignment;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TitledPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author paulstrasser
 */
public class SeekARideController implements Initializable {

    @FXML
    Stage stage;
    Parent root;
    
    @FXML
    private Button Signout, Search;
    
    @FXML
    private Text Name;
    
    @FXML
    private MenuButton Seek;
    
    @FXML
    private MenuItem SeekaRide;
    
    @FXML
    private GridPane results;
    
    @FXML
    private TitledPane searchResultsTitledPane;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Makes the 'Results' TitledPane not collapseable 
        searchResultsTitledPane.setCollapsible(false); 
    
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
    private void Profile(MouseEvent event) throws Exception {

        stage=(Stage) Name.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("Profile Page.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    private void addResults(ActionEvent event) throws Exception {
    //this method is a test done by Paul. It displays 'hello' in each grid of the gridpane.
    //Essentially, we want to show seek records in each gridPane.
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                Label test = new Label("Hello");
                results.add(test,i,j);
            }
        }
    }
    
    
    
    
       
    
}
