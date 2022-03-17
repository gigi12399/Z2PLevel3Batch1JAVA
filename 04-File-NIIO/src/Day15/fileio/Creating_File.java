package Day15.fileio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Creating_File {
	public static void main(String[] args) throws IOException {
		// create file
		Path path = Path.of("src/readme.txt");
		if(Files.exists(path)) {
			System.out.println("This file already exists!");
		}else {
			Files.createFile(path);
			System.out.println("File is created!");
		}
		
		// create directory
		path = Path.of("./test");
		if(Files.notExists(path))
			Files.createDirectories(path);
	}
}
