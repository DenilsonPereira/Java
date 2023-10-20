/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 *
 * @author Denilson
 */
public class LibraryUser {
    private String name, cpf, historyLoan;
    
    public LibraryUser(String name, String cpf, String historyLoan){
        this.name = name;
        this.cpf = cpf;
        this.historyLoan = historyLoan;
    }
    
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    
    public String getCpf(){
        return cpf;
    }
    public void setCpf(String cpf){
        this.cpf = cpf;
    }
    
    public String getHistoryLoan(){
        return historyLoan;
    }
    public void setHistoryLoan(String historyLoan){
        this.historyLoan = historyLoan;
    }
}
