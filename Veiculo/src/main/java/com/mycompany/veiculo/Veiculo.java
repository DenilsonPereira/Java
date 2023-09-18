/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.veiculo;

/**
 *
 * @author Denilson
 */
public class Veiculo {
    private String marca, ano;
    
    public Veiculo(String marca, String ano){
        this.marca = marca;
        this.ano = ano;
        exibirInformacoes();
    }
    
    public String getMarca(){
        return marca;
    }
    public void setMarca(String marca){
        this.marca = marca;
    }
    
    public String getAno(){
        return ano;
    }
    public void setAno(String ano){
        this.ano = ano;
    }
    
    public void exibirInformacoes(){
        System.out.println("Marca: " + getMarca() + "\nAno: " + getAno());
    }
}
