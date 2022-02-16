package Day5;

public class Math_Api {
	public static void main(String[] args) {
		// basic operation
		System.out.println("Absolute of -7: " + Math.abs(-7));
		System.out.println("3 power 4: " + Math.pow(3, 4));
		System.out.println("Square root of 49: " + Math.sqrt(49));
		System.out.println("Random value: " + Math.random());
		System.out.println("Min: " + Math.min(13, 31));
		System.out.println("Max: " + Math.max(13, 31));
		System.out.println("Sum: " + Math.addExact(13, 12));
		System.out.println("PI: " + Math.PI);
		
		// round
		System.out.println("Round(3.6): " + Math.round(3.6));
		System.out.println("Floor(3.6): " + Math.floor(3.6));
		System.out.println("Ceil(3.1): " + Math.ceil(3.1));
		
		// trigonometric & log function
		System.out.println("Sin(30): " + Math.sin(30));
		System.out.println("Log10(10): " + Math.log10(10));
	}
}
