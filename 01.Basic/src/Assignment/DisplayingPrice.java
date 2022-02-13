package Assignment;

import java.util.Scanner;

public class DisplayingPrice {
	Scanner sc =new Scanner(System.in);
	String brand;
	String processor;
	double price;
	double currentPrice;
	double total;
	void searchBrand(String[] brands) {
		int count = 0;
		System.out.println("Enter Brand: ");
		this.brand = sc .nextLine();
		for(var b : brands) {
			if(b.equals(brand)) {
				count =-1;
			}	
		}
		if(count == 0) {
			System.out.println("Brand's name " + this.brand + " does not exit.");
			searchBrand(brands);
		}
	}
	
	void searchProcessor(String[] processors) {
		int count = 0;
		System.out.println("Enter Processors: ");
		this.processor = sc .nextLine();
		for(var b : processors) {
			if(b.equals(this.processor)) {
				count =-1;
			}	
		}
		if(count == 0) {
			System.out.println("Processor " + this.processor + " does not exit.");
			searchProcessor(processors);
		}
	}
	void searchPrice(String[] brands,String[] processors, double[][] prices) {
		for(int i = 0; i < brands.length; i++) {
			if(brands[i].equals(this.brand)){
				for(int j = 0; j < processors.length; j++) {
					if(processors[j].equals(this.processor)) {
						this.price = prices[i][j];
					}
				}
			}
		}
		System.out.println("\n" + "Brand: " + brand + "\t" + "Processor: " + processor + "\t" + "Price: " + "$" + price);
		System.out.println();
	}
	
	void calculate() {
		System.out.println("Enter currency exchange rate: ");
		this.currentPrice = sc.nextDouble();
		this.total = this.currentPrice * this.price;
		System.out.println("\n" + "Final Price: " + this.total + "Kyats");
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] processors = {"core i3", "core i5", "core i7", "core i9"};
		String[] brands = {"lenovo", "hp", "samsung", "acer", "dell", "asus"};
		double[][] prices = {
				{230.21,529.483,552.504,690.63},
				{400.21,920.483,960.504,1200.63},
				{294.2,676.66,706.08,882.6},
				{693.33,1594.659,1663.992,2079.99},
				{340.44,783.012,817.056,1021.32},
				{691.99,1591.577,1660.776,2075.97}
		};
		int copy;
		
		do {
			DisplayingPrice obj = new DisplayingPrice();
			obj.searchBrand(brands);
			obj.searchProcessor(processors);
			obj.searchPrice(brands,processors,prices);
			obj.calculate();
			System.out.println("If you wanna calculate again, enter \"1\" and wanna stop, enter \"0\": ");
			int word = obj.sc.nextInt();
			copy = word;
		}while(copy == 1);
		}

}
