package infs2605.assignment;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import infs2605.assignment.DBController;

/**
 *
 * @author paulstrasser
 */
public class SQL_Object {
    private List<ArrayList<String>> results = null;
    private List<String> columnHeadings = null;
    private String logMsg = null;
    
    //Constructor for resultset statments
    public SQL_Object(List<ArrayList<String>> rs) throws SQLException{
        //Populate the column headings
        columnHeadings = new ArrayList<String>();
        for (String colName : rs.get(0)) {
            columnHeadings.add(colName);
        }
        
        //Remove Column Headings from ArrayList
        rs.remove(0);
        
        //Assign remainder ArrayList of data to the results
        results = rs;

        //Fill Log message
        logMsg = "Returned " + results.size() + " rows";
            
    }
    
    public List<ArrayList<String>> getResults() {
        return results;
    }

    public List<String> getColumnHeads() {
        return columnHeadings;
    }

    public String getLogMsg() {
        return logMsg;
    }
    
    
}

