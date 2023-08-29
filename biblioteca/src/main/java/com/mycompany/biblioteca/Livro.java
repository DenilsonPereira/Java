/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.biblioteca;

/**
 *
 * @author 20231ADSGR0057
 */
public class Livro {
    private Autor autor;
    private Editora editora;
    private int isbn;
    private String titulo;
    private int anoEdicao;
    
    public Autor getAutor(){
        return autor;
    }
    public void setAutor(Autor autor){
        this.autor = autor;
    }
    public Editora getEditora(){
        return editora;
    }
    public void setEditora(Editora editora){
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
    
    public Livro(Autor a, Editora e, int i, String t, int ano){
        this.autor = a;
        this.editora = e;
        this.isbn = i;
        this.titulo = t;
        this.anoEdicao = ano;
    }
}
