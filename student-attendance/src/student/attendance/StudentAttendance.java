/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student.attendance;
import model.Tutor;
import student.attendance.JDBConnection.CISConnection;

/**
 *
 * @author anthonymcgarry
 */
public class StudentAttendance {

    /**
     * @param args the command line argument
     */
    public static void main(String[] args) {
        
        CISConnection cis = new CISConnection("cis4005");
        // TODO code application logic here
        Tutor t = new Tutor(1,"Elaine", "Greene", "T0004", 22, "22/11/1996", "32 Regent Street", "elaine.greene@ormskirk.ac.uk", "password");
        System.out.println(t.getTutorNo());
        
        cis.insertTutor(t);
        System.out.println("Done!!");
        
    }
    
}
