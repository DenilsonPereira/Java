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
    public Retangulo(float base, float altura){
        super(base,altura);
    }
    
    @Override
    public void calcularArea() {
        float area = this.getBase() * this.getAltura();
        System.out.println(area);
    }

    @Override
    public void calcularPerimetro() {
       float perimetro = 2 * (this.getBase()+this.getAltura());
       System.out.println(perimetro);
    }
    
}
