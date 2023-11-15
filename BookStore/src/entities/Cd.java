package entities;

import java.util.ArrayList;
import java.util.Scanner;

public class Cd extends BookstoreItem implements Manage {
	public int volume;
	Scanner sc = new Scanner(System.in);

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
	public void addItem(ArrayList<BookstoreItem> items) {
		System.out.println("----------- Register Cd -----------");

		String name = null, author = null, yearPublication = null;
		Integer amount = 0, volume = 0;
		Double price = 0.0;
		while (true) {
			try {
				while (true) {
					System.out.println("Name: ");
					name = sc.nextLine();
					if (name.equals("")) {
						System.out.println("Empty name is invalid, please enter a valid name!");
					} else {
						break;
					}
				}

				while (true) {
					System.out.println("Author: ");
					author = sc.nextLine();
					if (author.equals("")) {
						System.out.println("Empty author name is invalid, please enter a valid name!");
					} else {
						break;
					}
				}

				while (true) {
					System.out.println("Year publication: ");
					yearPublication = sc.nextLine();
					try {
						yearPublication = VerifyYear.verify(yearPublication);
						break;
					} catch (IllegalArgumentException e) {
						System.out.println("Erro: " + e.getMessage());
					}
				}

				while (true) {
					System.out.println("Volume: ");
					volume = sc.nextInt();
					sc.nextLine();
					if (volume <= 0) {
						throw new IllegalArgumentException("Number cannot be negative");
					}
					break;
				}

				while (true) {
					System.out.println("Price: ");
					price = sc.nextDouble();
					sc.nextLine();
					try {
						if (price <= 0.0) {
							throw new IllegalArgumentException("Price cannot be zero or negative");
						}
						break;
					} catch (IllegalArgumentException e) {
						System.out.println("Erro: " + e.getMessage());
					}
				}

				while (true) {
					System.out.println("Amount: ");
					amount = sc.nextInt();
					sc.nextLine();
					try {
						if (amount <= 0) {
							throw new IllegalArgumentException("Quantity cannot be zero or negative");
						}
						break;
					} catch (IllegalArgumentException e) {
						System.out.println("Erro: " + e.getMessage());
					}
				}
				boolean availability = true;

				Cd cd = new Cd(name, author, yearPublication, availability, amount, price, volume);

				items.add(cd);
				System.out.println("\nCd registered successfully!" + "\n-----------------------------------------");
				break;
			} catch (NumberFormatException e) {
				System.out.println("Invalid value. Enter a valid number.");
			}
		}

	}

	@Override
	public void sellItem(ArrayList<BookstoreItem> items, ArrayList<Seller> sellers, ArrayList<Sale> sale) {
		boolean hasCd = false;
		for (BookstoreItem item : items) {
			if (item instanceof Cd) {
				hasCd = true;
				break;
			}
		}

		if (!hasCd) {
			System.out.println("There are no cd's registered at the moment.");
			return;
		}
		System.out.println("Enter the name of the cd: ");
		String name = sc.nextLine();

		Cd cdToSell = findCdByName(items, name);

		if (cdToSell != null) {
			if (cdToSell.getAvailability()) {
				int sellQuantity = 0;
				do {
					System.out.printf("Tell us how many books %s wants to buy?\n", cdToSell.getName());
					try {
						sellQuantity = sc.nextInt();
						if (sellQuantity <= 0) {
							throw new Exception("The quantity cannot be negative or zero.");
						}
						if (sellQuantity > cdToSell.getAmount()) {
				            throw new Exception("The quantity requested is not available.");
				        }
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				} while (sellQuantity <= 0 || sellQuantity > cdToSell.getAmount());
				sc.nextLine();

				boolean validSeller = false;
				while (!validSeller) {
					System.out.println("Inform the seller CPF: ");
					String cpf = sc.nextLine();

					Seller seller = FindSellerByCPF.findCPF(sellers, cpf);

					if (seller != null) {

						Sale saleH = new Sale(cdToSell.getName(), seller.getName(),
								(cdToSell.getPrice() * sellQuantity), sellQuantity);
						sale.add(saleH);

						validSeller = true;
						System.out.println("Sale Successfully Completed!");
					} else {
						System.out.println("Invalid seller, please re-enter!");
					}
				}
			} else {
				System.out.println("The cd is not available!");
			}
		} else {
			System.out.println("The cd is not registered!");
		}
	}

	@Override
	public String toString() {
		return "Name: " + this.getName() + "\nAuthor: " + this.getAuthor() + "\nYear publication: "
				+ this.getYearPublication() + "\nAvailability: " + this.getAvailability() + "\nAmount: "
				+ this.getAmount() + "\nPrice: $" + this.getPrice() + "\nVolume: " + this.getVolume();
	}

	private static Cd findCdByName(ArrayList<BookstoreItem> items, String name) {
		for (BookstoreItem item : items) {
			if (item instanceof Cd) {
				Cd cd = (Cd) item;
				if (name.equalsIgnoreCase(cd.getName())) {
					return cd;
				}
			}
		}
		return null;
	}
}