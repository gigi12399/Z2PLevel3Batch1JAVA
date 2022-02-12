package Day4;

import java.util.Arrays;

public class Array_2 {
	static void changeValue(int[] input,int a) {
		input[0] = 500;
		a = 1000;
		System.out.println("a = " + a);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {100,20,200,40,90};
		
		// total
		int total = Arrays.stream(arr).sum();
		System.out.println("Total: " + total);
		
		System.out.println("Min: " + Arrays.stream(arr).min().getAsInt());
		System.out.println("Max: " + Arrays.stream(arr).max().getAsInt());
		
		int num = 50;
		changeValue(arr,num);
		System.out.println("After calling method: " + Arrays.toString(arr));
		System.out.println("After calling method: " + num);
	}

}
