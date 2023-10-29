package entities;

public class Cd extends BookstoreItem implements SalesManager{
    public int volume;
    public Cd(String name, String author, String yearPublication, Boolean availability, int amount, double price, int volume){
        super(name, author, yearPublication, availability, amount, price);
        this.volume = volume;
    }
    
    public int getVolume(){
        return volume;
    }
    public void setVolume(int volume){
        this.volume = volume;
    }
    
    @Override
    public void checkAvailability(){
        int ava = getAmount();
        if(ava>0){
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
