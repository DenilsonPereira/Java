/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.product;
import entities.Product;
import java.util.Scanner;
import java.util.ArrayList;
/**
 *
 * @author Denilson
 */
public class Test {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ArrayList<Product> products = new ArrayList<Product>();
        String name;
        double price, total;
        int quantity, option;
        Product pr;
        
        while(true){
            System.out.println("1. Register product \n2. Add product \n3. Remove product \n0. Exit \nEnter the desired option: ");
            option = sc.nextInt();
            sc.nextLine();
            
            switch(option){
                default:
                    break;
                case 0:
                    System.exit(0);
                case 1:
                    System.out.println("Name:");
                    name = sc.nextLine();
                    
                    System.out.println("Price:");
                    price = sc.nextDouble();
                    sc.nextLine();
                    
                    System.out.println("Quantity in stock: ");
                    quantity = sc.nextInt();
                    sc.nextLine();
                   
                    pr = new Product(name, price, quantity);
                    
                    products.add(pr);
                    
                    total = pr.totalValueInStock();
                    System.out.println("Product data: " + pr.getName() + ", $ " + pr.getPrice() + ", " + pr.getQuantity() + " units, Total: $ " + total);
                    break;
                case 2:
                    System.out.println("Enter the number of products to be added in stock: ");
                    quantity = sc.nextInt();
                    sc.nextLine();
                    for(Product p : products){
                        
                        p.addProducts(quantity);
                    
                        System.out.println("Updated data: " + p.getName() + ", $ " + p.getPrice() + ", " + p.getQuantity() + " units, Total: $ " + p.totalValueInStock());
                    }
                    break;
                case 3:
                    for(Product p : products){
                        System.out.println("Enter the number of products to be removed from stock: ");
                        quantity = sc.nextInt();
                        sc.nextLine();
                        
                        p.removeProducts(quantity);
                        System.out.println("Updated data: " + p.getName() + ", $ " + p.getPrice() + ", " + p.getQuantity() + " units, Total: $ " + p.totalValueInStock());
                    }
                    break;
            }
        }
    }
}
