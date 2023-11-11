package entities;

import java.util.List;

public interface SalesManager {
	public void sellItem(int q);

	public void returnItem(int q);
	
	double calculateSalesTotal();
    int calculateTotalItemsSold();
    double calculateRevenueByItem(String itemName);

    List<Sale> getSales();
    List<ReturnedItem> getReturnedItems();
}