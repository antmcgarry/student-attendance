/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author Anthony Mcgarry
 * 
 */
public class Person {
    private final String firstName;
    private final String lastName;
    private int age;
    private final String dateOfBirth;
    private String address;
    private String email;
    private String password;
    
    public Person(String fName, String lName, int a, String dob, String add, String e, String p){
        this.firstName = fName;
        this.lastName = lName;
        this.age = a;
        this.dateOfBirth = dob;
        this.address = add;
        this.email = e;
        this.password = p;
    }

    Person() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    // The public getters and setters for the private instance fields.
    // Only used Setters for the age and address as these fields will be able to change.
    
    public String getFirstName(){
        return firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public int getAge(){
        return age;
    }
    
    public void setAge(int a) {
        this.age = a; 
    }
    
    public String getDateofBirth() {
        return dateOfBirth;
    }
    
    public String getAddress() {
        return address;
    }
    
    public void SetAddress(String add) {
        this.address = add;
    }
    
    public String getEmail(){
        return email;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    
    public void setPassword(String p){
        this.password = p;
    }
    
    public String getPassword(){
        return password;
    }
}