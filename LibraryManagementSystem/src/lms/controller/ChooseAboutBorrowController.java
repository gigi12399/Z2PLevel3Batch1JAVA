package lms.controller;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import lms.LMS_Main;
public class ChooseAboutBorrowController {
	@FXML
    void btn_back_click(ActionEvent event) throws IOException {
		LMS_Main.changeScene("view/Home.fxml");
    }

    @FXML
    void btn_borrow_books_click(ActionEvent event) throws IOException {
    	LMS_Main.changeScene("view/CardIDCheck.fxml");
    }

    @FXML
    void btn_borrow_history_click(ActionEvent event) throws IOException {
    	LMS_Main.changeScene("view/BorrowHistory.fxml");
    }
}
