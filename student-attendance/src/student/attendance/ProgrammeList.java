/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student.attendance;

import java.util.ArrayList;
import model.Programme;

/**
 *
 * @author anthonymcgarry
 */
public class ProgrammeList {
    private final ArrayList<Programme> programmeList;
    
    /**
     * set a new Array list on instantiation
     */
    public ProgrammeList(){
        programmeList = new ArrayList<>();
    }
    /**
     * add
     * @param p add a new programme object to the list
     */
    public void add(Programme p){
        programmeList.add(p);
    }
    /**
     * get
     * @param i get the programme at the index number
     * @return get the programme requested
     */
    public Programme get(int i){
        return programmeList.get(i);
    }
    /**
     * remove 
     * @param p remove the programme object from the list
     */
    public void remove(Programme p){
        programmeList.remove(p);
    }
    /**
     * getProgrammes
     * @return get all the programme objects in the list
     */
    public ArrayList<Programme> getProgrammes() {
        return programmeList;
    }
    /**
     * Size
     * @return get the size of the list
     */
    public int Size(){
        return programmeList.size();
    }
}
