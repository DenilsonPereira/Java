/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.biblioteca;

/**
 *
 * @author 20231ADSGR0057
 */
public class Editora extends Info {
    private String cnpj;
    private String telefone;
    
    public String getCnpj(){
        return cnpj;
    }
    public void setCnpj(String cnpj){
        this.cnpj = cnpj;
    }
    public String getTelefone(){
        return telefone;
    }
    public void setTelefone(String telefone){
        this.telefone = telefone;
    }
    
    public Editora(String c, String n, String e, String t){
        super(n,e);
        this.cnpj = c;
        this.telefone = t;
    }
}
