/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


/**
 * extends the person class by using a super object
 * @author Anthony Mcgarry
 */
public class Tutor extends Person {
    private final String role = "Tutor";
    private String tutorNo;
    private int id;
    private Module module;
    private Programme programme;
    
    /**
     * Tutor base model
     * @param id set the tutor ID 
     * @param fName set the tutor first name
     * @param lName set the tutor last name
     * @param tutorNo set the tutor unique tutor number
     * @param age set the tutor age
     * @param dob set the tutor date of birth
     * @param add set the tutor address
     * @param email set the tutor email address
     * @param password set the tutor password
     */
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
    /**
     * getRole
     * @return get the tutor role
     */
    public String getRole(){
        return role;
    }
    /**
     * getTutorNo
     * @return return the tutor number
     */
    public String getTutorNo() {
        return tutorNo;
    }
    /**
     * getTutorId
     * @return get the Tutor Id
     */
    public int getTutorId(){
        return id;
    }
    /**
     * setProgrammeLeader
     * @param p set the programme for the programme leader
     */
    public void setProgrammeLeader(Programme p){
        this.programme = p;
    }
    /**
     * getProgrammeLeader
     * @return get programme the tutor is the leader
     */
    public Programme getProgrammeLeader(){
        return programme;
    }
    /**
     * setModuleLeader
     * @param m set the module the tutor is the leader 
     */
    public void setModuleLeader(Module m){
        this.module = m;
    }
    /**
     * getModuleLeader
     * @return get the module the tutor is the leader for
     */
    public Module getModuleLeader() {
        return module;
    }
}
