/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.biblioteca;
import java.util.Scanner;
import java.util.ArrayList;
/**
 *
 * @author 20231ADSGR0057
 */
public class Menu {
   public static void main(String[] args){
       int opcao;
       Scanner sc = new Scanner(System.in);
       ArrayList<Livro> livros =  new ArrayList<Livro>();
       Livro book;
       Editora editora;
       Autor autor;
       String nome1;
       String nome2;
       String cpf;
       String cnpj;
       String endereco1;
       String endereco2;
       String telefone;
       String titulo;
       int isbn;
       int ano;
       
       while(true){
           System.out.println("Informe a opção desejada: ");
           System.out.println("1. Cadastrar livro \n2. Buscar por livro \n3. Listar livro por autor \n4. Listar todos os livros \n0. Sair");
           opcao = sc.nextInt();
           sc.nextLine();
           
           switch(opcao){
               default:
                   break;
               case 0:
                   return;
               case 1:
                   System.out.println("Informe o CPF do autor: ");
                   cpf = sc.nextLine();
                   
                   System.out.println("Informe o nome do autor: ");
                   nome1 = sc.nextLine();
                   
                   System.out.println("Informe o endereço do autor:");
                   endereco1 = sc.nextLine();
                   
                   autor = new Autor(cpf, nome1, endereco1);
                   
                   System.out.println("Informe o CNPJ da editora:");
                   cnpj = sc.nextLine();
                   
                   System.out.println("Informe o nome da editora: ");
                   nome2 = sc.nextLine();
                   
                   System.out.println("Informe o endereço da editora:");
                   endereco2 = sc.nextLine();
                   
                   System.out.println("Informe o telefone da editora: ");
                   telefone = sc.nextLine();
                   
                   editora = new Editora(cnpj, nome2, endereco2, telefone);
                   
                   System.out.println("Informe o ISBN do livro: ");
                   isbn = sc.nextInt();
                   sc.nextLine();
                   
                   System.out.println("Informe o título do livro: ");
                   titulo = sc.nextLine();
                   
                   System.out.println("Informe o ano da edição: ");
                   ano = sc.nextInt();
                   sc.nextLine();
                   
                   book = new Livro(autor, editora, isbn, titulo, ano);
                   
                   livros.add(book);
                   break;
               case 2:
                   System.out.println("Informe o título do livro que deseja buscar: ");
                   String buscaTitulo = sc.nextLine();
                   for(Livro tit : livros){
                       if(buscaTitulo.equalsIgnoreCase(tit.getTitulo())){
                           System.out.println("Autor: "+ tit.getAutor().getNome() + " Livro: " + tit.getTitulo() + " Editora: " + tit.getEditora().getNome() + " Ano de Edição: " + tit.getAnoEdicao());
                       }
                   }
                   break;
               case 3:
                   System.out.println("Informe o autor que deseja buscar seus livros: ");
                   String nAutor = sc.nextLine();
                   for(Livro aut : livros){
                       if(nAutor.equalsIgnoreCase(aut.getAutor().getNome())){
                           System.out.println("Livro: " + aut.getTitulo() + " Autor: "+ aut.getAutor().getNome() + " Editora: " + aut.getEditora().getNome() + " Ano de Edição: " + aut.getAnoEdicao());
                       }
                   }
                   break;
               case 4:
                   for(Livro todos : livros){
                       System.out.println("Livro: " + todos.getTitulo() + " Autor: "+ todos.getAutor().getNome() + " Editora: " + todos.getEditora().getNome() + " Ano de Edição: " + todos.getAnoEdicao());
                   }
                   break;
           }
       }
   }
}
