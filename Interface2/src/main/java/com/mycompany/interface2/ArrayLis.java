/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.interface2;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author 20231ADSGR0057
 */
public class ArrayLis implements IAluno {
    
    ArrayList<Double> notas = new ArrayList<>();
    
    @Override
    public void CalcularMedia(double nota1, double nota2){
        System.out.println((nota1+nota2)/2);
    };
    
    @Override
    public void AdicionarNota(double nota){
        notas.add(nota);
    };
    @Override
    public void RemoverNota(double nota){
        for(Double n : notas){
            if(nota==n){
                notas.remove(n);
            }else{
                System.out.println("Não tem essa nota");
            }
        }
    };
    @Override
    public void MaiorNota(){
       System.out.println(Collections.max(notas));
    };

    /**
     * @return the notas
     */
    public ArrayList<Double> getNotas() {
        return notas;
    }

    /**
     * @param notas the notas to set
     */
    public void setNotas(ArrayList<Double> notas) {
        this.notas = notas;
    }
    
}
