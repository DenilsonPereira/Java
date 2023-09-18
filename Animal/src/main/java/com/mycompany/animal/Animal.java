/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.animal;

/**
 *
 * @author Denilson
 */
public class Animal {
    private String nome, comprimento, cor, ambiente, velocidade, numPatas;

    public Animal(String n, String c, String nP, String cor, String a, String v){
        nP = "4";
        this.nome = n;
        this.comprimento = c;
        this.numPatas = nP;
        this.cor = cor;
        this.ambiente = a;
        this.velocidade = v;
    }

    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }

    public String getComprimento(){
        return comprimento;
    }
    public void setComprimento(String comprimento){
        this.comprimento = comprimento;
    }

    public String getNumPatas(){
        return numPatas;
    }
    public void setNumPatas(String numPatas){
        this.numPatas = numPatas;
    }

    public String getCor(){
        return cor;
    }
    public void setCor(String cor){
        this.cor = cor;
    }

    public String getAmbiente(){
        return ambiente;
    }
    public void setAmbiente(String ambiente){
        this.ambiente = ambiente;
    }

    public String getVelocidade(){
        return velocidade;
    }
    public void setVelocidade(String velocidade){
        this.velocidade = velocidade;
    }
}
