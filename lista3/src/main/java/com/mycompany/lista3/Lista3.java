/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.lista3;


import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author Denilson
 */
public class Lista3 {
    
    private static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
//        Questão 1
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Informe um número: ");
//        int num = sc.nextInt();
//        
//        if(num%2==0){
//            System.out.println("Par");
//        }else{
//            System.out.println("Ímpar");
//        }
        
//        Questão 2
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Informe o primeiro número:");
//        int x = sc.nextInt();
//        sc.nextLine();
//        System.out.println("Informe o segundo número:");
//        int y = sc.nextInt();
//        sc.nextLine();
//        
//        System.out.println("1 - Soma\n2 - Subtração\n3 - Multiplicação\n4 - Divisão");
//        System.out.println("Informe a opção desejada:");
//        int op = sc.nextInt();
//        
//        if(op==1){
//            sum(x, y);
//        }else if(op==2){
//            sub(x, y);
//        }else if(op==3){
//            mult(x, y);
//        }else if(op==4){
//            div(x, y);
//        }
//        Questão 3
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Informe uma string: ");
//        String frase = sc.nextLine();
//        String[] array = frase.split("");
//        int vogais = 0;
//        
//        for(int i = 0; i < array.length; i++){
//            if("a".equals(array[i]) || "e".equals(array[i]) || "i".equals(array[i]) || "o".equals(array[i]) || "u".equals(array[i]) || "A".equals(array[i]) || "E".equals(array[i]) || "I".equals(array[i]) || "O".equals(array[i]) || "U".equals(array[i])){
//                vogais++;
//            }
//        }
//        
//        System.out.println(vogais);

//        Questão 4
//        double sala = salario();
//        if(sala<=2000){
//            System.out.println("Seu imposto é: Isento");
//        }else if(sala>2000 && sala<=3500){
//            System.out.println("Seu imposto é: R$" + ((sala * 15)/100));
//        }else if(sala>3000 && sala<=5000){
//            System.out.println("Seu imposto é: R$" + ((sala * 22)/100));
//        }else if(sala>5000){
//            System.out.println("Seu imposto é: R$" + ((sala * 30)/100));
//        }

//        Questão 5
//        System.out.println("O que você deseja calcular?\n1 - Área\n2 - Perímetro");
//        int option = sc.nextInt();
//        sc.nextLine();
//        
//        if(option==1){
//            area();
//        }else if(option==2){
//            perimetro();
//        }else{
//            System.out.println("Opção não existe");
//        }

//        Questão 6
//        System.out.println("Informe a opção desejada: \n1 - Fahrenheit para Celsius\n2 - Kelvin para Celsius");
//        int opcao = sc.nextInt();
//        sc.nextLine();
//        
//        if(opcao==1){
//            celsius();
//        }else if(opcao==2){
//            kelvin();
//        }

//        Questão 7
//        System.out.println("Informe quantos valores tem o vetor: ");
//        int tamanho = sc.nextInt();
//        sc.nextLine();
//        int[] n = new int[tamanho];
//        for(int i = 0; i < tamanho; i++){
//            System.out.println("Informe o " + (i+1) + "º valor: ");
//            int valor = sc.nextInt();
//            n[i] = valor;
//        }
//        vetor(n);

//        Questão 8
        ArrayList<ArrayList<Object>> pessoas = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            ArrayList<Object> pessoa = new ArrayList<>();
            System.out.println("Informe o nome da " + (i+1) + "º pessoa: ");
            String nome = sc.nextLine();
            System.out.println("Informe a idade da " + (i+1) + "º pessoa: ");
            int idade = sc.nextInt();
            sc.nextLine();
            pessoa.add(nome);
            pessoa.add(idade);
            pessoas.add(pessoa);
        }
        velha(pessoas);
        nova(pessoas);
        acima(pessoas);
        
    }
    
    public static void velha(ArrayList<ArrayList<Object>> pes){
        double mais = Double.NEGATIVE_INFINITY;
        String nom;
        nom = null;
        for(ArrayList<Object> pessoa : pes){
            int id = (int) pessoa.get(1);
            if(id > mais){
                mais = id;
                nom = (String) pessoa.get(0);
            }
        }
        System.out.println("Pessoa mais velha: " + nom);
    }
    
    public static void nova(ArrayList<ArrayList<Object>> pes){
        double menos = Double.POSITIVE_INFINITY;
        String nome;
        nome = null;
        
        for(ArrayList<Object> pessoa : pes){
            int id = (int) pessoa.get(1);
            if(id<menos){
                menos = id;
                nome = (String) pessoa.get(0);
            }
        }
        System.out.println("Pessoa mais nova: " + nome);
    }
    
    public static void acima(ArrayList<ArrayList<Object>> pes){
        int acima = 0;
        for(ArrayList<Object> pessoa : pes){
            int idade = (int) pessoa.get(1);
            if(idade>18){
                acima++;
            }
        }
        System.out.println("Quantidade acima de 18 anos: " + acima);
    }
//    public static void vetor(int[] x){
//        int soma = 0;
//        for(int i = 0; i < x.length; i++){
//            soma = soma + x[i];
//        }
//        double media = soma/x.length;
//        System.out.println(media);
//    }
    
//    public static void celsius(){
//        System.out.println("Informe a temperatura em Fº: ");
//        double f = sc.nextDouble();
//        sc.nextLine();
//        
//        System.out.println(((5*(f - 32))/9)+ "Cº");
//    }
//    
//    public static void kelvin(){
//        System.out.println("Informe a temperatura em Kº: ");
//        double k = sc.nextDouble();
//        sc.nextLine();
//        
//        System.out.println((k - 273) + "Cº");
//    }
    
//    public static void area(){
//        System.out.println("Informe a base (b): ");
//        double b = sc.nextDouble();
//        sc.nextLine();
//        System.out.println("Informe a altura (h): ");
//        double h = sc.nextDouble();
//        sc.nextLine();
//        
//        System.out.println("A área do retângulo é " + (b*h));
//    }
//    
//    public static void perimetro(){
//        System.out.println("Informe a base (b): ");
//        double b = sc.nextDouble();
//        sc.nextLine();
//        System.out.println("Informe a altura (h): ");
//        double h = sc.nextDouble();
//        sc.nextLine();
//        
//        System.out.println("O perímetro do retângulo é " + ((2*b)+(2*h)));
//    }
    
//    public static double salario() {
//        System.out.println("Informe seu salário: ");
//        Scanner teclado = new Scanner(System.in);
//        double sal = teclado.nextDouble();
//        return sal;
//    }
    
//    public static void sum(int X, int Y){
//        System.out.println(X + Y);
//    }
//    public static void sub(int X, int Y){
//        System.out.println(X - Y);
//    }
//    public static void mult(int X, int Y){
//        System.out.println(X * Y);
//    }
//    public static void div(int X, int Y){
//        System.out.println(X / Y);
//    }
}
