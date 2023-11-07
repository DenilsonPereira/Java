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
						+ "\n2 - Register bookstore item" + "\n3 - Sell" + "\n4 - Give back"
						+ "\n5 - Seller's sales history" + "\n6 - List bookstore items" + "\n7 - List sellers"
						+ "\n0 - Exit" + "\n--------------------------------------" + "\nEnter the desired option:");

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

					sellItem(sc, item, sales, sellers);
					break;

				case 4:

					giveBackItem(sc, item);
					break;

				case 5:

					salesHistory(sc, sales);
					break;

				case 6:

					listBookstoreItems(item);
					break;

				case 7:
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
				break;
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

	private static void sellItem(Scanner sc, ArrayList<BookstoreItem> items, ArrayList<Sale> sales,
			ArrayList<Seller> sellers) {
		if (items.size() == 0) {
			System.out.println("No items registered or available!");
		} else {
			System.out.println(
					"----------- Sell -----------" + "\n1 - Book" + "\n2 - Magazine" + "\n3 - Cd" + "\n0 - Return"
							+ "\n-----------------------------------------------" + "\nEnter the desired option:");

			int option = sc.nextInt();
			sc.nextLine();
			switch (option) {
			default:
				break;
			case 1:

				sellBook(sc, items, sales, sellers);
				break;

			case 2:

				sellMagazine(sc, items, sales, sellers);
				break;

			case 3:
				sellCd(sc, items, sales, sellers);
				break;
			}
		}

	}

	private static void sellBook(Scanner sc, ArrayList<BookstoreItem> item, ArrayList<Sale> sales,
			ArrayList<Seller> sellers) {
		System.out.println("Enter the isbn of the book: ");
		String isbn = sc.nextLine();

		for (BookstoreItem li : item) {
			if (li instanceof Book) {
				Book b = (Book) li;
				if (isbn.equalsIgnoreCase(b.getIsbn())) {
					if (b.getAvailability() == true) {
						System.out.printf("Tell us how many books %s wants to buy?", b.getName());
						int sellB = sc.nextInt();
						sc.nextLine();
						b.sellItem(sellB);
						Boolean input = false;
						while (!input) {
							System.out.println("Inform the seller CPF: ");
							String cpf = sc.nextLine();
							for (Seller s : sellers) {
								if (cpf.equalsIgnoreCase(s.getCpf())) {
									Sale sale = new Sale(b.getName(), s.getName());
									sales.add(sale);
									input = true;
									System.out.println("Sale Successfully Completed!");
									break;
								}
							}
							if (!input) {
								System.out.println("Invalid seller, please re-enter!");
							}
						}
					} else {
						System.out.println("The book is not availability! ");
					}
				} else {
					System.out.println("The book is not registered! ");
				}
			}
		}
	}

	private static void sellMagazine(Scanner sc, ArrayList<BookstoreItem> item, ArrayList<Sale> sales,
			ArrayList<Seller> sellers) {
		System.out.println("Enter the name of the magazine: ");
		String name = sc.nextLine();

		for (BookstoreItem li : item) {
			if (li instanceof Magazine) {
				Magazine m = (Magazine) li;
				if (name.equalsIgnoreCase(m.getName())) {
					if (m.getAvailability() == true) {
						System.out.printf("Tell us how many magazines %s wants to buy?", m.getName());
						int sellM = sc.nextInt();
						sc.nextLine();
						m.sellItem(sellM);
						Boolean input = false;
						while (!input) {
							System.out.println("Inform the seller CPF: ");
							String cpf = sc.nextLine();
							for (Seller s : sellers) {
								if (cpf.equalsIgnoreCase(s.getCpf())) {
									Sale sale = new Sale(m.getName(), s.getName());
									sales.add(sale);
									input = true;
									System.out.println("Sale Successfully Completed!");
									break;
								}
							}
							if (!input) {
								System.out.println("Invalid seller, please re-enter!");
							}
						}
					} else {
						System.out.println("The magazine is not availability! ");
					}
				} else {
					System.out.println("The magazine is not registered! ");
				}
			}
		}
	}

	private static void sellCd(Scanner sc, ArrayList<BookstoreItem> item, ArrayList<Sale> sales,
			ArrayList<Seller> sellers) {
		System.out.println("Enter the name of the CD: ");
		String name = sc.nextLine();

		for (BookstoreItem li : item) {
			if (li instanceof Cd) {
				Cd c = (Cd) li;
				if (name.equalsIgnoreCase(c.getName())) {
					if (c.getAmount() > 0) {
						System.out.printf("Tell us how many cd's %s wants to buy?", c.getName());
						int sellC = sc.nextInt();
						sc.nextLine();
						c.sellItem(sellC);
						Boolean input = false;
						while (!input) {
							System.out.println("Inform the seller CPF: ");
							String cpf = sc.nextLine();
							for (Seller s : sellers) {
								if (cpf.equalsIgnoreCase(s.getCpf())) {
									Sale sale = new Sale(c.getName(), s.getName());
									sales.add(sale);
									input = true;
									System.out.println("Sale Successfully Completed!");
									break;
								}
							}
							if (!input) {
								System.out.println("Invalid seller, please re-enter!");
							}
						}
					} else {
						System.out.println("The cd is not availability! ");
					}
				} else {
					System.out.println("The book is not registered! ");
				}
			}
		}
	}

	private static void giveBackItem(Scanner sc, ArrayList<BookstoreItem> items) {
		if (items.size() == 0) {
			System.out.println("No items registered!");
		} else {
			System.out.println(
					"----------- Give back -----------" + "\n1 - Book" + "\n2 - Magazine" + "\n3 - Cd" + "\n0 - Return"
							+ "\n-----------------------------------------------" + "\nEnter the desired option:");

			int option = sc.nextInt();
			sc.nextLine();
			switch (option) {
			default:
				break;
			case 1:
				giveBackBook(sc, items);
				break;
			case 2:
				giveBackMagazine(sc, items);
				break;
			case 3:
				giveBackCd(sc, items);
				break;
			}
		}

	}

	private static void giveBackBook(Scanner sc, ArrayList<BookstoreItem> item) {
		System.out.println("Enter the isbn of the book: ");
		String isbn = sc.nextLine();

		for (BookstoreItem li : item) {
			Book b = (Book) li;
			if (isbn.equalsIgnoreCase(b.getIsbn())) {

				System.out.printf("How many %s books do you want to return?", b.getName());
				int bookReturn = sc.nextInt();
				sc.nextLine();
				b.returnItem(bookReturn);

			} else {
				System.out.println("The isbn of the book provided does not exist!");
			}
		}
	}

	private static void giveBackMagazine(Scanner sc, ArrayList<BookstoreItem> item) {
		System.out.println("Enter the name of the magazine: ");
		String name = sc.nextLine();

		for (BookstoreItem li : item) {
			Magazine m = (Magazine) li;
			if (name.equalsIgnoreCase(m.getName())) {
				System.out.printf("How many %s books do you want to return?", m.getName());
				int magazineReturn = sc.nextInt();
				sc.nextLine();
				m.returnItem(magazineReturn);
			} else {
				System.out.println("The name of the magazine provided does not exist!");
			}
		}
	}

	private static void giveBackCd(Scanner sc, ArrayList<BookstoreItem> item) {
		System.out.println("Enter the name of the CD: ");
		String name = sc.nextLine();

		for (BookstoreItem li : item) {
			Cd c = (Cd) li;
			if (name.equalsIgnoreCase(c.getName())) {
				System.out.printf("How many %s books do you want to return?", c.getName());
				int cdReturn = sc.nextInt();
				sc.nextLine();
				c.returnItem(cdReturn);
			} else {
				System.out.println("The name of the cd provided does not exist!");
			}
		}
	}

	private static void salesHistory(Scanner sc, ArrayList<Sale> sales) {

		System.out.println("----------- Sales history -----------");
		for (Sale s : sales) {
			System.out.printf("Item: %s, Vendedor: %s", s.getNameProduct(), s.getNameSeller());
		}

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
			System.out.printf(
					"-------------------------------------\n Name: %s | CPF: %s \n-------------------------------------",
					s.getName(), s.getCpf());
		}
	}

	private static String verifyCpf(String cpf) {
		cpf = cpf.replaceAll("[^0-9]", "");

		if (cpf.length() != 11) {

			throw new IllegalArgumentException("CPF must contain 11 digits.");
		}

		return cpf;
	}

	private static String verifyIsbn(String isbn) {
		isbn = isbn.replaceAll("[^0-9]", "");

		if (isbn.length() != 10) {

			throw new IllegalArgumentException("ISBN must contain 10 digits.");
		}

		return isbn;
	}
}