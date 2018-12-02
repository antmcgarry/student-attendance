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
    
    public Programme(int id,String code,String title,int level){
        this.id = id;
        this.code = code;
        this.title = title;
        this.level = level;
    }
    
    public int getProgramId() { return id; }
    
    public String getProgramCode() { return code; }
    
    public void setProgramCode(String c) { this.code = c; }
    
    public String getProgramTitle() { return title; }
    
    public void setProgramTitle(String t) { this.title = t; }
    
    public int getProgramLevel() { return level; }
    
    public void setProgramLevel(int l) { this.level = l; }
    
}
