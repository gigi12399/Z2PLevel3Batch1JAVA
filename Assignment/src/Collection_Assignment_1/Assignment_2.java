package Collection_Assignment_1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Assignment_2 {
	private static int c_index = 0;
	private static int a_index = 0;
	private static int a_book_index = 0;
	private static int count = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<String> categoryList = new ArrayList<>();
		List<Author> authorList = new ArrayList<Author>();
		List<Book> bookList = new ArrayList<Book>();
		
		categoryList.add("action");
		categoryList.add("horror");
		categoryList.add("comedy");
		categoryList.add("romance");
		
		authorList.add(new Author("Jerry Seinfeld","Brooklyn"));// comedy Is This Anything?
		authorList.add(new Author("Colleen Hoover","Sulphur Springs"));// romance It Ends with Us: A Novel
		authorList.add(new Author("Alex North","Leeds"));// horror The Shadows
		
		bookList.add(new Book(1982112697, "Is This Anything?", LocalDate.of(2020, 10, 6), "Comedy", authorList.get(0)));
		bookList.add(new Book(1501110365, "It Ends with Us: A Novel", LocalDate.of(2012, 8, 2), "Romance", authorList.get(1)));
		bookList.add(new Book(1538724731, "Verity", LocalDate.of(2021, 10, 26), "Romance", authorList.get(1)));
		
		//selectView
		String ch = selectView(sc);

		//View Authors
		if(ch.equalsIgnoreCase("a")) {
			System.out.println("All authors: " + "\n" + "--------------------------");
			authorList.forEach(author -> System.out.println("Name: " + author.getName() + " \t" + "Country: " + author.getCountry()));

			//View Books
		}else if(ch.equalsIgnoreCase("b")) {
			String ch2 = selectViewBook(sc);
			
			if(ch2.equalsIgnoreCase("a")) {
				// All Books
				System.out.println("\n" + "All Books: " + "\n" + "---------------------------");
				bookList.forEach(book -> {
					System.out.println("Title: " + book.getTitle() + "\t" + "Publish Date: " + book.getPublishDate());
				});
			}else if(ch2.equalsIgnoreCase("b")) {
				// book with category
				System.out.print("\n" + "Enter category: ");
				String categoryName = sc.nextLine().toLowerCase();
				viewWithCategory(categoryName,categoryList,bookList);
			}else if(ch2.equalsIgnoreCase("c")) {
				// book with author
				System.out.print("\n" + "Enter author: ");
				String authorName = sc.nextLine();
				viewWithAuthor(authorName,authorList,bookList);
			}
			//View Category
		}else if(ch.equalsIgnoreCase("c")) {
			System.out.println("\n" + "All Category: " + "\n" + "------------------------------");
			categoryList.forEach(category -> System.out.println(category));
			// Add Book
		}else if(ch.equalsIgnoreCase("d")) {
			AddBook(sc, categoryList, authorList, bookList);
			
			
		}
		sc.close();
		
	}

	private static void AddBook(Scanner sc, List<String> categoryList, List<Author> authorList, List<Book> bookList) {
		System.out.print("Enter book title: ");
		String title = sc.nextLine();
		System.out.print("Enter category: ");
		String category = sc.nextLine().toLowerCase();
		System.out.print("Enter author: ");
		String author = sc.nextLine();
		System.out.print("Enter author's country: ");
		String country = sc.nextLine();
		System.out.print("Enter book code: ");
		int code = sc.nextInt();
		System.out.print("Enter book publish day: ");
		int day = sc.nextInt();
		System.out.print("Enter book publish month: ");
		int month = sc.nextInt();
		System.out.print("Enter book publish year: ");
		int year = sc.nextInt();
		LocalDate publishDate = LocalDate.of(year, month, day);
		
		if(categoryList.contains(category)) {
			authorList.forEach(a -> {
				if(a.getName().equalsIgnoreCase(author)) {
					bookList.add(new Book(code,title,publishDate,category,a));
				}else
					count++;
			});
			if(count == authorList.size()) {
				authorList.add(new Author(author,country));
				bookList.add(new Book(code, title, publishDate, category, authorList.get(authorList.size()-1)));
			}
		}else {
			categoryList.add(category);
			authorList.forEach(a -> {
				if(a.getName().equalsIgnoreCase(author)) {
					bookList.add(new Book(code,title,publishDate,category,a));
				}else
					count++;
			});
			if(count == authorList.size()) {
				authorList.add(new Author(author,country));
				bookList.add(new Book(code, title, publishDate, category, authorList.get(authorList.size()-1)));
			}
		}
		
		bookList.forEach(s -> System.out.println(s.getTitle()));
		System.out.println();
		authorList.forEach(a -> System.out.println(a.getName()));
		System.out.println();
		categoryList.forEach(c -> System.out.println(c));
	}

	// choose book with author
	private static void viewWithAuthor(String authorName, List<Author> authorList, List<Book> bookList) {
		authorList.forEach(author -> {
			if(author.getName().equalsIgnoreCase(authorName)) {
				bookList.forEach(book -> {
					if(book.getAuthor().getName().equalsIgnoreCase(authorName))
						System.out.println("Title: " + book.getTitle() + "\t" + "Publich Date: " + book.getPublishDate());					
					else
						a_book_index++;
				});
			}else {
				a_index++;
			}
		});
		if(a_index == authorList.size())
			System.out.println("This author does not exist.");
		if(a_book_index == bookList.size())
			System.out.println("Therer is no book data for this author");
		
	}

	// choose book with category
	private static void viewWithCategory(String categoryName,List<String> categoryList,List<Book> bookList) {
		if(categoryList.contains(categoryName)) {
			System.out.println("Book list of the Category " + categoryName + "\n" + "---------------------------------");	
			bookList.forEach(book -> {
				if(book.getCategory().equalsIgnoreCase(categoryName))
					System.out.println("Title: " + book.getTitle() + "\t" + "Publich Date: " + book.getPublishDate());					
				else
					c_index++;
			});
			if(c_index == bookList.size()) {
				System.out.println("There is no book data for this category.");
			}
		}else {
			System.out.println("This category does not exist.");
		}
		
		
		
		
	}

	// select book
	private static String selectViewBook(Scanner sc) {
		String ch2 = null;
		try {
			System.out.println();
			System.out.println("a.View All");
			System.out.println("b.View with Category");
			System.out.println("c.View with Author");
			System.out.print("Choose Character: ");
			ch2 = sc.nextLine();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return ch2;
		
	}

	// select view
	private static String selectView(Scanner sc) {
		String ch = null;
		try {
			System.out.println("A.View Authors");
			System.out.println("B.View Books");
			System.out.println("C.View Categories");
			System.out.println("D.Add Book"); 
			System.out.print("Choose character: ");
			ch = sc.nextLine().toLowerCase();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return ch;
	}
}
