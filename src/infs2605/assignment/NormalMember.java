/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infs2605.assignment;

import java.awt.Container;
import java.util.Date;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.LongProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleObjectProperty;
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
    /*public IntegerProperty USERTYPE;
    public StringProperty GENDER;
    public ObjectProperty DOB;
    public LongProperty HPHONE;
    public LongProperty WPHONE;
    public LongProperty MPHONE;
    public StringProperty EMAIL;
    public IntegerProperty HNUM;
    public StringProperty HSTREET;
    public StringProperty HSUBURB;
    public StringProperty HCITY;
    public IntegerProperty HPOSTCODE;
    public IntegerProperty WNUM;
    public StringProperty WSTREET;
    public StringProperty WSUBURB;
    public StringProperty WCITY;
    public IntegerProperty WPOSTCODE;
    public StringProperty MAKE;
    public StringProperty MODEL;
    public StringProperty COLOUR;
    public StringProperty YEARMADE;
    public StringProperty REGISTRATION;
    public IntegerProperty NUMOFSEATS;
    public LongProperty LICENSENUM;
    public ObjectProperty EXPDATE;
    public ObjectProperty PROFILEPIC;
    public StringProperty USERNAME;
    public StringProperty PASSWORD;
    public StringProperty DESCRIPTION;
    public StringProperty NAMEONCARD;
    public LongProperty CARDNUM;
    public ObjectProperty CARDEXPIRY;
    public IntegerProperty CVV;*/


    public NormalMember(String USERID, String FNAME, String LNAME/*, int USERTYPE, String GENDER, Date DOB, long HPHONE
    , long WPHONE, long MPHONE, String EMAIL, int HNUM, String HSTREET, String HSUBURB, String HCITY, int HPOSTCODE, int WNUM
    , String WSTREET, String WSUBURB, String WCITY, int WPOSTCODE, String MAKE, String MODEL, String COLOUR, String YEARMADE, String REGISTRATION
    , int NUMOFSEATS, long LICENSENUM, Date EXPDATE, Container PROFILEPIC, String USERNAME, String PASSWORD, String DESCRIPTION, String NAMEONCARD, long CARDNUM
    , Date CARDEXPIRY, int CVV*/){
        this.USERID = new SimpleStringProperty(USERID);
        this.FNAME = new SimpleStringProperty(FNAME);
        this.LNAME = new SimpleStringProperty(LNAME);
        /*this.USERTYPE = new SimpleIntegerProperty(USERTYPE);
        this.GENDER = new SimpleStringProperty(GENDER);
        this.DOB = new SimpleObjectProperty(DOB);
        this.HPHONE = new SimpleLongProperty(HPHONE);
        this.WPHONE = new SimpleLongProperty(WPHONE);
        this.MPHONE = new SimpleLongProperty(MPHONE);
        this.EMAIL = new SimpleStringProperty(EMAIL);
        this.HNUM = new SimpleIntegerProperty(HNUM);
        this.HSTREET = new SimpleStringProperty(HSTREET);
        this.HSUBURB = new SimpleStringProperty(HSUBURB);
        this.HCITY = new SimpleStringProperty(HCITY);
        this.HPOSTCODE = new SimpleIntegerProperty(HPOSTCODE);
        this.WNUM = new SimpleIntegerProperty(WNUM);
        this.WSTREET = new SimpleStringProperty(WSTREET);
        this.WSUBURB = new SimpleStringProperty(WSUBURB);
        this.WCITY = new SimpleStringProperty(WCITY);
        this.WPOSTCODE = new SimpleIntegerProperty(WPOSTCODE);
        this.MAKE = new SimpleStringProperty(MAKE);
        this.MODEL = new SimpleStringProperty(MODEL);
        this.COLOUR = new SimpleStringProperty(COLOUR);
        this.YEARMADE = new SimpleStringProperty(YEARMADE);
        this.REGISTRATION = new SimpleStringProperty(REGISTRATION);
        this.NUMOFSEATS = new SimpleIntegerProperty(NUMOFSEATS);
        this.LICENSENUM = new SimpleLongProperty(LICENSENUM);
        this.EXPDATE = new SimpleObjectProperty(EXPDATE);
        this.PROFILEPIC = new SimpleObjectProperty(PROFILEPIC);
        this.USERNAME = new SimpleStringProperty(USERNAME);
        this.PASSWORD = new SimpleStringProperty(PASSWORD);
        this.DESCRIPTION = new SimpleStringProperty(DESCRIPTION);
        this.NAMEONCARD = new SimpleStringProperty(NAMEONCARD);
        this.CARDNUM = new SimpleLongProperty(CARDNUM);
        this.CARDEXPIRY = new SimpleObjectProperty(CARDEXPIRY);
        this.CVV = new SimpleIntegerProperty(CVV);*/

    }
    public NormalMember() {
        this("-","-","-");
    }
    
    public String getFNAME() {
        return FNAME.get();
    }
    
    public void setFNAME(String fname) {
        FNAME.set(fname);
    }
    
    public String getLNAME() {
        return LNAME.get();
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



