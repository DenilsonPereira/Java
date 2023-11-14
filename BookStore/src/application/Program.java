package application;

import entities.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<BookstoreItem> item = new ArrayList<BookstoreItem>();
		ArrayList<Seller> sellers = new ArrayList<Seller>();
		ArrayList<Sale> sales = new ArrayList<Sale>();
		int option;

		System.out.println("----------- Bookstore System -----------");
		registerSeller(sc, sellers);

		while (true) {
			try {
				System.out.println("\n----------- Bookstore System -----------" + "\n1 - Register Seller"
						+ "\n2 - Register bookstore item" + "\n3 - Sell"
						+ "\n4 - Sales history" + "\n5 - List bookstore items" + "\n6 - List sellers" + "\n0 - Exit"
						+ "\n--------------------------------------" + "\nEnter the desired option:");

				option = sc.nextInt();
				sc.nextLine();

				switch (option) {
				case 0:
					System.exit(0);

				case 1:

					registerSeller(sc, sellers);
					break;

				case 2:

					registerItem(sc, item);
					break;
				case 3:

					sellItem(sc, item, sellers, sales);
					break;

				case 4:

					salesHistory(sales);
					break;

				case 5:

					listBookstoreItems(item);
					break;

				case 6:
					listSellers(sellers);
					break;

				default:
					System.out.println("Invalid option");
					break;

				}
			} catch (InputMismatchException e) {
				System.out.println("You entered a letter, please enter a number!");
				sc.nextLine();
			}
		}
	}

	private static void registerSeller(Scanner sc, ArrayList<Seller> sellers) {
		System.out.println("----------- Register Seller -----------");
		System.out.print("Name: ");
		String name = sc.nextLine();
		String cpf;
		while (true) {
			System.out.print("Cpf: ");
			cpf = sc.nextLine();
			try {
				cpf = verifyCpf(cpf);
				if (isCpfAlreadyRegistered(cpf, sellers)) {
					System.out.println("CPF already registered for another seller. Please enter a different CPF.");
				} else {
					break;
				}
			} catch (IllegalArgumentException e) {
				System.out.println("Erro: " + e.getMessage());
			}
		}
		Seller seller = new Seller(name, cpf);

		sellers.add(seller);

		System.out.println("\nSeller registered successfully!");
	}

	private static void registerItem(Scanner sc, ArrayList<BookstoreItem> items) {
		System.out.println("------------ Register Bookstore Item ------------" + "\n1 - Register Book"
				+ "\n2 - Register Magazine" + "\n3 - Register Cd" + "\n0 - Return" + "\nEnter the desired option: ");

		int option = sc.nextInt();
		sc.nextLine();

		switch (option) {
		case 1:
			registerBook(sc, items);
			break;
		case 2:
			registerMagazine(sc, items);
			break;
		case 3:
			registerCd(sc, items);
			break;
		default:
			System.out.println("Invalid option!");
			break;
		}
	}

	private static void registerBook(Scanner sc, ArrayList<BookstoreItem> items) {
		System.out.println("----------- Register Book -----------");
		String name = null, author = null, yearPublication = null, isbn = null, gender = null;
		Integer amount = 0;
		Double price = 0.0;
		while (true) {
			try {
				System.out.println("Name: ");
				name = sc.nextLine();

				System.out.println("Author: ");
				author = sc.nextLine();

				System.out.println("Year publication: ");
				yearPublication = sc.nextLine();

				while (true) {
					System.out.println("ISBN: ");
					isbn = sc.nextLine();
					try {
						isbn = verifyIsbn(isbn);
						break;
					} catch (IllegalArgumentException e) {
						System.out.println("Erro: " + e.getMessage());
					}
				}

				while (true) {
					System.out.println("Price: ");
					price = Double.parseDouble(sc.nextLine());
					if (price >= 0.0) {
						break;
					} else {
						System.out.println("Price must be greater than zero!");
					}
				}

				while (true) {
					System.out.println("Amount: ");
					amount = Integer.parseInt(sc.nextLine());
					if (amount > 0) {
						break;
					} else {
						System.out.println("Quantity must be greater than zero!");
					}
				}

				System.out.println("Gender: ");
				gender = sc.nextLine();
				if (name.isEmpty() || price <= 0 || amount <= 0) {
					throw new BusinessException("Invalid Input!");
				}

				break;
			} catch (NumberFormatException e) {
				System.out.println("Invalid value. Enter a valid number.");
			} catch (BusinessException e) {
				System.out.println("Business rule error: " + e.getMessage());
			}
		}

		boolean availability = true;
		Book book = new Book(name, author, yearPublication, availability, amount, price, isbn, gender);
		items.add(book);

		System.out.println("\nBook registered successfully!" + "\n-----------------------------------------");
	}

	private static void registerMagazine(Scanner sc, ArrayList<BookstoreItem> items) {
		System.out.println("----------- Register Magazine -----------");
		String name = null, author = null, yearPublication = null, edition = null;
		Integer amount = 0;
		Double price = 0.0;
		boolean enter = false;
		while (!enter) {
			try {
				System.out.println("Name: ");
				name = sc.nextLine();

				System.out.println("Author: ");
				author = sc.nextLine();

				System.out.println("Year publication: ");
				yearPublication = sc.nextLine();

				System.out.println("Edition: ");
				edition = sc.nextLine();

				while (true) {
					System.out.println("Price: ");
					price = Double.parseDouble(sc.nextLine());
					if (price >= 0.0) {
						break;
					} else {
						System.out.println("Price must be greater than zero!");
					}
				}

				while (true) {
					System.out.println("Amount: ");
					amount = Integer.parseInt(sc.nextLine());
					if (amount > 0) {
						break;
					} else {
						System.out.println("Quantity must be greater than zero!");
					}
				}

				if (name.isEmpty() || price <= 0 || amount <= 0) {
					throw new BusinessException("Invalid Input");
				}

				enter = true;
			} catch (NumberFormatException e) {
				System.out.println("Invalid value. Enter a valid number.");
			} catch (BusinessException e) {
				System.out.println("Business rule error: " + e.getMessage());
			}
		}

		boolean availability = true;

		Magazine magazine = new Magazine(name, author, yearPublication, availability, amount, price, edition);
		items.add(magazine);

		System.out.println("\nMagazine registered successfully!" + "\n-----------------------------------------");
	}

	private static void registerCd(Scanner sc, ArrayList<BookstoreItem> items) {
		System.out.println("----------- Register Cd -----------");

		String name = null, author = null, yearPublication = null;
		Integer amount = 0, volume = 0;
		Double price = 0.0;
		while (true) {
			try {
				System.out.println("Name: ");
				name = sc.nextLine();

				System.out.println("Author: ");
				author = sc.nextLine();

				System.out.println("Year publication: ");
				yearPublication = sc.nextLine();

				System.out.println("Volume: ");
				volume = Integer.parseInt(sc.nextLine());

				while (true) {
					System.out.println("Price: ");
					price = Double.parseDouble(sc.nextLine());
					if (price >= 0.0) {
						break;
					} else {
						System.out.println("Price must be greater than zero!");
					}
				}

				while (true) {
					System.out.println("Amount: ");
					amount = Integer.parseInt(sc.nextLine());
					if (amount > 0) {
						break;
					} else {
						System.out.println("Quantity must be greater than zero!");
					}
				}

				if (name.isEmpty() || price <= 0 || amount <= 0) {
					throw new BusinessException("Invalid Input");
				}

				break;
			} catch (NumberFormatException e) {
				System.out.println("Invalid value. Enter a valid number.");
			} catch (BusinessException e) {
				System.out.println("Business rule error: " + e.getMessage());
			}
		}

		boolean availability = true;

		Cd cd = new Cd(name, author, yearPublication, availability, amount, price, volume);

		items.add(cd);
		System.out.println("\nCd registered successfully!" + "\n-----------------------------------------");
	}

	private static void sellItem(Scanner sc, ArrayList<BookstoreItem> items, ArrayList<Seller> sellers, ArrayList<Sale> sale) {
		while (true) {
			if (items.size() == 0) {
				System.out.println("No items registered or available!");
				break;
			} else {
				System.out.println(
						"----------- Sell -----------" + "\n1 - Book" + "\n2 - Magazine" + "\n3 - Cd" + "\n0 - Return"
								+ "\n-----------------------------------------------" + "\nEnter the desired option:");

				int option = sc.nextInt();
				sc.nextLine();
				switch (option) {
				case 0:
					return;
				case 1:

					sellBook(sc, items, sellers, sale);
					return;

				case 2:

					sellMagazine(sc, items, sellers, sale);
					return;

				case 3:
					sellCd(sc, items, sellers, sale);
					return;
				default:
					System.out.println("Invalid option!");
					break;
				}
			}
		}

	}

	private static void sellBook(Scanner sc, ArrayList<BookstoreItem> items, ArrayList<Seller> sellers, ArrayList<Sale> sale) {
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
		System.out.println("Enter the isbn of the book: ");
		String isbn = sc.nextLine();

		Book bookToSell = findBookByISBN(items, isbn);

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
				    } catch (Exception e) {
				        System.out.println(e.getMessage());
				    }
				} while (sellQuantity <= 0);
				sc.nextLine();
				bookToSell.sellItem(sellQuantity);

				boolean validSeller = false;
				while (!validSeller) {
					System.out.println("Inform the seller CPF: ");
					String cpf = sc.nextLine();

					Seller seller = findSellerByCPF(sellers, cpf);

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

	private static void sellMagazine(Scanner sc, ArrayList<BookstoreItem> items, ArrayList<Seller> sellers,
			ArrayList<Sale> sale) {
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
					System.out.printf("Tell us how many magazines %s wants to buy?\n", magazineToSell.getName());
				    try {
				        sellQuantity = sc.nextInt();
				        if (sellQuantity <= 0) {
				            throw new Exception("The quantity cannot be negative or zero.");
				        }
				    } catch (Exception e) {
				        System.out.println(e.getMessage());
				    }
				} while (sellQuantity <= 0);
				sc.nextLine();
				magazineToSell.sellItem(sellQuantity);

				boolean validSeller = false;
				while (!validSeller) {
					System.out.println("Inform the seller CPF: ");
					String cpf = sc.nextLine();

					Seller seller = findSellerByCPF(sellers, cpf);

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

	private static void sellCd(Scanner sc, ArrayList<BookstoreItem> items, ArrayList<Seller> sellers, ArrayList<Sale> sale) {
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
					System.out.printf("Tell us how many cd's %s wants to buy?\n", cdToSell.getName());
				    try {
				        sellQuantity = sc.nextInt();
				        if (sellQuantity <= 0) {
				            throw new Exception("The quantity cannot be negative or zero.");
				        }
				    } catch (Exception e) {
				        System.out.println(e.getMessage());
				    }
				} while (sellQuantity <= 0);
				sc.nextLine();
				cdToSell.sellItem(sellQuantity);

				boolean validSeller = false;
				while (!validSeller) {
					System.out.println("Inform the seller CPF: ");
					String cpf = sc.nextLine();

					Seller seller = findSellerByCPF(sellers, cpf);

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

	private static void salesHistory(ArrayList<Sale> sales) {

		System.out.println("----------- Sales history -----------");
		for (Sale s : sales) {
			System.out.printf("\nSeller: %s | Item: %s | Value: $%s | Quantity: %s",  s.getNameSeller(), s.getNameProduct(), s.getPrice(), s.getAmount());
			System.out.println("\n------------------------------------");
		}
		Sale s = sales.get(0);
		System.out.printf("TOTAL ITEM: %s | TOTAL PRICE: $%s", s.totalItems(), s.totalSale());
	}

	private static void listBookstoreItems(ArrayList<BookstoreItem> items) {
		System.out.println("----------- List bookstore items -----------");
		if (items.size() == 0) {
			System.out.println("No items registered!");
		} else {
			for (BookstoreItem l : items) {
				if (l instanceof Book) {
					Book b = (Book) l;
					System.out.println("---------------------\n" + b.toString() + "\n---------------------");

				} else if (l instanceof Magazine) {
					Magazine m = (Magazine) l;
					System.out.println("---------------------\n" + m.toString() + "\n---------------------");

				} else if (l instanceof Cd) {
					Cd c = (Cd) l;
					System.out.println("---------------------\n" + c.toString() + "\n---------------------");
				}
			}
		}
	}

	private static void listSellers(ArrayList<Seller> sellers) {
		System.out.println("----------- List sellers -----------");
		for (Seller s : sellers) {
			System.out.printf("\n-------------------------------------\n Name: %s | CPF: %s ", s.getName(), s.getCpf());
		}
		System.out.println("\n-------------------------------------");
	}

	private static String verifyCpf(String cpf) {
		cpf = cpf.replaceAll("[^0-9]", "");

		if (cpf.length() != 11) {

			throw new IllegalArgumentException("CPF must contain 11 numerical digits.");
		}

		return cpf;
	}

	private static boolean isCpfAlreadyRegistered(String cpf, ArrayList<Seller> sellers) {
		for (Seller seller : sellers) {
			if (seller.getCpf().equals(cpf)) {
				return true;
			}
		}
		return false;
	}

	private static String verifyIsbn(String isbn) {
		isbn = isbn.replaceAll("[^0-9]", "");

		if (isbn.length() != 10) {

			throw new IllegalArgumentException("ISBN must contain 10 digits.");
		}

		return isbn;
	}

	private static Book findBookByISBN(ArrayList<BookstoreItem> items, String isbn) {
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

	private static Seller findSellerByCPF(ArrayList<Seller> sellers, String cpf) {
		for (Seller seller : sellers) {
			if (cpf.equalsIgnoreCase(seller.getCpf())) {
				return seller;
			}
		}
		return null;
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