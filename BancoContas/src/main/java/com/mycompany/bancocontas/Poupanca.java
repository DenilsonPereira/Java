/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bancocontas;

/**
 *
 * @author Denilson
 */
public class Poupanca extends Conta{
    private double juros;
    
    public Poupanca(String n, Banco b, Cliente c, double s, double j) {
        super(n, b, c, s);
        this.juros = j;
    }
    
    public double getJuros(){
        return juros;
    }
    public void setJuros(double juros){
        this.juros = juros;
    }
    
    public void renderJuros(double saldo, double juros){
        double novo = (saldo*juros)/100;
        this.saldo = saldo + novo;
    }
}
