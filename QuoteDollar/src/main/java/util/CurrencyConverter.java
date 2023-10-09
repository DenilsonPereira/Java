/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

/**
 *
 * @author Denilson
 */
public class CurrencyConverter {
    public static final double IOF = 6.0;
    
    public static double value(double price, double amount){
        return (price*amount) + (((price*amount) * IOF)/100);
    }
}
