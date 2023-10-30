package entities;

public class Magazine extends BookstoreItem implements SalesManager{
    private String edition;
    public Magazine(String name, String author, String yearPublication, Boolean availability, int amount, double price, String edition){
        super(name, author, yearPublication, availability, amount, price);
        this.edition = edition;
    }
    
    public String getEdition(){
        return edition;
    }
    public void setEdition(String edition){
        this.edition = edition;
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
	
	@Override
	public String toString() {
		return "Name: " + this.getName() + "\nAuthor: " + this.getAuthor() + "\nYear publication: "
		+ this.getYearPublication() + "\nAvailability: " + this.getAvailability() + "\nAmount: "
		+ this.getAmount() + "\nPrice: " + this.getPrice() + "\nEdition: " + this.getEdition();
	}
}
