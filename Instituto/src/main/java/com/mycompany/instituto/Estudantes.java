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
public class Estudantes {
    private String matricula;
    private String nomeEstudante;
    private ArrayList<Double> notas = new ArrayList<>();
    
    public String getMatricula(){
        return matricula;
    }
    public void setMatricula(String matricula){
        this.matricula = matricula;
    }
    public String getNomeEstudante(){
        return nomeEstudante;
    }
    public void setNomeEstudante(String nomeEstudante){
        this.nomeEstudante = nomeEstudante;
    }
    public ArrayList<Double> getNotas(){
        return notas;
    }
    public void setNotas(ArrayList<Double> notas){
        this.notas = notas;
    }
    
    public Estudantes(String m, String n, ArrayList<Double> nota){
        this.matricula = m;
        this.nomeEstudante = n;
        this.notas = nota;
    }
}
