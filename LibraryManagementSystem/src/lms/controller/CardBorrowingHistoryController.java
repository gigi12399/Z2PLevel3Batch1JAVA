package lms.controller;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lms.LMS_Main;
import lms.mode.service.DatabaseService;
import lms.model.entity.BorrowBook;
public class CardBorrowingHistoryController implements Initializable {
	 @FXML
	    private TableColumn<BorrowBook, String> col_book;

	    @FXML
	    private TableColumn<BorrowBook, LocalDate> col_borrow_date;

	    @FXML
	    private TableColumn<BorrowBook, LocalDate> col_due_date;

	    @FXML
	    private TableColumn<BorrowBook, Integer> col_fine_fees;

	    @FXML
	    private TableColumn<BorrowBook, Integer> col_id;

	    @FXML
	    private TableColumn<BorrowBook, String> col_librarian;

	    @FXML
	    private TableColumn<BorrowBook, String> col_member;

	    @FXML
	    private TableColumn<BorrowBook, LocalDate> col_return_date;

	    @FXML
	    private TableView<BorrowBook> tbl_card_borrow_history;

	    @FXML
	    void btn_back_click(ActionEvent event) throws IOException {
	    	LMS_Main.changeScene("view/CardBorrowBooks.fxml");
	    }

	    @FXML
	    void btn_home_click(ActionEvent event) throws IOException {
	    	LMS_Main.changeScene("view/Home.fxml");
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
			
			List<BorrowBook> borrowBooksList = DatabaseService.searchBorrowBooksByMember(CardIDCheckController.login_member.getCard_id());
			tbl_card_borrow_history.setItems(FXCollections.observableArrayList(borrowBooksList));
		}
}
