/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quad;

/**
 *
 * @author 20231ADSGR0057
 */
public class Circulo extends Quadilatero{
    private float raio;
    
    public Circulo(float r){
        this.raio = r;
    }
    @Override
    public void calcularArea(){
        Double area = Math.PI * Math.pow(this.raio, 2);
        System.out.println(area);
    }
    @Override
    public void calcularPerimetro(){
        Double perimetro = 2 * Math.PI * this.raio;
        System.out.println(perimetro);
    }
}
