/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infs2605.assignment;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author paulstrasser
 */


public class NormalMember {
    public Long USERID;
    public StringProperty FNAME;
    public StringProperty LNAME;
    public StringProperty USERTYPE;
    public StringProperty GENDER;
    public StringProperty DOB;
    public Long HPHONE;
    public Long WPHONE;
    public Long MPHONE;
    public StringProperty EMAIL;
    public Integer HNUM;
    public StringProperty HSTREET;
    public StringProperty HSUBURB;
    public StringProperty HCITY;
    public Integer HPOSTCODE;
    public Integer WNUM;
    public StringProperty WSTREET;
    public StringProperty WSUBURB;
    public StringProperty WCITY;
    public Integer WPOSTCODE;
    public StringProperty MAKE;
    public StringProperty MODEL;
    public StringProperty COLOUR;
    public StringProperty YEARMADE;
    public StringProperty REGISTRATION;
    public Integer NUMOFSEATS;
    public Long LICENSENUM;
    public StringProperty EXPDATE;
    //public StringProperty PROFILEPIC;
    public StringProperty USERNAME;
    public StringProperty PASSWORD;
    public StringProperty DESCRIPTION;
    public StringProperty NAMEONCARD;
    public Long CARDNUM;
    public StringProperty CARDEXPIRY;
    public Integer CVV;


    public NormalMember(long USERID, String FNAME, String LNAME, String USERTYPE, String GENDER, String DOB, long HPHONE
    , long WPHONE, long MPHONE, String EMAIL, int HNUM, String HSTREET, String HSUBURB, String HCITY, int HPOSTCODE, int WNUM
    , String WSTREET, String WSUBURB, String WCITY, int WPOSTCODE, String MAKE, String MODEL, String COLOUR, String YEARMADE, String REGISTRATION
    , int NUMOFSEATS, long LICENSENUM, String EXPDATE, /*Container PROFILEPIC, */String USERNAME, String PASSWORD, String DESCRIPTION, String NAMEONCARD, long CARDNUM
    , String CARDEXPIRY, int CVV){
        this.USERID = new Long(USERID);
        this.FNAME = new SimpleStringProperty(FNAME);
        this.LNAME = new SimpleStringProperty(LNAME);
        this.USERTYPE = new SimpleStringProperty(USERTYPE);
        this.GENDER = new SimpleStringProperty(GENDER);
        this.DOB = new SimpleStringProperty(DOB);
        this.HPHONE = new Long(HPHONE);
        this.WPHONE = new Long(WPHONE);
        this.MPHONE = new Long(MPHONE);
        this.EMAIL = new SimpleStringProperty(EMAIL);
        this.HNUM = new Integer(HNUM);
        this.HSTREET = new SimpleStringProperty(HSTREET);
        this.HSUBURB = new SimpleStringProperty(HSUBURB);
        this.HCITY = new SimpleStringProperty(HCITY);
        this.HPOSTCODE = new Integer(HPOSTCODE);
        this.WNUM = new Integer(WNUM);
        this.WSTREET = new SimpleStringProperty(WSTREET);
        this.WSUBURB = new SimpleStringProperty(WSUBURB);
        this.WCITY = new SimpleStringProperty(WCITY);
        this.WPOSTCODE = new Integer(WPOSTCODE);
        this.MAKE = new SimpleStringProperty(MAKE);
        this.MODEL = new SimpleStringProperty(MODEL);
        this.COLOUR = new SimpleStringProperty(COLOUR);
        this.YEARMADE = new SimpleStringProperty(YEARMADE);
        this.REGISTRATION = new SimpleStringProperty(REGISTRATION);
        this.NUMOFSEATS = new Integer(NUMOFSEATS);
        this.LICENSENUM = new Long(LICENSENUM);
        this.EXPDATE = new SimpleStringProperty(EXPDATE);
        //this.PROFILEPIC = new SimpleObjectProperty(PROFILEPIC);
        this.USERNAME = new SimpleStringProperty(USERNAME);
        this.PASSWORD = new SimpleStringProperty(PASSWORD);
        this.DESCRIPTION = new SimpleStringProperty(DESCRIPTION);
        this.NAMEONCARD = new SimpleStringProperty(NAMEONCARD);
        this.CARDNUM = new Long(CARDNUM);
        this.CARDEXPIRY = new SimpleStringProperty(CARDEXPIRY);
        this.CVV = new Integer(CVV);

    }
    /*public NormalMember() {
        this();  
    }*/
    
    public String getUSERID() {
        return USERID.toString();
    }
    
    public String getFNAME() {
        return FNAME.get();
    }
    
    public String getLNAME() {
        return LNAME.get();
    }
    
    public String getUSERTYPE() {
        return USERTYPE.get();
    }
    
    public String getGENDER() {
        return GENDER.get();
    }
    
    public String getDOB() {
        return DOB.get();
    }
    
    
    public String getHPHONE() {
        return HPHONE.toString();
    }
    
    public String getWPHONE() {
        return WPHONE.toString();
    }
    
    public String getMPHONE() {
        return MPHONE.toString();
    }
    
    public String getEMAIL() {
        return EMAIL.get();
    }
    
    public String getHNUM() {
        return HNUM.toString();
    }
    
    public String getHSTREET() {
        return HSTREET.get();
    }
    
    public String getHSUBURB() {
        return HSUBURB.get();
    }
    
    public String getHCITY() {
        return HCITY.get();
    }
    
    public String getHPOSTCODE() {
        return HPOSTCODE.toString();
    }
    
    public String getWNUM() {
        return WNUM.toString();
    }
    
    public String getWSTREET() {
        return WSTREET.get();
    }
    
    public String getWSUBURB() {
        return WSUBURB.get();
    }
    
    public String getWCITY() {
        return WCITY.get();
    }
    
    public String getWPOSTCODE() {
        return WPOSTCODE.toString();
    }
    
    public String getMAKE() {
        return MAKE.get();
    }
    
    public String getMODEL() {
        return MODEL.get();
    }
    
    public String getCOLOUR() {
        return COLOUR.get();
    }
    
    public String getYEARMADE() {
        return YEARMADE.get();
    }
    
    public String getREGISTRATION() {
        return REGISTRATION.get();
    }
    
    public String getNUMOFSEATS() {
        return NUMOFSEATS.toString();
    }
    
    public String getLICENSENUM() {
        return LICENSENUM.toString();
    }
    
    public String getEXPDATE() {
        return EXPDATE.get();
    }
    
    public String getUSERNAME() {
        return USERNAME.get();
    }
    
    public String getPASSWORD() {
        return PASSWORD.get();
    }
    
    public String getDESCRIPTION() {
        return DESCRIPTION.get();
    }
    
    public String getNAMEONCARD() {
        return NAMEONCARD.get();
    }
    
    public String getCARDNUM() {
        return CARDNUM.toString();
    }
    
    public String getCARDEXPIRY() {
        return CARDEXPIRY.get();
    }
    
    public String getCVV() {
        return CVV.toString();
    }
    
    
    
    public Long getUSERIDProperty() {
        return USERID;
    }
    
    public StringProperty getFNAMEProperty() {
        return FNAME;
    }
    
    public StringProperty getLNAMEProperty() {
        return LNAME;
    }
    
    public StringProperty getUSERTYPEProperty() {
        return USERTYPE;
    }
    
    public StringProperty getGENDERProperty() {
        return GENDER;
    }
    
    public StringProperty getDOBProperty() {
        return DOB;
    }
    
    public Long getHPHONEProperty() {
        return HPHONE;
    }
    
    public Long getWPHONEProperty() {
        return WPHONE;
    }
    
    public Long getMPHONEProperty() {
        return MPHONE;
    }
    
    public StringProperty getEMAILProperty() {
        return EMAIL;
    }
    
    public Integer getHNUMProperty() {
        return HNUM;
    }
    
    public StringProperty getHSTREETProperty() {
        return HSTREET;
    }
    
    public StringProperty getHSUBURBProperty() {
        return HSUBURB;
    }
    
    public StringProperty getHCITYProperty() {
        return HCITY;
    }
    
    public Integer getHPOSTCODEProperty() {
        return HPOSTCODE;
    }
    
    public Integer getWNUMProperty() {
        return WNUM;
    }
    
    public StringProperty getWSTREETProperty() {
        return WSTREET;
    }
    
    public StringProperty getWSUBURBProperty() {
        return WSUBURB;
    }
    
    public StringProperty getWCITYProperty() {
        return WCITY;
    }
    
    public Integer getWPOSTCODEProperty() {
        return WPOSTCODE;
    }
    
    public StringProperty getMAKEProperty() {
        return MAKE;
    }
    
    public StringProperty getMODELProperty() {
        return MODEL;
    }
    
    public StringProperty getCOLOURProperty() {
        return COLOUR;
    }
    
    public StringProperty getYEARMADEProperty() {
        return YEARMADE;
    }
    
    public StringProperty getREGISTRATIONProperty() {
        return REGISTRATION;
    }
    
    public Integer getNUMOFSEATSProperty() {
        return NUMOFSEATS;
    }
    
    public Long getLICENSENUMProperty() {
        return LICENSENUM;
    }
    
    public StringProperty getEXPDATEProperty() {
        return EXPDATE;
    }
    
    public StringProperty getUSERNAMEProperty() {
        return USERNAME;
    }
    
    public StringProperty getPASSWORDProperty() {
        return PASSWORD;
    }
    
    public StringProperty getDESCRIPTIONProperty() {
        return DESCRIPTION;
    }
    
    public StringProperty getNAMEONCARDProperty() {
        return NAMEONCARD;
    }  
    
    public Long getCARDNUMProperty() {
        return CARDNUM;
    }
    
    public StringProperty getCARDEXPIRYProperty() {
        return CARDEXPIRY;
    }
    
    public Integer getCVVProperty() {
        return CVV;
    }
}



