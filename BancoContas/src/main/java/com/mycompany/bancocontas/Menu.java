/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bancocontas;

import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author Denilson
 */
public class Menu {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int opcao;
        Banco bank, alteracao;
        Cliente cliente;
        ArrayList<Conta> contas = new ArrayList<Conta>();
        double saldo;
        String nomeAgencia, numAgencia, nomeCliente, cpf, num, buscarCpf;
        
        while(true){
            System.out.println("1. Cadastrar conta \n2. Realizar depósito \n3. Realizar Saque \n4. Verificar saldo \n5. Consultar número e nome da agência \n6. Alterar o número e nome da agência \n0. Sair");
            System.out.println("Informe a opção desejada: ");
            opcao = sc.nextInt();
            sc.nextLine();
            
            switch(opcao){
                default:
                    break;
                case 0:
                    return;
                case 1:
                    System.out.println("Informe o nome: ex:(José da Conceição)");
                    nomeCliente = sc.nextLine();
                    
                    System.out.println("Informe o cpf: ex:(999999999)");
                    cpf = sc.nextLine();
                    
                    System.out.println("Informe o nome da agência: ex:(Bradesco Centro)");
                    nomeAgencia = sc.nextLine();
                    
                    System.out.println("Informe o número da Agência: ex:(11)");
                    numAgencia = sc.nextLine();
                    
                    System.out.println("Informe o número da conta: ex:(1234)");
                    num = sc.nextLine();
                    
                    saldo = 0;
                    
                    bank = new Banco(numAgencia, nomeAgencia);
                    cliente = new Cliente(nomeCliente, cpf);
                    Conta conta = new Conta(num, bank, cliente, saldo);
                    contas.add(conta);
                    break;
                case 2:
                    System.out.println("Informe o cpf: ex:(999999999)");
                    buscarCpf = sc.nextLine();
                    for(Conta pessoa : contas){
                        if(buscarCpf.equals(pessoa.getCliente().getCpf())){
                            System.out.println("Informe quanto deseja depósitar: R$ ");
                            saldo = sc.nextDouble();
                            pessoa.setSaldo(pessoa.getSaldo() + saldo); 
                            System.out.println("Depósito realizado com sucesso!");
                        }
                    }
                    break;
                case 3:
                    System.out.println("Informe o cpf: ex:(999999999)");
                    buscarCpf = sc.nextLine();
                    for(Conta pessoa : contas){
                        if(buscarCpf.equals(pessoa.getCliente().getCpf())){
                            System.out.println("Informe quanto deseja sacar: R$ ");
                            saldo = sc.nextDouble();
                            if(pessoa.getSaldo()>=saldo){
                                pessoa.setSaldo(pessoa.getSaldo() - saldo); 
                                System.out.printf("%nSaque de R$ %.2f realizado com sucesso!%n", saldo);
                            }else{
                                System.out.println("Saldo insuficiente, não é possível realizar o saque!");
                            }
                        }
                    }
                    break;
                case 4:
                    System.out.println("Informe o cpf: ex:(999999999)");
                    buscarCpf = sc.nextLine();
                    for(Conta pessoa : contas){
                        if(buscarCpf.equals(pessoa.getCliente().getCpf())){
                            System.out.println("Saldo disponível: R$" + pessoa.getSaldo());
                        }
                    }
                    break;
                case 5:
                    System.out.println("Informe o cpf: ex:(999999999)");
                    buscarCpf = sc.nextLine();
                    for(Conta pessoa : contas){
                        if(buscarCpf.equals(pessoa.getCliente().getCpf())){
                            System.out.printf("Cliente: %s %nCpf: %s %nNúmero da agência: %s %nNome da agência: %s %n", pessoa.getCliente().getNomeCliente(),pessoa.getCliente().getCpf(), pessoa.getBanco().getNumeroAgencia(), pessoa.getBanco().getNomeAgencia() );
                        }
                    }
                    break;
                case 6:
                    System.out.println("Informe o nome do cliente: ex:(José Conceição)");
                    nomeCliente = sc.nextLine();
                    for(Conta pessoa : contas){
                        if(nomeCliente.equalsIgnoreCase(pessoa.getCliente().getNomeCliente())){
                            System.out.println("Informe a nova agência: ");
                            nomeAgencia = sc.nextLine();
                            
                            System.out.println("Informe o novo número da agência: ");
                            numAgencia = sc.nextLine();
                            
                            alteracao = new Banco(numAgencia, nomeAgencia);
                            pessoa.setBanco(alteracao);
                            
                            System.out.println("Alteração realizada com sucesso!");
                        }
                    }
                    break;
            }
        }
    }
}
