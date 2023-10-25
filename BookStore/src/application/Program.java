package application;

import entities.User;
import entities.Seller;
import entities.Client;
import entities.BookstoreItem;
import entities.Cd;
import entities.Book;
import entities.Magazine;
import java.util.Scanner;
import java.util.ArrayList;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        ArrayList<BookstoreItem> item = new ArrayList<BookstoreItem>();
        ArrayList<User> users = new ArrayList<User>();
        int option, volume, numberTracks, amount;
        Boolean availability;
        String name, author, yearPublication, edition, isbn, bookPublisher, gender, cpf, historyLoan, a;
        Book book = null;
        Magazine magazine = null;
        Cd cd = null;
        User user;
        
        while(true){
            System.out.println("\n----------- Bookstore System -----------"
                    + "\n1 - Register User"
                    + "\n2 - Register bookstore item"
                    + "\n3 - Sell"
                    + "\n4 - Give back"
                    + "\n5 - Seller's sales history"
                    + "\n6 - List bookstore items"
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
                    
                    user = new User(name, cpf, historyLoan);
                    
                    users.add(user);
                    
                    System.out.println("\nUser registered successfully!" 
                            + "\n-----------------------------------------");
                    break;
                    
                case 2:
                    System.out.println("------------ Register Bookstore Item ------------"
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
                            item.add(book);
                            
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
                            item.add(magazine);
                            
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
                            
                            item.add(cd);
                            System.out.println("\nCd registered successfully!" 
                            + "\n-----------------------------------------");
                            break;
                    }
                    break;
                case 3:
                    System.out.println("----------- Sell -----------"
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
                            
                            for(BookstoreItem li : item){
                                Book b = (Book) li;
                                if(name==b.getName()){
                                    if(b.getAvailability()==true){
                                        b.sellItem();
                                    }else{
                                        System.out.println("The book is not availability! ");
                                    }
                                }
                            }
                            break;
                        case 2:
                            System.out.println("Enter the name of the magazine: ");
                            name = sc.nextLine();
                            
                            for(BookstoreItem li : item){
                                Magazine m = (Magazine) li;
                                if(name==m.getName()){
                                    if(m.getAvailability()==true){
                                        m.sellItem();
                                    }else{
                                        System.out.println("The magazine is not availability! ");
                                    }
                                }
                            }
                            break;
                        case 3:
                            System.out.println("Enter the name of the CD: ");
                            name = sc.nextLine();
                            
                            for(BookstoreItem li : item){
                                Cd c = (Cd) li;
                                if(name==c.getName()){
                                    if(c.getAmount()>0){
                                        cd.sellItem();
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
                            
                            for(BookstoreItem li : item){
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
                            
                            for(BookstoreItem li : item){
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
                            
                            for(BookstoreItem li : item){
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
                    System.out.println("----------- Seller's sales history -----------"
                            + "What's the seller cpf?");
                    cpf = sc.nextLine();
                    for(User ur : users){
                        if(cpf.equalsIgnoreCase(ur.getCpf())){
                            System.out.println("Loan History for " + ur.getName());
                        }
                    }
                    
                    break;
                case 6:
                    System.out.println("----------- List bookstore items -----------");
                    for(BookstoreItem l : item){
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