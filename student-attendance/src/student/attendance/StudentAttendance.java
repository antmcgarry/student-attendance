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
//        Tutor t = new Tutor("John", "Smith", "T0003", 40, "11/04/1978", "9 Dale Street", "john.smith@ormskirk.ac.uk", "password");
//        System.out.println(t.getTutorNo());
//        
//        cis.insertTutor(t);
//        System.out.println("Done!!");
//        
    }
    
}
