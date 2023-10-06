/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rectangle;
import entities.Rectangle;
import java.util.Scanner;
/**
 *
 * @author Denilson
 */
public class Test {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        double width, height;
        Rectangle rectangle;
        
        System.out.println("Enter rectangle width and height:");
        width = sc.nextDouble();
        sc.nextLine();
        height = sc.nextDouble();
        sc.nextLine();
        
        rectangle = new Rectangle(width, height);
        
        System.out.println("AREA = " + rectangle.area());
        System.out.println("PERIMETER = " + rectangle.perimeter());
        System.out.println("DIAGONAL = " + rectangle.diagonal());
        
        
        sc.close();
    }
}
