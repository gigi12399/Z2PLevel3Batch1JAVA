package lms.controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import lms.LMS_Main;

public class HomeController {
	@FXML
	void btn_author_click(MouseEvent event) throws IOException {
		LMS_Main.changeScene("view/Author.fxml");
	}

	@FXML
	void btn_book_click(MouseEvent event) throws IOException {
		LMS_Main.changeScene("view/Book.fxml");
	}

	@FXML
	void btn_borrow_book_click(MouseEvent event) throws IOException {
		LMS_Main.changeScene("view/ChooseAboutBorrow.fxml");
	}

	@FXML
	void btn_category_click(MouseEvent event) throws IOException {
		LMS_Main.changeScene("view/Category.fxml");
	}

	@FXML
	void btn_librarian_click(MouseEvent event) throws IOException {
		LMS_Main.changeScene("view/Librarian.fxml");
	}

	@FXML
	void btn_log_out_click(ActionEvent event) throws IOException {
		LMS_Main.changeScene("view/Login.fxml");
	}

	@FXML
	void btn_member_click(MouseEvent event) throws IOException {
		LMS_Main.changeScene("view/Member.fxml");
	}

	@FXML
	void btn_return_book_click(MouseEvent event) throws IOException {
		LMS_Main.changeScene("view/ReturnBooks.fxml");
	}
}
