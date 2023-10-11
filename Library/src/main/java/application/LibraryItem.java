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
    
    public LibraryItem(String name, String author, String yearPublication){
        this.name = name;
        this.author = author;
        this.yearPublication = yearPublication;
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
    
    public abstract void checkAvailability();
}
