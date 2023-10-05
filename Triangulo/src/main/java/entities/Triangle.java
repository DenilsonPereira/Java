/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 *
 * @author Denilson
 */
public class Triangle {
    public Double a,b,c;
    
    public double calculo(){
        Double p= (a+b+c)/2;
        return Math.sqrt(p*(p-a)*(p-b)*(p-c));
    } 
}
