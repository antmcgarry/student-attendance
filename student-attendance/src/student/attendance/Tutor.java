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
public class Tutor extends Person {
    private final String role = "Tutor";
    private boolean moduleLeader;
    private boolean programLeader;
    
     public Tutor(
        String fName, 
        String lName,
        int age, 
        String dob, 
        String add,
        String email,
        Boolean m,
        Boolean p
    )
    {
      super(fName, lName, age, dob, add, email);
      this.moduleLeader = m;
      this.programLeader = p;
    }
     
     public void setModuleLeader(Boolean m){
         this.moduleLeader = m;
     }
     
     public Boolean getModuleLeader(){
         return moduleLeader;
     }
     
     public void setProgramLeader(Boolean p){
         this.programLeader = p;
     }
    
     public Boolean getProgramLeader(){
         return programLeader;
     }
    
     public String getRole(){
         return role;
     }
}
