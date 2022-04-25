package lms.controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
public class CardBorrowBooksController {
	@FXML
    private TableColumn<?, ?> col_author;

    @FXML
    private TableColumn<?, ?> col_book_code;

    @FXML
    private TableColumn<?, ?> col_category;

    @FXML
    private TableColumn<?, ?> col_title;

    @FXML
    private TableView<?> tbl_borrow_with_card;

    @FXML
    private TextField txt_book_id;

    @FXML
    void btn_back_click(ActionEvent event) {

    }

    @FXML
    void btn_confirm_borrow_click(ActionEvent event) {

    }

    @FXML
    void btn_home_click(ActionEvent event) {

    }

    @FXML
    void btn_search_click(ActionEvent event) {

    }
}
