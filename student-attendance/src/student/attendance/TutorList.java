/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student.attendance;

import java.util.ArrayList;
import model.Tutor;

/**
 *
 * @author Anthony Mcgarry
 */
public class TutorList {
        private final ArrayList<Tutor> tutorList;
    
    public TutorList(){
        tutorList = new ArrayList<>();
    }
    
    public void add(Tutor t){
        tutorList.add(t);
    }
    
    public Tutor get(int i){
        return tutorList.get(i);
    }
    
    public void remove(Tutor t){
        tutorList.remove(t);
    }
    
    public ArrayList<Tutor> getTutors() {
        return tutorList;
    }
    
    public int Size(){
        return tutorList.size();
    }
}
