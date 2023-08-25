package com.mycompany.conta;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.Scanner;
import java.util.ArrayList;
/**
 *
 * @author Denilson
 */
public class Operacoes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcao;
        String nome;
        int cpf;
        int numero = 0;
        int local = 0;
        int centro = 320054;
        int bairro = 330098;
        int agencia;
        double saldo = 0;
        double saque;
        ArrayList<Conta> contas;
        contas = new ArrayList<>();
        
        while(true){
            System.out.println("1. Cadastrar Conta \n2. Realizar depósito \n3. Realizar saque \n4. Verificar saldo \n5. Consultar Cliente \n0. Sair");
            System.out.println("Informe a opção desejada: ");
            opcao = sc.nextInt();
            sc.nextLine();
            
            switch(opcao){
                default:
                    break;
                case 0:
                    return;
                case 1:
                    System.out.println("Informe o nome: ");
                    nome = sc.nextLine();
                    
                    System.out.println("Informe o cpf de " + nome + " :");
                    cpf = sc.nextInt();
                    sc.nextLine();
                    
                    numero+=1;
                    
                    System.out.println("Informe a agência da conta: (1. Centro) (2. Bairro)");
                    local = sc.nextInt();
                    sc.nextLine();
                    
                    if(local==1){
                        agencia = centro;
                    }else{
                        agencia = bairro;
                    }
                    saldo = 0;
                    
                    Conta pessoa = new Conta(nome, cpf, numero, agencia, saldo);
                    contas.add(pessoa);
                    System.out.println("Cliente cadastrado com sucesso!");
                    break;
                case 2:
                    System.out.println("Informe o nome da pessoa que deseja realizar o depósito: ");
                    nome = sc.nextLine();
                    for(Conta p : contas){
                        if(nome.equalsIgnoreCase(p.getNomeCliente())){
                            System.out.println("Informe o valor que deseja depósitar: \nR$ ");
                            saldo = sc.nextDouble();
                            sc.nextLine();
                            
                            p.setSaldo(p.getSaldo() + saldo);
                            System.out.println("Depósito realizado com sucesso!");
                        }
                    }
                    break;
                case 3:
                    System.out.println("Informe o nome da pessoa que deseja realizar o saque: ");
                    nome = sc.nextLine();
                    for(Conta p : contas){
                        if(nome.equalsIgnoreCase(p.getNomeCliente())){
                            System.out.println("Informe o valor que deseja sacar: \nR$ ");
                            saque = sc.nextDouble();
                            if(saque<=p.getSaldo()){
                                p.setSaldo(p.getSaldo() - saque);
                                System.out.println("Saque de R$ " + saque + " , realizado com Sucesso!");
                            }else{
                                System.out.println("Saldo insuficiente!");
                            }
                        }
                    }
                    break;
                case 4:
                    System.out.println("Informe o nome da pessoa que deseja verificar o saldo: ");
                    nome = sc.nextLine();
                    
                    for(Conta p : contas){
                        if(nome.equalsIgnoreCase(p.getNomeCliente())){
                            System.out.println("Saldo disponível: R$ " + p.getSaldo());
                        }
                    }
                    break;
                case 5:
                    System.out.println("Informe o cliente que deseja consultar:  ");
                    nome = sc.nextLine();
                    for(Conta p : contas){
                        if(nome.equalsIgnoreCase(p.getNomeCliente())){
                            System.out.println("Nome: " + p.getNomeCliente() + " CPF: " + p.getCpf());
                        }
                    }
                    break;
            }
            
        }
    }
}
