/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 *
 * @author Denilson
 */
public class Book extends LibraryItem implements LoanManagement{
    private String isbn, bookPublisher, gender;
    public Book(String name, String author, String yearPublication,Boolean availability, String isbn, String bookPublisher, String gender){
        super(name, author, yearPublication, availability);
        this.isbn = isbn;
        this.bookPublisher = bookPublisher;
        this.gender = gender;
    }
    
    public String getIsbn(){
        return isbn;
    }
    public void setIsbn(String isbn){
        this.isbn = isbn;
    }
    
    public String getBookPublisher(){
        return bookPublisher;
    }
    public void setBookPublisher(String bookPublisher){
        this.bookPublisher = bookPublisher;
    }
    
    public String getGender(){
        return gender;
    }
    public void setGender(String gender){
        this.gender = gender;
    }
    
    @Override
    public void checkAvailability(){
        Boolean ava = getAvailability();
        if(ava==true){
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
