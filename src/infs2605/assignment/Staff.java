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


public class Staff {
    public Long staffId;
    public StringProperty username;
    public StringProperty password;
    public StringProperty fName;
    public StringProperty lName;
    public StringProperty DOB;
    public StringProperty email;
    /*ProfilePicture*/
    public StringProperty Role;



    public Staff(long staffId, String username, String password, String fName, String lName, String DOB, String email, String Role){
        this.staffId = new Long(staffId);
        this.username = new SimpleStringProperty(username);
        this.password = new SimpleStringProperty(password);
        this.fName = new SimpleStringProperty(fName);
        this.lName = new SimpleStringProperty(lName);
        this.DOB = new SimpleStringProperty(DOB);
        this.email = new SimpleStringProperty(email);
        this.Role = new SimpleStringProperty(Role);

    }
    
    public String getStaffId() {
        return staffId.toString();
    }
    
    public String getUsername() {
        return username.get();
    }
    
    public String getPassword() {
        return password.get();
    }
    
    public String getFName() {
        return fName.get();
    }
    
    public String getLName() {
        return lName.get();
    }
    
    public String getDOB() {
        return DOB.get();
    }
    
    public String getEmail() {
        return email.get();
    }
    
    public String getRole() {
        return Role.get();
    }
    
    
    //---------------------------------------------------------------------------
    
    public Long getStaffIdProperty() {
        return staffId;
    }
    
    public StringProperty getUsernameProperty() {
        return username;
    }
    
    public StringProperty getPasswordProperty() {
        return password;
    }
    
    public StringProperty getFNameProperty() {
        return fName;
    }
    
    public StringProperty getLNameProperty() {
        return lName;
    }
    
    public StringProperty getDOBProperty() {
        return DOB;
    }
    
    public StringProperty getEmailProperty() {
        return email;
    }
    
    public StringProperty getRoleProperty() {
        return Role;
    }
    
}
    
    