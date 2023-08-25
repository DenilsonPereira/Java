
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 20231ADSGR0057
 */
public class Menu {
    public static void main(String[] args){
        Funcionarios funcionarios = new Funcionarios();
        int opcao;
        String nome;
        double salario;
        Scanner sc = new Scanner(System.in);
        
        while(true){
            System.out.println("Informe a opção desejada: \n1 - Cadastrar funcionário \n2 - Exibir funcionários que recebe acima de 5000 \n0 - Sair");
            opcao = sc.nextInt();
            sc.nextLine();
            
            switch(opcao){
                case 1:
                    funcionarios.cadastro();
                    break;
                case 2:
                    funcionarios.exibir();
                    break;
            }
            if(opcao==0){
                break;
            }
        }
    }
}
