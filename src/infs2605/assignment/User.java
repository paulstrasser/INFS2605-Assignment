/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment_folder;

/**
 *
 * @author paulstrasser
 */
public class User {
    
    public int id;
    public String fName;
    public String lName;
    public int userType;
    public String gender;
    public int age;
    public long homeNum;
    public long hpNum;
    public String email;
    //Home Address
    public int houseNumber;
    public String appartmentNumber;
    public String hStreetName;
    public String hSuburb;
    public String hCity;
    public String hCountry;
    public long hPostCode;
    //Company Address
    public int streetNumber;
    public String cStreetName;
    public String cSuburb;
    public String cCity;
    public String cCountry;
    public long cPostCode;
    //Car details (if any)
    public String make;
    public String model;
    public String year;
    public String numOfSeats;
    
    public User() {
        
    }
}
