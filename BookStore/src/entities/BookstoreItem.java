package entities;

public abstract class BookstoreItem {

	private int amount;
	private double price;
	private String name, author, yearPublication;
    private Boolean availability;
    
    public BookstoreItem(String name, String author, String yearPublication, Boolean availability, int amount, double price){
        this.name = name;
        this.author = author;
        this.yearPublication = yearPublication;
        this.availability = availability;
        this.amount = amount;
        this.price = price;
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
    public void setAvailability(Boolean availability) {
    	this.availability = availability;
    }
    public int getAmount() {
    	return amount;
    }
    public void setAmount(int amount) {
    	this.amount = amount;
    }
    public double getPrice() {
    	return price;
    }
    
    public abstract void checkAvailability();
}
