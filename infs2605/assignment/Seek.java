/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infs2605.assignment;

import java.util.Date;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Administrator
 */
public class Seek {
    public long seekID;
    public long seekerID;
    public String strtSuburb;
    public int strtPostCode;
    public int strtStreetNo;
    public String strtStreetName;
    public String endSuburb;
    public int endPostCode;
    public int endStreetNo;
    public String endStreetName;
    public Date date;
    public double price;
    public String pickUpTime;
    public String DropOffTime;
    public Date dateCreated;
    public String status;
    public int numSeatsRequired;

    public Seek(long seekID, long seekerID, String strtSuburb, int strtPostCode, int strtStreetNo, String strtStreetName, String endSuburb, int endPostCode, int endStreetNo, String endStreetName, Date date, double price, String pickUpTime, String DropOffTime, Date dateCreated, String status, int numSeatsRequired) {
        this.seekID = seekID;
        this.seekerID = seekerID;
        this.strtSuburb = strtSuburb;
        this.strtPostCode = strtPostCode;
        this.strtStreetNo = strtStreetNo;
        this.strtStreetName = strtStreetName;
        this.endSuburb = endSuburb;
        this.endPostCode = endPostCode;
        this.endStreetNo = endStreetNo;
        this.endStreetName = endStreetName;
        this.date = date;
        this.price = price;
        this.pickUpTime = pickUpTime;
        this.DropOffTime = DropOffTime;
        this.dateCreated = dateCreated;
        this.status = status;
        this.numSeatsRequired = numSeatsRequired;
    }

    public long getSeekID() {
        return seekID;
    }

    public void setSeekID(long seekID) {
        this.seekID = seekID;
    }

    public long getSeekerID() {
        return seekerID;
    }

    public void setSeekerID(long seekerID) {
        this.seekerID = seekerID;
    }

    public String getStrtSuburb() {
        return strtSuburb;
    }

    public void setStrtSuburb(String strtSuburb) {
        this.strtSuburb = strtSuburb;
    }

    public int getStrtPostCode() {
        return strtPostCode;
    }

    public void setStrtPostCode(int strtPostCode) {
        this.strtPostCode = strtPostCode;
    }

    public int getStrtStreetNo() {
        return strtStreetNo;
    }

    public void setStrtStreetNo(int strtStreetNo) {
        this.strtStreetNo = strtStreetNo;
    }

    public String getStrtStreetName() {
        return strtStreetName;
    }

    public void setStrtStreetName(String strtStreetName) {
        this.strtStreetName = strtStreetName;
    }

    public String getEndSuburb() {
        return endSuburb;
    }

    public void setEndSuburb(String endSuburb) {
        this.endSuburb = endSuburb;
    }

    public int getEndPostCode() {
        return endPostCode;
    }

    public void setEndPostCode(int endPostCode) {
        this.endPostCode = endPostCode;
    }

    public int getEndStreetNo() {
        return endStreetNo;
    }

    public void setEndStreetNo(int endStreetNo) {
        this.endStreetNo = endStreetNo;
    }

    public String getEndStreetName() {
        return endStreetName;
    }

    public void setEndStreetName(String endStreetName) {
        this.endStreetName = endStreetName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPickUpTime() {
        return pickUpTime;
    }

    public void setPickUpTime(String pickUpTime) {
        this.pickUpTime = pickUpTime;
    }

    public String getDropOffTime() {
        return DropOffTime;
    }

    public void setDropOffTime(String DropOffTime) {
        this.DropOffTime = DropOffTime;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getNumSeatsRequired() {
        return numSeatsRequired;
    }

    public void setNumSeatsRequired(int numSeatsRequired) {
        this.numSeatsRequired = numSeatsRequired;
    }
 
    private ObservableList<Seek> personData = FXCollections.observableArrayList();
    
}
