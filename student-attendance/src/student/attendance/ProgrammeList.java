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
    
    public ProgrammeList(){
        programmeList = new ArrayList<>();
    }
    
    public void add(Programme p){
        programmeList.add(p);
    }
    
    public Programme get(int i){
        return programmeList.get(i);
    }
    
    public void remove(Programme p){
        programmeList.remove(p);
    }
    
    public ArrayList<Programme> getProgrammes() {
        return programmeList;
    }
    
    public int Size(){
        return programmeList.size();
    }
}
