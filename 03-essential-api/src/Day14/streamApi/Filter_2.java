package Day14.streamApi;

import java.util.List;

public class Filter_2 {
	public static void main(String[] args) {
		List<Users> users = List.of(
				new Users("Kyaw Kyaw","Yangon"),
				new Users("Aung Aung","Mandalay"),
				new Users("Mg Mg","Mandalay"),
				new Users("Yuri","Yangon"),
				new Users("Jeon","Monywa")
				);
		
		users.stream()
			.filter(u -> u.getName().contains("Aung") && u.getRole().equals("Staff"));
	}
}
