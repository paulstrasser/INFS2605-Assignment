
package infs2605.assignment;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    
    //Not yet used
    public String returnName(int userID){
        currentQuery = "SELECT GENDER FROM USER WHERE ID = " + Integer.toString(userID);
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
        currentQuery = "SELECT USERID FROM USER WHERE USERNAME = '" + username + "' AND PASSWORD = '" + password + "'";
        try {
            rs = st.executeQuery(currentQuery);
            if (rs.next()){
                return true;
            }
            else {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBController.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    /* ALL THIS TABLEVIEW SHIT I CANT GET TO WORK
    public ResultSet returnResultSet(String s) throws SQLException{
        rs=st.executeQuery(s);
        
        return rs;
    }
    
    
    public List<ArrayList<String>> returnNormalMembers(ResultSet rs) throws SQLException{
        String SQL = "Select * From USER";
        rs=st.executeQuery(SQL);

        //Initiate results list
        List<ArrayList<String>> results = new ArrayList<ArrayList<String>>();
        
        //Get the column count
        ResultSetMetaData rsmd = rs.getMetaData();
        int columnCount = rsmd.getColumnCount();
        
        //Build the column headings list
        ArrayList<String> columnHeadings = new ArrayList<String>();
        for (int i = 1; i <= columnCount; i++) {
            columnHeadings.add(rsmd.getColumnLabel(i));
        }
        results.add(columnHeadings);
        
        //Fill Results
        while (rs.next()) {
            ArrayList<String> row = new ArrayList<String>();
            for (int i = 1; i <= columnCount; i++) {
                row.add(rs.getString(i));
            }
            results.add(row);
        }
        
        return results;
    } */
    


}
