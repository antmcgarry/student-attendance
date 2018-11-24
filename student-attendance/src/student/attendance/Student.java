/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student.attendance;

/**
 *
 * @author ADMIN
 */
public class Student extends Person {
    
    private final int id;
    private String registered; //Full-Time || Part-Time
    private final String role = "Student";
           
    public Student(
        String fName, 
        String lName,
        int age, 
        String dob, 
        String add,
        int id
    )
    {
      super(fName, lName, age, dob, add);
      this.id = id;
    }
    
    public int getId(){
        return id;
    }
    
    public String getRole(){
        return role;
    }
    
    public String getRegisteredType(){
        return registered;
    }
    
    public void setRegisteredType(String type){
        this.registered = type;
    }
    
    
}
