package Day18.bookmanagementsystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
	
}
