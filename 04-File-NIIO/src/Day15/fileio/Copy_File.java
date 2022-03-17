package Day15.fileio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class Copy_File {
	public static void main(String[] args) throws IOException {
		Path source = Path.of("src/readme.txt");
		Path dest = Path.of("src/another.txt");
		
//		Files.copy(source, dest);
//		System.out.println("Copy success");
		
		source = Path.of("src/myfile.txt");
		Files.copy(source, dest, StandardCopyOption.REPLACE_EXISTING );
		System.out.println("Copy Success");
	}
}
