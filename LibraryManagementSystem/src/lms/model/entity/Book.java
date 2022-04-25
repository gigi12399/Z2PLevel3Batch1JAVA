package lms.model.entity;

public class Book {
	private int code;
	private String title;
	private Author author;
	private Category category;
	private String is_available;
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public String getIs_available() {
		return is_available;
	}
	public void setIs_available(String is_available) {
		this.is_available = is_available;
	}
	public String getAuthor_name() {
		return this.author.getName();
	}
	public String getCategory_name() {
		return this.category.getName();
	}
	
}
