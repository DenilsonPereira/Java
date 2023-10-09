/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quad;

/**
 *
 * @author 20231ADSGR0057
 */
public class Quadrado extends Retangulo{
    private float lado;
    
    public Quadrado(float lado){
        super(lado, lado);
        this.lado = lado;
    }
    @Override
    public void calcularArea(){
        double area = Math.pow(this.lado,2);
        System.out.println(area);
    }
    @Override
    public void calcularPerimetro(){
        double perimetro = 4*this.lado;
        System.out.println(perimetro);
    }
}
