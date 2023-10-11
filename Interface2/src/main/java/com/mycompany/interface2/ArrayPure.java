/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.interface2;

/**
 *
 * @author 20231ADSGR0057
 */
public class ArrayPure implements IAluno {
    double[] notas = new double[2];
    int count = 0;
    
    @Override
    public void CalcularMedia(double nota1, double nota2){
        System.out.println((nota1+nota2)/2);
    };
    
    @Override
    public void AdicionarNota(double nota){
        if(count < notas.length){
            notas[count++] = nota;
        }
    };
    @Override
    public void RemoverNota(double nota){
        for(int i = 0; i<count; i++){
            if(notas[i]==nota){
                for(int j = i; j < count - 1; j++){
                    notas[j] = notas[j+1];
                }
                count--;
            }
        }
    };
    @Override
    public void MaiorNota(){
        if(count == 0){
            System.out.println("Não há notas!");
        }
        double maior = 0;
        for(int i = 0; i < count; i++){
            if(notas[i] > maior){
                maior = notas[i];
            }
        }
       System.out.println(maior);
    };
}
