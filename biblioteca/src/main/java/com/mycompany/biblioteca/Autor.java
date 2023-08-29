/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.biblioteca;

/**
 *
 * @author 20231ADSGR0057
 */
public class Autor extends Info {
    private String cpf;
    
    public String getCpf(){
        return cpf;
    }
    public void setCpf(String cpf){
        this.cpf = cpf;
    }
    
    public Autor(String c, String n, String e){
        super(n,e);
        this.cpf = c;
    }
}
