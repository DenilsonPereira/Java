/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.interface2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Denilson
 */
public class Menu {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ArrayList<ArrayLis> lista = new ArrayList<ArrayLis>();
        IAluno a = new ArrayLis();
        double[] array = new double[2];
        int opcao;
        double nota;
        
        while(true){
            System.out.println("1 - Adicionar nota \n2 - Remover nota \n3 - Calcular média \n4 - Maior nota \n0 - Sair \nInforme a opção desejada: ");
            opcao = sc.nextInt();
            sc.nextLine();
            
            switch(opcao){
                default:
                    break;
                case 0:
                    System.exit(0);
                case 1:
                    
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
            }
        }
    }
}
