/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package application;
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
        String name, author, yearPublication, edition, isbn, bookPublisher, gender, cpf, historyLoan;
        Book book = null;
        Magazine magazine = null;
        Cd cd = null;
        LibraryUser user;
        
        while(true){
            System.out.println("----------- Library System -----------"
                    + "\n1 - Register User"
                    + "\n2 - Register library item"
                    + "\n3 - Borrow"
                    + "\n4 - Give back"
                    + "\n5 - Check user's loan history"
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
                            book.lendItem();
                            break;
                        case 2:
                            magazine.lendItem();
                            break;
                        case 3:
                            cd.lendItem();
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
                            book.returnItem();
                            break;
                        case 2:
                            magazine.returnItem();
                            break;
                        case 3:
                            cd.returnItem();
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
  
            }
        }
    }
}
