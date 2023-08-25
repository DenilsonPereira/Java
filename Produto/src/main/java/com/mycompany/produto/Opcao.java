/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.produto;
import java.util.Scanner;
import java.util.ArrayList;
/**
 *
 * @author Denilson
 */
public class Opcao {
    public static void main(String[] args){
        int opcao;
        Scanner sc = new Scanner(System.in);
        String nome;
        int codigo;
        double preco;
        int quantidade;
        ArrayList<Produto> livros;
        livros = new ArrayList<>();
        
        while(true){
            System.out.println("Informe a opção desejada: ");
            System.out.println("1. Cadastrar produto \n2. Buscar produto (pelo nome) \n3. Listar todos os produtos \n4. Efetuar venda de produto \n0. Sair");
            opcao = sc.nextInt();
            sc.nextLine();
            switch(opcao){
                default:
                    break;
                case 0:
                    return;
                case 1:
                    System.out.println("Informe o nome do produto: ");
                    nome = sc.nextLine();
                    
                    System.out.println("Informe o código do produto: ");
                    codigo = sc.nextInt();
                    sc.nextLine();
                    
                    System.out.println("Informe o preço do produto: ");
                    preco = sc.nextDouble();
                    sc.nextLine();
                    
                    System.out.println("Informe a quantidade do produto: ");
                    quantidade = sc.nextInt();
                    sc.nextLine();
                    Produto livro = new Produto(nome, codigo, preco, quantidade);
                    livros.add(livro);
                    break;
                case 2:
                    System.out.println("Pesquisar produto: ");
                    String nProduto = sc.nextLine();
                    for(Produto prod : livros){
                        if(nProduto.equalsIgnoreCase(prod.getNome())){
                            System.out.println(prod.getNome() + " " + prod.getQuantidade());
                        }
                    }
                    break;
                case 3:
                    for(Produto prod : livros){
                        System.out.println(prod.getNome());
                    }
                    break;
                case 4:
                    System.out.println("Produto: ");
                    String venda = sc.nextLine();
                    double valor = 0;
                    int qItem = 1000;
                    int confirmar;
                    
                    for(Produto prod : livros){
                        if(venda.equalsIgnoreCase(prod.getNome())){
                            if(prod.getQuantidade() == 0){
                                System.out.println("Estoque esgotado!");
                            }else{
                                while(qItem>prod.getQuantidade()){
                                    System.out.println("Quantidade: ");
                                    qItem = sc.nextInt();
                                    sc.nextLine();
                                    if(qItem>prod.getQuantidade()){
                                        System.out.println("Quantidade indisponível \nDisponível: " + prod.getQuantidade());
                                    }
                                }
                                valor = prod.getPreco() * qItem;
                                System.out.println("Produto: " + prod.getNome() + "Quantidade: " + qItem + "Valor: R$ " + valor);
                                System.out.println(" 1. Confirmar \n2. Cancelar");
                                confirmar = sc.nextInt();
                                sc.nextLine();

                                if(confirmar == 1){
                                    prod.setQuantidade(prod.getQuantidade() - qItem);
                                    System.out.println("Produto: " + prod.getNome() + " Quantidade: " + qItem + " Valor: R$ " + valor);
                                    System.out.println("Venda realizada!");
                                }
                                else{
                                    System.out.println("Operação cancelada!");
                                }
                            }
                        }
                    }
                    break;

            }
        }
    }
}
