package Day18.bookmanagementsystem;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

public class DatabaseHandler {

	public static List<Author> retrieveAuthors() {
		List<Author> list = new ArrayList<>();
		try(Connection con = MyConnection.createConnection()) {
			String query = "SELECT * FROM authors";
			PreparedStatement pstm = con.prepareStatement(query);
			
			ResultSet rs = pstm.executeQuery();
			while(rs.next()) {
				Author author = new Author();
				author.setId(rs.getInt("author_id"));
				author.setCountry(rs.getString("country"));
				author.setName(rs.getString("name"));
				
				list.add(author);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public static List<Category> retrieveCategories() {
		List<Category> list = new ArrayList<>();
		
		try(Connection con = MyConnection.createConnection()) {
			String query = "SELECT * FROM categories";
			PreparedStatement pstm = con.prepareStatement(query);
			ResultSet rs = pstm.executeQuery();
			
			while(rs.next()) {
				Category cat = new Category();
				cat.setId(rs.getInt("category_id"));
				cat.setName(rs.getString("name"));
				
				list.add(cat);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

	public static List<Book> findAllBooks() {
		List<Book> list = new ArrayList<>();
		
		try(Connection con = MyConnection.createConnection()) {
			String query = """
					SELECT b.*,a.name 'author_name',a.country,c.name 'category_name'
					FROM books b,authors a,categories c
					WHERE b.author_id = a.author_id AND b.category_id = c.category_id""";
			
			PreparedStatement pstm = con.prepareStatement(query);
			
			ResultSet rs = pstm.executeQuery();
			
			while(rs.next()){
				Book book = new Book();
				
				book.setCode(rs.getInt("code"));
				book.setTitle(rs.getString("title"));
				book.setPublish_date(LocalDate.parse(rs.getString("publish_date")));
				
				Author author = new Author();
				author.setCountry(rs.getString("country"));
				author.setName(rs.getString("author_name"));
				author.setId(rs.getInt("author_id"));
				
				book.setAuthor(author);
				
				Category cat = new Category();
				cat.setId(rs.getInt("category_id"));
				cat.setName(rs.getString("category_name"));
				
				book.setCategory(cat);
				
				list.add(book);
			}
					
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

	public static Author findAuthorByName(String name) {
		Author author = null;
		
		try(Connection con = MyConnection.createConnection()) {
			String query = "SELECT * FROM authors WHERE name = ?";
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setString(1, name);
			
			ResultSet rs = pstm.executeQuery();
			if(rs.next()) {
				author = new Author();
				author.setId(rs.getInt("author_id"));
				author.setName(rs.getString("name"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return author;
	}

	public static List<Book> findBookByAuthor(int id) {
		List<Book> list = new ArrayList<>();
		
		try(Connection con = MyConnection.createConnection()) {
			String query = "SELECT b.*,c.name FROM books b,categories c WHERE author_id = ? AND b.category_id = c.category_id";
			
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setInt(1, id);
			ResultSet rs = pstm.executeQuery();
			
			while(rs.next()) {
				Book book = new Book();
				book.setCode(rs.getInt("code"));
				book.setTitle(rs.getString("title"));
				book.setPublish_date(LocalDate.parse(rs.getString("publish_date")));
				
				Category cat = new Category();
				cat.setName(rs.getString("name")); // category name
				
				book.setCategory(cat);
				list.add(book);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

	public static Category findCategoryByName(String c_name) {
		Category cat = null;
		
		try(Connection con = MyConnection.createConnection()) {
			String query = "SELECT * FROM categories WHERE name = ?";
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setString(1, c_name);
			ResultSet rs = pstm.executeQuery();
			
			while(rs.next()) {
				cat = new Category();
				cat.setId(rs.getInt("category_id"));
				cat.setName(rs.getString("name"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return cat;
	}

	public static List<Book> findBookByCategory(int id) {
		List<Book> list = new ArrayList<>();
		
		try(Connection con = MyConnection.createConnection()) {
			String query = "SELECT b.*,a.name FROM books b,authors a WHERE category_id = ? AND b.author_id = a.author_id";
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setInt(1, id);
			ResultSet rs = pstm.executeQuery();
			while(rs.next()) {
				Book book = new Book();
				book.setCode(rs.getInt("code"));
				book.setTitle(rs.getString("title"));
				book.setPublish_date(LocalDate.parse(rs.getString("publish_date")));
				
				Author author = new Author();
				author.setName(rs.getString("name"));
				
				book.setAuthor(author);
				list.add(book);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

	public static Author checkAuthorName(String nextLine) {
		Author author = new Author();
		
		try(Connection con = MyConnection.createConnection()) {
			String query = "SELECT * FROM authors WHERE name = ?";
			
			PreparedStatement pstm = con.prepareStatement(query);
			
			pstm.setString(1, nextLine);
			
			ResultSet rs = pstm.executeQuery();
			if(rs.next()) {
				author.setId(rs.getInt("author_id"));
				author.setName(rs.getString("name"));
				author.setCountry(rs.getString("country"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return author;
	}

	public static Author addNewAuthor(Author author) {
		Author insertedAuthor = new Author();
		
		try(Connection con = MyConnection.createConnection()) {
			String query = "INSERT INTO authors(name,country)VALUES(?,?)";
			PreparedStatement pstm = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			pstm.setString(1, author.getName());
			pstm.setString(2, author.getCountry());
			pstm.executeUpdate();
			
			ResultSet rs = pstm.getGeneratedKeys();
			rs.next();
			int id = rs.getInt(1);
			insertedAuthor.setId(id);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return insertedAuthor;
	}

	public static Category verifyCategory(String catName) {
		Category cat = new Category();
		
		try(Connection con = MyConnection.createConnection()) {
			String query = "SELECT * FROM categories WHERE name = ?";
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setString(1, catName);
			ResultSet rs = pstm.executeQuery();
			
			if(rs.next()) { // category already exist
				cat.setId(rs.getInt("category_id"));
			}else { // new category
				String insert = "INSERT INTO categories(name)VALUES(?)";
				
				pstm = con.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
				pstm.setString(1, catName);
				pstm.executeUpdate();
				rs = pstm.getGeneratedKeys();
				rs.next();
				cat.setId(rs.getInt(1));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return cat;
	}

	public static boolean addNewBook(Book book) {
		boolean result;
		try(Connection con = MyConnection.createConnection()) {
			String query = "INSERT INTO books(code,title,publish_date,author_id,category_id)VALUES(?,?,?,?,?)";
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setInt(1, book.getCode());
			pstm.setString(2, book.getTitle());
			pstm.setDate(3, Date.valueOf(book.getPublish_date()));
			pstm.setInt(4, book.getAuthor().getId());
			pstm.setInt(5, book.getCategory().getId());
			
			pstm.executeUpdate();
			result = true;
			
		} catch (Exception e) {
			result = false;
		}
		return result;
		
	}
	
}
