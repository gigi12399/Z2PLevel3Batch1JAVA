package lms.controller;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import lms.LMS_Main;
public class CardAboutBorrowController {
	@FXML
    void btn_back_click(ActionEvent event) throws IOException {
		LMS_Main.changeScene("view/CardIDCheck.fxml");
    }

    @FXML
    void btn_borrow_books_click(ActionEvent event) throws IOException {
		LMS_Main.changeScene("view/CardBorrowBooks.fxml");
    }

    @FXML
    void btn_home_click(ActionEvent event) throws IOException {
		LMS_Main.changeScene("view/Home.fxml");
    }

    @FXML
    void btn_view_history_click(ActionEvent event) throws IOException {
		LMS_Main.changeScene("view/CardBorrowingHistory.fxml");
    }

}
