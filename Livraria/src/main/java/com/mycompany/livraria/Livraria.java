/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.livraria;
import java.util.Scanner;
import java.util.ArrayList;
/**
 *
 * @author Denilson
 */
public class Livraria {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String titulo, anoPubli, autor, editora, mesPubli, issn, genero, isbn;
        int edicao, numPaginas, opcao;
        ArrayList<Livro> livros = new ArrayList<>();
        ArrayList<Revista> revistas = new ArrayList<>();
        Revista r;
        Livro l;
        
        while(true){
            System.out.println("1 - Cadastrar revista \n2 - Cadastrar livro \n3 - Exibir livros ou revistas cadastrados \n0 - Sair \nInforme a opção desejada: ");
            opcao = sc.nextInt();
            sc.nextLine();
            
            switch(opcao){
                default:
                    break;
                case 0:
                    System.exit(0);
                case 1:
                    System.out.println("Titulo: ");
                    titulo = sc.nextLine();

                    System.out.println("Ano publicação: ");
                    anoPubli = sc.nextLine();

                    System.out.println("Autor: ");
                    autor = sc.nextLine();

                    System.out.println("Editora: ");
                    editora = sc.nextLine();

                    System.out.println("Mês publicação: ");
                    mesPubli = sc.nextLine();

                    System.out.println("Issn: ");
                    issn = sc.nextLine();

                    System.out.println("Edição: ");
                    edicao = sc.nextInt();
                    sc.nextLine();

                    r = new Revista(titulo, anoPubli, autor, editora, mesPubli, issn, edicao);
                    
                    revistas.add(r);
                    break;
                case 2:
                    
                    System.out.println("Titulo: ");
                    titulo = sc.nextLine();

                    System.out.println("Ano publicação: ");
                    anoPubli = sc.nextLine();

                    System.out.println("Autor: ");
                    autor = sc.nextLine();

                    System.out.println("Editora: ");
                    editora = sc.nextLine();

                    System.out.println("Gênero: ");
                    genero = sc.nextLine();

                    System.out.println("Isbn: ");
                    isbn = sc.nextLine();

                    System.out.println("Número de páginas: ");
                    numPaginas = sc.nextInt();
                    sc.nextLine();

                    l = new Livro(titulo, anoPubli, autor, editora, genero, isbn, numPaginas);
                    livros.add(l);
                    
                    break;
                case 3:
                    System.out.println("Informe a opção desejada: 1 - Livro 2 - Revistas");
                    opcao = sc.nextInt();
                    sc.nextLine();
                    
                    switch(opcao){
                        default:
                            System.out.println("Opção inválida!");
                            break;
                        case 1:
                            for(Livro livro : livros){
                                livro.exibirInfo();
                            }
                            break;
                        case 2:
                            for(Revista revista : revistas){
                                revista.exibirInfo();
                            }
                            break;
                    }
                    break;
            }
        }
    }
}
