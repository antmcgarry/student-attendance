/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student.attendance;
import java.sql.*;
import static java.time.Clock.system;

/**
 *
 * @author anthonymcgarry
 */
public class StudentAttendance {

    /**
     * @param args the command line argument
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
           Class.forName("org.apache.derby.jdbc.EmbeddedDriver"); 
        }catch(ClassNotFoundException e){
            System.err.println(e);
        }
        
        try{
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/cis4005", "cis4005", "cis4005");
            Statement stmt = con.createStatement();
           
            ResultSet st = stmt.executeQuery("SELECT * from student");

        }catch(SQLException e){
            System.err.println(e);
        }
    }
    
}
