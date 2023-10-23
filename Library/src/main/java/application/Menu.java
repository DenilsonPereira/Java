/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package application;
import entities.LibraryUser;
import entities.LibraryItem;
import entities.Cd;
import entities.Book;
import entities.Magazine;
import java.util.Scanner;
import java.util.ArrayList;
/**
 *
 * @author Denilson
 */
public class Menu {
    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        ArrayList<LibraryItem> library = new ArrayList<LibraryItem>();
        ArrayList<LibraryUser> users = new ArrayList<LibraryUser>();
        int option, volume, numberTracks, amount;
        Boolean availability;
        String name, author, yearPublication, edition, isbn, bookPublisher, gender, cpf, historyLoan, a;
        Book book = null;
        Magazine magazine = null;
        Cd cd = null;
        LibraryUser user;
        
        while(true){
            System.out.println("\n----------- Library System -----------"
                    + "\n1 - Register User"
                    + "\n2 - Register library item"
                    + "\n3 - Borrow"
                    + "\n4 - Give back"
                    + "\n5 - Check user's loan history"
                    + "\n6 - List library items"
                    + "\n0 - Exit"
                    + "\n--------------------------------------"
                    + "\nEnter the desired option:");
            
            option = sc.nextInt();
            sc.nextLine();
            
            switch(option){
                default:
                    break;
                    
                case 0:
                    System.exit(0);
                    
                case 1:
                    System.out.println("----------- Register User -----------"
                            + "\nName: ");
                    name = sc.nextLine();
                    
                    System.out.println("Cpf: ");
                    cpf = sc.nextLine();
                    
                    historyLoan = "";
                    
                    user = new LibraryUser(name, cpf, historyLoan);
                    
                    users.add(user);
                    
                    System.out.println("\nUser registered successfully!" 
                            + "\n-----------------------------------------");
                    break;
                    
                case 2:
                    System.out.println("------------ Register Library Item ------------"
                    + "\n1 - Register Book"
                    + "\n2 - Register Magazine"
                    + "\n3 - Register Cd"
                    + "\n-----------------------------------------------"
                    + "\nEnter the desired option:");
            
                    option = sc.nextInt();
                    sc.nextLine();
                    switch(option){
                        default:
                            break;
                        case 1:
                            System.out.println("----------- Register Book -----------"
                            + "\nName: ");
                            name = sc.nextLine();
                            
                            System.out.println("Author: ");
                            author = sc.nextLine();
                            
                            System.out.println("Year publication: ");
                            yearPublication = sc.nextLine();
                            
                            availability = true;
                            
                            System.out.println("ISBN: ");
                            isbn = sc.nextLine();
                            
                            System.out.println("Book publisher: ");
                            bookPublisher = sc.nextLine();
                            
                            System.out.println("Gender: ");
                            gender = sc.nextLine();
                            
                            book = new Book(name, author, yearPublication, availability, isbn, bookPublisher, gender);
                            library.add(book);
                            
                            System.out.println("\nBook registered successfully!" 
                            + "\n-----------------------------------------");
                            break;
                        case 2:
                            System.out.println("----------- Register Magazine -----------"
                            + "\nName: ");
                            name = sc.nextLine();
                            
                            System.out.println("Author: ");
                            author = sc.nextLine();
                            
                            System.out.println("Year publication: ");
                            yearPublication = sc.nextLine();
                            
                            availability = true;
                            
                            System.out.println("Edition: ");
                            edition = sc.nextLine();
                            
                            magazine = new Magazine(name, author, yearPublication, availability, edition);
                            library.add(magazine);
                            
                            System.out.println("\nMagazine registered successfully!" 
                            + "\n-----------------------------------------");
                            break;
                        case 3:
                            System.out.println("----------- Register Cd -----------"
                            + "\nName: ");
                            name = sc.nextLine();
                            
                            System.out.println("Author: ");
                            author = sc.nextLine();
                            
                            System.out.println("Year publication: ");
                            yearPublication = sc.nextLine();
                            
                            availability = true;
                            
                            System.out.println("Volume: ");
                            volume = sc.nextInt();
                            sc.nextLine();
                            
                            System.out.println("Number tracks: ");
                            numberTracks = sc.nextInt();
                            sc.nextLine();
                            
                            System.out.println("Amount: ");
                            amount = sc.nextInt();
                            sc.nextLine();
                            
                            cd = new Cd(name, author, yearPublication, availability, volume, numberTracks, amount);
                            
                            library.add(cd);
                            System.out.println("\nCd registered successfully!" 
                            + "\n-----------------------------------------");
                            break;
                    }
                    break;
                case 3:
                    System.out.println("----------- Borrow -----------"
                    + "\n1 - Book"
                    + "\n2 - Magazine"
                    + "\n3 - Cd"
                    + "\n-----------------------------------------------"
                    + "\nEnter the desired option:");
            
                    option = sc.nextInt();
                    sc.nextLine();
                    switch(option){
                        default:
                            break;
                        case 1:
                            System.out.println("Enter the name of the book: ");
                            name = sc.nextLine();
                            
                            for(LibraryItem li : library){
                                Book b = (Book) li;
                                if(name==b.getName()){
                                    if(b.getAvailability()==true){
                                        b.lendItem();
                                    }else{
                                        System.out.println("The book is not availability! ");
                                    }
                                }
                            }
                            break;
                        case 2:
                            System.out.println("Enter the name of the magazine: ");
                            name = sc.nextLine();
                            
                            for(LibraryItem li : library){
                                Magazine m = (Magazine) li;
                                if(name==m.getName()){
                                    if(m.getAvailability()==true){
                                        m.lendItem();
                                    }else{
                                        System.out.println("The magazine is not availability! ");
                                    }
                                }
                            }
                            break;
                        case 3:
                            System.out.println("Enter the name of the CD: ");
                            name = sc.nextLine();
                            
                            for(LibraryItem li : library){
                                Cd c = (Cd) li;
                                if(name==c.getName()){
                                    if(c.getAmount()>0){
                                        cd.lendItem();
                                    }else{
                                        System.out.println("The cd is not availability! ");
                                    }
                                }
                            }
                            break;
                    }
                    break;
                case 4:
                    System.out.println("----------- Give back -----------"
                    + "\n1 - Book"
                    + "\n2 - Magazine"
                    + "\n3 - Cd"
                    + "\n-----------------------------------------------"
                    + "\nEnter the desired option:");
            
                    option = sc.nextInt();
                    sc.nextLine();
                    switch(option){
                        default:
                            break;
                        case 1:
                            System.out.println("Enter the name of the book: ");
                            name = sc.nextLine();
                            
                            for(LibraryItem li : library){
                                Book b = (Book) li;
                                if(name==b.getName()){
                                    if(b.getAvailability()==false){
                                        b.returnItem();
                                    }else{
                                        System.out.println("The book is availability! ");
                                    }
                                }
                            }
                            break;
                        case 2:
                            System.out.println("Enter the name of the magazine: ");
                            name = sc.nextLine();
                            
                            for(LibraryItem li : library){
                                Magazine m = (Magazine) li;
                                if(name==m.getName()){
                                    if(m.getAvailability()==false){
                                        m.returnItem();
                                    }else{
                                        System.out.println("The magazine is availability! ");
                                    }
                                }
                            }
                        case 3:
                            System.out.println("Enter the name of the CD: ");
                            name = sc.nextLine();
                            
                            for(LibraryItem li : library){
                                Cd c = (Cd) li;
                                if(name==c.getName()){
                                    if(c.getAmount()==0){
                                        cd.returnItem();
                                    }else{
                                        System.out.println("The cd is availability! ");
                                    }
                                }
                            }
                            
                            break;
                    }
                    break;
                case 5:
                    System.out.println("----------- Check user's loan history -----------"
                            + "What's the user cpf?");
                    cpf = sc.nextLine();
                    for(LibraryUser ur : users){
                        if(cpf.equalsIgnoreCase(ur.getCpf())){
                            System.out.println("Loan History for " + ur.getName());
                        }
                    }
                    
                    break;
                case 6:
                    System.out.println("----------- List library items -----------");
                    for(LibraryItem l : library){
                        if(l.getAvailability()==true){
                            a = "Disponivel";
                        }else{
                            a = "Indisponivel";
                        }
                        if(l instanceof Book){
                            Book b = (Book) l;
                            System.out.printf("Name: %s \nAuthor: %s \nYear publication: %s \nAvailability(): %s \nISBN: %s \nBook Publisher: %s \nGender:", b.getName(), b.getAuthor(), b.getYearPublication(), b.getAvailability(), b.getIsbn(), b.getBookPublisher(), b.getGender());
                            
                        }else if(l instanceof Magazine){
                            Magazine m = (Magazine) l;
                            System.out.printf("Name: %s \nAuthor: %s \nYear publication: %s \nAvailability(): %s \nEdition: %s", m.getName(), m.getAuthor(), m.getYearPublication(), m.getAvailability(), m.getEdition());
                            
                            
                        }else if(l instanceof Cd){
                            Cd c = (Cd) l;
                            System.out.printf("Name: %s \nAuthor: %s \nYear publication: %s \nAvailability(): %s \nVolume: %s \nNumber tracks: %s \nAmount: %s", c.getName(), c.getAuthor(), c.getYearPublication(), c.getAvailability(), c.getVolume(), c.getNumberTracks(), c.getAmount());
                        }
                    }
                    break;
                    
  
            }
        }
    }
}
