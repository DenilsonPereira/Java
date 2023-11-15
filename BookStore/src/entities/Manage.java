package entities;

import java.util.ArrayList;

public interface Manage {
	public void sellItem(ArrayList<BookstoreItem> items, ArrayList<Seller> sellers, ArrayList<Sale> sale);

	public void addItem(ArrayList<BookstoreItem> items);
}