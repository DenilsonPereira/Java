/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import entities.LoanManagement;

/**
 *
 * @author Denilson
 */
public class Cd extends LibraryItem implements LoanManagement{
    public int volume, numberTracks, amount;
    public Cd(String name, String author, String yearPublication, Boolean availability, int volume, int numberTracks, int amount){
        super(name, author, yearPublication, availability);
        this.volume = volume;
        this.numberTracks = numberTracks;
        this.amount = amount;
    }
    
    public int getVolume(){
        return volume;
    }
    public void setVolume(int volume){
        this.volume = volume;
    }
    
    public int getNumberTracks(){
        return numberTracks;
    }
    public void setNumberTracks(int numberTracks){
        this.numberTracks = numberTracks;
    }
    
    public int getAmount(){
        return amount;
    }
    public void setAmount(int amount){
        this.amount = amount;
    }
    
@Override
    public void checkAvailability(){
        int ava = getAmount();
        if(ava>0){
            return "Disponível";
        }else{
            return "Indisponível";
        }
    }

    @Override
    public void lendItem() {
        setAvailability(false);
    }
    
    @Override
    public void returnItem(){
        setAvailability(true);
    }
}