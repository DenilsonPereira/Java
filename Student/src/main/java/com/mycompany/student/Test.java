/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.student;
import entities.Student;
import java.util.Scanner;
/**
 *
 * @author Denilson
 */
public class Test {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String name;
        double n1, n2, n3, total;
        Student student;
        
        System.out.println("NAME: ");
        name = sc.nextLine();
        
        System.out.println("NOTES: ");
        n1 = sc.nextDouble();
        sc.nextLine();
        n2 = sc.nextDouble();
        sc.nextLine();
        n3 = sc.nextDouble();
        sc.nextLine();
        
        student = new Student(name, n1, n2, n3);
        total = student.noteFinal();
        student.result(total);
        
        sc.close();
    }
}
