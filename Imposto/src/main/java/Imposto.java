/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 20231ADSGR0057
 */
public class Imposto {
    private String nome;
    private double salario;
    private double imposto;
    
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
    public double getImposto(){
        return imposto;
    }
    public void setImposto(double imposto){
        this.imposto = imposto;
    }
    
    
    public Imposto(String n, double s){
        this.nome = n;
        this.salario = s;
        if(s<=2000){
           imposto = 0;
        }else if(s>2000 && s<=3500){
           imposto = (s*15)/100;
            
        }else if(s>3500 && s<=5000){
            imposto = (s*22)/100;
        }else if(s>5000){
            imposto = (s*30)/100;
        }
    }
}
