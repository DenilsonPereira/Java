/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quad;

/**
 *
 * @author 20231ADSGR0057
 */
public class Retangulo extends Quadilatero{
    private float lado, altura;
    public Retangulo(float l, float a){
        this.lado = l;
        this.altura = a;
    }
    
    @Override
    public void calcularArea() {
        float area = this.lado * this.altura;
        System.out.println(area);
    }

    @Override
    public void calcularPerimetro() {
       float perimetro = 2 * (this.lado+this.altura);
       System.out.println(perimetro);
    }
    
}
