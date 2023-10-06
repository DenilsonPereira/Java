/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package entities;

/**
 *
 * @author Denilson
 */
public class Employee {
    private String name;
    private double grossSalary, tax;
    
    public Employee(String n, double g, double t){
        this.name = n;
        this.grossSalary = g;
        this.tax = t;
    }
    
    public String getName(){
        return name;
    }
    public void setName(String n){
        this.name = n;
    }
    public double getGrossSalary(){
        return grossSalary;
    }
    public void setGrossSalary(double g){
        this.grossSalary = g;
    }
    public double getTax(){
        return tax;
    }
    public void setTax(double t){
        this.tax = t;
    }
    public double netSalary(){
        return grossSalary - tax;
    }
    public void increaseSalary(double percentage){
        this.grossSalary += (grossSalary*percentage)/100;
    }
}
