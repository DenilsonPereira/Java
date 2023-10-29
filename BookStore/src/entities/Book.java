package entities;

public class Book extends BookstoreItem implements SalesManager{
    private String isbn, gender;
    public Book(String name, String author, String yearPublication,Boolean availability, int amount, double price, String isbn, String gender){
        super(name, author, yearPublication, availability,amount,price);
        this.isbn = isbn;
        this.gender = gender;
    }
    
    public String getIsbn(){
        return isbn;
    }
    public void setIsbn(String isbn){
        this.isbn = isbn;
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
        }else{
        }
    }
    
    @Override
    public void returnItem(){
    }

	@Override
	public void sellItem() {
		// TODO Auto-generated method stub
		
	}
}
