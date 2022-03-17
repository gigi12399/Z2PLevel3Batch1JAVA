package Day16.fileio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class Writing_File_2 {
	public static void main(String[] args) throws IOException {
		Path path = Path.of("Student.txt");
		
		String data = """
					Name: Aung Aung
					Address: Yangon
					Age: 26
				""";
		Files.writeString(path, data, StandardOpenOption.CREATE_NEW);
		System.out.println("Write Success");
	} 
}
