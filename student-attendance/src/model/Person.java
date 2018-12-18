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
    /**
     * Person base Object
     * @param fName The person first name
     * @param lName The person last name
     * @param a The person age
     * @param dob The person date of birth
     * @param add The person address
     * @param e The person email address
     * @param p The person password
     */
    public Person(String fName, String lName, int a, String dob, String add, String e, String p){
        this.firstName = fName;
        this.lastName = lName;
        this.age = a;
        this.dateOfBirth = dob;
        this.address = add;
        this.email = e;
        this.password = p;
    }

    // The public getters and setters for the private instance fields.
    // Only used Setters for the age and address as these fields will be able to change.
    /**
     * getFirstName
     * @return the person first name
     */
    public String getFirstName(){
        return firstName;
    }
    /**
     * getLastName
     * @return the person last name
     */
    public String getLastName() {
        return lastName;
    }
    /**
     * getAge
     * @return the person age
     */
    public int getAge(){
        return age;
    }
    /**
     * setAge
     * @param a update the person age
     */
    public void setAge(int a) {
        this.age = a; 
    }
    /**
     * getDateofBirth
     * @return the person date of birth
     */
    public String getDateofBirth() {
        return dateOfBirth;
    }
    /**
     * getAddress
     * @return the person address
     */
    public String getAddress() {
        return address;
    }
    /**
     * SetAddress
     * @param add update the person address
     */
    public void SetAddress(String add) {
        this.address = add;
    }
    /**
     * getEmail
     * @return the person email address
     */
    public String getEmail(){
        return email;
    }
    /**
     * setEmail
     * @param email update the person email address
     */
    public void setEmail(String email){
        this.email = email;
    }
    /**
     * setPassword
     * @param p updates the person password
     */
    public void setPassword(String p){
        this.password = p;
    }
    /**
     * getPassword
     * @return the person password
     */
    public String getPassword(){
        return password;
    }
}
