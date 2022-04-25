package lms.controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
public class CardBorrowingHistoryController {
	 @FXML
	    private TableColumn<?, ?> col_book;

	    @FXML
	    private TableColumn<?, ?> col_borrow_date;

	    @FXML
	    private TableColumn<?, ?> col_due_date;

	    @FXML
	    private TableColumn<?, ?> col_fine_fees;

	    @FXML
	    private TableColumn<?, ?> col_id;

	    @FXML
	    private TableColumn<?, ?> col_librarian;

	    @FXML
	    private TableColumn<?, ?> col_member;

	    @FXML
	    private TableColumn<?, ?> col_return_date;

	    @FXML
	    private TableView<?> tbl_card_borrow_history;

	    @FXML
	    void btn_back_click(ActionEvent event) {

	    }

	    @FXML
	    void btn_home_click(ActionEvent event) {

	    }
}
