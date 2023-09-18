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
        ArrayList<Animal> animais = new ArrayList<Animal>();
        String nome, comprimento, cor, ambiente, velocidade, barbatanas, calda, aliPref, numPatas;
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
                    
                    System.out.println("Números de patas: ");
                    numPatas = sc.nextLine();
                    
                    System.out.println("Cor: ");
                    cor = sc.nextLine();
                    
                    System.out.println("Ambiente: ");
                    ambiente = sc.nextLine();
                    
                    System.out.println("Velocidade(m/s): ");
                    velocidade = sc.nextLine();
                    
                    System.out.println("Características das barbatanas: ");
                    barbatanas = sc.nextLine();
                    
                    System.out.println("Características da calda: ");
                    calda = sc.nextLine();
                    
                    peixe = new Peixe(nome, comprimento, numPatas, cor, ambiente, velocidade, barbatanas, calda);
                    animais.add(peixe);
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
                    
                    System.out.println("Ambiente: ");
                    ambiente = sc.nextLine();
                    
                    System.out.println("Velocidade(m/s): ");
                    velocidade = sc.nextLine();
                    
                    System.out.println("Alimento preferido: ");
                    aliPref = sc.nextLine();
                    
                    mamifero = new Mamifero(nome, comprimento, numPatas, cor, ambiente, velocidade, aliPref);
                    animais.add(mamifero);
                    break;
                case 3:
                    for(Animal item : animais){
                        if(item instanceof Peixe p){
                            System.out.println("-------------------------------");
                            System.out.printf("Nome: %s %nComprimento: %s %nNúmero de patas: %s %nCor: %s %nAmbiente: %s %nVelocidade: %s %nCaracterísticas das barbatanas: %s %nCaracterísticas da calda: %s%n" ,p.getNome(), p.getComprimento(), p.getNumPatas(), p.getCor(), p.getAmbiente(), p.getVelocidade(), p.getBarbatanas(), p.getCalda());
                        }
                        
                        if(item instanceof Mamifero m){
                            System.out.println("-------------------------------");
                            System.out.printf("Nome: %s %nComprimento: %s %nNúmero de patas: %s %nCor: %s %nAmbiente: %s %nVelocidade: %s %nAlimento preferido: %s%n" ,m.getNome(), m.getComprimento(), m.getNumPatas(), m.getCor(), m.getAmbiente(), m.getVelocidade(), m.getAliPref());
                    }
                    }
                    break;
                case 4:
                    for(Animal item : animais){
                        if(item instanceof Peixe peixe1){
                            System.out.println("-------------------------------");
                            System.out.printf("Nome: %s %nComprimento: %s %nNúmero de patas: %s %nCor: %s %nAmbiente: %s %nVelocidade: %s %nCaracterísticas das barbatanas: %s %nCaracterísticas da calda: %s%n" ,item.getNome(), item.getComprimento(), item.getNumPatas(), item.getCor(), item.getAmbiente(), item.getVelocidade(), peixe1.getBarbatanas(), peixe1.getCalda());
                        }
                    }
                    break;
            }
        }
    }
}
