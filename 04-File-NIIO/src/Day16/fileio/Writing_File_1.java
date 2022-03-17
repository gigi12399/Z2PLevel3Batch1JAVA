package Day16.fileio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class Writing_File_1 {
	public static void main(String[] args) throws IOException {
		List<String> cities = List.of("Yangon", "Mandalay", "Pyin Oo Lwin", "Hledan", "Insein", "Hlaing");
		
		Path path = Path.of("city_data.txt");
		Files.write(path, cities);
		System.out.println("Write Success");
		
		Files.write(path, "Monywa".getBytes(), StandardOpenOption.APPEND);
		System.out.println("Write again");
	}
}
