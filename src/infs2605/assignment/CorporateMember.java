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


public class CorporateMember {
    public Integer corporateMemberId;
    public StringProperty companyName;
    public Integer cStreetNum;
    public StringProperty cStreetName;
    public StringProperty cSuburb;
    public StringProperty cCity;
    public Integer cPostCode;
    public Long companyPhoneNum;
    public Long ABN;


    public CorporateMember(int corporateMemberId, String companyName, int cStreetNum, String cStreetName, String cSuburb, String cCity, int cPostcode, long companyPhoneNum, long ABN){
        this.corporateMemberId = new Integer(corporateMemberId);
        this.companyName = new SimpleStringProperty(companyName);
        this.cStreetNum = new Integer(cStreetNum);
        this.cStreetName = new SimpleStringProperty(cStreetName);
        this.cSuburb = new SimpleStringProperty(cSuburb);
        this.cCity = new SimpleStringProperty(cCity);
        this.cPostCode = new Integer(cPostCode);
        this.companyPhoneNum = new Long(companyPhoneNum);
        this.ABN = new Long(ABN);   
    }
    /*public NormalMember() {
        this();  
    }*/
    
    public String getCorporateMemberId() {
        return corporateMemberId.toString();
    }
    
    public String getCompanyName() {
        return companyName.get();
    }
    
    public String getCStreetNum() {
        return cStreetNum.toString();
    }
    
    public String getCStreetName() {
        return cStreetName.get();
    }
    
    public String getCSuburb() {
        return cSuburb.get();
    }
    
    public String getCCity() {
        return cCity.get();
    }
    
    public String getCPostCode() {
        return cPostCode.toString();
    }
    
    public String getCompanyPhoneNum() {
        return companyPhoneNum.toString();
    }
    
    public String getABN() {
        return ABN.toString();
    }
    
    //---------------------------------------------------------------------------
    
    public Integer getCorporateMemberIdProperty() {
        return corporateMemberId;
    }
    
    public StringProperty getCompanyNameProperty() {
        return companyName;
    }
    
    public Integer getCStreetNumProperty() {
        return cStreetNum;
    }
    
    public StringProperty getCStreetNameProperty() {
        return cStreetName;
    }
    
    public StringProperty getCSuburbProperty() {
        return cSuburb;
    }
    
    public StringProperty getCCityProperty() {
        return cCity;
    }
    
    public Integer getCPostCodeProperty() {
        return cPostCode;
    }

    public Long getCompanyPhoneNumProperty() {
        return companyPhoneNum;
    }
    
    public Long getABNProperty() {
        return ABN;
    }
}