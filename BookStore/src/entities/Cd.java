package entities;

public class Cd extends BookstoreItem implements SalesManager{
    public int volume, numberTracks, amount;
    public Cd(String name, String author, String yearPublication, Boolean availability, int volume, int numberTracks, int amount){
        super(name, author, yearPublication, availability);
        this.volume = volume;
        this.numberTracks = numberTracks;
        this.amount = amount;
    }
    
    public int getVolume(){
        return volume;
    }
    public void setVolume(int volume){
        this.volume = volume;
    }
    
    public int getNumberTracks(){
        return numberTracks;
    }
    public void setNumberTracks(int numberTracks){
        this.numberTracks = numberTracks;
    }
    
    public int getAmount(){
        return amount;
    }
    public void setAmount(int amount){
        this.amount = amount;
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
