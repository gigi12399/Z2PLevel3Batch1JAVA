package bms.model.service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


import bms.model.entity.Author;
import bms.model.entity.Book;
import bms.model.entity.Category;

public class DatabaseService {

	public static List<Author> getAllAuthors() {
		List<Author> list = new ArrayList<>();
		try(Connection con = MyConnection.getConnection()) {
			String query = "SELECT * FROM authors";
			PreparedStatement pstm = con.prepareStatement(query);
			ResultSet rs = pstm.executeQuery();
			
			while(rs.next()) {
				Author obj = new Author();
				obj.setId(rs.getInt("author_id"));
				obj.setName(rs.getString("name"));
				obj.setCountry(rs.getString("country"));
				list.add(obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public static List<Category> getAllCategory() {
		List<Category> list = new ArrayList<>();
		try(Connection con = MyConnection.getConnection()) {
			String query = "SELECT * FROM categories";
			PreparedStatement pstm = con.prepareStatement(query);
			ResultSet rs = pstm.executeQuery();
			
			while(rs.next()) {
				Category obj = new Category();
				obj.setId(rs.getInt("category_id"));
				obj.setName(rs.getString("name"));
				list.add(obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public static List<Book> getAllBooks() {
		List<Book> list = new ArrayList<>();
		
		try(Connection con = MyConnection.getConnection()) {
			String query = """
					SELECT b.*, a.name 'author_name', c.name 'category_name'
					FROM books b, authors a, categories c
					WHERE b.author_id = a.author_id AND b.category_id = c.category_id
					""";
			PreparedStatement pstm = con.prepareStatement(query);
			ResultSet rs = pstm.executeQuery();
			while(rs.next()) {
				Book book = new Book();
				
				book.setCode(rs.getInt("code"));
				book.setTitle(rs.getString("title"));
				book.setPublish_date(LocalDate.parse(rs.getString("publish_date")));
				
				Category cat = new Category();
				cat.setId(rs.getInt("category_id"));
				cat.setName(rs.getString("category_name"));
				book.setCategory(cat); 
				
				Author author = new Author();
				author.setId(rs.getInt("author_id"));
				author.setName(rs.getString("author_name"));
				
				book.setAuthor(author);
				list.add(book);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

	public static boolean saveBook(Book book) {
		Boolean result = false;
		
		try(Connection con = MyConnection.getConnection()) {
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
			e.printStackTrace();
		}
		
		return result;
	}

}
