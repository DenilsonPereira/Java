/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 20231ADSGR0057
 */
public class Livro {
    private String autor;
    private String editora;
    private int isbn;
    private String titulo;
    private int anoEdicao;
    
    public String getAutor(){
        return autor;
    }
    public void setAutor(String autor){
        this.autor = autor;
    }
    public String getEditora(){
        return editora;
    }
    public void setEditora(String editora){
        this.editora = editora;
    }
    public int getIsbn(){
        return isbn;
    }
    public void setIsbn(int isbn){
        this.isbn = isbn;
    }
    public String getTitulo(){
        return titulo;
    }
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }
    public int getAnoEdicao(){
        return anoEdicao;
    }
    public void setAnoEdicao(int anoEdicao){
        this.anoEdicao = anoEdicao;
    }
    
    public Livro(String autor, String editora, int isbn, String titulo, int ano){
        this.autor = autor;
        this.editora = editora;
        this.isbn = isbn;
        this.titulo = titulo;
        this.anoEdicao = ano;
                
    }
}
