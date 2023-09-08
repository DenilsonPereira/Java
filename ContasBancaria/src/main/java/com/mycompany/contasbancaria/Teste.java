/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.contasbancaria;
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
        ArrayList<ContaBancaria> contas = new ArrayList<>();
        ContaBancaria contaNormal;
        ContaPoupanca poupanca;
        ContaEspecial corrente;
        String nCliente, nConta;
        Double saldo, saque, depo, nSaldo, limite;
        int diaR;
        while(true){
            
//            1) Incluir dados relativos a conta de um cliente (Limitado a 5 contas);
//            2) Sacar um determinado valor de uma conta (Procure pelo número da conta);
//            3) Depositar um determinado valor na sua conta (Procure pelo número da conta);
//            4) Mostrar o novo saldo do cliente, a partir da taxa de rendimento, daqueles que
//            possuem conta poupança;
//            5) Mostrar os dados de todas as contas cadastradas.

            System.out.println("-------------------------------------------");
            System.out.println("1) Incluir dados relativos a conta de um cliente (Limitado a 5 contas);\n" +
                               "2) Sacar um determinado valor de uma conta (Procure pelo número da conta);\n" +
                               "3) Depositar um determinado valor na sua conta (Procure pelo número da conta);\n" +
                               "4) Mostrar o novo saldo do cliente, a partir da taxa de rendimento, daqueles que possuem conta poupança;\n" +
                               "5) Mostrar os dados de todas as contas cadastradas;\n0) Sair");
            System.out.println("Informe a opção desejada: ");
            opcao = sc.nextInt();
            sc.nextLine();
            System.out.println("-------------------------------------------");
            switch(opcao){
                default:
                    break;
                case 0:
                    System.exit(0);
                case 1:
                    if(contas.size()<5){
                        System.out.println("1 - Conta Poupança \n2 - Conta Corrente \nDigite a opção de conta desejada: ");
                        System.out.println("-------------------------------------------");
                        opcao = sc.nextInt();
                        sc.nextLine();
                        switch(opcao){
                            case 1:
                                System.out.println("--------[POUPANÇA]--------");
                                System.out.println("Nome: ");
                                nCliente = sc.nextLine();
                                
                                System.out.println("Número da conta: ");
                                nConta = sc.nextLine();
                                
                                System.out.println("Deseja depósitar algum valor? \n1 - Sim \n2 - Não");
                                opcao = sc.nextInt();
                                sc.nextLine();
                                if(opcao==1){
                                    System.out.println("Qual o valor que deseja depósitar: R$ ");
                                    saldo = sc.nextDouble();
                                    sc.nextLine();
                                }else{
                                    saldo = 0.0;
                                }
                                
                                depo = 0.0;
                                nSaldo = 0.0;
                                saque = 0.0;
                                diaR = 20;
                                
                                poupanca = new ContaPoupanca(nCliente, nConta, saldo, depo, nSaldo, saque, diaR);
                                contas.add(poupanca);
                                break;
                            case 2:
                                System.out.println("--------[CORRENTE]--------");
                                System.out.println("Nome: ");
                                nCliente = sc.nextLine();
                                
                                System.out.println("Número da conta: ");
                                nConta = sc.nextLine();
                                
                                System.out.println("Deseja depósitar algum valor? \n1 - Sim \n2 - Não");
                                opcao = sc.nextInt();
                                sc.nextLine();
                                if(opcao==1){
                                    System.out.println("Qual o valor que deseja depósitar: R$ ");
                                    saldo = sc.nextDouble();
                                    sc.nextLine();
                                }else{
                                    saldo = 0.0;
                                }
                                
                                depo = 0.0;
                                saque = 0.0;
                                
                                corrente = new ContaEspecial(nCliente, nConta, saldo, saque, depo);
                                contas.add(corrente);
                                break;
                            default:
                                System.out.println("--------[OPÇÃO INVÁLIDA]--------");
                                break;
                        }
                    }
                    break;
                case 2:
                    System.out.println("Informe o número da conta: ");
                    nConta = sc.nextLine();
                    
                    for(ContaBancaria lista : contas){
                        if(nConta.equalsIgnoreCase(lista.getNumConta())){
                            System.out.println("Quanto deseja sacar: R$");
                            saque = sc.nextDouble();
                            sc.nextLine();
                            lista.sacar(saque, lista.getSaldo());
                        }
                    }
                    break;
                case 3:
                    System.out.println("Informe o número da conta: ");
                    nConta = sc.nextLine();
                    
                    for(ContaBancaria lista : contas){
                        if(nConta.equalsIgnoreCase(lista.getNumConta())){
                            System.out.println("Quanto deseja depositar: R$");
                            depo = sc.nextDouble();
                            sc.nextLine();
                            lista.depositar(depo);
                        }
                    }
                    break;
                case 4:
                    System.out.println("Informe o número da conta: ");
                    nConta = sc.nextLine();
                    
                    for(ContaBancaria lista : contas){
                        if(nConta.equalsIgnoreCase(lista.getNumConta())){
                            System.out.println("Quanto deseja depositar: R$");
                            depo = sc.nextDouble();
                            sc.nextLine();
                            lista.depositar(depo);
                        }
                    }
                    break;
                case 5:
                    for(ContaBancaria lista : contas){
                        System.out.println(lista.getNomeCliente() + " Saldo: " + lista.getSaldo());
                    }
                    System.out.println(contas.size());
                    break;
            }
        }
    }
}
