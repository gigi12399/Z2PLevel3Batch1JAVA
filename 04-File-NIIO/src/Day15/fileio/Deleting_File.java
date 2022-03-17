package Day15.fileio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Deleting_File {
	public static void main(String[] args) throws IOException {
//		Path path = Path.of("src/readme.txt");
//		
//		boolean deleted = Files.deleteIfExists(path);
//		
//		if(deleted)
//			System.out.println("File deleted");
//		else
//			System.out.println("File does not exist!");
		
		
		
		// delete empty dir
		Path path = Path.of("E","ProgrammingFundamentals", "files");
//		if(Files.deleteIfExists(path)) {
//			System.out.println("Directory Deleted");
//		}else {
//			System.out.println("Directory does not exist");
//		}
		
		
		if(Files.exists(path)) {
			Files.walk(path)
					.map(p -> p.toFile())
					.forEach(f -> f.delete());
			
			Files.delete(path);
			System.out.println("File deleted");
	}
		
	}
}
