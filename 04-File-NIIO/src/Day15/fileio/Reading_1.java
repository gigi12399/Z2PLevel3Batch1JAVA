package Day15.fileio;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Reading_1 {
	public static void main(String[] args) throws IOException {
		Path path = Path.of("src/employee.txt");
		
		try (Stream<String> data = Files.lines(path)){
			List<String> names = data.filter(d -> d.contains("aung")).collect(Collectors.toList());
			System.out.println(names);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try(Stream<String> data = Files.lines(path,StandardCharsets.UTF_8)){
			data.map(d-> d.toUpperCase()).forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// reading large files
		// parallel stream
		Stream<String> data = Files.lines(path).parallel();
		List<String> list = data.collect(Collectors.toList());
		
		System.out.println(list);
		
		// Buffer reader
		try(BufferedReader reader = Files.newBufferedReader(path)) {
			String current = null;
			while((current = reader.readLine()) != null) {
				System.out.println(current);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
