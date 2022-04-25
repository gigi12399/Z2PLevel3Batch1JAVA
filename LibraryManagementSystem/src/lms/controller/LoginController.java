package lms.controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import lms.LMS_Main;
import lms.mode.service.DatabaseService;
import lms.model.entity.Librarian;

public class LoginController {
	@FXML
	private TextField txt_username;

	@FXML
	private Text txt_error;

	@FXML
	private TextField txt_password;

	@FXML
	void btn_login_click(ActionEvent event) throws IOException {
		String name = txt_username.getText();
		String password = txt_password.getText();
		boolean result = DatabaseService.getLogin(name, password);

		if (result) {
			LMS_Main.changeScene("view/Home.fxml");
		} else {
			txt_error.setText("Invalid username or password!!");
		}
	}
}
