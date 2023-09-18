/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.livraria;

/**
 *
 * @author Denilson
 */
public class Livro extends Material{
    private String genero, isbn;
    private int numPaginas;
    
    public Livro(String t, String aP, String a, String e, String g, String i, int nP){
        super(t, aP, a, e);
        this.genero = g;
        this.isbn = i;
        this.numPaginas = nP;
    }
    
    public String getGenero(){
        return genero;
    }
    public void setGenero(String genero){
        this.genero = genero;
    }
    
    public String getIsbn(){
        return isbn;
    }
    public void setIsbn(String isbn){
        this.isbn = isbn;
    }
    
    public int getNumPaginas(){
        return numPaginas;
    }
    public void setNumPaginas(int numPaginas){
        this.numPaginas = numPaginas;
    }
    
    @Override
    public void exibirInfo(){
        System.out.println("-------------------------\n" + toString() + "\n-------------------------");
    }
    
    @Override
    public String toString(){
        return "Titulo: " + getTitulo() + "\nAno Publicação:" + getAnoPubli() + "\nAutor: " + getAutor() + "\nEditora: " + getEditora() + "\nGênero: " + getGenero() + "\nIsbn: " + getIsbn() + "\nNúmero de páginas: " + getNumPaginas();
    }
}
