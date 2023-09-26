/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.triangulo;

import java.util.Scanner;

import entities.Triangle;

/**
 *
 * @author Denilson
 */
public class Triangulo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        Triangle X, Y;
        
        X = new Triangle();
        Y = new Triangle();
        
        System.out.println("Informe os valores do lado do triangulo X: ");
        X.a = sc.nextDouble();
        sc.nextLine();
        X.b = sc.nextDouble();
        sc.nextLine();
        X.c = sc.nextDouble();
        sc.nextLine();
        
        System.out.println("Informe os valores do lado do triangulo Y: ");
        Y.a = sc.nextDouble();
        sc.nextLine();
        Y.b = sc.nextDouble();
        sc.nextLine();
        Y.c = sc.nextDouble();
        sc.nextLine();
        
        Double p = (X.a+X.b+X.c)/2;
        
        double areaX = Math.sqrt(p*(p-X.a)*(p-X.b)*(p-X.c));
        
        p = (Y.a+Y.b+Y.c)/2;
        double areaY = Math.sqrt(p*(p-Y.a)*(p-Y.b)*(p-Y.c));
        
        System.out.println("Triangle X area: " + areaX);
        System.out.println("Triangle Y area: " + areaY);
        if(areaX>areaY){
            System.out.println("Larger: X");
        }else{
            System.out.println("Larger: Y");
        }
        
    }
}
