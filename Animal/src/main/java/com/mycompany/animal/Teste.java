/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.animal;
import java.util.Scanner;
import java.util.ArrayList;
/**
 *
 * @author Denilson
 */
public class Teste {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int opcao;
        ArrayList<Peixe> peixes = new ArrayList<Peixe>();
        ArrayList<Mamifero> mamiferos = new ArrayList<Mamifero>();
        String nome, comprimento, numPatas, cor, ambiente, velocidade, barbatanas, calda, aliPref;
        Peixe peixe;
        Mamifero mamifero;
        
        
        while(true){
            System.out.println("-------------------------------");
            System.out.println("1) Incluir dados relativos a um Peixe \n2) Incluir dados relativos a um Mamífero \n3) Listar todos os animais cadastrados \n4) Listar todos os peixes cadastrados \n0) Sair");
            System.out.println("Informe a opção desejada: ");
            
            opcao = sc.nextInt();
            sc.nextLine();
            
            System.out.println("-------------------------------");
            
            switch(opcao){
                default:
                    break;
                case 0:
                    System.exit(0);
                case 1:

                    System.out.println("Nome do peixe: ");
                    nome = sc.nextLine();
                    
                    System.out.println("Comprimento: ");
                    comprimento = sc.nextLine();
                    
                    numPatas = "0";
                    cor = "Cizenta";
                    ambiente = "Mar";
                    
                    System.out.println("Velocidade(m/s): ");
                    velocidade = sc.nextLine();
                    
                    System.out.println("Características das barbatanas: ");
                    barbatanas = sc.nextLine();
                    
                    System.out.println("Características da calda: ");
                    calda = sc.nextLine();
                    
                    peixe = new Peixe(nome, comprimento, numPatas, cor, ambiente, velocidade, barbatanas, calda);
                    peixes.add(peixe);
                    break;
                case 2:
                    System.out.println("Nome do mamífero: ");
                    nome = sc.nextLine();
                    
                    System.out.println("Comprimento: ");
                    comprimento = sc.nextLine();
                    
                    System.out.println("Número de patas: ");
                    numPatas = sc.nextLine();
                    
                    System.out.println("Cor: ");
                    cor = sc.nextLine();
                    
                    ambiente = "Terra";
                    
                    System.out.println("Velocidade(m/s): ");
                    velocidade = sc.nextLine();
                    
                    System.out.println("Alimento preferido: ");
                    aliPref = sc.nextLine();
                    
                    mamifero = new Mamifero(nome, comprimento, numPatas, cor, ambiente, velocidade, aliPref);
                    mamiferos.add(mamifero);
                    break;
                case 3:
                    for(Peixe p : peixes){
                        System.out.println("-------------------------------");
                        System.out.printf("Nome: %s %nComprimento: %s %nNúmero de patas: %s %nCor: %s %nAmbiente: %s %nVelocidade: %s %nCaracterísticas das barbatanas: %s %nCaracterísticas da calda: %s%n" ,p.getNome(), p.getComprimento(), p.getNumPatas(), p.getCor(), p.getAmbiente(), p.getVelocidade(), p.getBarbatanas(), p.getCalda());
                    }
                    for(Mamifero m : mamiferos){
                        System.out.println("-------------------------------");
                        System.out.printf("Nome: %s %nComprimento: %s %nNúmero de patas: %s %nCor: %s %nAmbiente: %s %nVelocidade: %s %nAlimento preferido: %s%n" ,m.getNome(), m.getComprimento(), m.getNumPatas(), m.getCor(), m.getAmbiente(), m.getVelocidade(), m.getAliPref());
                    }
                    break;
                case 4:
                    for(Peixe p : peixes){
                        System.out.println("-------------------------------");
                        System.out.printf("Nome: %s %nComprimento: %s %nNúmero de patas: %s %nCor: %s %nAmbiente: %s %nVelocidade: %s %nCaracterísticas das barbatanas: %s %nCaracterísticas da calda: %s%n" ,p.getNome(), p.getComprimento(), p.getNumPatas(), p.getCor(), p.getAmbiente(), p.getVelocidade(), p.getBarbatanas(), p.getCalda());
                    }
                    break;
            }
        }
    }
}
