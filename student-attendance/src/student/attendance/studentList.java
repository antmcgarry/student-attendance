package student.attendance;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;

/**
 *
 * @author Anthony Mcgarry
 */
public class studentList {
    private final ArrayList<Student> studentList;
    
    public studentList(){
        studentList = new ArrayList<>();
    }
    
    public void add(Student s){
        studentList.add(s);
    }
    
    public void remove(Student s){
        studentList.remove(s);
    }
    
    public ArrayList<Student> getStudents() {
        return studentList;
    }
}
