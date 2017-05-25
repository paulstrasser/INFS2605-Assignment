
package infs2605.assignment;

import java.util.Date;
import javafx.beans.property.StringProperty;
/**
 *
 * @author paulstrasser
 */
public class Seek {
public long seekID;
public long seekerID;
public StringProperty strtSuburb;
public int strtPostCode;
public int strtStreetNo;
public StringProperty strtStreetName;
public StringProperty endSuburb;
public int endPostCode;
public int endStreetNo;
public StringProperty endStreetName;
public Date date;
public double price;
public StringProperty pickUpTime;
public Date dateCreated;
public StringProperty status;
public int numSeatsRequired;

public Seek(long seekID, long seekerID, StringProperty strtSuburb, int strtPostCode, int strtStreetNo, StringProperty strtStreetName, StringProperty endSuburb, int endPostCode, int endStreetNo, StringProperty endStreetName, Date date, double price, StringProperty pickUpTime, Date dateCreated, StringProperty status, int numSeatsRequired) {
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
        this.dateCreated = dateCreated;
        this.status = status;
        this.numSeatsRequired = numSeatsRequired;
    }

    public long getSeekID() {
        return seekID;
    }

    public long getSeekerID() {
        return seekerID;
    }

    public StringProperty getStrtSuburb() {
        return strtSuburb;
    }

    public int getStrtPostCode() {
        return strtPostCode;
    }

    public int getStrtStreetNo() {
        return strtStreetNo;
    }

    public StringProperty getStrtStreetName() {
        return strtStreetName;
    }

    public StringProperty getEndSuburb() {
        return endSuburb;
    }

    public int getEndPostCode() {
        return endPostCode;
    }

    public int getEndStreetNo() {
        return endStreetNo;
    }

    public StringProperty getEndStreetName() {
        return endStreetName;
    }

    public Date getDate() {
        return date;
    }

    public double getPrice() {
        return price;
    }

    public StringProperty getPickUpTime() {
        return pickUpTime;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public StringProperty getStatus() {
        return status;
    }

    public int getnumSeatsRequired() {
        return numSeatsRequired;
    }

}