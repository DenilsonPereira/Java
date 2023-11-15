package application;

import entities.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
						+ "\n2 - Register bookstore item" + "\n3 - Sell" + "\n4 - Sales history"
						+ "\n5 - List bookstore items" + "\n6 - List sellers" + "\n7 - Best Selling Item" + "\n0 - Exit"
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

				case 7:
					BestSellingItem repeat = new BestSellingItem();
					repeat.method(sales);
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
		String name;
		while (true) {
			System.out.println("Name: ");
			name = sc.nextLine();
			if (name.equals("")) {
				System.out.println("Empty name is invalid, please enter a valid name!");
			} else {
				break;
			}
		}
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

			Book book = new Book(null, null, null, null, 0, 0.0, null, null);
			book.addItem(items);
			break;

		case 2:

			Magazine magazine = new Magazine(null, null, null, null, 0, 0.0, null);
			magazine.addItem(items);
			break;

		case 3:

			Cd cd = new Cd(null, null, null, null, 0, 0.0, 0);
			cd.addItem(items);
			break;

		default:
			System.out.println("Invalid option!");
			break;
		}
	}

	private static void sellItem(Scanner sc, ArrayList<BookstoreItem> items, ArrayList<Seller> sellers,
			ArrayList<Sale> sale) {
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

					Book book = new Book(null, null, null, null, 0, 0.0, null, null);
					book.sellItem(items, sellers, sale);
					return;

				case 2:

					Magazine magazine = new Magazine(null, null, null, null, 0, 0.0, null);
					magazine.sellItem(items, sellers, sale);
					return;

				case 3:

					Cd cd = new Cd(null, null, null, null, 0, 0.0, 0);
					cd.sellItem(items, sellers, sale);
					return;

				default:

					System.out.println("Invalid option!");
					break;
				}
			}
		}

	}

	private static void salesHistory(ArrayList<Sale> sales) {
		try {
			LocalDateTime now = LocalDateTime.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
			String dateFormatted = now.format(formatter);
			System.out.println("----------- Sales history -----------");
			System.out.println("Date: " + dateFormatted);
			for (Sale s : sales) {
				System.out.printf("\nSeller: %s | Item: %s | Value: $%s | Quantity: %s", s.getNameSeller(),
						s.getNameProduct(), s.getPrice(), s.getAmount());
				System.out.println("\n------------------------------------");
			}
			Sale s = sales.get(0);
			System.out.printf("TOTAL ITEM: %s | TOTAL PRICE: $%s\n", s.totalItems(), s.totalSale());
		} catch (IndexOutOfBoundsException e) {
			System.out.println("No items sold!");
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
			System.out.printf("\n-------------------------------------\n Name: %s | CPF: %s ", s.getName(), s.getCpf());
		}
		System.out.println("\n-------------------------------------");
	}

	private static String verifyCpf(String cpf) {
		cpf = cpf.replaceAll("[^0-9]", "");

		if (cpf.length() != 11) {

			throw new IllegalArgumentException("CPF must contain 11 numerical digits!");
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
}