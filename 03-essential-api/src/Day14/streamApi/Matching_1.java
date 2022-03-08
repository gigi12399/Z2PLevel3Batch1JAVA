package Day14.streamApi;

import java.util.List;

public class Matching_1 {
	public static void main(String[] args) {
		List<Integer> numbers = List.of(2, 4, 6, 8, 11);
		
		boolean allEven = numbers.stream().allMatch(n -> n % 2 == 0);
		System.out.println("All Even: " + allEven);
		
		System.out.println("Even: " + numbers.stream().anyMatch(n -> n % 2 == 0));
		
		System.out.println("Not Even: " + numbers.stream().noneMatch(n -> n % 2 == 0));
	}
}
