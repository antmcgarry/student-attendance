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
public class Programme {
    int id;
    String code;
    String title;
    int level;
    /**
     * Programme base object
     * @param id programme id related to the DB
     * @param code programme unique code
     * @param title programme title
     * @param level  programme level
     */
    public Programme(int id,String code,String title,int level){
        this.id = id;
        this.code = code;
        this.title = title;
        this.level = level;
    }
    
    /**
     * getProgramId
     * @return get the programme ID
     */
    public int getProgramId() { return id; }
    /**
     * getProgramCode
     * @return get the programme unique code
     */
    public String getProgramCode() { return code; }
    /**
     * setProgramCode
     * @param c update the program unique code
     */
    public void setProgramCode(String c) { this.code = c; }
    /**
     * getProgramTitle
     * @return get the programme title
     */
    public String getProgramTitle() { return title; }
    /**
     * setProgramTitle
     * @param t update the programme title
     */
    public void setProgramTitle(String t) { this.title = t; }
    /**
     * getProgramLevel
     * @return get the programme level
     */
    public int getProgramLevel() { return level; }
    /**
     * setProgramLevel
     * @param l updates the programme level
     */
    public void setProgramLevel(int l) { this.level = l; }
    
}
