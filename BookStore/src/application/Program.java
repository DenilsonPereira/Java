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
        int option;
        
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
    	
    	System.out.println("----------- Sell -----------"
                + "\n1 - Book"
                + "\n2 - Magazine"
                + "\n3 - Cd"
                + "\n-----------------------------------------------"
                + "\nEnter the desired option:");
        
                int option = sc.nextInt();
                sc.nextLine();
                switch(option){
                    default:
                        break;
                    case 1:
    	
                        sellBook(sc, items);
                        break;
    	
                    case 2:
    	
                        sellMagazine(sc, items);
                        break;
    	
                    case 3:
                        sellCd(sc, items);
                        break;
                }
    	
    }
    
    private static void sellBook(Scanner sc, ArrayList<BookstoreItem> item) {
    	System.out.println("Enter the isbn of the book: ");
    	String isbn = sc.nextLine();
      
    	for(BookstoreItem li : item){
    		Book b = (Book) li;
    		if(isbn.equalsIgnoreCase(b.getIsbn())){
    			if(b.getAvailability()==true){
    				System.out.printf("Tell us how many books %s wants to buy?", b.getName());
    				int sellB = sc.nextInt();
    				sc.nextLine();
    				b.sellItem(sellB);
    			}else{
                  System.out.println("The book is not availability! ");
    			}
    		}
    	}
    }
    
    private static void sellMagazine(Scanner sc, ArrayList<BookstoreItem> item) {
    	System.out.println("Enter the name of the magazine: ");
	    String name = sc.nextLine();
	      
	      for(BookstoreItem li : item){
	          Magazine m = (Magazine) li;
	          if(name.equalsIgnoreCase(m.getName())){
	              if(m.getAvailability()==true){
	            	  System.out.printf("Tell us how many magazines %s wants to buy?", m.getName());
	            	  int sellM = sc.nextInt();
	            	  sc.nextLine();
	                  m.sellItem(sellM);
	              }else{
	                  System.out.println("The magazine is not availability! ");
	              }
	          }
	      }
    }
    
    private static void sellCd(Scanner sc, ArrayList<BookstoreItem> item) {
    	System.out.println("Enter the name of the CD: ");
	    String name = sc.nextLine();
	      
	    for(BookstoreItem li : item){
	         Cd c = (Cd) li;
	         if(name.equalsIgnoreCase(c.getName())){
	              if(c.getAmount()>0){
	            	  System.out.printf("Tell us how many cd's %s wants to buy?", c.getName());
	            	  int sellC = sc.nextInt();
	            	  sc.nextLine();
	                  c.sellItem(sellC);
	              }else{
	                  System.out.println("The cd is not availability! ");
	              }
	          }
	      }
    }
    
    private static void giveBackItem(Scanner sc, ArrayList<BookstoreItem> items) {
    	
    	System.out.println("----------- Give back -----------"
                + "\n1 - Book"
                + "\n2 - Magazine"
                + "\n3 - Cd"
                + "\n-----------------------------------------------"
                + "\nEnter the desired option:");
        
                int option = sc.nextInt();
                sc.nextLine();
                switch(option){
                    default:
                        break;
                    case 1:
                    	giveBackBook(sc,items);
                        break;
                    case 2:
                        giveBackMagazine(sc, items);
                        break;
                    case 3:
                    	giveBackCd(sc, items);
                    	break;
                }
    	
    }
                
    private static void giveBackBook(Scanner sc, ArrayList<BookstoreItem> item) {
	      System.out.println("Enter the isbn of the book: ");
	      String isbn = sc.nextLine();
	      
	      for(BookstoreItem li : item){
	          Book b = (Book) li;
	          if(isbn.equalsIgnoreCase(b.getIsbn())){
	        	  
	             System.out.printf("How many %s books do you want to return?", b.getName());
	             int bookReturn = sc.nextInt();
	             sc.nextLine();
	             b.returnItem(bookReturn);
	             
	          }else{
	             System.out.println("The isbn of the book provided does not exist!");
	          }
	      }
	}
    
    private static void giveBackMagazine(Scanner sc, ArrayList<BookstoreItem> item) {
    	System.out.println("Enter the name of the magazine: ");
	    String name = sc.nextLine();
	      
	    for(BookstoreItem li : item){
	          Magazine m = (Magazine) li;
	          if(name.equalsIgnoreCase(m.getName())){
	        	  System.out.printf("How many %s books do you want to return?", m.getName());
	        	  int magazineReturn = sc.nextInt();
		          sc.nextLine();
	              m.returnItem(magazineReturn);
	          }else{
	                  System.out.println("The name of the magazine provided does not exist!");
	          }
	    }
    }
    
    private static void giveBackCd(Scanner sc, ArrayList<BookstoreItem> item) {
    	System.out.println("Enter the name of the CD: ");
    	String name = sc.nextLine();
	      
	    for(BookstoreItem li : item){
	          Cd c = (Cd) li;
	          if(name.equalsIgnoreCase(c.getName())){
	        	  System.out.printf("How many %s books do you want to return?", c.getName());
	        	  int cdReturn = sc.nextInt();
	        	  sc.nextLine();
	              c.returnItem(cdReturn);
	          }else{
	                  System.out.println("The name of the cd provided does not exist!");
	          }
	    }
    }
    
    private static void salesHistory(Scanner sc, ArrayList<User> users) {

    	
        System.out.println("----------- Seller's sales history -----------"
                + "What's the seller cpf?");
        String cpf = sc.nextLine();
        for(User ur : users){
            if(cpf.equalsIgnoreCase(ur.getCpf())){
                System.out.println("Loan History for " + ur.getName());
            }
        }
    	
    }

    private static void listBookstoreItems(ArrayList<BookstoreItem> items) {
    	
    	System.out.println("----------- List bookstore items -----------");
        for(BookstoreItem l : items){
            if(l instanceof Book){
                Book b = (Book) l;
                System.out.println(b.toString());
                
            }else if(l instanceof Magazine){
                Magazine m = (Magazine) l;
                System.out.println(m.toString());
                
            }else if(l instanceof Cd){
                Cd c = (Cd) l;
                System.out.println(c.toString());
            }
        }
    }
}