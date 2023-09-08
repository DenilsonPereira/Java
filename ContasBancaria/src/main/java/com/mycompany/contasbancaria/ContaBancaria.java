/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.contasbancaria;

/**
 *
 * @author Denilson
 */
public class ContaBancaria {
    private String nomeCliente;
    private String numConta;
    private Double saldo;
    
    public ContaBancaria(String nCliente, String nConta, Double sal, Double saq, Double dep){
        this.nomeCliente = nCliente;
        this.numConta = nConta;
        this.saldo = sal;
        sacar(saq, sal);
        depositar(dep);
    }
    
    public String getNomeCliente(){
        return nomeCliente;
    }
    public void setNomeCliente(String nomeCliente){
        this.nomeCliente = nomeCliente;
    }
    
    public String getNumConta(){
        return numConta;
    }
    public void setNumConta(String numConta){
        this.numConta = numConta;
    }
    
    public Double getSaldo(){
        return saldo;
    }
    public void setSaldo(Double saldo){
        this.saldo = saldo;
    }
    
    public void sacar(Double saque, Double sal){
        sal = saldo;
        if(sal<saque){
            System.out.println("Saque não efetuado, valor superior o da conta.");
        }else{
            saldo = sal - saque;
        }
    }
    
    public void depositar(Double deposito){
        saldo+=deposito;
    }
}
