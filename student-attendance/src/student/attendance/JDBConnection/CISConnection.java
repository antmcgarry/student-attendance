/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package student.attendance.JDBConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import student.attendance.Student;
import student.attendance.studentList;

/**
 *
 * @author Andersma
 */
public class CISConnection extends DBConnection {


    /**
     * Creates a new instance of the connection class, and creates a
     * connection to the named database
     * @param dbName Service name of database
     */
    public CISConnection(final String dbName)
    {
        this.connectDatabase(dbName);
    }

    /**
     * Insert a new student record into the database
     * @param forename Student forename
     * @param surname Student surname
     * @param studentNo Student number
     * @param fullPartTime Full- or part-time indicator flag (F or T)
     */
    public void insertStudent(final String forename,
            final String surname, final String studentNo, final String fullPartTime)
    {
        final String insertStmt = "INSERT INTO student (forename, surname, studentNo, fullPartTime) VALUES (?,?,?,?)";
        try
        {
            PreparedStatement pstmt = getConnection().prepareStatement(insertStmt);
            pstmt.setString(1, forename);
            pstmt.setString(2, surname);
            pstmt.setString(3, studentNo);
            pstmt.setString(4, fullPartTime);
            pstmt.executeUpdate();
        }
        catch (SQLException sqle)
        {
            System.out.println("Exception when inserting student record: " + sqle.toString());
        }
    }

    /**
     * Find a student with a given surname
     * @param surname The surname of the student to find
     * @return ResultSet containing those students with the specified surname
     */
    public ResultSet findStudentBySurname(final String surname)
    {
        final String findStmt = "SELECT * FROM student WHERE surname = ?";
        ResultSet rs = null;
        try
        {
            PreparedStatement pstmt = getConnection().prepareStatement(findStmt);
            pstmt.setString(1, surname);
            rs = pstmt.executeQuery();

        }
        catch (SQLException sqle)
        {
            System.out.println("Exception when inserting student record: " + sqle.toString());
        }
        finally
        {
            return rs;
        }
    }

    /**
     * Print out all the records contained in the student table.   Prints
     * to System.out. 
     */
    public void printAllStudents(studentList list)
    {
        final String retrieveQuery = "SELECT * from student";
        this.setQuery(retrieveQuery);
        this.runQuery();
        ResultSet output = this.getResultSet();
        try
        {
        if (null != output)
        {
            while(output.next())
            {
                String fname = output.getString(2);
                String lname = output.getString(3);
                String studid = output.getString(4);
                String registered = output.getString(5);
                String email = output.getString(6);
                String password = output.getString(7);
                String dob = output.getString(8);
                int age = output.getInt(9);
                String address = output.getString(10);
                
                char r = registered.charAt(0);
                Student student = new Student(Integer.parseInt(studid),fname, lname, age, dob, address, email, password, r);
                list.add(student);
            }
        }
        }
        catch (SQLException sqle)
        {
            System.out.println("Exception when printing all students: " + sqle.toString());
        }

    }

    /**
     * Insert a new programme record into the database
     * @param code The programme code
     * @param name The programme name
     */
    public void insertProgramme(final String code,
            final String name)
    {
        final String insertStmt = "INSERT INTO programme (programmeCode, programmeName) VALUES (?,?)";
        try
        {
            PreparedStatement pstmt = getConnection().prepareStatement(insertStmt);
            pstmt.setString(1, code);
            pstmt.setString(2, name);
            pstmt.executeUpdate();
        }
        catch (SQLException sqle)
        {
            System.out.println("Exception when inserting programme record: " + sqle.toString());
        }
    }

    /**
     * Insert a new module into the database
     * @param title The module title
     * @param credit The number of credits for the module
     * @param code The module code
     * @param level The level of the module (4,5,6 or 7)
     * @param semester The semester that the module runs in
     */
    public void insertModule(final String title, final int credit,
            final String code, final String level, final String semester)
    {
        final String insertStmt = "INSERT INTO module (moduleTitle, credits, moduleCode, level, semester) VALUES (?,?,?,?,?)";
        try
        {
            PreparedStatement pstmt = getConnection().prepareStatement(insertStmt);
            pstmt.setString(1, title);
            pstmt.setInt(2, credit);
            pstmt.setString(3, code);
            pstmt.setString(4, level);
            pstmt.setString(5, semester);
            pstmt.executeUpdate();
        }
        catch (SQLException sqle)
        {
            System.out.println("Exception when inserting module record: " + sqle.toString());
        }
    }

    /**
     * Method to add a module to a programme
     * @param moduleId The module id of the new module
     * @param programmeId The programme id of the programme
     */
    public void addModuleToProgramme(final int moduleId, final int programmeId)
    {
        final String insertStmt = "INSERT INTO moduleprogramme (moduleId, programmeId) VALUES (?,?)";
        try
        {
            PreparedStatement pstmt = getConnection().prepareStatement(insertStmt);
            pstmt.setInt(1, moduleId);
            pstmt.setInt(2, programmeId);

            pstmt.executeUpdate();
        }
        catch (SQLException sqle)
        {
            System.out.println("Exception when adding module to programme: " + sqle.toString());
        }
    }
    
    public Boolean login(final String u, final String p){
        try {
            String queryString = "SELECT * FROM student WHERE email= ? and password= ?";
            PreparedStatement pstmt = getConnection().prepareStatement(queryString);
            pstmt.setString(1, u);
            pstmt.setString(2, p);
            ResultSet result = pstmt.executeQuery();
            if(result.next()) {
                String email = result.getString("email");
                String password =  result.getString("password");
            if ((u.equals(email)) && (p.equals(password))) {
                String role  = result.getString("status");
                //TODO need to add a check in for role to know which portal to render
                  System.out.println("Succesfully logged in ");
                  return true;
                }   
            }
            System.out.println("failed to log in");
            return false;
        } catch (SQLException sql) {
            System.out.print(sql);
            return false;
        }
    }
}

