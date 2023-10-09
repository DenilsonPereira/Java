/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quad;

/**
 *
 * @author 20231ADSGR0057
 */
public  abstract class Quadilatero {
    private float base, altura;
    public Quadilatero(float b, float a){
        this.base = b;
        this.altura = a;
    }
    
    public float getBase(){
        return base;
    }
    public float getAltura(){
        return altura;
    }
    
    public abstract void calcularArea();
    public  abstract void calcularPerimetro();
}