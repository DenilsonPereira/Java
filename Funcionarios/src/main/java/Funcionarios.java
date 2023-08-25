
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
public class Funcionarios {
    private Scanner sc = new Scanner(System.in);
    private String nome;
    private double salario;
    private ArrayList<String> acima = new ArrayList();
    
    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public double getSalario(){
        return salario;
    }
    public void setSalario(double salario){
        this.salario = salario;
    }
    
    public ArrayList getAcima(){
        return acima;
    }
    public void setAcima(ArrayList acima){
        this.acima = acima;
    }

    public Scanner getSc() {
        return sc;
    }
    
    public void setSc(Scanner sc) {
        this.sc = sc;
    }
    
    public void cadastro(){
        String n;
        double sal;
        
        System.out.println("Informe o nome do funcinário: ");
        n = sc.nextLine();
        
        System.out.println("Informe o salário do funcionário " + n + ":");
        sal = sc.nextDouble();
        sc.nextLine(); 
        
        if(sal>=5000){
            acima.add(n);
        }
    }
    
    public void exibir(){
        for(int i = 0; i < acima.size(); i++){
            System.out.println(acima.get(i));
        }
    }
    
}
