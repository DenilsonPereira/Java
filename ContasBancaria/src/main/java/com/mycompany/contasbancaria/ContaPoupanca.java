/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.contasbancaria;

/**
 *
 * @author Denilson
 */
public class ContaPoupanca extends ContaBancaria{
    private int diaRendimento;
    private Double novoSaldo;
    
    public ContaPoupanca(String nCliente, String nConta, Double sal, Double dep, Double nSal, Double saq, int dR){
        super(nCliente, nConta, sal, saq, dep);
        this.diaRendimento = dR;
        this.novoSaldo = nSal;
    }
    
    public int getDiaRendimento(){
        return diaRendimento;
    }
    public void setDiaRendimento(int diaRendimento){
        this.diaRendimento = diaRendimento;
    }
    
    public Double getNovoSaldo(){
        return novoSaldo;
    }
    public void setNovoSaldo(Double novoSaldo){
        this.novoSaldo = novoSaldo;
    }
}
