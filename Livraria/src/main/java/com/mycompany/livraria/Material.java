/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.livraria;

/**
 *
 * @author Denilson
 */
public class Material {
    private String titulo, anoPubli, autor, editora, mesPubli, issn;
    
    public Material(String t, String aP, String a, String e){
        this.titulo = t;
        this.anoPubli = aP;
        this.autor = a;
        this.editora = e;
    }
    
    public String getTitulo(){
        return titulo;
    }
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }
    
    public String getAnoPubli(){
        return anoPubli;
    }
    public void setAnoPubli(String anoPubli){
        this.anoPubli = anoPubli;
    }
    
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
    
    public void exibirInfo(){
        toString();
    }
    
    /**
     *
     * @return
     */
    @Override
    public String toString(){
        return "Titulo: " + getTitulo() + "\nAno Publicação:" + getAnoPubli() + "\nAutor: " + getAutor() + "\nEditora: " + getEditora();
    }
}
