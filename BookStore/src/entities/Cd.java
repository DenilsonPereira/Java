package entities;

public class Cd extends BookstoreItem implements SalesManager {
	public int volume;

	public Cd(String name, String author, String yearPublication, Boolean availability, int amount, double price,
			int volume) {
		super(name, author, yearPublication, availability, amount, price);
		this.volume = volume;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	@Override
	public void checkAvailability() {
		if (getAmount() > 0) {
			Cd.this.setAvailability(true);
		} else {
			Cd.this.setAvailability(false);
		}
	}

	@Override
	public void returnItem(int q) {
		Cd.this.setAmount(getAmount() + q);
		System.out.printf("Returned cd %s", getName());
	}

	@Override
	public void sellItem(int q) {
		if (getAmount() >= q) {
			Cd.this.setAmount(getAmount() - q);
			if (getAmount() == 0) {
				Cd.this.setAvailability(false);
			}
		}
		System.out.printf("Cd %s sold!", getName());
	}

	@Override
	public String toString() {
		return "Name: " + this.getName() + "\nAuthor: " + this.getAuthor() + "\nYear publication: "
				+ this.getYearPublication() + "\nAvailability: " + this.getAvailability() + "\nAmount: "
				+ this.getAmount() + "\nPrice: $" + this.getPrice() + "\nVolume: " + this.getVolume();
	}
}