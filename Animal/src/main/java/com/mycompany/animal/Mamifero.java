/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.animal;

/**
 *
 * @author Denilson
 */
public class Mamifero extends Animal{
    private String aliPref;

    public Mamifero(String n, String c, String nP, String cor, String a, String v, String ali) {
        super(n, c, nP, cor, a = "Terra", v);
        this.aliPref = ali;
    }
    
    public String getAliPref(){
        return aliPref;
    }
    public void setAliPref(String aliPref){
        this.aliPref = aliPref;
    }
    
}
