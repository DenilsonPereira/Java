package entities;

import java.util.ArrayList;

public class FindSellerByCPF {
	public static Seller findCPF(ArrayList<Seller> sellers, String cpf) {
		for (Seller seller : sellers) {
			if (cpf.equalsIgnoreCase(seller.getCpf())) {
				return seller;
			}
		}
		return null;
	}
}
