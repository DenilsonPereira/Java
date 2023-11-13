package entities;

public class Sale {
	private String nameProduct, nameSeller;
	private double price;

	public Sale(String nameProduct, String nameSeller, double price) {
		this.nameProduct = nameProduct;
		this.nameSeller = nameSeller;
		this.price = price;
	}

	public String getNameProduct() {
		return nameProduct;
	}

	public String getNameSeller() {
		return nameSeller;
	}
	
	public double getPrice() {
		return price;
	}
}