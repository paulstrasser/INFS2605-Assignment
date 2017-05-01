
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author paulstrasser
 */
public class DatabaseConnection {

    private String location;
    private Connection conn;
    
    public DatabaseConnection(String location) {
        this.location = location;
    }
    
    public void openConnection() throws SQLException {
        conn = DriverManager.getConnection("jdbc:h2:" + location + ";create=true");
        System.out.println("Connected to Database");
        
    }
    
    public void closeConnection() throws SQLException {
        if (conn != null) {
            conn.close();
        }
        System.out.println("Disconnected from Database");
    }
    

    
    
    
}
//SELECT statements, using statement.executeQuery, INSERT and CREATE statements, use statement.execute UPDATE, use statement.executeUpdate