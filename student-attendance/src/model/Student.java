/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Anthony Mcgarry
 */
public class Student extends Person {
    
    private final int studentNo;
    private char registered; // F = Full-Time || P = Part-Time
    private final String role = "Student";
           
    public Student(
        int studentNo,
        String fName, 
        String lName,
        int age, 
        String dob, 
        String add,
        String email,
        String password,
        char r  
    )
    {
      super(fName, lName, age, dob, add, email, password);
      this.studentNo = studentNo;
      this.registered = r;
    }
    
    public int getStudentNo(){
        return studentNo;
    }
    
    public String getRole(){
        return role;
    }
    
    public char getRegisteredType(){
        return registered;
    }
    
    public void setRegisteredType(char type){
        this.registered = type;
    }
       
}
