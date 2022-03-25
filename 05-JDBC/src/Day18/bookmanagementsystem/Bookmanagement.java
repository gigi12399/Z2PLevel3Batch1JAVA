package Day18.bookmanagementsystem;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.xml.crypto.Data;

public class Bookmanagement {

	public static void main(String[] args) throws SQLException {
		String input = """
				1. View Authors
				2. View Books
				3. View Categories
				4. Add Book
				Choose 1,2,3 or 4 :""";
		System.out.print(input);
		Scanner sc = new Scanner(System.in);
		int menu = Integer.parseInt(sc.nextLine());
		
		if(menu == 1) { // view Authors
			viewAuthors();
		}else if(menu == 2) {// view books
			viewBooks();
		}else if(menu == 3) { // view categories
			viewCategories();
		}else if(menu == 4) { // add book
			addNewBook();
		}else
			System.err.println("Invalid number");
		sc.close();

	}

	private static void addNewBook() throws SQLException {
		Book book = new Book();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Book Information");
		System.out.print("Code: ");
		book.setCode(Integer.parseInt(sc.nextLine()));
		System.out.print("Tilte: ");
		book.setTitle(sc.nextLine());
		System.out.print("Publish Date(yyyy-MM-dd): ");
		book.setPublish_date(LocalDate.parse(sc.nextLine()));
		
		System.out.print("Category Name:");
		String catName = sc.nextLine();
		Category cat = DatabaseHandler.verifyCategory(catName);
		book.setCategory(cat);
		
		System.out.print("Author Name: ");
		String authorName = sc.nextLine();
		Author author = DatabaseHandler.checkAuthorName(authorName);
		if(author.getId() == 0) { // new author
			System.out.println("This is new author");
			System.out.print("Enter country name: ");
			author.setCountry(sc.nextLine());
		}
		book.setAuthor(author);
		
		boolean result = DatabaseHandler.addNewBook(book);
		if(result)
			System.out.println("A new book is inserted");
		else
			System.out.println("Somthing is wrong.Please try again!");
		
		sc.close();
		
	}

	private static void viewBooks() {
		Scanner sc = new Scanner(System.in);
		String input = """
				1. View All
				2. View By Category
				3. View By Author
				Choose 1,2, or 3 :""";
		System.out.print(input);
		int menu = Integer.parseInt(sc.nextLine());
		
		if(menu == 1)	{ // view all
			viewAllBooks();
		}else if(menu == 2) { // view by category
			viewByCategory();
		}else if(menu == 3) { // view by author
			viewByAuthor();
		}else
			System.err.println("Invalid Number");
		sc.close();
	}

	private static void viewByAuthor() {
		String name;
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter Author name: ");
		name = sc.nextLine();
		
		Author author = DatabaseHandler.findAuthorByName(name);
		
		if(author == null) {
			System.err.println("There is no this author name - " + name);
		}else { // author exist
			List<Book> list = DatabaseHandler.findBookByAuthor(author.getId());
			
			// has author but no books
			if(list.size() == 0) {
				System.out.println("This author has no book");
			}else { // has author and his books
				System.out.println("Code\tBook Title\tPublish Date\tCategory");
				System.out.println("----------------------------------------------");
				list.forEach(book -> {
					System.out.print(book.getCode() + "\t");
					System.out.print(book.getTitle() + "\t");
					System.out.print(book.getPublish_date() + "\t");
					System.out.print(book.getCategory().getName() + "\n");
				});
			}
			
			
		}
		
		sc.close();
		
	}

	private static void viewByCategory() {
		String c_name;
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter Category: ");
		c_name = sc.nextLine();
		
		Category cat = DatabaseHandler.findCategoryByName(c_name);
		
		
		if(cat == null) { // category does not exist
			System.out.println("This is no " + c_name + " Category");
		}else { // category exist
			List<Book> list = DatabaseHandler.findBookByCategory(cat.getId());
			
			if(list.size() == 0) { // no book
				System.out.println("There is no book in this category.");
			}else{ // exist books
				System.out.println("Code\tTitle\tPublish Date\tAuthor Name");
				System.out.println("-----------------------------------------");
				list.forEach(book -> {
					System.out.print(book.getCode() + "\t");
					System.out.print(book.getTitle() + "\t");
					System.out.print(book.getPublish_date() + "\t");
					System.out.print(book.getAuthor().getName() + "\n");
				});
			}
		}
		sc.close();
	}

	private static void viewAllBooks() {
		List<Book> list = DatabaseHandler.findAllBooks();
		System.out.println("Code\tTitle\tPublish Date\tCategory\tAuthor");
		System.out.println("-----------------------------------------------");
		list.forEach(book -> {
			System.out.print(book.getCode() + "\t");
			System.out.print(book.getTitle() + "\t");
			System.out.print(book.getPublish_date() + "\t");
			System.out.print(book.getCategory().getName() + "\t");
			System.out.print(book.getAuthor().getName() + "\n");
		});
		
	}

	private static void viewCategories() {
		List<Category> list = DatabaseHandler.retrieveCategories();
		System.out.println("Id\tDescription");
		System.out.println("------------------------------------");
		list.forEach(cat -> System.out.println(cat.getId() + "\t" + cat.getName()));
		
	}

	private static void viewAuthors() {
		List<Author> list = DatabaseHandler.retrieveAuthors();
		System.out.println("Id\tAuthor Name\tCountry");
		System.out.println("---------------------------");
		list.stream().forEach(obj -> {
			System.out.println(obj.getId() + "\t" + obj.getName() + "\t" + obj.getCountry());
		});
	}

}
