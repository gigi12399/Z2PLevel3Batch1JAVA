package Day15.fileio;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class List_Contents {
	public static void main(String[] args) {
		Path path = Path.of(".");
		try (Stream<Path> filelist = Files.list(path)){
			filelist.forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("---------------------------");
		
		try (Stream<Path> filelist = Files.walk(path)){
			//System.out.println("***** files and directory *****");
			//filelist.forEach(System.out::println);
			
			System.out.println("*** only directories ***");
			//filelist.filter(Files::isDirectory).forEach(System.out::println);
			
			filelist.filter(p -> p.toString().contains(".java")).forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
