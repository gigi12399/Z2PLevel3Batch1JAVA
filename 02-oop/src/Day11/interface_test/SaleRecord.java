package Day11.interface_test;

import java.time.LocalDate;

public class SaleRecord {
	int id;
	int saleQty;
	LocalDate saleDate;
	Product product;
	public SaleRecord(int id, int saleQty, Product product) {
		super();
		this.id = id;
		this.saleQty = saleQty;
		this.product = product;
		this.saleDate = LocalDate.now();
	}
	
	void showData() {
		System.out.print(id + "\t" + saleDate + "\t");
		System.out.print(product.name + "\t" + product.price + "\t");
		System.out.print(saleQty + "\t" + (product.price * saleQty) + "\n");
	}
	
}
