package Day4;

import java.util.Arrays;

public class Array_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] numbers = new int[] {100,20,200,40,90};
		
		for(var n : numbers)
			System.out.println(n);
		
		// Copy
		int[] copyArr1 = Arrays.copyOf(numbers, numbers.length);
		System.out.println("CopyArray: " + Arrays.toString(copyArr1));
		
		int[] copyArr2 = Arrays.copyOfRange(numbers, 1, 3); //(start-index,end-index - 1)
		System.out.println("CopyArray2: " + Arrays.toString(copyArr2));
		
		// Equals
		System.out.println("numbers == copyArr1: " + Arrays.equals(numbers, copyArr1));
		System.out.println("copyArr1 == copyArr2: " + Arrays.equals(copyArr1, copyArr2));
		
		// Sorting
		Arrays.sort(numbers);
		System.out.println("Sorted: " + Arrays.toString(numbers));
		
		// Searching
		System.out.println("Is 90? : " + Arrays.binarySearch(numbers, 90)); //If present, return index number
		System.out.println("Is 300? : " + Arrays.binarySearch(numbers, 300));//If absent, return negative number
		
		// Fill data
		Arrays.fill(copyArr1, 7);
		System.out.println("After filling: " + Arrays.toString(copyArr1));
		
		
	} 

}
