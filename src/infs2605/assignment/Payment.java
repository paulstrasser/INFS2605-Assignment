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


public class Payment {
    public Long paymentID;
    public Long seekerID;
    public Long offererID;
    public StringProperty date;
    public StringProperty paymentMethod;
    public Double amount;

    public Payment(Long paymentID, Long seekerID, Long offererID, String date, String paymentMethod, Double amount) {
        this.paymentID = paymentID;
        this.seekerID = seekerID;
        this.offererID = offererID;
        this.date = new SimpleStringProperty(date);
        this.paymentMethod = new SimpleStringProperty(paymentMethod);
        this.amount = amount;
    }

    public String getPaymentID() {
        return paymentID.toString();
    }
    
    public String getSeekerID() {
        return seekerID.toString();
    }
    
    public String getOffererID() {
        return offererID.toString();
    }
    
    public String getDate() {
        return date.get();
    }
    
    public String getPaymentMethod() {
        return paymentMethod.get();
    }
    
    public String getAmount() {
        return amount.toString();
    }
   
    //---------------------------------------------------------------------------
    
    /*public Long getConsultIDProperty() {
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
    }*/
}
