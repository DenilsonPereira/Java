/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Menu;

import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author Denilson
 */
public class Funcionarios {
    Scanner sc = new Scanner(System.in);
    String nome;
    double salario;
    ArrayList<Object> alta = new ArrayList<>();
    
    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public double getSalario(){
        return salario;
    }
    public void setSalario(double salario){
        this.salario = salario;
    }
    
    public ArrayList getAlta(){
        return alta;
    }
    public void setAlta(ArrayList alta){
        this.alta = alta;
    }
    
    public void cadastro(){
        int opcao;
        String nome;
        double salario;
        while (true){
            System.out.println("Informe o nome do funcionário: ");
            nome = sc.nextLine();
            
            System.out.println("Informe o salário do funcionário " + nome + ": ");
            salario = sc.nextDouble();
            sc.nextLine();
            
            if(salario>=5000){
                alta.add(nome);
            }
            
            System.out.println("Quer cadastrar outro funcionário?\n1 - Sim \n2 - Não");
            opcao = sc.nextInt();
            sc.nextLine();
            if(opcao == 2){
                break;
            }
        }
        
        sc.close();
    }
    
    public void exibir(){
        for(int i = 0; i<alta.size(); i++){
            String lista = (String) alta.get(i);
            System.out.println(lista);
        }
    }
}
