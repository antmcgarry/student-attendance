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
    /**
     * TutorList
     * set a new Array list on instantiation
     */
    public TutorList(){
        tutorList = new ArrayList<>();
    }
    /**
     * add
     * @param t add a new tutor object to the list
     */
    public void add(Tutor t){
        tutorList.add(t);
    }
    /**
     * get
     * @param i access the index of the list by the value provided
     * @return the tutor object located at index required if available 
     */
    public Tutor get(int i){
        return tutorList.get(i);
    }
    /**
     * remove
     * @param t remove the tutor object from the list
     */
    public void remove(Tutor t){
        tutorList.remove(t);
    }
    /**
     * getTutors
     * @return the all the tutors in the list 
     */
    public ArrayList<Tutor> getTutors() {
        return tutorList;
    }
    /**
     * Size
     * @return the size of the list
     */
    public int Size(){
        return tutorList.size();
    }
}
