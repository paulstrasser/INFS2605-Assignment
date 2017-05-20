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
    public SimpleStringProperty USERID = new SimpleStringProperty();
    public StringProperty FNAME = new SimpleStringProperty();
    public StringProperty LNAME = new SimpleStringProperty();


    public String getUSERID() {
        return USERID.get();
    }

    public String getFNAME() {
        return FNAME.get();
    }

    public String getLNAME() {
        return LNAME.get();
    }    
    
}



