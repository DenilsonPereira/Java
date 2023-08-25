
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 20231ADSGR0057
 */
public class Escola {
    private String matricula;
    private String nome;
    private ArrayList<Double> notas = new ArrayList<>();
    private ArrayList<ArrayList<Object>> alunos = new ArrayList<>();

    Escola() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public String getMatricula(){
        return matricula;
    }
    public void setMatricula(String matricula){
        this.matricula = matricula;
    }
    
    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public ArrayList getNotas(){
        return notas;
    }
    public void setNotas(ArrayList notas){
        this.notas = notas;
    }
    
    public ArrayList getAlunos(){
        return alunos;
    }
    
    public Escola(String matricula, String nome, ArrayList<Double> notas){
        this.matricula = matricula;
        this.nome = nome;
        this.notas = notas;
        ArrayList<Object> aluno = new ArrayList<>();
        aluno.add(this.matricula);
        aluno.add(this.nome);
        aluno.add(this.notas);
        
        alunos.add(aluno);
    }
    
    public void buscar(String matricula){
        
        for (int i = 0; i < alunos.size(); i++) {
            ArrayList<Object> aluno = alunos.get(i); // Obter os detalhes do aluno
            if (matricula.equals(aluno.get(0))) {
                System.out.println("Nome do aluno: " + aluno.get(1));
//                System.out.println("Matrícula do aluno: " + aluno.get(0));
//                System.out.println("Notas do aluno: " + aluno.get(2));
            }
        }
    }
    public void media(){
        double media = (notas.get(0) + notas.get(1))/2;
        System.out.println("A média do aluno " + nome + " é " + media);
        if(media>=7){
            System.out.println("APROVADO!!!");
        }else if(media<7 && media>=5){
            System.out.println("RECUPERAÇÃO!!!");
        }else{
            System.out.println("REPROVADO!!!!");
        }
    }
}
