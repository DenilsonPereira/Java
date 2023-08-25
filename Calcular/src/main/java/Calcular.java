/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.ArrayList;
/**
 *
 * @author 20231ADSGR0057
 */
public class Calcular {
    private String nome;
    private double peso;
    private double altura;
    private ArrayList<String> abaixo = new ArrayList<>();
    private ArrayList<String> normal = new ArrayList<>();
    private ArrayList<String> acima = new ArrayList<>();
    
    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public double getPeso(){
        return peso;
    }
    public void setPeso(double peso){
        this.peso = peso;
    }
    public double getAltura(){
        return altura;
    }
    public void setAltura(double altura){
        this.altura = altura;
    }
    public ArrayList<String> getAbaixo(){
        return abaixo;
    }
    public void setAbaixo(ArrayList<String> abaixo){
        this.abaixo = abaixo;
    }
    public ArrayList<String> getNormal(){
        return normal;
    }
    public void setNormal(ArrayList<String> normal){
        this.normal = normal;
    }
    public ArrayList<String> getAcima(){
        return acima;
    }
    public void setAcima(ArrayList<String> acima){
        this.acima = acima;
    }
    
    public Calcular(String nome, double peso, double altura){
          double imc = peso/(altura*altura);
          if(imc<18.5){
              abaixo.add(nome);
          }else if(imc>=18.5 && imc<25){
              normal.add(nome);
          }else if(imc>=25){
              acima.add(nome);
          }
    }
    
    public void exibir(int a){
        if(a==1){
            for(int i = 0; i < abaixo.size(); i++){
                System.out.println(abaixo.get(i));
            }
        }else if(a==2){
            for(int i = 0; i < normal.size(); i++){
                System.out.println(normal.get(i));
            }
        }else if(a==3){
            for(int i = 0; i < acima.size(); i++){
                System.out.println(acima.get(i));
            }
        }
    }
}
