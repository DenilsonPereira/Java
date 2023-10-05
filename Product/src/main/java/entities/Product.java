/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package entities;

/**
 *
 * @author Denilson
 */
public class Product {
    private String name;
    private double price;
    private int quantity;
    
    public Product(String n, double p, int q){
        this.name = n;
        this.price = p;
        this.quantity = q;
    }
    
    public String getName(){
        return name;
    }
    public void setName(String n){
        this.name = n;
    }
    public double getPrice(){
        return price;
    }
    public void setPrice(double p){
        this.price = p;
    }
    public int getQuantity(){
        return quantity;
    }
    public void setQuantity(int q){
        this.quantity = q;
    }
    
    public double totalValueInStock(){
        return quantity*price;
    }
    public void addProducts(int q){
        this.quantity += q;
    }
    public void removeProducts(int q){
        this.quantity -= q;
    }
}
