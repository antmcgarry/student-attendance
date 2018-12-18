/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 * extends the person class by using a super object
 * @author anthonymcgarry
 */
public class Student extends Person {
    
    private final int studentNo;
    private char registered; // F = Full-Time || P = Part-Time
    private final String role = "Student";
    private int studentId;
    /**
     * Student base Object
     * @param studentNo set the student unique student number
     * @param fName set the student first name
     * @param lName set the student last name
     * @param age set the student age
     * @param dob set the student date of birth
     * @param add set the student address
     * @param email set the student email address
     * @param password set the student password
     * @param r set the student register type (Full-Time/Part-Time)
     */       
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
    /**
     * setStudentId
     * @param id set the student with a unique ID
     */
    public void setStudentId(int id){
        this.studentId = id;
    }
    /**
     * getStudentId
     * @return get the student ID
     */
    public int getStudentId(){
        return studentId;
    }
    /**
     * getStudentNo
     * @return get the student unique student number
     */
    public int getStudentNo(){
        return studentNo;
    }
    /**
     * getRole
     * @return get the role of the student
     */
    public String getRole(){
        return role;
    }
    /**
     * getRegisteredType
     * @return get the register type of the student
     */
    public char getRegisteredType(){
        return registered;
    }
    /**
     * setRegisteredType
     * @param type updates the register type of the student
     */
    public void setRegisteredType(char type){
        this.registered = type;
    }
       
}
