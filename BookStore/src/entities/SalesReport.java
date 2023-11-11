package entities;

public class SalesReport {
	private double totalSales;
	private int totalItem;

	public SalesReport(double totalSales, int totalItem) {
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
}