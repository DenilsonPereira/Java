/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.contasbancaria;

/**
 *
 * @author Denilson
 */
public class ContaEspecial extends ContaBancaria{
    private Double limite;

    public ContaEspecial(String nCliente, String nConta, Double sal, Double saq, Double dep) {
        super(nCliente, nConta, sal, saq, dep);
    }
    
    public Double getLimite(){
        return limite;
    }
    public void setLimite(Double limite){
        this.limite = limite;
    }
    
    public void sacar(Double saque, Double sal){
        if (saque <= (2 * sal)) {
            limite = sal - saque;
            System.out.println("Saque de R$ " + saque + " efetuado!");
        } else {
            System.out.println("Não efetuado!");
        }
        // Atualize o saldo, se necessário
        setSaldo(limite);
    }
}
