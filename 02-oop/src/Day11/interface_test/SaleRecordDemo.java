package Day11.interface_test;

public class SaleRecordDemo {
	public static void main(String[] args) {
		SaleRecord[] records = new SaleRecord[3];
		
		Product p1 = new Product("Coffee", 1250);
		Product p2 = new Product("Pizza", 12300);
		
		records[0] = new SaleRecord(1001, 3, p1);
		records[1] = new SaleRecord(1002, 1, p2);
		records[2] = new SaleRecord(1003, 2, p1);
		
		System.out.println("No.\t SaleDate\t Product\t Price\t Qty\t SubTotal");
		System.out.println("----------------------------------------------------");
		for(var rec : records)
			rec.showData();
	}
}
