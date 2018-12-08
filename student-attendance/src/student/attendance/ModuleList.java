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
    
    public ModuleList(){
        moduleList = new ArrayList<>();
    }
    
    public void add(Module m){
        moduleList.add(m);
    }
    
    public Module get(int i){
        return moduleList.get(i);
    }
    
    public void remove(Module m){
        moduleList.remove(m);
    }
    
    public ArrayList<Module> getModules() {
        return moduleList;
    }
    
    public int Size(){
        return moduleList.size();
    }
    
    public Boolean Contains(Module m){
        return moduleList.contains(m);
    }
}
