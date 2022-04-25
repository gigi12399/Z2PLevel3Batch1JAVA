package lms.model.entity;

import java.time.LocalDate;
import java.util.Date;

public class BorrowBook {
	private int id;
	private Member member;
	private Book book;
	private LocalDate borrow_date;
	private LocalDate due_date;
	private LocalDate return_date;
	private Librarian librarian;
	private int fine_fees;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	public String getMember_name() {
		return this.member.getName();
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public String getBook_title() {
		return this.book.getTitle();
	}
	public LocalDate getBorrow_date() {
		return borrow_date;
	}
	public void setBorrow_date(LocalDate borrow_date) {
		this.borrow_date = borrow_date;
	}
	public LocalDate getDue_date() {
		return due_date;
	}
	public void setDue_date(LocalDate due_date) {
		this.due_date = due_date;
	}
	public LocalDate getReturn_date() {
		return return_date;
	}
	public void setReturn_date(LocalDate return_date) {
		this.return_date = return_date;
	}
	public Librarian getLibrarian() {
		return librarian;
	}
	public void setLibrarian(Librarian librarian) {
		this.librarian = librarian;
	}
	public String getLibrarian_name() {
		return this.librarian.getUsername();
	}
	public int getFine_fees() {
		return fine_fees;
	}
	public void setFine_fees(int fees) {
		this.fine_fees = fees;
	}
	
	
	
}
