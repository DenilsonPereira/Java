/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author 20231ADSGR0057
 */
public class Menu {
    public static void main(String[] args){
        int opcao;
        Scanner sc = new Scanner(System.in);
        String autor;
        String editora;
        int isbn;
        String titulo;
        int anoEdicao;
        ArrayList<Livro> Estante;
        Estante = new ArrayList();
        
        while(true){
            System.out.println("Informe a opção desejada:");
            System.out.println("1. Cadastrar livro \n2. Buscar livro por titulo \n3. Listar livros por autor \n4. Listar todos os livros \n0. Sair");
            opcao = sc.nextInt();
            sc.nextLine();
            
            switch(opcao){
                default:
                    break;
                case 0:
                    return;
                case 1:
                    System.out.println("Informe o nome do autor: ");
                    autor = sc.nextLine();
                    
                    System.out.println("Informe a editora do livro: ");
                    editora = sc.nextLine();
                    
                    System.out.println("Informe o ISBN do livro: ");
                    isbn = sc.nextInt();
                    sc.nextLine();
                    
                    System.out.println("Informe o titulo do livro: ");
                    titulo = sc.nextLine();
                    
                    System.out.println("Informe o ano da edição do livro: ");
                    anoEdicao = sc.nextInt();
                    sc.nextLine();
                    
                    Livro book = new Livro(autor, editora, isbn, titulo, anoEdicao);
                    
                    Estante.add(book);
                    break;
                case 2:
                    System.out.println("Qual titulo deseja pesquisar? ");
                    String tPesquisa = sc.nextLine();
                    for(Livro c : Estante){
                        if(tPesquisa.equalsIgnoreCase(c.getTitulo())){
                            System.out.println("Autor: "+ c.getAutor() + ", Editora: "+ c.getEditora() + ", ISBN: "+ c.getIsbn() + ",Titulo: " + c.getTitulo() + ", Ano Edição: " + c.getAnoEdicao());
                        }
                    }
                    break;
                case 3:
                    System.out.println("Qual autor deseja pesquisar? ");
                    String aPesquisa = sc.nextLine();
                    for(Livro c : Estante){
                        if(aPesquisa.equalsIgnoreCase(c.getAutor())){
                            System.out.println("Autor: "+ c.getAutor() + ", Editora: "+ c.getEditora() + ", ISBN: "+ c.getIsbn() + ",Titulo: " + c.getTitulo() + ", Ano Edição: " + c.getAnoEdicao());
                        }
                    }
                    break;
                case 4:
                    for(Livro c : Estante){
                        System.out.println("Autor: "+ c.getAutor() + " , Editora: "+ c.getEditora() + " , ISBN: "+ c.getIsbn() + " ,Titulo: " + c.getTitulo() + ", Ano Edição: " + c.getAnoEdicao());
                    }
                    break;
            }
        }
    }
}
