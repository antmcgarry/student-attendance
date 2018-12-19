/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student.attendance;

import java.util.ArrayList;
import model.Module;

/**
 *
 * @author Anthony Mcgarry
 */
public class ModuleList {
        private final ArrayList<Module> moduleList;
    /**
     * set a new Array list on instantiation
     */
    public ModuleList(){
        moduleList = new ArrayList<>();
    }
    /**
     * add
     * @param m add a module object to the current list
     */
    public void add(Module m){
        moduleList.add(m);
    }
    /**
     * get 
     * @param i get the module at the index location in the list
     * @return get the module requested
     */
    public Module get(int i){
        return moduleList.get(i);
    }
    /**
     * remove
     * @param m remove the module object from the list
     */
    public void remove(Module m){
        moduleList.remove(m);
    }
    /**
     * getModules
     * @return get all the modules in the list
     */
    public ArrayList<Module> getModules() {
        return moduleList;
    }
    /**
     * Size
     * @return get the size of the module list
     */
    public int Size(){
        return moduleList.size();
    }
    /**
     * Contains
     * @param m check if matching module is in the list
     * @return true or false depending on the check
     */
    public Boolean Contains(Module m){
        return moduleList.contains(m);
    }
}
