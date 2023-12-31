/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 *
 * @author Denilson
 */
public class Magazine extends LibraryObject implements LoanManagement{
    private String edition;
    public Magazine(String name, String author, String yearPublication, Boolean availability, String edition){
        super(name, author, yearPublication, availability);
        this.edition = edition;
    }
    
    public String getEdition(){
        return edition;
    }
    public void setEdition(String edition){
        this.edition = edition;
    }
    
    @Override
    public void checkAvailability(){
        Boolean ava = getAvailability();
        if(ava==true){
            
        }else{
            
        }
    }

    @Override
    public void lendItem() {
        
    }
    
    @Override
    public void returnItem(){
        
    }
}