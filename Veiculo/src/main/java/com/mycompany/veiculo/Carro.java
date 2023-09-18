/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.veiculo;

/**
 *
 * @author Denilson
 */
public class Carro extends Veiculo{
    private String numPortas;
    
    public Carro(String m, String a, String n){
        super(m, a);
        this.numPortas = n;
        exibirInformacoes();
    }
    
    public String getNumPortas(){
        return numPortas;
    }
    public void setNumPortas(String numPortas){
        this.numPortas = numPortas;
    }
    
    @Override
    public void exibirInformacoes(){
        System.out.println("Marca: " + getMarca() + "\nAno: " + getAno() + "\nNúmero de portas: " + getNumPortas());
        
    }
}
