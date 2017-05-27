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
public class Adjustment {
    public Long adjustmentID;
    public Long agreementID;   
    public Long seekID;
    public Long seekerID;
    public Long offerID;
    public Long offererID;
    public StringProperty strtSuburb;
    public Integer strtPostCode;
    public Integer strtStreetNo;
    public StringProperty strtStreetName;
    public StringProperty endSuburb;
    public Integer endPostCode;
    public Integer endStreetNo;
    public StringProperty endStreetName;
    public StringProperty date;
    public Double price;
    public StringProperty pickUpTime;
    public StringProperty dateCreated;
    public StringProperty status;
    public Long paymentID;
    public Integer numSeatsRequired;
    public Long adjustedBy;

    public Adjustment(Long adjustmentID, Long agreementID, Long seekID, Long seekerID, Long offerID, Long offererID, String strtSuburb, Integer strtPostCode, Integer strtStreetNo, String strtStreetName, String endSuburb, Integer endPostCode, Integer endStreetNo, String endStreetName, String date, Double price, String pickUpTime, String dateCreated, String status, Long paymentID, Integer numSeatsRequired, Long adjustedBy) {
        this.adjustmentID = adjustmentID;
        this.agreementID = agreementID;
        this.seekID = seekID;
        this.seekerID = seekerID;
        this.offerID = offerID;
        this.offererID = offererID;
        this.strtSuburb = new SimpleStringProperty(strtSuburb);
        this.strtPostCode = strtPostCode;
        this.strtStreetNo = strtStreetNo;
        this.strtStreetName = new SimpleStringProperty(strtStreetName);
        this.endSuburb = new SimpleStringProperty(endSuburb);
        this.endPostCode = endPostCode;
        this.endStreetNo = endStreetNo;
        this.endStreetName = new SimpleStringProperty(endStreetName);
        this.date = new SimpleStringProperty(date);
        this.price = price;
        this.pickUpTime = new SimpleStringProperty(pickUpTime);
        this.dateCreated = new SimpleStringProperty(dateCreated);
        this.status = new SimpleStringProperty(status);
        this.paymentID = paymentID;
        this.numSeatsRequired = numSeatsRequired;
        this.adjustedBy = adjustedBy;
    }
    
    
    public String getAdjustmentID() {
        return adjustmentID.toString();
    }
    
    public String getAgreementID() {
        return agreementID.toString();
    }
    
    public String getSeekID() {
        return seekID.toString();
    }
    
    public String getSeekerID() {
        return seekerID.toString();
    }
    
    public String getOfferID() {
        return offerID.toString();
    }
    
    public String getOffererID() {
        return offererID.toString();
    }
    
    public String getStrtSuburb() {
        return strtSuburb.get();
    }

    public String getStrtPostCode() {
        return strtPostCode.toString();
    }

    public String getStrtStreetNo() {
        return strtStreetNo.toString();
    }

    public String getStrtStreetName() {
        return strtStreetName.get();
    }

    public String getEndSuburb() {
        return endSuburb.get();
    }

    public String getEndPostCode() {
        return endPostCode.toString();
    }

    public String getEndStreetNo() {
        return endStreetNo.toString();
    }

    public String getEndStreetName() {
        return endStreetName.get();
    }

    public String getDate() {
        return date.get();
    }

    public String getPrice() {
        return price.toString();
    }

    public String getPickUpTime() {
        return pickUpTime.get();
    }

    public String getDateCreated() {
        return dateCreated.get();
    }

    public String getStatus() {
        return status.get();
    }
    
    public String getPaymentID() {
        return paymentID.toString();
    }

    public String getNumSeatsRequired() {
        return numSeatsRequired.toString();
    }
    
    public String getAdjustedBy() {
        return adjustedBy.toString();
    }

    //---------------------------------------------------------------------------
    
    public Long getAdjustmentIDProperty() {
        return adjustmentID;
    }
    
    public Long getAgreementIDProperty() {
        return agreementID;
    }
    
    public Long getSeekIDProperty() {
        return seekID;
    }
    
    public Long getSeekerIDProperty() {
        return seekerID;
    }
    
    public Long getOfferIDProperty() {
        return offerID;
    }
    
    public Long getOffererIDProperty() {
        return offererID;
    }
    
    public StringProperty getStrtSuburbProperty() {
        return strtSuburb;
    }
    
    public Integer getStrtPostCodeProperty() {
        return strtPostCode;
    }
    
    public Integer getStrtStreetNoProperty() {
        return strtStreetNo;
    }
    
    public StringProperty getStrtStreetNameProperty() {
        return strtStreetName;
    }
    
    public StringProperty getEndSuburbProperty() {
        return endSuburb;
    }
    
    public Integer getEndPostCodeProperty() {
        return endPostCode;
    }
    
    public Integer getEndStreetNoProperty() {
        return endStreetNo;
    }
    
    public StringProperty getEndStreetNameProperty() {
        return endStreetName;
    }
    
    public StringProperty getDateProperty() {
        return date;
    }
    
    public Double getPriceProperty() {
        return price;
    }
    
    public StringProperty getPickUpTimeProperty() {
        return pickUpTime;
    }

    public StringProperty getDateCreatedProperty() {
        return dateCreated;
    }
    
    public StringProperty getStatusProperty() {
        return status;
    }
    
    public Long getPaymentIDProperty() {
        return paymentID;
    }
    
    public Integer getNumSeatsRequiredProperty() {
        return numSeatsRequired;
    }
    
    public Long getAdjustedByProperty() {
        return adjustedBy;
    }
}