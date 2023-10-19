/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package application;

import entities.Employee;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Denilson
 */
public class Program {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Employee employee;
        List<Employee> list = new ArrayList<>();
        int num, id;
        String name;
        double salary, percentage;
        
        System.out.println("How many employees will be registered?");
        num = sc.nextInt();
        sc.nextLine();
        
        for(int i = 0; i < num; i++){
            System.out.println("Employee #" + (i+1) + ":");
            System.out.println("Id: ");
            id = sc.nextInt();
            sc.nextLine();
            
            System.out.println("Name: ");
            name = sc.nextLine();
            
            System.out.println("Salary: ");
            salary = sc.nextDouble();
            sc.nextLine();
            
            employee = new Employee(id, name, salary);
            list.add(employee);
        }
        
        System.out.println("Enter the employee id that will have salary icrease: ");
        id = sc.nextInt();
        sc.nextLine();
        
        for(Employee x : list){
            if(id==x.getId()){
                System.out.println("Enter the percentage");
                percentage = sc.nextDouble();
                sc.nextLine();
                
                double increase = x.getSalary() + ((x.getSalary()*percentage)/100);
                
                x.setSalary(increase);
            }
        }
        
        
        System.out.println("List of employees: ");
        for(Employee x : list){
            System.out.printf("%s , %s, %s \n", x.getId(), x.getName(), x.getSalary());
        }
        sc.close();
    }
}
