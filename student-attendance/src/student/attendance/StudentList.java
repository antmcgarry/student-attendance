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
    
    public StudentList(){
        studentList = new ArrayList<>();
    }
    
    public void add(Student s){
        studentList.add(s);
    }
    
    public Student get(int i){
        return studentList.get(i);
    }
    
    public void remove(Student s){
        studentList.remove(s);
    }
    
    public ArrayList<Student> getStudents() {
        return studentList;
    }
    
    public int Size(){
        return studentList.size();
    }
    
    public Boolean Contains(Student s){
        return studentList.contains(s);
    }
}
