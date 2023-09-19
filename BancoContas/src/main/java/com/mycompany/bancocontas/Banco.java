/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bancocontas;

/**
 *
 * @author Denilson
 */
public class Banco {
    private String numeroAgencia, nomeAgencia;
    
    public Banco(String numero, String nome){
        this.numeroAgencia = numero;
        this.nomeAgencia = nome;
    }
    
    public String getNumeroAgencia(){
        return numeroAgencia;
    }
    public void setNumeroAgencia(String numeroAgencia){
        this.numeroAgencia = numeroAgencia;
    }
    public String getNomeAgencia(){
        return nomeAgencia;
    }
    public void setNomeAgencia(String nomeAgencia){
        this.nomeAgencia = nomeAgencia;
    }
}
