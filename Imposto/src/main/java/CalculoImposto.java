/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author 20231ADSGR0057
 */
public class CalculoImposto {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int opcao;
        String nome;
        double salario;
        ArrayList<Imposto> funcionariosLista = new ArrayList<>();
        
        while(true){
            
            System.out.println("Informe a opção desejada: ");
            System.out.println("1 - Cadastrar funcionário \n2 - Calcular imposto \n0 - Sair");
            opcao = sc.nextInt();
            sc.nextLine();
                
            switch(opcao){
                default:
                    System.out.println("Opção inválida!");
                    break;
                    
                case 0:
                    System.out.println("Saindooooo!!!!!");
                    return;
            
                case 1:
                    System.out.println("Informe o nome do funcionário: ");
                    nome = sc.nextLine();
                    System.out.println("Qual o salário de " + nome + "?");
                    salario = sc.nextDouble();
                    sc.nextLine();
                    
                    Imposto funcionario = new Imposto(nome, salario);
                    System.out.println(funcionario.getNome());
                    funcionariosLista.add(funcionario);
                    break;
                case 2:
                    System.out.println("Informe o nome que deseja buscar: ");
                    nome = sc.nextLine();
                    for(Imposto func : funcionariosLista){
                        if(func.getNome().equalsIgnoreCase(nome)){
                            System.out.println("Nome: " + func.getNome());
                            System.out.println("Salário: R$" + func.getSalario());
                            System.out.println("Imposto: R$" + func.getImposto());
                        }
                    }
                    break;
            }
        }
    }
}