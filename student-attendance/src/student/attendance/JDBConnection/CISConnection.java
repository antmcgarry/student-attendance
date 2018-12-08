/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package student.attendance.JDBConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Module;
import model.Programme;
import model.Student;
import model.Tutor;
import student.attendance.ModuleList;
import student.attendance.ProgrammeList;
import student.attendance.StudentList;
import student.attendance.TutorList;

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
    public CISConnection(final String dbName){
        this.connectDatabase(dbName);
    }
    
    /**
     * Collects all the tutors from the data base and stores them in a list object
     * @param list 
     */
    public void getAllTutors(TutorList list){
        final String retrieveQuery = "SELECT * from tutor";
        this.setQuery(retrieveQuery);
        this.runQuery();
        ResultSet output = this.getResultSet();
        try
        {
        if (null != output)
        {
            while(output.next())
            {
                int id = output.getInt(1);
                String fname = output.getString(2);
                String lname = output.getString(3);
                String tutorNo = output.getString(4);
                String email = output.getString(5);
                String password = output.getString(6);
                String dob = output.getString(7);
                int age = output.getInt(8);
                String address = output.getString(9);
                Tutor tutor = new Tutor(id, fname, lname, tutorNo, age, dob, address, email, password);
                list.add(tutor);
            }
        }
        }
        catch (SQLException sqle)
        {
            System.out.println("Exception when printing all students: " + sqle.toString());
        }

    }
    
    /**
     * Insert a new tutor record into the database
     * @param tutor used to pass the Tutor object model
     */
    public void insertTutor(Tutor tutor){
        final String insertStmt = "INSERT INTO tutor (forename, surname, tutorNo, email, password, dob, age, address, status) VALUES (?,?,?,?,?,?,?,?,?)";
        try
        {
            PreparedStatement pstmt = getConnection().prepareStatement(insertStmt);
//            pstmt.setInt(1, 1);
            pstmt.setString(1, tutor.getFirstName());
            pstmt.setString(2, tutor.getLastName());
            pstmt.setString(3, tutor.getTutorNo());
            pstmt.setString(4, tutor.getEmail());
            pstmt.setString(5, tutor.getPassword());
            pstmt.setString(6, tutor.getDateofBirth());
            pstmt.setInt(7, tutor.getAge());
            pstmt.setString(8, tutor.getAddress());
            pstmt.setString(9, tutor.getRole());
            pstmt.executeUpdate();
        }
        catch (SQLException sqle)
        {
            System.out.println("Exception when inserting student record: " + sqle.toString());
        }
    }
    
    /**
     * Remove tutor record from the database
     * @param id to located the tutor in the database
     */
    public void removeTutor(int id){
        final String sql = "DELETE FROM tutor WHERE TUTORNO = ?";
        try
        {
            PreparedStatement pstmt = getConnection().prepareStatement(sql);
            // set the corresponding param
            pstmt.setInt(1, id);
            // execute the delete statement
            pstmt.executeUpdate();
        }
        catch (SQLException sqle)
        {
            System.out.println("Exception when deleting student record: " + sqle.toString());
        }

    }
    

    /**
     * Insert a new student record into the database
     * @param student
     */
    public void insertStudent(Student student){
        final String insertStmt = "INSERT INTO student (forename, surname, studentNo, fullPartTime, email, password, dob, age, address, status) VALUES (?,?,?,?,?,?,?,?,?,?)";
        try
        {
            PreparedStatement pstmt = getConnection().prepareStatement(insertStmt);
            pstmt.setString(1, student.getFirstName());
            pstmt.setString(2, student.getLastName());
            pstmt.setInt(3, student.getStudentNo());
            pstmt.setString(4, String.valueOf(student.getRegisteredType()));
            pstmt.setString(5, student.getEmail());
            pstmt.setString(6, student.getPassword());
            pstmt.setString(7, student.getDateofBirth());
            pstmt.setInt(8, student.getAge());
            pstmt.setString(9, student.getAddress());
            pstmt.setString(10, student.getRole());
            pstmt.executeUpdate();
        }
        catch (SQLException sqle)
        {
            System.out.println("Exception when inserting student record: " + sqle.toString());
        }
    }
    
    public void removeStudent(int id){
        final String sql = "DELETE FROM student WHERE studentNo = ?";
        try
        {
            PreparedStatement pstmt = getConnection().prepareStatement(sql);
            // set the corresponding param
            pstmt.setInt(1, id);
            // execute the delete statement
            pstmt.executeUpdate();
        }
        catch (SQLException sqle)
        {
            System.out.println("Exception when deleting student record: " + sqle.toString());
        }

    }

    /**
     * Find a student with a given surname
     * @param surname The surname of the student to find
     * @return ResultSet containing those students with the specified surname
     */
    public ResultSet findStudentBySurname(final String surname){
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
     * Changed printAllStudents to getAllStudents to retrieve students from db
     * and load the students into new student objects and add them to student
     * list
     */
    public void getAllStudents(StudentList list){
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
     * @param p The programme object
     */
    public void insertProgramme(Programme p){
        final String insertStmt = "INSERT INTO programme (programmeCode, programmeName, level) VALUES (?,?,?)";
        try
        {
            PreparedStatement pstmt = getConnection().prepareStatement(insertStmt);
            pstmt.setString(1, p.getProgramCode());
            pstmt.setString(2, p.getProgramTitle());
            pstmt.setInt(3, p.getProgramLevel());
            pstmt.executeUpdate();
        }
        catch (SQLException sqle)
        {
            System.out.println("Exception when inserting programme record: " + sqle.toString());
        }
    }
    
    /**
     * 
     * @param code used to find the programme in the DB
     * Then removes the programme once found
     */
    public void removeProgramme(String code){
        final String sql = "DELETE FROM programme WHERE programmecode = ?";
        try
        {
            PreparedStatement pstmt = getConnection().prepareStatement(sql);
            // set the corresponding param
            pstmt.setString(1, code);
            // execute the delete statement
            pstmt.executeUpdate();
        }
        catch (SQLException sqle)
        {
            System.out.println("Exception when deleting student record: " + sqle.toString());
        }
    }
    /**
     * Get a List of all the programme records from the database
     * @param list The programme list object which uses the programme object to
     * store all the information received from the DB
     */
    public void getProgrammeList(ProgrammeList list){
        final String retrieveQuery = "SELECT * from programme";
        this.setQuery(retrieveQuery);
        this.runQuery();
        ResultSet output = this.getResultSet();
        try
        {
        if (null != output)
        {
            while(output.next())
            {
                int id = output.getInt(1);
                String code = output.getString(2);
                String title = output.getString(3);
                int level = output.getInt(4);
                Programme p = new Programme(id, code, title, level);
                list.add(p);
            }
        }
        }
        catch (SQLException sqle)
        {
            System.out.println("Exception when printing all students: " + sqle.toString());
        }
    }
    
    public void getModuleList(ModuleList list){
        final String retrieveQuery = "SELECT * from module";
        this.setQuery(retrieveQuery);
        this.runQuery();
        ResultSet output = this.getResultSet();
        try
        {
        if (null != output)
        {
            while(output.next())
            {
                int id = output.getInt(1);
                String title = output.getString(2);
                int credit = output.getInt(3);
                String code = output.getString(4);
                int level = output.getInt(5);
                int semester = output.getInt(6);
                Module m = new Module(id, title, credit, code, level, semester);
                list.add(m);
            }
        }
        }
        catch (SQLException sqle)
        {
            System.out.println("Exception when printing all students: " + sqle.toString());
        }
    }
    /**
     * Insert a new module into the database
     * @param m The module object
     */
    public void insertModule(Module m)
    {
        final String insertStmt = "INSERT INTO module (moduleTitle, credits, moduleCode, level, semester) VALUES (?,?,?,?,?)";
        try
        {
            PreparedStatement pstmt = getConnection().prepareStatement(insertStmt);
            pstmt.setString(1, m.getModuleTitle());
            pstmt.setInt(2, m.getModuleCredit());
            pstmt.setString(3, m.getModuleCode());
            pstmt.setInt(4, m.getModuleLevel());
            pstmt.setInt(5, m.getModuleSemester());
            pstmt.executeUpdate();
        }
        catch (SQLException sqle)
        {
            System.out.println("Exception when inserting module record: " + sqle.toString());
        }
    }
    
    public void removeModule(String code){
        final String sql = "DELETE FROM module WHERE modulecode = ?";
        try
        {
            PreparedStatement pstmt = getConnection().prepareStatement(sql);
            // set the corresponding param
            pstmt.setString(1, code);
            // execute the delete statement
            pstmt.executeUpdate();
        }
        catch (SQLException sqle)
        {
            System.out.println("Exception when deleting student record: " + sqle.toString());
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
    
    public void getModluesToProgramme(ModuleList list, int id){
        final String retrieveQuery = "SELECT MODULE.ID, MODULE.MODULETITLE, MODULE.CREDITS, MODULECODE, LEVEL, SEMESTER FROM CIS4005.MODULE inner join CIS4005.MODULEPROGRAMME on MODULEPROGRAMME.PROGRAMMEID = ? AND MODULEPROGRAMME.MODULEID = MODULE.ID";
        ResultSet output;
        try
        {
            PreparedStatement pstmt = getConnection().prepareStatement(retrieveQuery);
            pstmt.setInt(1, id);
            output = pstmt.executeQuery();
        if (null != output)
        {
            while(output.next())
            {
                id = output.getInt(1);
                String title = output.getString(2);
                int credit = output.getInt(3);
                String code = output.getString(4);
                int level = output.getInt(5);
                int semester = output.getInt(6);
                Module m = new Module(id, title, credit, code, level, semester);
                list.add(m);
            }
        }
        }
        catch (SQLException sqle)
        {
            System.out.println("Exception when printing all students: " + sqle.toString());
        }
    }
    
        public Tutor getProgrammeLeader(int ProgrammeId){
        final String retrieveQuery = "SELECT TUTOR.ID, TUTOR.FORENAME, TUTOR.SURNAME, TUTOR.TUTORNO, TUTOR.EMAIL, TUTOR.PASSWORD, TUTOR.DOB, TUTOR.AGE, TUTOR.ADDRESS, TUTOR.STATUS FROM CIS4005.TUTOR inner join CIS4005.TUTORPROGRAMME on TUTORPROGRAMME.PROGRAMMEID = ? AND TUTORPROGRAMME.TUTORID = TUTOR.ID";
        ResultSet output;
        try
        {
            PreparedStatement pstmt = getConnection().prepareStatement(retrieveQuery);
            pstmt.setInt(1, ProgrammeId);
            output = pstmt.executeQuery();
        if (null != output)
        {
            while(output.next())
            {
                int id = output.getInt(1);
                String fName = output.getString(2);
                String lName = output.getString(3);
                String tutorNo = output.getString(4);
                String email = output.getString(5);
                String password = output.getString(6);
                String dob = output.getString(7);
                int age = output.getInt(8);
                String address = output.getString(9);
                Tutor t = new Tutor(id, fName, lName, tutorNo, age, dob, address, email, password);
                return t;
            }
        }
        }
        catch (SQLException sqle)
        {
            System.out.println("Exception when printing all programme leader: " + sqle.toString());
        }
        return null;
    }
    
    public void removeModuleFromProgramme(final int moduleId, final int programmeId){
        final String sql = "DELETE FROM moduleprogramme WHERE moduleid = ? and programmeId = ?";
        try
        {
            PreparedStatement pstmt = getConnection().prepareStatement(sql);
            // set the corresponding param
            pstmt.setInt(1, moduleId);
            pstmt.setInt(2, programmeId);
            // execute the delete statement
            pstmt.executeUpdate();
        }
        catch (SQLException sqle)
        {
            System.out.println("Exception when deleting student record: " + sqle.toString());
        }
    }
    
    public void assignProgrammeLeader(final int TutorId, final int programmeId)
    {
        final String insertStmt = "INSERT INTO TUTORPROGRAMME (tutorId, programmeId) VALUES (?,?)";
        try
        {
            PreparedStatement pstmt = getConnection().prepareStatement(insertStmt);
            pstmt.setInt(1, TutorId);
            pstmt.setInt(2, programmeId);

            pstmt.executeUpdate();
        }
        catch (SQLException sqle)
        {
            System.out.println("Exception when adding module to programme: " + sqle.toString());
        }
    }
    
    public Boolean login(final String u, final String p, final String role){
        String queryString = null;
        switch (role) {
            case "student":
                queryString = "SELECT * FROM student WHERE email= ? and password= ?";
                break;
            case "Administrator":
                queryString = "SELECT * FROM admin WHERE email= ? and password= ?";
                break;
            case "tutor":
                queryString = "SELECT * FROM tutor WHERE email= ? and password= ?";
                break;
            default:
                break;
        }
        try {
            PreparedStatement pstmt = getConnection().prepareStatement(queryString);
            pstmt.setString(1, u);
            pstmt.setString(2, p);
            ResultSet result = pstmt.executeQuery();
            if(result.next()) {
                String email = result.getString("email");
                String password =  result.getString("password");
                if ((u.equals(email)) && (p.equals(password))) {
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

