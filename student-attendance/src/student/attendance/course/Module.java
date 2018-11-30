/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student.attendance.course;

/**
 *
 * @author anthonymcgarry
 */
public class Module {
    int id;
    String title;
    int credit;
    String code;
    int level;
    int semester;
    
    public Module(int id, String t, int c, String code, int l, int s){
        this.id = id;
        this.title = t;
        this.credit = c;
        this.code = code;
        this.level = l;
        this.semester = s;
    }
    
    public int getModuleId() { return id; }
    
    public void setModuleTitle(String t) { this.title = t; }
    
    public String getModuleTitle() { return title; }
    
    public void setModuleCredit(int c) { this.credit = c; }
    
    public int getModuleCredit() { return credit; }
    
    public void setModuleCode(String c) { this.code = c; }
    
    public String getModuleCode() { return code; }
    
    public void setModuleLevel(int l) { this.level = l; }
    
    public int getModuleLevel() { return level; }
    
    public void setModuleSemester(int s) { this.semester = s; }
    
    public int getModuleSemester() { return semester; } 
    
    
    
    
    
    
    
}
