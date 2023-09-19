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
        Banco banco;
        Cliente cliente;
        Conta conta;
        Poupanca poupanca;
        ArrayList<Conta> contas = new ArrayList<Conta>();
        double saldo, juros, deposito;
        String nomeAgencia, numAgencia, nomeCliente, cpf, num;
        
        while(true){
            System.out.println("1. Cadastrar conta \n2. Realizar depósito \n3. Render Juros \n4. Consultar agência \n5. Alterar número e nome da agência \n0. Sair");
            System.out.println("Informe a opção desejada: ");
            opcao = sc.nextInt();
            sc.nextLine();
            
            switch(opcao){
                default:
                    break;
                case 0:
                    return;
                case 1:
                    System.out.println("Deseja cadastrar que tipo de conta: 1-Conta 2-Poupança");
                    opcao = sc.nextInt();
                    sc.nextLine();
                    
                    switch(opcao){
                        default:
                            break;
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

                            banco = new Banco(numAgencia, nomeAgencia);
                            cliente = new Cliente(nomeCliente, cpf);
                            conta = new Conta(num, banco, cliente, saldo);
                            contas.add(conta);
                            break;
                        case 2:
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
                            System.out.println("Taxa de juros: ");
                            juros = sc.nextDouble();
                            sc.nextLine();
                            
                            banco = new Banco(numAgencia, nomeAgencia);
                            cliente = new Cliente(nomeCliente, cpf);
                            poupanca = new Poupanca(num, banco, cliente, saldo, juros);
                            contas.add(poupanca);
                            break;
                    }
                    break;
                case 2:
                    System.out.println("Informe o cpf: ex:(999999999)");
                    cpf = sc.nextLine();
                    for(Conta pessoa : contas){
                        if(cpf.equalsIgnoreCase(pessoa.getCliente().getCpf())){
                            System.out.println("Informe quanto deseja depósitar: R$ ");
                            saldo = sc.nextDouble();
                            pessoa.setSaldo(pessoa.getSaldo() + saldo); 
                            System.out.println("Depósito realizado com sucesso!");
                        }
                    }
                    break;
                case 3:
                    System.out.println("Informe o cpf:");
                    cpf = sc.nextLine();
                    for(Conta pessoa : contas){
                        if(cpf.equals(pessoa.getCliente().getCpf())){
                            if(pessoa instanceof Poupanca p){
                                p.renderJuros(p.getSaldo(), p.getJuros());
                            }
                        }
                    }
                    break;
                case 4:
                    System.out.println("Nome da agência: ");
                    nomeAgencia = sc.nextLine();
                    for(Conta pessoa : contas){
                        if(nomeAgencia.equals(pessoa.getBanco().getNomeAgencia())){
                            System.out.printf("Cliente: %s %nCpf: %s \n", pessoa.getCliente().getNomeCliente(),pessoa.getCliente().getCpf());
                        }
                    }
                    break;
                case 5:
                    System.out.println("Informe o nome do cliente:");
                    nomeCliente = sc.nextLine();
                    for(Conta pessoa : contas){
                        if(nomeCliente.equalsIgnoreCase(pessoa.getCliente().getNomeCliente())){
                            System.out.println("Informe a nova agência: ");
                            nomeAgencia = sc.nextLine();
                            
                            System.out.println("Informe o novo número da agência: ");
                            numAgencia = sc.nextLine();
                            
                            banco = new Banco(numAgencia, nomeAgencia);
                            pessoa.setBanco(banco);
                            
                            System.out.println("Alteração realizada com sucesso!");
                        }
                    }
                    break;
            }
        }
    }
}
