package Day15.fileio;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ConstructingPath {
	public static void main(String[] args) {
		// < java 11
		Path path = Paths.get("E:\\ProgrammingFundamentals\\Files\\readme.txt");
		System.out.println("Path: " + path);
		
		// + java 11
		path = Path.of("E:\\ProgrammingFundamentals\\Files\\readme.txt");
		System.out.println("Path: " + path);
		
		path = Path.of("E/ProgrammingFundamentals/Files/readme.txt");
		System.out.println("Path: " + path);
		
		path = Path.of("E", "ProgrammingFundamentals", "Files", "readme.txt");
		System.out.println("path: " + path);
		
		path = Path.of("E", "ProgrammingFundamentals", "Files").resolve("readme.txt");
		System.out.println("Path: " + path);
		
		path = Path.of("./src/Day15/fileio/ConstructingPath.java");
		System.out.println("Path: " + path); // relative or current path
		System.out.println("Path: " + path.toAbsolutePath());
		
		path = Path.of("src", "Day15", "fileio", "ConstructingPath.java");
		System.out.println("Path: " + path);
		
		
	}
}
