package Day14.streamApi;

import java.util.List;
import java.util.stream.Collectors;

public class Filtering_2 {
	public static void main(String[] args) {
		List<Users> users = List.of(
				new Users("Kyaw Kyaw","Staff"),
				new Users("Aung Aung","Staff"),
				new Users("Hla Hla","Staff"),
				new Users("Yuri","Customer"),
				new Users("Jeon","Customer")
				);
		
		List<String> names = users.stream()
			.filter(u -> u.getName().contains("Aung") && u.getRole().equals("Staff"))
			.map(u -> u.getName()) // convert users object to string
			.collect(Collectors.toList());
		System.out.println(names);
	}
}
