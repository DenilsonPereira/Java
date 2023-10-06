/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.employee;
import entities.Employee;
import java.util.Scanner;
/**
 *
 * @author Denilson
 */
public class Test {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String name;
        double salary, tax, percentage;
        Employee employee;
        
        System.out.println("Name: ");
        name = sc.nextLine();
        System.out.println("Gross Salary: ");
        salary = sc.nextDouble();
        sc.nextLine();
        System.out.println("Tax: ");
        tax = sc.nextDouble();
        sc.nextLine();
        
        employee = new Employee(name, salary, tax);
        
        System.out.println("Employee: " + employee.getName() + ", $ " + employee.netSalary());
        System.out.println("Which percentage to increase salary? ");
        percentage = sc.nextDouble();
        sc.nextLine();
        employee.increaseSalary(percentage);
                
        System.out.println("Update data: " + employee.getName() + ", $ " + employee.netSalary());
        
        sc.close();
    }
}
