package student.attendance;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import student.attendance.Tutor;

/**
 *
 * @author Anthony Mcgarry
 */
public class tutorList {
    private ArrayList<Tutor> tutorList;
    
    public tutorList(){
        tutorList = new ArrayList<Tutor>();
        Tutor t1 = new Tutor("John", "Smith", 25, "14/07/93", "3 road", "test@test.test", false, true);
        Tutor t2 = new Tutor("James", "bob", 33, "22/01/82", "5 something road", "let@test.test", true, false);
        tutorList.add(t1);
        tutorList.add(t2);
    }
    
    public void add(Tutor t){
        tutorList.add(t);
    }
    
    public ArrayList<Tutor> getTutors() {
        return tutorList;
    }
}
