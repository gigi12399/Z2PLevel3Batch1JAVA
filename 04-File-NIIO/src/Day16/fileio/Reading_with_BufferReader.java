package Day16.fileio;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Reading_with_BufferReader {
	public static void main(String[] args) {
		Path path = Path.of("src/Day16/fileio/Employee.txt");
		try (BufferedReader reader = Files.newBufferedReader(path)){
			String line = null;
			List<String> list = new ArrayList<>();
			
			while((line = reader.readLine()) != null) {
				String tmp = line.toLowerCase();
				if(tmp.contains("aung"))
					list.add(line);
			}
			System.out.println(list);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
