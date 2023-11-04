package entities;

public class Sale {
	private String nameProduct, nameSeller;

	public Sale(String nameProduct, String nameSeller) {
		this.nameProduct = nameProduct;
		this.nameSeller = nameSeller;
	}

	public String getNameProduct() {
		return nameProduct;
	}

	public String getNameSeller() {
		return nameSeller;
	}
}