package entities;

public class Magazine extends BookstoreItem implements SalesManager{
    private String edition;
    public Magazine(String name, String author, String yearPublication, Boolean availability, String edition){
        super(name, author, yearPublication, availability);
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
}
