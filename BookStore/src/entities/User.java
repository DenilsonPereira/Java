package entities;

public class User {
	 private String name, cpf, typeUser;
	    
	    public User(String name, String cpf, String typeUser){
	        this.name = name;
	        this.cpf = cpf;
	        this.typeUser = typeUser;
	    }
	    
	    public String getName(){
	        return name;
	    }
	    public void setName(String name){
	        this.name = name;
	    }
	    
	    public String getCpf(){
	        return cpf;
	    }
	    public void setCpf(String cpf){
	        this.cpf = cpf;
	    }
	    
	    public String getTypeUser(){
	        return typeUser;
	    }
	    public void setHistoryLoan(String typeUser){
	        this.typeUser = typeUser;
	    }
}
