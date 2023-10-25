package entities;

public class Seller extends User{
	public double discount;
	public Seller(String name, String cpf, String typeUser, double discount) {
		super(name, cpf, typeUser);
		this.discount = discount;
	}
	
	public double getDiscount() {
		return discount;
	}
}