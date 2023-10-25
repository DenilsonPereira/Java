package entities;

public abstract class BookstoreItem {


	private String name, author, yearPublication;
    private Boolean availability;
    
    public BookstoreItem(String name, String author, String yearPublication, Boolean availability){
        this.name = name;
        this.author = author;
        this.yearPublication = yearPublication;
        this.availability = availability;
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
    
    public abstract void checkAvailability();
}
