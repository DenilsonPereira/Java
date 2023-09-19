/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bancocontas;

/**
 *
 * @author Denilson
 */
public class Conta {
    private String numero;
    private Banco banco;
    private Cliente cliente;
    protected double saldo;
    
    public Conta(String n, Banco b, Cliente c, double s){
        this.numero = n;
        this.banco = b;
        this.cliente = c;
        this.saldo = s;
    }
    
    public String getNumero(){
        return numero;
    }
    public void setNumero(String numero){
        this.numero = numero;
    }
    public Banco getBanco(){
        return banco;
    }
    public void setBanco(Banco banco){
        this.banco = banco;
    }
    public Cliente getCliente(){
        return cliente;
    }
    public void setCliente(Cliente cliente){
        this.cliente = cliente;
    }
    public double getSaldo(){
        return saldo;
    }
    public void setSaldo(double saldo){
        this.saldo = saldo;
    }
}
