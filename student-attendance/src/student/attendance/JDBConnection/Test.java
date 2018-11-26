/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package student.attendance.JDBConnection;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Andersma
 */
public class Test {
    public static void main(String args[])
    {
        CISConnection cis = new CISConnection("cis4005");
        //cis.insertStudent("Mark", "Anderson", "0003", "F");
        cis.printAllStudents();

        ResultSet studentRS = cis.findStudentBySurname("Evans");
        try
        {
            while ((null != studentRS) && (studentRS.next()))
            {
                String id = studentRS.getString(1);
                String fname = studentRS.getString(2);
                String sname = studentRS.getString(3);
                String sid = studentRS.getString(4);
                System.out.println(id + ":" + fname + " " + sname + " " + sid);
            }
        }
        catch (SQLException sqle)
        {
            System.out.println("Error finding student: " + sqle.toString());
        }

        //cis.insertProgramme("G500", "Computer Science");
        //cis.insertModule("OO Programming", 20, "CIS2023", "5", "1");
        cis.addModuleToProgramme(2, 1);

        cis.closeConnection();
    }
}
