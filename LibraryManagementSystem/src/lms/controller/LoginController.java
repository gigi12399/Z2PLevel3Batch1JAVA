package lms.controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import lms.LMS_Main;
import lms.mode.service.DatabaseService;
import lms.model.entity.Librarian;

public class LoginController {
	public static Librarian login_librarian;
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
		if(name.isEmpty() && password.isEmpty()) {
			txt_error.setText("Enter Username And Password");
			return;
		}
		if(name.isEmpty()) {
			txt_error.setText("Enter Username");
			return;
		}
		if(password.isEmpty()) {
			txt_error.setText("Enter Password");
			return;
		}
		
		Librarian lib = DatabaseService.getLogin(name, password);

		if (lib != null ) {
			login_librarian = lib;
			LMS_Main.changeScene("view/Home.fxml");
		} else {
			txt_error.setText("Invalid username or password!!");
		}
	}

}
