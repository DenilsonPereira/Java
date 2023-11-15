package entities;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Magazine extends BookstoreItem implements Manage {
	private String edition;
	Scanner sc = new Scanner(System.in);

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
	public void addItem(ArrayList<BookstoreItem> items) {
		System.out.println("----------- Register Magazine -----------");
		String name = null, author = null, yearPublication = null, edition = null;
		Integer amount = 0;
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
					System.out.println("Edition: ");
					edition = sc.nextLine();
					if (edition.equals("")) {
						System.out.println("Empty edition is invalid, please enter a valid edition!");
					} else {
						break;
					}
				}

				while (true) {
					try {
						System.out.println("Price: ");
						price = sc.nextDouble();
						sc.nextLine();
						if (price <= 0.0) {
							throw new IllegalArgumentException("Price cannot be zero or negative");
						}
						break;
					} catch (IllegalArgumentException e) {
						System.out.println("Erro: " + e.getMessage());
					} catch (InputMismatchException e) {
						System.out.println("You entered a letter, please enter a number!");
						sc.nextLine();
					}
				}

				while (true) {
					try {
						System.out.println("Amount: ");
						amount = sc.nextInt();
						sc.nextLine();
						if (amount <= 0) {
							throw new IllegalArgumentException("Quantity cannot be zero or negative");
						}
						break;
					} catch (IllegalArgumentException e) {
						System.out.println("Erro: " + e.getMessage());
					} catch (InputMismatchException e) {
						System.out.println("You entered a letter, please enter a number!");
						sc.nextLine();
					}
				}
				boolean availability = true;
				Magazine magazine = new Magazine(name, author, yearPublication, availability, amount, price, edition);
				items.add(magazine);

				System.out
						.println("\nMagazine registered successfully!" + "\n-----------------------------------------");
				break;
			} catch (NumberFormatException e) {
				System.out.println("Invalid value. Enter a valid number.");
			}
		}
	}

	@Override
	public void sellItem(ArrayList<BookstoreItem> items, ArrayList<Seller> sellers, ArrayList<Sale> sale) {
		boolean hasMagazine = false;
		for (BookstoreItem item : items) {
			if (item instanceof Magazine) {
				hasMagazine = true;
				break;
			}
		}

		if (!hasMagazine) {
			System.out.println("There are no magazines registered at the moment.");
			return;
		}
		System.out.println("Enter the name of the magazine: ");
		String name = sc.nextLine();

		Magazine magazineToSell = findMagazineByName(items, name);

		if (magazineToSell != null) {
			if (magazineToSell.getAvailability()) {
				int sellQuantity = 0;
				do {
					System.out.printf("Tell us how many books %s wants to buy?\n", magazineToSell.getName());
					try {
						sellQuantity = sc.nextInt();
						if (sellQuantity <= 0) {
							throw new Exception("The quantity cannot be negative or zero.");
						}
						if (sellQuantity > magazineToSell.getAmount()) {
							throw new Exception("The quantity requested is not available.");
						}
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				} while (sellQuantity <= 0 || sellQuantity > magazineToSell.getAmount());
				sc.nextLine();

				boolean validSeller = false;
				while (!validSeller) {
					System.out.println("Inform the seller CPF: ");
					String cpf = sc.nextLine();

					Seller seller = FindSellerByCPF.findCPF(sellers, cpf);

					if (seller != null) {

						Sale saleH = new Sale(magazineToSell.getName(), seller.getName(),
								(magazineToSell.getPrice() * sellQuantity), sellQuantity);
						sale.add(saleH);

						validSeller = true;
						System.out.println("Sale Successfully Completed!");
					} else {
						System.out.println("Invalid seller, please re-enter!");
					}
				}
			} else {
				System.out.println("The magazine is not available!");
			}
		} else {
			System.out.println("The magazine is not registered!");
		}
	}

	@Override
	public String toString() {
		return "Name: " + this.getName() + "\nAuthor: " + this.getAuthor() + "\nYear publication: "
				+ this.getYearPublication() + "\nAvailability: " + this.getAvailability() + "\nAmount: "
				+ this.getAmount() + "\nPrice: $" + this.getPrice() + "\nEdition: " + this.getEdition();
	}

	private static Magazine findMagazineByName(ArrayList<BookstoreItem> items, String name) {
		for (BookstoreItem item : items) {
			if (item instanceof Magazine) {
				Magazine magazine = (Magazine) item;
				if (name.equalsIgnoreCase(magazine.getName())) {
					return magazine;
				}
			}
		}
		return null;
	}
}
