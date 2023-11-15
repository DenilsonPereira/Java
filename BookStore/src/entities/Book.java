package entities;

import java.util.ArrayList;
import java.util.Scanner;

public class Book extends BookstoreItem implements Manage {
	private String isbn, gender;
	Scanner sc = new Scanner(System.in);

	public Book(String name, String author, String yearPublication, Boolean availability, int amount, double price,
			String isbn, String gender) {
		super(name, author, yearPublication, availability, amount, price);
		this.isbn = isbn;
		this.gender = gender;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public void checkAvailability() {
		if (getAmount() > 0) {
			Book.this.setAvailability(true);
		} else {
			Book.this.setAvailability(false);
		}
	}

	@Override
	public void addItem(ArrayList<BookstoreItem> items) {
		System.out.println("----------- Register Book -----------");
		String name = null, author = null, yearPublication = null, isbn = null, gender = null;
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
					System.out.println("ISBN: ");
					isbn = sc.nextLine();
					try {
						isbn = VerifyIsbn.verify(isbn);
						break;
					} catch (IllegalArgumentException e) {
						System.out.println("Erro: " + e.getMessage());
					}
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

				while (true) {
					System.out.println("Gender: ");
					gender = sc.nextLine();

					if (gender.equals("")) {
						System.out.println("Gender needs to be informed! Enter the valid gender.");
					} else {
						break;
					}
				}

				boolean availability = true;
				Book newBook = new Book(name, author, yearPublication, availability, amount, price, isbn, gender);
				items.add(newBook);
				System.out.println("\nBook registered successfully!" + "\n-----------------------------------------");
				break;

			} catch (NumberFormatException e) {
				System.out.println("Invalid value. Enter a valid number.");
			}
		}
	}

	@Override
	public void sellItem(ArrayList<BookstoreItem> items, ArrayList<Seller> sellers, ArrayList<Sale> sale) {
		boolean hasBooks = false;
		for (BookstoreItem item : items) {
			if (item instanceof Book) {
				hasBooks = true;
				break;
			}
		}

		if (!hasBooks) {
			System.out.println("There are no books registered at the moment.");
			return;
		}

		String isbn;
		while (true) {
			System.out.println("Enter the isbn of the book: ");
			isbn = sc.nextLine();
			try {
				isbn = VerifyIsbn.verify(isbn);
				break;
			} catch (IllegalArgumentException e) {
				System.out.println("Error: " + e.getMessage());
			}
		}

		Book bookToSell = findBookIsbn(items, isbn);

		if (bookToSell != null) {
			if (bookToSell.getAvailability()) {
				int sellQuantity = 0;
				do {
					System.out.printf("Tell us how many books %s wants to buy?\n", bookToSell.getName());
					try {
						sellQuantity = sc.nextInt();
						if (sellQuantity <= 0) {
							throw new Exception("The quantity cannot be negative or zero.");
						}
						if (sellQuantity > bookToSell.getAmount()) {
				            throw new Exception("The quantity requested is not available.");
				        }
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				} while (sellQuantity <= 0 || sellQuantity > bookToSell.getAmount());
				sc.nextLine();

				boolean validSeller = false;
				while (!validSeller) {
					System.out.println("Inform the seller CPF: ");
					String cpf = sc.nextLine();

					Seller seller = FindSellerByCPF.findCPF(sellers, cpf);

					if (seller != null) {

						Sale saleH = new Sale(bookToSell.getName(), seller.getName(),
								(bookToSell.getPrice() * sellQuantity), sellQuantity);
						sale.add(saleH);

						validSeller = true;
						System.out.println("Sale Successfully Completed!");
					} else {
						System.out.println("Invalid seller, please re-enter!");
					}
				}
			} else {
				System.out.println("The book is not available!");
			}
		} else {
			System.out.println("The book is not registered!");
		}
	}

	@Override
	public String toString() {
		return "Name: " + this.getName() + "\nAuthor: " + this.getAuthor() + "\nYear publication: "
				+ this.getYearPublication() + "\nAvailability: " + this.getAvailability() + "\nAmount: "
				+ this.getAmount() + "\nPrice: $" + this.getPrice() + "\nISBN: " + this.getIsbn() + "\nGender: "
				+ this.getGender();
	}

	private static Book findBookIsbn(ArrayList<BookstoreItem> items, String isbn) {
		for (BookstoreItem item : items) {
			if (item instanceof Book) {
				Book book = (Book) item;
				if (isbn.equalsIgnoreCase(book.getIsbn())) {
					return book;
				}
			}
		}
		return null;
	}
}