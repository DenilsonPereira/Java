/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.carro;

import java.util.Scanner;

/**
 *
 * @author Denilson
 */
public class Menu {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcao;
        Carro carrinho = null;
        double eficiencia;
        double quilometros;

        while (true) {
            System.out.println("Informe a opção desejada: ");
            System.out.println("1. Andar \n2. Reabastecer \n3. Verificar a quantidade de combustível restante \n4. Encerrar viagem");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                default:
                    System.out.println("Opção inválida!");
                case 1:
                    System.out.println("Informe quantos km/l o carro faz: ");
                    eficiencia = sc.nextDouble();
                    sc.nextLine();
                    carrinho = new Carro(eficiencia);
                    break;
                case 2:
                    System.out.println("Informe quantos km irá percorrer: ");
                    quilometros = sc.nextDouble();
                    sc.nextLine();
                    carrinho.Andar(quilometros);
                    break;
                case 3:
                    break;
                case 4:
                    System.out.println("Encerrando viagem!!!");
                    return;
            }
        }
    }
}