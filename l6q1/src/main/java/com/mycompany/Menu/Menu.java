/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Menu;

import java.util.Scanner;

/**
 *
 * @author Denilson
 */
public class Menu {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int opcao = 0;
        Funcionarios funcionarios = new Funcionarios();
        
        while(true){
            System.out.println("Selecione a opção desejada: \n1 - Cadastrar um funcionário \n2 - Exibir os funcionários de alta renda \n0 - Sair");
            opcao = sc.nextInt();
            sc.nextLine();
            
            if(opcao == 1){
                funcionarios.cadastro();
            }else if(opcao == 2){
                funcionarios.exibir();
            }else{
                break;
            }
                    
        }
    }
}
