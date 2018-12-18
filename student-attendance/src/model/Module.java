/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

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
    
    /**
     * Module object base when creating a new module
     * @param id The ID which is stored in the DB
     * @param t The Module title
     * @param c The amount of credits
     * @param code The module code 
     * @param l The module level
     * @param s The module semester
     */
    public Module(int id, String t, int c, String code, int l, int s){
        this.id = id;
        this.title = t;
        this.credit = c;
        this.code = code;
        this.level = l;
        this.semester = s;
    } 
    /**
     * getModuleId
     * @return the module ID
     */
    public int getModuleId() { return id; }
    /**
     * setModuleTitle
     * @param t changes the current module title to a new title
     */
    public void setModuleTitle(String t) { this.title = t; }
    /**
     * getModuleTitle
     * @return the title of the module
     */
    public String getModuleTitle() { return title; }
    /**
     * setModuleCredit
     * @param c changes the current value of the module credits
     */
    public void setModuleCredit(int c) { this.credit = c; }
    /**
     * getModuleCredit
     * @return the module credits
     */
    public int getModuleCredit() { return credit; }
    /**
     * setModuleCode
     * @param c updates the current module code with a new module code
     */
    public void setModuleCode(String c) { this.code = c; }
    /**
     * getModuleCode
     * @return the module code
     */
    public String getModuleCode() { return code; }
    /**
     * setModuleLevel
     * @param l set the module with a new level
     */
    public void setModuleLevel(int l) { this.level = l; }
    /**
     * getModuleLevel
     * @return get the module level
     */
    public int getModuleLevel() { return level; }
    /**
     * setModuleSemester
     * @param s set the module with a new semester
     */
    public void setModuleSemester(int s) { this.semester = s; }
    /**
     * getModuleSemester
     * @return returns the module semester
     */
    public int getModuleSemester() { return semester; } 

}
