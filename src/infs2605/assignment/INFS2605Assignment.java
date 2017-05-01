
package infs2605.assignment;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author edHopkins
 */
public class INFS2605Assignment extends Application {
    
    @Override
    public void start(Stage stage) throws IOException  {
        Parent root = FXMLLoader.load(getClass().getResource("Welcome.fxml"));
        
        stage.setResizable(false);
        Scene scene = new Scene(root);
        stage.setTitle("SuBer");
        stage.setScene(scene);
        stage.show();
    }
    
    

    
    public static void main(String[] args) {
        launch(args);
    }
    
}
