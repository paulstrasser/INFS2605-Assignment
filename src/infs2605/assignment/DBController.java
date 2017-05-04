
package infs2605.assignment;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBController {
    
    protected Connection conn;
    protected Statement st;
    protected ResultSet rs;
    protected ResultSetMetaData rsmd;
    protected String currentQuery;
    
    public DBController(){
        //Connect to DB
        try {
            Class.forName("org.h2.Driver");
            conn = DriverManager.getConnection("jdbc:h2:./INFS2605 Assi");
            st = conn.createStatement();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(INFS2605Assignment.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(INFS2605Assignment.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String returnName(int userID){
        currentQuery = "SELECT GENDER FROM USER WHERE ID = " + Integer.toString(userID);
        System.out.println(currentQuery);
        try {
            rs = st.executeQuery(currentQuery);
            if (rs.next()){
                return rs.getString("GENDER");
            }
            else {
                return "NOTHING FOUND";
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBController.class.getName()).log(Level.SEVERE, null, ex);
            return "ERROR";
        }   
    }

}
