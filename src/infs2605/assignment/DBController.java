
package infs2605.assignment;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DBController {
    
    public static Connection conn;
    //protected Statement st;
    //protected ResultSet rs;
    //protected ResultSetMetaData rsmd;
    protected String currentQuery;
    
    
    //Paul added this in - used to open the connection to the database
    public static void openConnection() {
        if (conn == null) {
            try {
                conn = DriverManager.getConnection("jdbc:h2:./INFS2605 Assi");
                java.sql.Statement st = conn.createStatement();
                
            } catch (SQLException ex) {
                ex.printStackTrace();
                
            }
        }
    }
    
    //Ed's old constructor method
    /*public DBController(){
        //Connect to DB
        try {
            Class.forName("org.h2.Driver");
            conn = DriverManager.getConnection("jdbc:h2:./INFS2605 Assi");
            java.sql.Statement st = conn.createStatement();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(INFS2605Assignment.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(INFS2605Assignment.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/
    
    //Not yet used
    public String returnName(int userID){
        java.sql.Statement statement = null;
        currentQuery = "SELECT GENDER FROM USER WHERE ID = " + Integer.toString(userID);
        openConnection();
        try {
            statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(currentQuery);
            if (rs.next()){
                statement.close();
                conn.commit();
                return rs.getString("GENDER");
            }
            else {
                statement.close();
                conn.commit();
                return "NOTHING FOUND";
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(DBController.class.getName()).log(Level.SEVERE, null, ex);
            return "ERROR";
        }
    }
    
    public boolean sanitise(String username, String password){
                //check special characters
        
                Pattern p = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
        Matcher m1 = p.matcher(username);
        Matcher m2 = p.matcher(password);
        boolean b1 = m1.find();
        boolean b2 = m2.find();
        if (b1 || b2){
            return false;
        }
        return true;
    }
    
    //Authenticate
    public boolean authenticate(String username, String password){
        java.sql.Statement statement = null;
        currentQuery = "SELECT USERID FROM USER WHERE USERNAME = '" + username + "' AND PASSWORD = '" + password + "'";
        openConnection();
        try {
            statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(currentQuery);
            if (rs.next()){
                statement.close();
                conn.commit();
                return true;
            }
            else {
                statement.close();
                conn.commit();
                return false;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DBController.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    // This method reads in an sql string and returns a result set
    public ResultSet getResultSet(String sqlstatement) throws SQLException {
        openConnection();
        java.sql.Statement statement = conn.createStatement();
        ResultSet RS = statement.executeQuery(sqlstatement);
        return RS;
    }
    
    public void Insert(String insertSQL) {
        java.sql.Statement statement = null;
        openConnection();
        try {
            statement = conn.createStatement();
            statement.executeUpdate(insertSQL);
            statement.close();
            conn.commit();
        } catch (SQLException ex) {
            Logger.getLogger(DBController.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    public String GetUserPK(){
        java.sql.Statement statement = null;
        currentQuery = "SELECT MAX(USERID) AS MAXX FROM USER";
        openConnection();
        try {
            statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(currentQuery);
            if (rs.next()){ 
                conn.commit();
                return rs.getString("MAXX");
            }
            else {
                statement.close();
                conn.commit();
                return "NOTHING FOUND";
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(DBController.class.getName()).log(Level.SEVERE, null, ex);
            return "ERROR";
        }
    }
}