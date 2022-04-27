package lms.controller;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import lms.LMS_Main;
import lms.mode.service.DatabaseService;
import lms.model.entity.Book;
import lms.model.entity.BorrowBook;
public class CardBorrowBooksController implements Initializable {
	private List<BorrowBook> borrowBookList = new ArrayList<>();
	private List<Book> bookList = new ArrayList<>();
	@FXML
    private TableColumn<Book, String> col_author;

    @FXML
    private TableColumn<Book, Integer> col_book_code;

    @FXML
    private TableColumn<Book, String> col_category;

    @FXML
    private TableColumn<Book, String> col_title;

    @FXML
    private TableView<Book> tbl_borrow_with_card;

    @FXML
    private TextField txt_book_id;

    @FXML
    void btn_back_click(ActionEvent event) throws IOException {
    	LMS_Main.changeScene("view/CardIDCheck.fxml");
    }

    @FXML
    void btn_confirm_borrow_click(ActionEvent event) throws IOException {
    		for(var i = 0; i < bookList.size(); i++) {
    			BorrowBook bBook = new BorrowBook();
        		bBook.setMember(CardIDCheckController.login_member);
        		bBook.setBook(bookList.get(i));
        		LocalDate date = LocalDate.now();
        		bBook.setBorrow_date(date);
        		bBook.setDue_date(date.plusDays(7));
        		bBook.setLibrarian(LoginController.login_librarian);
        		bBook.setFine_fees(0);
        		
        		borrowBookList.add(bBook);
    		}
    		if(borrowBookList.size() == 0) {
    			alertShow(AlertType.INFORMATION, "You didn't choose books to borrow!!");
    			return;
    		}
    		if(DatabaseService.confirmBorrowBooks(borrowBookList)) {
    			DatabaseService.changeAvailable(bookList, "No");
    			LMS_Main.changeScene("view/CardBorrowingHistory.fxml");
    		}else {
    			alertShow(AlertType.ERROR, "Something is wrong.Please try again.");
    		}
    		
    	}
    	
    
    
    @FXML
    void btn_delete_click(ActionEvent event) {
    	if(bookList.size() == 0) {
			alertShow(AlertType.INFORMATION, "There is no book to delete");
			return;
		}
    	Alert alert = new Alert(AlertType.CONFIRMATION);
    	alert.setTitle("Confirmation message");
    	alert.setHeaderText(null);
    	alert.setContentText("Are you sure to cancle this book?");
    	Optional<ButtonType> result = alert.showAndWait();
    	
    	// delete
    	if(result.get() == ButtonType.OK) {
    		Book book = tbl_borrow_with_card.getSelectionModel().getSelectedItem();
    		for(var i = 0; i < bookList.size(); i++) {
    			if(book != null) {
    				if(bookList.get(i).getCode() == book.getCode()) {
        				bookList.remove(i);
        			}
    			}else {
    				
    				alertShow(AlertType.INFORMATION, "Please select any book that you want to delete.");
    			}
    			
    		}
    		tbl_borrow_with_card.setItems(FXCollections.observableArrayList(bookList));
    	}
    }

    @FXML
    void btn_home_click(ActionEvent event) throws IOException {
    	LMS_Main.changeScene("view/Home.fxml");
    }

    @FXML
    void btn_search_click(ActionEvent event) {
    	if(txt_book_id.getText() != null) {
    		int book_code = Integer.parseInt(txt_book_id.getText());
        	Book book = DatabaseService.searchBooksByBookID(book_code);
        	if(book != null) {
        		// System.out.println(book.getIs_available());
        		if(book.getIs_available().equalsIgnoreCase("no")) {
        			alertShow(AlertType.INFORMATION, "This book has been borrowed by other.");
        		}else {
        			bookList.add(book);
        			tbl_borrow_with_card.setItems(FXCollections.observableArrayList(bookList));
        		}
        	}else {
        		alertShow(AlertType.INFORMATION, "This book does not exist.");
        	}
    	}else {
    		alertShow(AlertType.INFORMATION, "Enter Book ID");
    	}
    	
    	txt_book_id.setText(null);
    }


	private void alertShow(AlertType type, String body) {
		Alert alert = new Alert(type);
		alert.setTitle("Library Management System");
		alert.setHeaderText(null);
		alert.setContentText(body);
		alert.showAndWait();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		col_book_code.setCellValueFactory(new PropertyValueFactory<>("code"));
		col_title.setCellValueFactory(new PropertyValueFactory<>("title"));
		col_author.setCellValueFactory(new PropertyValueFactory<>("author_name"));
		col_category.setCellValueFactory(new PropertyValueFactory<>("category_name"));
		txt_book_id.setText(null);
	}
}
