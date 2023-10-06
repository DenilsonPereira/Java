/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package entities;

/**
 *
 * @author Denilson
 */
public class Student {
    private String name;
    private double note1, note2, note3;
    
    public Student(String n, double n1, double n2, double n3){
        this.name = n;
        this.note1 = n1;
        this.note2 = n2;
        this.note3 = n3;
    }
    public String getName(){
        return name;
    }
    public double getNote1(){
        return note1;
    }
    public double getNote2(){
        return note2;
    }
    public double getNote3(){
        return note3;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setNote1(double n1){
        this.note1 = n1;
    }
    public void setNote2(double n2){
        this.note2 = n2;
    }
    public void setNote3(double n3){
        this.note3 = n3;
    }
    
    public double noteFinal(){
        return this.note1+this.note2+this.note3;
    }
    public void result(double total){
        if(total>=60){
            System.out.println("FINAL GRADE: " + noteFinal() + "\nPASS");
        }else{
            System.out.println("FINAL GRADE: " + noteFinal() + "\nFAILED \nMISSING " + (60 - noteFinal()) + " POINTS");
        }
    }
}
