package lms.controller;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

import javax.xml.crypto.Data;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import lms.LMS_Main;
import lms.mode.service.DatabaseService;
import lms.model.entity.BorrowBook;
import lms.model.entity.Member;

public class BorrowHistoryController implements Initializable {
	@FXML
	private TableColumn<BorrowBook, String> col_book;

	@FXML
	private TableColumn<BorrowBook, LocalDate> col_borrow_date;

	@FXML
	private TableColumn<BorrowBook, String> col_member;

	@FXML
	private TableColumn<BorrowBook, LocalDate> col_due_date;

	@FXML
	private TableColumn<BorrowBook, Integer> col_fine_fees;

	@FXML
	private TableColumn<BorrowBook, Integer> col_id;

	@FXML
	private TableColumn<BorrowBook, String> col_librarian;

	@FXML
	private TableColumn<BorrowBook, LocalDate> col_return_date;

	@FXML
	private TableView<BorrowBook> tbl_borrow_books;

	@FXML
	private TextField txt_member_id;

	@FXML
	void btn_Home_click(ActionEvent event) throws IOException {
		LMS_Main.changeScene("view/Home.fxml");
	}

	@FXML
	void btn_back_click(ActionEvent event) throws IOException {
		LMS_Main.changeScene("view/ChooseAboutBorrow.fxml");
	}

	@FXML
	void btn_search_click(ActionEvent event) {
		String member = txt_member_id.getText();
		int member_id;
		if (member == null) {
			List<BorrowBook> borrowBookList = DatabaseService.getAllBorrowBooks();
			tbl_borrow_books.setItems(FXCollections.observableArrayList(borrowBookList));
		}else {
			member_id = Integer.parseInt(member);
			Member mem = DatabaseService.searchCardID(member);
			if(mem != null) {
				List<BorrowBook> borrowList = DatabaseService.searchBorrowBooksByMember(member_id);
				tbl_borrow_books.setItems(FXCollections.observableArrayList(borrowList));
			}else {
				alertShow(AlertType.INFORMATION, "Does not exit this Card ID!!");
			}
			
			txt_member_id.setText(null);
		}
		
	}
	
	private void alertShow(AlertType type, String body) {
		Alert alert = new Alert(type);
		alert.setTitle("Message");
		alert.setHeaderText(null);
		alert.setContentText(body);
		alert.showAndWait();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
		col_member.setCellValueFactory(new PropertyValueFactory<>("member_name"));
		col_book.setCellValueFactory(new PropertyValueFactory<>("book_title"));
		col_borrow_date.setCellValueFactory(new PropertyValueFactory<>("borrow_date"));
		col_due_date.setCellValueFactory(new PropertyValueFactory<>("due_date"));
		col_return_date.setCellValueFactory(new PropertyValueFactory<>("return_date"));
		col_librarian.setCellValueFactory(new PropertyValueFactory<>("librarian_name"));
		col_fine_fees.setCellValueFactory(new PropertyValueFactory<>("fine_fees"));

		txt_member_id.setText(null);
		List<BorrowBook> borrowBookList = DatabaseService.getAllBorrowBooks();
		tbl_borrow_books.setItems(FXCollections.observableArrayList(borrowBookList));

	}

}
