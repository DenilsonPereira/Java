/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.instituto;

import java.util.ArrayList;

/**
 *
 * @author Denilson
 */
public class Turma {
    private String codigo;
    private String nomeTurma;
    private ArrayList<Estudantes> estudante;
    
    public String getCodigo(){
        return codigo;
    }
    public void setCodigo(String codigo){
        this.codigo = codigo;
    }
    public String getNomeTurma(){
        return nomeTurma;
    }
    public void setNomeTurma(String nomeTurma){
        this.nomeTurma = nomeTurma;
    }
    public ArrayList<Estudantes> getEstudante(){
        return estudante;
    }
    public void setEstudante(ArrayList<Estudantes> estudante){
        this.estudante = estudante;
    }
    
    public Turma(String c, String nT, ArrayList<Estudantes> e){
        this.codigo = c;
        this.nomeTurma = nT;
        this.estudante = e;
    }
}
