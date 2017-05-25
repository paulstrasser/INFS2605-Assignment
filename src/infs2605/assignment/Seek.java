/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infs2605.assignment;

import java.util.Date;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
/**
 *
 * @author Hamish Cowan
 */
public class Seek {
public long SEEKID;
public long SEEKERID;
public StringProperty STRTSUBURB;
public int STRTPOSTCODE;
public int STRTSTREETNO;
public StringProperty STRTSTREETNAME;
public StringProperty ENDSUBURB;
public int ENDPOSTCODE;
public int ENDSTREETNO;
public StringProperty ENDSTREETNAME;
public Date DATE;
public double PRICE;
public StringProperty PICKUPTIME;
public Date DATECREATED;
public StringProperty STATUS;
public int NUMSEATSREQUIRED;

public Seek(long SEEKID, long SEEKERID, StringProperty STRTSUBURB, int STRTPOSTCODE, int STRTSTREETNO, StringProperty STRTSTREETNAME, StringProperty ENDSUBURB, int ENDPOSTCODE, int ENDSTREETNO, StringProperty ENDSTREETNAME, Date DATE, double PRICE, StringProperty PICKUPTIME, Date DATECREATED, StringProperty STATUS, int NUMSEATSREQUIRED) {
        this.SEEKID = SEEKID;
        this.SEEKERID = SEEKERID;
        this.STRTSUBURB = STRTSUBURB;
        this.STRTPOSTCODE = STRTPOSTCODE;
        this.STRTSTREETNO = STRTSTREETNO;
        this.STRTSTREETNAME = STRTSTREETNAME;
        this.ENDSUBURB = ENDSUBURB;
        this.ENDPOSTCODE = ENDPOSTCODE;
        this.ENDSTREETNO = ENDSTREETNO;
        this.ENDSTREETNAME = ENDSTREETNAME;
        this.DATE = DATE;
        this.PRICE = PRICE;
        this.PICKUPTIME = PICKUPTIME;
        this.DATECREATED = DATECREATED;
        this.STATUS = STATUS;
        this.NUMSEATSREQUIRED = NUMSEATSREQUIRED;
    }

    public long getSEEKID() {
        return SEEKID;
    }

    public long getSEEKERID() {
        return SEEKERID;
    }

    public StringProperty getSTRTSUBURB() {
        return STRTSUBURB;
    }

    public int getSTRTPOSTCODE() {
        return STRTPOSTCODE;
    }

    public int getSTRTSTREETNO() {
        return STRTSTREETNO;
    }

    public StringProperty getSTRTSTREETNAME() {
        return STRTSTREETNAME;
    }

    public StringProperty getENDSUBURB() {
        return ENDSUBURB;
    }

    public int getENDPOSTCODE() {
        return ENDPOSTCODE;
    }

    public int getENDSTREETNO() {
        return ENDSTREETNO;
    }

    public StringProperty getENDSTREETNAME() {
        return ENDSTREETNAME;
    }

    public Date getDATE() {
        return DATE;
    }

    public double getPRICE() {
        return PRICE;
    }

    public StringProperty getPICKUPTIME() {
        return PICKUPTIME;
    }

    public Date getDATECREATED() {
        return DATECREATED;
    }

    public StringProperty getSTATUS() {
        return STATUS;
    }

    public int getNUMSEATSREQUIRED() {
        return NUMSEATSREQUIRED;
    }

}



