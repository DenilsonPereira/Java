/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quad;
import java.util.Scanner;
import java.util.ArrayList;
/**
 *
 * @author 20231ADSGR0057
 */
public class Teste {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int opcao;
        ArrayList <Quadilatero> lista = new ArrayList<Quadilatero>();
        float base, altura, lado, raio;
        
        while(true){
            System.out.println("1. Cadastrar Retângulo \n2. Cadastrar Círculo \n3. Cadastrar Quadrado \n4. Mostrar o valor de todas as áreas \n5. Mostrar os valores de todos os perímetros \n0. Sair \nInforme a opção desejada:");
            opcao = sc.nextInt();
            sc.nextLine();
            
            switch(opcao){
                default:
                    break;
                case 0:
                    System.exit(0);
                case 1:
                    System.out.println("-=-=-=-=-=-=-=-=-=-=-=-= RETÂNGULO -=-=-=-=-=-=-=-=-=-=-=-=");
                    System.out.println("Informe a base:");
                    base = sc.nextFloat();
                    sc.nextLine();
                    System.out.println("Informe a altura: ");
                    altura = sc.nextFloat();
                    sc.nextLine();
                    
                    Retangulo r = new Retangulo(base, altura);
                    lista.add(r);
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                    
            }
        }
    }
}
