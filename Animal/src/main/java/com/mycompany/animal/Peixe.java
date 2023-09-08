/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.animal;

/**
 *
 * @author Denilson
 */
public class Peixe extends Animal{
    private String barbatanas, calda;
    
    public Peixe(String n, String c, String nP, String cor, String a, String v, String b, String cal) {
        super(n, c, nP, cor, a, v);
        this.barbatanas = b;
        this.calda = cal;
        
    }
    
    public String getBarbatanas(){
        return barbatanas;
    }
    public void setBarbatanas(String barbatanas){
        this.barbatanas = barbatanas;
    }
    
    public String getCalda(){
        return calda;
    }
    public void setCalda(String calda){
        this.calda = calda;
    }
}
