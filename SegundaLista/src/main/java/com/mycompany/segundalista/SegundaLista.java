/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.segundalista;

import java.util.Scanner;

/**
 *
 * @author Denilson
 */
public class SegundaLista {

    public static void main(String[] args) {
//       Scanner sc = new Scanner(System.in);
//        Questão 1
//        int[] numeros = new int[10];
//        int numero = 0;
//        for(int i=0;i<10;i++){
//            System.out.print("Informe um número: ");
//            int valor = sc.nextInt();
//            numeros[i] = valor;
//        }
//        for(int c = 0;c<10;c++){
//            numero = numero + numeros[c];
//        }
//        System.out.print(numero);

//        Questão 2
//        int[] valores = new int[10];
//        for(int i = 0; i < 10; i++){
//            int valor = sc.nextInt();
//            valores[i] = valor;
//        }
//        int c = 0;
//        int menor = 0;
//        int maior = 0;
//        int soma = 0;
//        float media;
//         while(c<10){
//            if(valores[c]<menor){
//                menor = valores[c];
//            }
//            if(valores[c]>maior){
//                maior = valores[c];
//            }
//            soma+=valores[c];
//            c++;
//        }
//        media = soma/10;
//        System.out.println(menor);
//        System.out.println(maior);
//        System.out.println(media);
//        while(c<10){
//            if(valores[c]<menor){
//                menor = valores[c];
//            }
//            if(valores[c]>maior){
//                maior = valores[c];
//            }
//            soma+=valores[c];
//            c++;
//        }
//        media = soma/10;
//        System.out.println(menor);
//        System.out.println(maior);
//        System.out.println(media);

//        Questão 9
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Informe uma palavra: ");
        String palavra = sc.nextLine();
        String[] array = palavra.split("");
        int vogal = 0;
        
        for(int i = 0; i < array.length; i++){
            if("a".equals(array[i]) || "e".equals(array[i]) || "i".equals(array[i]) || "o".equals(array[i]) || "u".equals(array[i])){
                vogal = vogal + 1;
            }
        }
        
        System.out.println(vogal);
        
    }
}
