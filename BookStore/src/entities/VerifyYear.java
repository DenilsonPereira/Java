package entities;

public class VerifyYear {
	public static String verify(String year) {
		year = year.replaceAll("[^0-9]", "");

		if (year.length() != 4) {

			throw new IllegalArgumentException("Year Publication must contain 4 digits!");
		}

		return year;
	}
}
