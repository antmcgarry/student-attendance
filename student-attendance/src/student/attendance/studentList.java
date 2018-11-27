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
        Student student1 = new Student(1, "John", "Smith", 25, "14/07/93", "3 road", "test@test.test", "123",'F');
        Student student2 = new Student(2, "James", "bob", 33, "22/01/82", "5 something road", "let@test.test", "123", 'F');
        studentList.add(student1);
        studentList.add(student2);
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
