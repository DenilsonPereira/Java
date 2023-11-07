package entities;

public class Magazine extends BookstoreItem implements SalesManager {
	private String edition;

	public Magazine(String name, String author, String yearPublication, Boolean availability, int amount, double price,
			String edition) {
		super(name, author, yearPublication, availability, amount, price);
		this.edition = edition;
	}

	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}

	@Override
	public void checkAvailability() {
		if (getAmount() > 0) {
			Magazine.this.setAvailability(true);
		} else {
			Magazine.this.setAvailability(false);
		}
	}

	@Override
	public void returnItem(int q) {
		Magazine.this.setAmount(getAmount() + q);
		System.out.printf("Returned book %s", getName());
	}

	@Override
	public void sellItem(int q) {
		if (getAmount() >= q) {
			Magazine.this.setAmount(getAmount() - q);
			if (getAmount() == 0) {
				Magazine.this.setAvailability(false);
			}
		}
		System.out.printf("Book %s sold!", getName());
	}

	@Override
	public String toString() {
		return "Name: " + this.getName() + "\nAuthor: " + this.getAuthor() + "\nYear publication: "
				+ this.getYearPublication() + "\nAvailability: " + this.getAvailability() + "\nAmount: "
				+ this.getAmount() + "\nPrice: $" + this.getPrice() + "\nEdition: " + this.getEdition();
	}
}
