/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package application;

/**
 *
 * @author Denilson
 */
public abstract class LibraryItem {
    private String name, author, yearPublication;
    private Boolean availability;
    
    public LibraryItem(String name, String author, String yearPublication, Boolean availability){
        this.name = name;
        this.author = author;
        this.yearPublication = yearPublication;
        this.availability = availability;
    }
    
    public String getName(){
        return name;
    }
    public String getAuthor(){
        return author;
    }
    public String getYearPublication(){
        return yearPublication;
    }
    public Boolean getAvailability(){
        return availability;
    }
    
    public abstract void checkAvailability();
}
