/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.instituto;
import java.util.Scanner;
import java.util.ArrayList;
/**
 *
 * @author Denilson
 */
public class Instituto {

    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        int opcao;
        String codigo, matricula, nomeTurma, nomeEstudante;
        ArrayList<Turma> turmas = new ArrayList<>();
        ArrayList<Estudantes> estudante = new ArrayList<>();
        ArrayList<Double> notas = new ArrayList<>();
        ArrayList<Double> notasAluno = new ArrayList<>();
        Turma sala;
        Estudantes aluno;
        double n;
        
        while(true){
            System.out.println("1. Cadastrar turma \n2. Cadastrar estudante \n3. Listar turmas \n4. Listar estudantes por turma \n5. Consultar média de um estudante \n6. Alterar notas de um estudante \n7. Exibir média dos estudantes de uma turma \n0. Sair");
            System.out.println("Informe a opção desejada: ");
            opcao = sc.nextInt();
            sc.nextLine();
            
            switch(opcao){
                default:
                    break;
                case 0:
                    System.exit(0);
                case 1:
                    System.out.println("Informe o código da turma: ");
                    codigo = sc.nextLine();
                    
                    System.out.println("Informe o nome da turma: ");
                    nomeTurma = sc.nextLine();  
                  
                    sala = new Turma(codigo, nomeTurma, estudante);
                    
                    turmas.add(sala);
                    
                    break;
                case 2:
                    System.out.println("Informe o código da turma: ");
                    codigo = sc.nextLine();
                    notas = new ArrayList<>();
                    
                    for(Turma a : turmas){
                        if(codigo.equalsIgnoreCase(a.getCodigo())){
                            System.out.println("Informe a matricula do estudante: ");
                            matricula = sc.nextLine();
                            
                            System.out.println("Informe o nome do estudante: ");
                            nomeEstudante = sc.nextLine();
                            
                            for(int i = 0; i < 4; i++){
                                System.out.println("Informe a "+ (i+1)+ "ª nota: ");
                                n = sc.nextDouble();
                                sc.nextLine();
                                notas.add(n);
                            }
                            
                            aluno = new Estudantes(matricula, nomeEstudante, notas);
                            
                            estudante.add(aluno);
                            
                            a.setEstudante(estudante);
                        }else{
                            System.out.println("Turma não encontrada!");
                        }
                    }
                    break;
                case 3:
                    System.out.println("Turmas cadastradas: ");
                    for(Turma a : turmas){
                        System.out.println(a.getNomeTurma());
                    }
                    break;
                case 4:
                    System.out.println("Informe o código da turma: ");
                    codigo = sc.nextLine();
                    for(Turma a : turmas){
                        if(codigo.equalsIgnoreCase(a.getCodigo())){
                            System.out.println("Turma: " + a.getNomeTurma());
                            for(Estudantes e : a.getEstudante()){
                                System.out.println(e.getNomeEstudante() + " " + e.getNotas());
                            }
                        }else{
                            System.out.println("Turma não encontrada!");
                        }
                    }
                    break;
                case 5:
                    System.out.println("Informe o código da turma: ");
                    codigo = sc.nextLine();
                    
                    System.out.println("Informe a matricula do aluno: ");
                    matricula = sc.nextLine();
                    
                    for(Turma a : turmas){
                        if(codigo.equalsIgnoreCase(a.getCodigo())){
                            for(Estudantes e : a.getEstudante()){
                                if(matricula.equalsIgnoreCase(e.getMatricula())){
                                    double soma = 0.0;
                                    notasAluno = new ArrayList<>();
                                    notasAluno = e.getNotas();
                                    for(Double nt : notasAluno){
                                        soma += nt;
                                    }
                                    double media = soma/4;
                                    System.out.printf("A média do estudante %s é %.2f %n",e.getNomeEstudante(), media);
                                }
                            }
                        }else{
                            System.out.println("Turma não encontrada!");
                        }
                    }
                    break;
                case 6:
                    System.out.println("Informe o código da turma: ");
                    codigo = sc.nextLine();
                    
                    System.out.println("Informe a matricula do aluno: ");
                    matricula = sc.nextLine();
                    
                    for(Turma a : turmas){
                        if(codigo.equalsIgnoreCase(a.getCodigo())){
                            for(Estudantes e : a.getEstudante()){
                                if(matricula.equalsIgnoreCase(e.getMatricula())){
                                    
                                    e.getNotas().clear();
                                    for(int i = 0; i < 4; i++){
                                        System.out.println("Informe a "+ (i+1)+ "ª nota: ");
                                        n = sc.nextDouble();
                                        sc.nextLine();
                                        notas.add(n);
                                    }
                                    e.setNotas(notas);
                                    
                                    System.out.println(e.getNomeEstudante() + e.getNotas());
                                }
                            }
                        }else{
                            System.out.println("Turma não encontrada!");
                        }
                    }
                    break;
                case 7:
                    System.out.println("Informe o código da turma: ");
                    codigo = sc.nextLine();
                    double soma = 0.0, media;
                    for(Turma a : turmas){
                        if(codigo.equalsIgnoreCase(a.getCodigo())){
                            for(Estudantes e : a.getEstudante()){
                                notasAluno = new ArrayList<>();
                                notasAluno = e.getNotas();
                                for(Double nt : notasAluno){
                                    soma += nt;
                                }
                            }
                            media = soma/((a.getEstudante().size())*4);
                            System.out.println("A média da turma é: " + media);
                        }else{
                            System.out.println("Turma não encontrada!");
                        }
                    }
                    break;
            }
        } 
    }
}
