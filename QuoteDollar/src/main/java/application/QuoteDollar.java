/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package application;

import java.util.Locale;
import java.util.Scanner;
import util.CurrencyConverter;

/**
 *
 * @author Denilson
 */
public class QuoteDollar {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("What is the dollar price? ");
        double price = sc.nextDouble();
        sc.nextLine();

        System.out.println("How many dollars will be bought?");
        double amount = sc.nextDouble();
        sc.nextLine();

        System.out.printf("Amount to be paid in reais = %.2f%n", CurrencyConverter.value(price, amount));

        sc.close();
    }
}
