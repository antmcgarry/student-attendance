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
public class Tutor extends Person {
    private final String role = "Tutor";
    private String tutorNo;
    private int id;
    private Module module;
    private Programme programme;
    
    
     public Tutor(
        int id,
        String fName, 
        String lName,
        String tutorNo,
        int age, 
        String dob, 
        String add,
        String email,
        String password
    )
    {
      super(fName, lName, age, dob, add, email, password);
      this.tutorNo = tutorNo;
      this.id = id;
    }

    public String getRole(){
        return role;
    }
    
    public String getTutorNo() {
        return tutorNo;
    }
    
    public int getTutorId(){
        return id;
    }
    
    public void setProgrammeLeader(Programme p){
        this.programme = p;
    }
    
    public Programme getProgrammeLeader(){
        return programme;
    }
    
    public void setModuleLeader(Module m){
        this.module = m;
    }
    
    public Module getModuleLeader() {
        return module;
    }
}
