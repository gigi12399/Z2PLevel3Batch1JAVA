package Day14.streamApi;

import java.util.stream.Stream;

public class Filtering_3 {
	public static void main(String[] args) {
		Stream<Integer> numbers = Stream.iterate(1, i -> i + 1).limit(15);
		
		numbers.filter(n -> n >4 && n <= 10)
				.filter(n -> n%2 == 0)
				.forEach(System.out::println);
	}
}
