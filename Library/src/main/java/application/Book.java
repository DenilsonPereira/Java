/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package application;

/**
 *
 * @author Denilson
 */
public class Book extends LibraryItem{
    public Book(String name, String author, String yearPublication){
        super(name, author, yearPublication);
    }
    @Override
    public void checkAvailability(){
    }
}
