
import java.util.ArrayList;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 20231ADSGR0057
 */
public class Alunos {
    public static void main(String[] args){
        String mat;
        String nom;
        int opcao;
        Scanner sc = new Scanner(System.in);
        double nota;
        ArrayList<Escola> estudantes = new ArrayList<>();
        
        while(true){
            System.out.println("Informe a opção desejada: \n1. Cadastrar um estudante\n2. Obter o nome do estudante (procurar pela matricula)\n" + 
                    "3. Calcular a média (informar se o estudante foi aprovado ou não)\n0. Sair");
            opcao = sc.nextInt();
            sc.nextLine();
            
            switch(opcao){
                case 1:
                    System.out.println("Informe a matricula do aluno: ");
                    mat = sc.nextLine();
                    
                    System.out.println("Informe o nome do aluno: ");
                    nom = sc.nextLine();
                    ArrayList<Double> notas = new ArrayList();
                    for(int i = 0; i < 2; i++){
                        System.out.println("Informe a " + (i+1) + "º nota: ");
                        nota = sc.nextDouble();
                        sc.nextLine();
                        
                        notas.add(nota);
                    }
                    Escola estudante = new Escola(mat, nom, notas);
                    estudantes.add(estudante);
                    break;
                    
                case 2:
                    System.out.println("Informe a matricula do aluno: ");
                    mat = sc.nextLine();
                    for (Escola aluno : estudantes) {
                        aluno.buscar(mat);
                    }
                    break;
                    
                case 3:
                    for (Escola aluno : estudantes) {
                        aluno.media();
                    }
                    break;
                    
            }
            if(opcao == 0){
                break;
            }
            
        }
    }
}
