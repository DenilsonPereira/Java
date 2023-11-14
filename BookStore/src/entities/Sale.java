package entities;

public class Sale {
	private String nameProduct, nameSeller;
	private double price;
	private int amount;
	private static double totalSold = 0;
	private static int totalItem = 0;

	public Sale(String nameProduct, String nameSeller, double price, int amount) {
		this.nameProduct = nameProduct;
		this.nameSeller = nameSeller;
		this.price = price;
		this.amount = amount;
		totalItem += amount;
		totalSold += price;
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
	
	public int getAmount() {
		return amount;
	}
	public int totalItems() {
		return totalItem;
	}
	
	
	public double totalSale() {
		return totalSold;
	}
}