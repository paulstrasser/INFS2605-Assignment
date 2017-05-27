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


public class Consultation {
    public Long consultID;
    public Long StaffID;
    public Long CorporateMemberID;
    public Double price;
    public StringProperty openDate;
    public StringProperty closedDate;
    public StringProperty status;

    public Consultation(long consultID, long StaffID, long CorporateMemberID, double price, String openDate, String closedDate, String status){
        this.consultID = new Long(consultID);
        this.StaffID = new Long(StaffID);
        this.CorporateMemberID = new Long(CorporateMemberID);
        this.price = new Double(price);
        this.openDate = new SimpleStringProperty(openDate);
        this.closedDate = new SimpleStringProperty(closedDate);
        this.status = new SimpleStringProperty(status);       
    }
    
    public String getConsultID() {
        return consultID.toString();
    }
    
    public String getStaffID() {
        return StaffID.toString();
    }
    
    public String getCorporateMemberID() {
        return CorporateMemberID.toString();
    }
    
    public String getPrice() {
        return price.toString();
    }
    
    public String getOpenDate() {
        return openDate.get();
    }
    
    public String getClosedDate() {
        return closedDate.get();
    }
    
    public String getStatus() {
        return status.get();
    }

    //---------------------------------------------------------------------------
    
    public Long getConsultIDProperty() {
        return consultID;
    }
    
    public Long getStaffIDProperty() {
        return StaffID;
    }
    
    public Long getCorporateMemberIDProperty() {
        return CorporateMemberID;
    }
    
    public Double getPriceProperty() {
        return price;
    }
    
    public StringProperty getOpenDateProperty() {
        return openDate;
    }
    
    public StringProperty getClosedDateProperty() {
        return closedDate;
    }
    
    public StringProperty getStatusProperty() {
        return status;
    }
}