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
        int option, volume, amount;
        double price;
        Boolean availability;
        String name, author, yearPublication, edition, isbn, gender, cpf, historyLoan,a;
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
                	
                	registerUser(sc, users);
                    break;
                    
                case 2:
                	
                	registerItem(sc, item);
                    break;
                case 3:
                	
                	sellItem(sc, item);
                    break;
                    
                case 4:
                	
                	giveBackItem(sc, item);
                    break;
                    
                case 5:
                	
                	salesHistory(sc, users);
                    break;
                    
                case 6:
                	
                	listBookstoreItems(item);
                    break;    
                    
            }
        }
    }
	
	private static void registerUser(Scanner sc, ArrayList<User> users) {
		System.out.println("----------- Register User -----------");
        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("Cpf: ");
        String cpf = sc.nextLine();

        String historyLoan = "";

        User user = new User(name, cpf, historyLoan);

        users.add(user);

        System.out.println("\nUser registered successfully!");
	}
	
	private static void registerItem(Scanner sc, ArrayList<BookstoreItem> items) {
		System.out.println("------------ Register Bookstore Item ------------");
        System.out.println("1 - Register Book");
        System.out.println("2 - Register Magazine");
        System.out.println("3 - Register Cd");
        System.out.print("Enter the desired option: ");

        int option = sc.nextInt();
        sc.nextLine();

        switch (option) {
            case 1:
                registerBook(sc, items);
                break;
            case 2:
                registerMagazine(sc, items);
                break;
            case 3:
                registerCd(sc, items);
                break;
            default:
                System.out.println("Invalid option!");
                break;
        }
	}
	private static void registerBook(Scanner sc, ArrayList<BookstoreItem> items) {
		System.out.println("----------- Register Book -----------"
        + "\nName: ");
        String name = sc.nextLine();
                
        System.out.println("Author: ");
        String author = sc.nextLine();
                
        System.out.println("Year publication: ");
        String yearPublication = sc.nextLine();
                
        boolean availability = true;
                
        System.out.println("ISBN: ");
        String isbn = sc.nextLine();
                
        System.out.println("Price: ");
        double price = sc.nextDouble();
        sc.nextLine();
                
        System.out.println("Amount: ");
        int amount = sc.nextInt();
        sc.nextLine();
                
        System.out.println("Gender: ");
        String gender = sc.nextLine();
                
        Book book = new Book(name, author, yearPublication, availability, amount, price, isbn, gender);
        items.add(book);
                
        System.out.println("\nBook registered successfully!" 
        + "\n-----------------------------------------");
    }

    private static void registerMagazine(Scanner sc, ArrayList<BookstoreItem> items) {
    	System.out.println("----------- Register Magazine -----------"
        + "\nName: ");
        String name = sc.nextLine();
                
        System.out.println("Author: ");
        String author = sc.nextLine();
                
        System.out.println("Year publication: ");
        String yearPublication = sc.nextLine();
                
        Boolean availability = true;
        
        System.out.println("Price: ");
        double price = sc.nextDouble();
        sc.nextLine();
        
        System.out.println("Amount: ");
        int amount = sc.nextInt();
        sc.nextLine();
                
        System.out.println("Edition: ");
        String edition = sc.nextLine();
                
        Magazine magazine = new Magazine(name, author, yearPublication, availability, amount, price, edition);
        items.add(magazine);
                
        System.out.println("\nMagazine registered successfully!" 
        + "\n-----------------------------------------");
    }

    private static void registerCd(Scanner sc, ArrayList<BookstoreItem> items) {
    	System.out.println("----------- Register Cd -----------"
        + "\nName: ");
        String name = sc.nextLine();
                
        System.out.println("Author: ");
        String author = sc.nextLine();
                
        System.out.println("Year publication: ");
        String yearPublication = sc.nextLine();
                
        Boolean availability = true;
                
        System.out.println("Volume: ");
        int volume = sc.nextInt();
        sc.nextLine();
                
        System.out.println("Price: ");
        double price = sc.nextDouble();
        sc.nextLine();
                
        System.out.println("Amount: ");
        int amount = sc.nextInt();
        sc.nextLine();
                
        Cd cd = new Cd(name, author, yearPublication, availability, amount, price, volume);
                
        items.add(cd);
        System.out.println("\nCd registered successfully!" 
        + "\n-----------------------------------------");
    }

    private static void sellItem(Scanner sc, ArrayList<BookstoreItem> items) {
    	
//    	System.out.println("----------- Sell -----------"
//                + "\n1 - Book"
//                + "\n2 - Magazine"
//                + "\n3 - Cd"
//                + "\n-----------------------------------------------"
//                + "\nEnter the desired option:");
//        
//                option = sc.nextInt();
//                sc.nextLine();
//                switch(option){
//                    default:
//                        break;
//                    case 1:
//                        System.out.println("Enter the name of the book: ");
//                        name = sc.nextLine();
//                        
//                        for(BookstoreItem li : item){
//                            Book b = (Book) li;
//                            if(name==b.getName()){
//                                if(b.getAvailability()==true){
//                                    b.sellItem();
//                                }else{
//                                    System.out.println("The book is not availability! ");
//                                }
//                            }
//                        }
//                        break;
//                    case 2:
//                        System.out.println("Enter the name of the magazine: ");
//                        name = sc.nextLine();
//                        
//                        for(BookstoreItem li : item){
//                            Magazine m = (Magazine) li;
//                            if(name==m.getName()){
//                                if(m.getAvailability()==true){
//                                    m.sellItem();
//                                }else{
//                                    System.out.println("The magazine is not availability! ");
//                                }
//                            }
//                        }
//                        break;
//                    case 3:
//                        System.out.println("Enter the name of the CD: ");
//                        name = sc.nextLine();
//                        
//                        for(BookstoreItem li : item){
//                            Cd c = (Cd) li;
//                            if(name==c.getName()){
//                                if(c.getAmount()>0){
//                                    cd.sellItem();
//                                }else{
//                                    System.out.println("The cd is not availability! ");
//                                }
//                            }
//                        }
//                        break;
//                }
    	
    }

    private static void giveBackItem(Scanner sc, ArrayList<BookstoreItem> items) {
    	
//    	System.out.println("----------- Give back -----------"
//                + "\n1 - Book"
//                + "\n2 - Magazine"
//                + "\n3 - Cd"
//                + "\n-----------------------------------------------"
//                + "\nEnter the desired option:");
//        
//                option = sc.nextInt();
//                sc.nextLine();
//                switch(option){
//                    default:
//                        break;
//                    case 1:
//                        System.out.println("Enter the name of the book: ");
//                        name = sc.nextLine();
//                        
//                        for(BookstoreItem li : item){
//                            Book b = (Book) li;
//                            if(name==b.getName()){
//                                if(b.getAvailability()==false){
//                                    b.returnItem();
//                                }else{
//                                    System.out.println("The book is availability! ");
//                                }
//                            }
//                        }
//                        break;
//                    case 2:
//                        System.out.println("Enter the name of the magazine: ");
//                        name = sc.nextLine();
//                        
//                        for(BookstoreItem li : item){
//                            Magazine m = (Magazine) li;
//                            if(name==m.getName()){
//                                if(m.getAvailability()==false){
//                                    m.returnItem();
//                                }else{
//                                    System.out.println("The magazine is availability! ");
//                                }
//                            }
//                        }
//                    case 3:
//                        System.out.println("Enter the name of the CD: ");
//                        name = sc.nextLine();
//                        
//                        for(BookstoreItem li : item){
//                            Cd c = (Cd) li;
//                            if(name==c.getName()){
//                                if(c.getAmount()==0){
//                                    cd.returnItem();
//                                }else{
//                                    System.out.println("The cd is availability! ");
//                                }
//                            }
//                        }
//                        
//                        break;
//                }
    	
    }

    private static void salesHistory(Scanner sc, ArrayList<User> users) {

    	
//        System.out.println("----------- Seller's sales history -----------"
//                + "What's the seller cpf?");
//        cpf = sc.nextLine();
//        for(User ur : users){
//            if(cpf.equalsIgnoreCase(ur.getCpf())){
//                System.out.println("Loan History for " + ur.getName());
//            }
//        }
    	
    }

    private static void listBookstoreItems(ArrayList<BookstoreItem> items) {
    	
//    	System.out.println("----------- List bookstore items -----------");
//        for(BookstoreItem l : item){
//            if(l.getAvailability()==true){
//                a = "Disponivel";
//            }else{
//                a = "Indisponivel";
//            }
//            if(l instanceof Book){
//                Book b = (Book) l;
//                System.out.printf("Name: %s \nAuthor: %s \nYear publication: %s \nAvailability(): %s \nAmount: %s \nPrice: %s \nISBN: %s \nGender: %s", b.getName(), b.getAuthor(), b.getYearPublication(), b.getAvailability(), b.getAmount(), b.getPrice(), b.getIsbn(), b.getGender());
//                
//            }else if(l instanceof Magazine){
//                Magazine m = (Magazine) l;
//                System.out.printf("Name: %s \nAuthor: %s \nYear publication: %s \nAvailability(): %s \nAmount: %s \nPrice: %s \nEdition: %s", m.getName(), m.getAuthor(), m.getYearPublication(), m.getAvailability(), m.getAmount(), m.getPrice(), m.getEdition());
//                
//                
//            }else if(l instanceof Cd){
//                Cd c = (Cd) l;
//                System.out.printf("Name: %s \nAuthor: %s \nYear publication: %s \nAvailability(): %s \nAmount: %s \nPrice: %s \nVolume: %s", c.getName(), c.getAuthor(), c.getYearPublication(), c.getAvailability(), c.getAmount(), c.getPrice(), c.getVolume());
//            }
//        }
    	
    }
}