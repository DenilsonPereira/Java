package entities;

public class VerifyIsbn {
	public static String verify(String isbn) {
		isbn = isbn.replaceAll("[^0-9]", "");

		if (isbn.length() != 10) {

			throw new IllegalArgumentException("ISBN must contain 10 digits!");
		}

		return isbn;
	}
}
