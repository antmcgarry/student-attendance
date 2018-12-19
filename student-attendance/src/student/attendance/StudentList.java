package student.attendance;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import model.Student;
import java.util.ArrayList;

/**
 *
 * @author Anthony Mcgarry
 */
public class StudentList {
    private final ArrayList<Student> studentList;
    /**
     * set a new Array list on instantiation
     */
    public StudentList(){
        studentList = new ArrayList<>();
    }
    /**
     * add
     * @param s add a new student object to the list
     */
    public void add(Student s){
        studentList.add(s);
    }
    /**
     * get
     * @param i get the student object at the index number provided
     * @return get the student object as requested if available
     */
    public Student get(int i){
        return studentList.get(i);
    }
    /**
     * remove
     * @param s remove the student object in the list
     */
    public void remove(Student s){
        studentList.remove(s);
    }
    /**
     * getStudents
     * @return get all the students in the list
     */
    public ArrayList<Student> getStudents() {
        return studentList;
    }
    /**
     * Size
     * @return get the size of the array list
     */
    public int Size(){
        return studentList.size();
    }
    /**
     * Contains
     * @param s take a student object as the parameter
     * @return returns true or false if a matching student is in the list
     */
    public Boolean Contains(Student s){
        return studentList.contains(s);
    }
}
