package Day12.lambda;

import java.util.ArrayList;
import java.util.List;

public class lambdaWithCollection {
	public static void main(String[] args) {
		List<String> languages = List.of("HTML", "JAVASCRIPT", "CSS", "JAVA", "PHP");
		
		languages.forEach(s-> System.out.println(s));
		
		System.out.println("-------------------------");
		
		languages.forEach(lang -> {
			if(lang.contains("JAVA"))
				System.out.println(lang);
		});
		
	}
}
