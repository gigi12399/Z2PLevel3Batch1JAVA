package lms.mode.service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

import lms.model.entity.Author;
import lms.model.entity.Book;
import lms.model.entity.BorrowBook;
import lms.model.entity.Category;
import lms.model.entity.Librarian;
import lms.model.entity.Member;

public class DatabaseService {

	public static Boolean getLogin(String name, String password) {
		try(Connection con = MyConnection.getConnection()) {
			String query = "SELECT * FROM librarians WHERE username = ? AND password = ?";
			
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setString(1, name);
			pstm.setString(2, password);
			ResultSet rs = pstm.executeQuery();
			
			if(rs.next()) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public static List<Author> getAllAuthors() {
		List<Author> authorlist = new ArrayList<>();
		try(Connection con = MyConnection.getConnection()) {
			String query = "SELECT * FROM authors";
			PreparedStatement pstm = con.prepareStatement(query);
			ResultSet rs = pstm.executeQuery();
			
			while(rs.next()) {
				Author auth = new Author();
				auth.setAuthor_id(rs.getInt("author_id"));
				auth.setName(rs.getString("name"));
				auth.setCountry(rs.getString("country"));
				
				authorlist.add(auth);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return authorlist;
	}

	public static boolean addAuthor(Author auth) {
		boolean result = false;
		try(Connection con = MyConnection.getConnection()) {
			String query = "INSERT INTO authors(name,country)VALUES(?,?)";
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setString(1, auth.getName());
			pstm.setString(2, auth.getCountry());
			pstm.executeUpdate();
			return result = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public static boolean UpdateAuthor(Author auth) {
		boolean result = false;
		try(Connection con = MyConnection.getConnection()) {
			String query = "UPDATE authors SET name = ?, country = ? WHERE author_id = ?";
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setString(1, auth.getName());
			pstm.setString(2, auth.getCountry());
			pstm.setInt(3, auth.getAuthor_id());
			pstm.executeUpdate();
			return result = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public static List<Author> searchAuthors(String name, String country) {
		List<Author> authorlist = new ArrayList<>();
		try(Connection con = MyConnection.getConnection()) {
			String query = "SELECT * FROM authors";
			List<Object> list = new ArrayList<>();
			
			if(name != null) {
				query += " WHERE name = ?";
				list.add(name);
			}
			if(country != null) {
				if(query.contains("WHERE")) {
					query += " AND country = ?";
				}else {
					query += " WHERE country = ?";
				}
				list.add(country);
			}
			PreparedStatement pstm = con.prepareStatement(query);
			for(var i = 0; i < list.size(); i++) {
				pstm.setObject(i + 1, list.get(i));
			}
			ResultSet rs = pstm.executeQuery();
			while(rs.next()){
				Author auth = new Author();
				auth.setAuthor_id(rs.getInt("author_id"));
				auth.setName(rs.getString("name"));
				auth.setCountry(rs.getString("country"));
				
				authorlist.add(auth);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return authorlist;
	}

	public static List<Category> getAllCategories() {
		List<Category> list = new ArrayList<>();
		try(Connection con = MyConnection.getConnection()) {
			String query = "SELECT * FROM categories";
			PreparedStatement pstm = con.prepareStatement(query);
			ResultSet rs = pstm.executeQuery();
			
			while(rs.next()) {
				Category cate = new Category();
				cate.setCategory_id(rs.getInt("category_id"));
				cate.setName(rs.getString("name"));
				
				list.add(cate);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public static boolean addCategory(String name) {
		boolean result = false;
		try(Connection con = MyConnection.getConnection()) {
			String query = "INSERT INTO categories(name)VALUES(?)";
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setString(1, name);
			pstm.executeUpdate();
			return result = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public static boolean updateCategory(int category_id, String name) {
		boolean result = false;
		try(Connection con = MyConnection.getConnection()) {
			String query = "UPDATE categories SET name = ? WHERE category_id = ?";
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setString(1, name);
			pstm.setInt(2, category_id);
			pstm.executeUpdate();
			return result = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public static List<Category> searchCategories(String name) {
		List<Category> list = new ArrayList<>();
		try(Connection con = MyConnection.getConnection()) {
			String query = "SELECT * FROM categories WHERE name = ?";
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setString(1, name);
			ResultSet rs = pstm.executeQuery();
			
			while(rs.next()) {
				Category cate = new Category();
				cate.setCategory_id(rs.getInt("category_id"));
				cate.setName(rs.getString("name"));
				
				list.add(cate);
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
				book.setIs_available(rs.getString("is_available"));
				
				Author auth = new Author();
				auth.setAuthor_id(rs.getInt("author_id"));
				auth.setName(rs.getString("author_name"));
				book.setAuthor(auth);
				
				Category cate = new Category();
				cate.setCategory_id(rs.getInt("category_id"));
				cate.setName(rs.getString("category_name"));
				book.setCategory(cate);
				
				
				list.add(book);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public static boolean addBook(Book book) {
		boolean result = false;
		try(Connection con = MyConnection.getConnection()) {
			String query = "INSERT INTO books(code, title, author_id, category_id, is_available)VALUES(?,?,?,?,?)";
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setInt(1, book.getCode());
			pstm.setString(2, book.getTitle());
			pstm.setInt(3, book.getAuthor().getAuthor_id());
			pstm.setInt(4, book.getCategory().getCategory_id());
			pstm.setString(5, book.getIs_available());
			pstm.executeUpdate();
			return result = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public static boolean editBook(Book book) {
		try(Connection con = MyConnection.getConnection()) {
			String query = "UPDATE books SET title = ?, author_id = ?, category_id = ?, is_available = ? WHERE code = ?";
			PreparedStatement pstm = con.prepareStatement(query);
			
			pstm.setString(1, book.getTitle());
			pstm.setInt(2, book.getAuthor().getAuthor_id());
			pstm.setInt(3, book.getCategory().getCategory_id());
			pstm.setString(4, book.getIs_available());
			pstm.setInt(5, book.getCode());
			pstm.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public static List<Book> searchBooks(Book book) {
		List<Book> bookList = new ArrayList<>();
		try(Connection con = MyConnection.getConnection()) {
			String query = """
						SELECT b.*, a.name 'author_name', c.name 'category_name'
						FROM books b, authors a, categories c
						WHERE b.author_id = a.author_id AND b.category_id = c.category_id
						""";
			
			List<Object> list = new ArrayList<>();
			if(book.getCode() != -1) {
				query += " AND b.code = ?";
				list.add(book.getCode());
			}
			if(book.getTitle() != null) {
				query += " AND b.title = ?";
				list.add(book.getTitle());
			}
			if(book.getAuthor() != null) {
				query += " AND a.name LIKE ?";
				list.add("%" + book.getAuthor().getName() + "%");
			}
			if(book.getCategory() != null) {
				query += " AND c.category_id = ?";
				list.add(book.getCategory().getCategory_id());
			}
			if(book.getIs_available() != null) {
				query += " AND b.is_available = ?";
				list.add(book.getIs_available());
			}
			
			PreparedStatement pstm = con.prepareStatement(query);
			for(var i = 0; i < list.size(); i++) {
				pstm.setObject(i+1, list.get(i));
			}
			ResultSet rs = pstm.executeQuery();
			while(rs.next()) {
				Book bookObj = new Book();
				bookObj.setCode(rs.getInt("code"));
				bookObj.setTitle(rs.getString("title"));
				
				Author auth = new Author();
				auth.setAuthor_id(rs.getInt("author_id"));
				auth.setName(rs.getString("author_name"));
				bookObj.setAuthor(auth);
				
				Category cate = new Category();
				cate.setCategory_id(rs.getInt("category_id"));
				cate.setName(rs.getString("category_name"));
				bookObj.setCategory(cate);
				
				bookObj.setIs_available(rs.getString("is_available"));
				
				bookList.add(bookObj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bookList;
	}

	

	public static List<Librarian> getAllLibrarian() {
		List<Librarian> librarianList = new ArrayList<>();
		try(Connection con = MyConnection.getConnection()) {
			String query = "SELECT * FROM librarians";
			PreparedStatement pstm = con.prepareStatement(query);
			ResultSet rs = pstm.executeQuery();
			
			while(rs.next()) {
				Librarian lib = new Librarian();
				lib.setId(rs.getInt("id"));
				lib.setUsername(rs.getString("username"));
				lib.setPassword(rs.getString("password"));
				lib.setNrcno(rs.getString("nrcno"));
				lib.setPhone(rs.getString("phone"));
				lib.setCreated_at(LocalDate.parse(rs.getString("created_at")));
				
				librarianList.add(lib);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return librarianList;
	}

	public static boolean addLibrarian(Librarian lib) {
		try(Connection con = MyConnection.getConnection()) {
			String query = "INSERT INTO librarians(username, password, nrcno, phone)VALUES(?,?,?,?)";
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setString(1, lib.getUsername());
			pstm.setString(2, lib.getPassword());
			pstm.setString(3, lib.getNrcno());
			pstm.setString(4, lib.getPhone());
			pstm.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public static boolean updateLibrarian(Librarian lib) {
		try(Connection con = MyConnection.getConnection()) {
			String query = "UPDATE librarians SET username = ?, password = ?, nrcno = ?, phone = ? WHERE id = ?";
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setString(1, lib.getUsername());
			pstm.setString(2, lib.getPassword());
			pstm.setString(3, lib.getNrcno());
			pstm.setString(4, lib.getPhone());
			pstm.setInt(5, lib.getId());
			pstm.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public static List<Librarian> searchLibrarian(Librarian lib) {
		List<Librarian> librarianList = new ArrayList<>();
		try(Connection con = MyConnection.getConnection()) {
			String query = "SELECT * FROM librarians";
			
			List<Object> list = new ArrayList<>();
			if(lib.getUsername() != null) {
				query += " WHERE username = ?";
				list.add(lib.getUsername());
			}
			if(lib.getPassword() != null) {
				if(query.contains("WHERE")) {
					query += " AND password = ?";
				}else {
					query += " WHERE password = ?";
				}
				list.add(lib.getPassword());
			}
			if(lib.getNrcno() != null) {
				if(query.contains("WHERE")) {
					query += " AND nrcno = ?";
				}else {
					query += " WHERE nrcno = ?";
				}
				list.add(lib.getNrcno());
			}
			if(lib.getPhone() != null) {
				if(query.contains("WHERE")) {
					query += " AND phone = ?";
				}else {
					query += " WHERE phone = ?";
				}
				list.add(lib.getPhone());
			}
			PreparedStatement pstm = con.prepareStatement(query);
			for(var i = 0; i < list.size(); i++) {
				pstm.setObject(i + 1, list.get(i));
			}
			
			ResultSet rs = pstm.executeQuery();
			
			while(rs.next()) {
				Librarian librarian = new Librarian();
				librarian.setId(rs.getInt("id"));
				librarian.setUsername(rs.getString("username"));
				librarian.setPassword(rs.getString("password"));
				librarian.setNrcno(rs.getString("nrcno"));
				librarian.setPhone(rs.getString("phone"));
				librarian.setCreated_at(LocalDate.parse(rs.getString("created_at")));
				
				librarianList.add(librarian);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return librarianList;
	}
	
	public static List<Member> getAllMembers() {
		List<Member> memberlist = new ArrayList<>();
		try(Connection con = MyConnection.getConnection()) {
			String query = "SELECT * FROM members";
			PreparedStatement pstm = con.prepareStatement(query);
			ResultSet rs = pstm.executeQuery();
			
			while(rs.next()) {
				Member member = new Member();
				member.setCard_id(rs.getInt("card_id"));
				member.setName(rs.getString("name"));
				member.setRoll_no(rs.getString("roll_no"));
				member.setClass_year(rs.getString("class_year"));
				member.setAcedemic_year(rs.getInt("acedemic_year"));
				member.setCreated_date(LocalDate.parse(rs.getString("created_date")));
				member.setExpired_date(LocalDate.parse(rs.getString("expired_date")));
				
				memberlist.add(member);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return memberlist;
	}

	public static boolean addMember(Member member) {
		try(Connection con = MyConnection.getConnection()) {
			String query = "INSERT INTO members(card_id, name, roll_no, class_year, acedemic_year, created_date, expired_date)VALUES(?,?,?,?,?,?,?)";
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setInt(1, member.getCard_id());
			pstm.setString(2, member.getName());
			pstm.setString(3, member.getRoll_no());
			pstm.setString(4, member.getClass_year());
			pstm.setInt(5, member.getAcedemic_year());
			pstm.setDate(6, Date.valueOf(member.getCreated_date()));
			pstm.setDate(7, Date.valueOf(member.getExpired_date()));
			pstm.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public static boolean updateMember(Member member) {
		try(Connection con = MyConnection.getConnection()) {
			String query = "UPDATE members SET name = ?, roll_no = ?, class_year = ?, acedemic_year = ? WHERE card_id = ?";
			PreparedStatement pstm = con.prepareStatement(query);
			
			pstm.setString(1, member.getName());
			pstm.setString(2, member.getRoll_no());
			pstm.setString(3, member.getClass_year());
			pstm.setInt(4, member.getAcedemic_year());
			pstm.setInt(5, member.getCard_id());
			pstm.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public static List<Member> searchMembers(Member member) {
		List<Member> memberlist = new ArrayList<>();
		try(Connection con = MyConnection.getConnection()) {
			String query = "SELECT * FROM members";
			List<Object> list = new ArrayList<>();
			if(member.getCard_id() != -1) {
				query += " WHERE card_id = ?";
				list.add(member.getCard_id());
			}
			if(member.getName() != null) {
				if(query.contains("WHERE")) {
					query += " AND name = ?";
				}else {
					query += " WHERE name = ?";
				}
				list.add(member.getName());
			}
			if(member.getRoll_no() != null) {
				if(query.contains("WHERE")) {
					query += " AND roll_no = ?";
				}else {
					query += " WHERE roll_no = ?";
				}
				list.add(member.getRoll_no());
			}
			if(member.getClass_year() != null) {
				if(query.contains("WHERE")) {
					query += " AND class_year = ?";
				}else {
					query += " WHERE class_year = ?";
				}
				list.add(member.getClass_year());
			}
			if(member.getAcedemic_year() != -1) {
				if(query.contains("WHERE")) {
					query += " AND acedemic_year = ?";
				}else {
					query += " WHERE acedemic_year = ?";
				}
				list.add(member.getAcedemic_year());
			}
			
			PreparedStatement pstm = con.prepareStatement(query);
			for(var i = 0; i < list.size(); i++) {
				pstm.setObject(i + 1, list.get(i));
			}
			ResultSet rs = pstm.executeQuery();
			while(rs.next()) {
				Member mem = new Member();
				mem.setCard_id(rs.getInt("card_id"));
				mem.setName(rs.getString("name"));
				mem.setRoll_no(rs.getString("roll_no"));
				mem.setClass_year(rs.getString("class_year"));
				mem.setAcedemic_year(rs.getInt("acedemic_year"));
				mem.setCreated_date(LocalDate.parse(rs.getString("created_date")));
				mem.setExpired_date(LocalDate.parse(rs.getString("expired_date")));
				
				memberlist.add(mem);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return memberlist;
	}

	public static boolean searchCardID(String card_id) {
		try(Connection con = MyConnection.getConnection()) {
			String query = "SELECT * FROM members WHERE card_id = ?";
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setInt(1, Integer.parseInt(card_id));
			ResultSet rs = pstm.executeQuery();
			if(rs.next()) {
				return true;
			}else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public static List<BorrowBook> getAllBorrowBooks() {
		List<BorrowBook> borrowBookList = new ArrayList<>();
		try(Connection con = MyConnection.getConnection()) {
			String query = """
					SELECT o.*, m.name, b.title, l.username, l.id 'librarian_id'
					FROM borrow_books o, members m, books b, librarians l
					WHERE o.card_id = m.card_id AND o.book_id = b.code AND o.librarian_id = l.librarian_id
					""";
			PreparedStatement pstm = con.prepareStatement(query);
			ResultSet rs = pstm.executeQuery();
			while(rs.next()) {
				BorrowBook bBook = new BorrowBook();
				bBook.setId(rs.getInt("id"));
				bBook.setBorrow_date(LocalDate.parse(rs.getString("borrow_date")));
				bBook.setDue_date(LocalDate.parse(rs.getString("due_date")));
				bBook.setReturn_date(LocalDate.parse(rs.getString("return_date")));
				bBook.setFine_fees(rs.getInt("fine_fees"));
				
				Member mem = new Member();
				mem.setCard_id(rs.getInt("card_id"));
				mem.setName(rs.getString("name"));
				bBook.setMember(mem);
				
				Book book = new Book();
				book.setCode(rs.getInt("code"));
				book.setTitle(rs.getString("title"));
				bBook.setBook(book);
				
				Librarian lib = new Librarian();
				lib.setId(rs.getInt("librarian_id"));
				lib.setUsername(rs.getString("username"));
				bBook.setLibrarian(lib);
				
				borrowBookList.add(bBook);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return borrowBookList;
	}
}


