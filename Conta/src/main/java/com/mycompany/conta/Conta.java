/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.conta;

/**
 *
 * @author Denilson
 */
public class Conta {
    private int numero;
    private int agencia;
    private String nomeCliente;
    private int cpf;
    private double saldo;
    
    public int getNumero(){
        return numero;
    }
    public void setNumero(int numero){
        this.numero = numero;
    }
    public int getAgencia(){
        return agencia;
    }
    public void setAgencia(int agencia){
        this.agencia = agencia;
    }
    public String getNomeCliente(){
        return nomeCliente;
    }
    public void setNomeCliente(String nomeCliente){
        this.nomeCliente = nomeCliente;
    }
    public int getCpf(){
        return cpf;
    }
    public void setCpf(int cpf){
        this.cpf = cpf;
    }
    public double getSaldo(){
        return saldo;
    }
    public void setSaldo(double saldo){
        this.saldo = saldo;
    }
    
    public Conta(String nome, int cpf, int numero, int agencia, double saldo){
        this.nomeCliente = nome;
        this.cpf = cpf;
        this.numero = numero;
        this.agencia = agencia;
        this.saldo = saldo;
    }
}
