/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.livraria;

/**
 *
 * @author Denilson
 */
public class Revista extends Material{
    private String mesPubli, issn;
    private int edicao;

    public Revista(String t, String aP, String a, String e, String mP, String i, int ed) {
        super(t, aP, a, e);
        this.mesPubli = mP;
        this.issn = i;
        this.edicao = ed;
    }
    
    public String getMesPubli(){
        return mesPubli;
    }
    public void setMesPubli(String mesPubli){
        this.mesPubli = mesPubli;
    }
    
    public String getIssn(){
        return issn;
    }
    public void setIssn(String issn){
        this.issn = issn;
    }
    
    public int getEdicao(){
        return edicao;
    }
    public void setEdicao(int edicao){
        this.edicao = edicao;
    }
    
    @Override
    public void exibirInfo(){
        System.out.println("-------------------------\n" + toString() + "\n-------------------------");
    }
    
    @Override
    public String toString(){
        return "Titulo: " + getTitulo() + "\nAno Publicação:" + getAnoPubli() + "\nAutor: " + getAutor() + "\nEditora: " + getEditora() + "\nMês de publicação: " + getMesPubli() + "\nIssn: " + getIssn() + "\nEdição: " + getEdicao();
    }
}
