/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infs2605.assignment;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author paulstrasser
 */


public class NormalMember {
    public StringProperty USERID;
    public StringProperty FNAME;
    public StringProperty LNAME;

    public NormalMember(String USERID, String FNAME, String LNAME) {
        this.USERID = new SimpleStringProperty(USERID);
        this.FNAME = new SimpleStringProperty(FNAME);
        this.LNAME = new SimpleStringProperty(LNAME);
    }
    
    public NormalMember() {
        this("-", "-", "-"); //This is just a test
    }
    
    public String getUSERID() {
        return USERID.get();
    }
    
    public void setUSERID(String userid) {
        this.USERID.set(userid);
    }

    public String getFNAME() {
        return FNAME.get();
    }
    
    public void setFNAME(String fname) {
        this.FNAME.set(fname);
    }

    public String getLNAME() {
        return LNAME.get();
    }
    
    public void setLNAME(String lname) {
        this.LNAME.set(lname);
    }
    
    public StringProperty getUSERIDProperty() {
        return USERID;
    }
    
    public StringProperty getFNAMEProperty() {
        return FNAME;
    }
    
    public StringProperty getLNAMEProperty() {
        return LNAME;
    }
    
    
    
    
    
    
}



