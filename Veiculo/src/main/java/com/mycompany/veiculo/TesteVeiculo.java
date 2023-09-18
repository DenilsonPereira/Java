/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.veiculo;
import java.util.Scanner;
import java.util.ArrayList;
/**
 *
 * @author Denilson
 */
public class TesteVeiculo {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Carro v;
        String m, a, n;
        
        System.out.println("Informe a marca: ");
        m = sc.nextLine();
        
        System.out.println("Informe o ano: ");
        a = sc.nextLine();
        
        System.out.println("Informe o número de portas: ");
        n = sc.nextLine();
        
        v = new Carro(m, a, n);
        
        System.out.println(v);
        
    }
}
