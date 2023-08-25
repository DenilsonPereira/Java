/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.Scanner;
/**
 *
 * @author 20231ADSGR0057
 */
public class Menu {
    public static void main(String[] args){
        int opcao;
        Scanner sc = new Scanner(System.in);
        Calcular imc = null;
        
        while(true){
            System.out.println("Informe a opção desejada: \n" + "1. Cadastrar uma pessoa\n" +
                                             "2. Mostrar as pessoas que estão abaixo do peso (IMC < 18,5)\n" +
                                             "3. Mostrar as pessoas que estão dentro do peso ideal (IMC > 18,5 e IMC <25)\n" +
                                             "4. Mostrar as pessoas que estão acima do peso (IMC > = 25)\n" +
                                             "0. Sair");
            opcao = sc.nextInt();
            sc.nextLine();
            
            switch(opcao){
                case 1:
                    System.out.println();
//                   toString
                    imc = new Calcular(nome, peso, altura);
                    break;
                case 2:
                    imc.exibir(1);
                    break;
                case 3:
                    imc.exibir(2);
                    break;
                case 4:
                    imc.exibir(3);
                    break;
            }
            if(opcao==0){
                break;
            }
        }
    }
}
