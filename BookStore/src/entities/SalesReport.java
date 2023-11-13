package entities;

public class SalesReport {
	private String nameProd, nameSeller;
	private double totalSales;
	private int totalItem;

	public SalesReport( String nameProd,String nameSeller, double totalSales, int totalItem) {
		this.nameProd = nameProd;
		this.nameSeller = nameSeller;
		this.totalSales = totalSales;
		this.totalItem = totalItem;
	}

	public double getTotalSales() {
		return totalSales;
	}

	public int getTotalItem() {
		return totalItem;
	}

	public void setTotalSales(double total) {
		this.totalSales = total;
	}

	public void setTotalItem(int total) {
		this.totalItem = total;
	}

	public void updateSales(double salesAmount, int soldItems) {
		this.totalSales += salesAmount;
		this.totalItem += soldItems;
	}

	public String getNameProd() {
		return nameProd;
	}

	public void setNameProd(String nameProd) {
		this.nameProd = nameProd;
	}

	public String getNameSeller() {
		return nameSeller;
	}

	public void setNameSeller(String nameSeller) {
		this.nameSeller = nameSeller;
	}
}