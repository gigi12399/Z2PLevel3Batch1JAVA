package application;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class SampleController {
	@FXML
	private TextField txt_name;
	@FXML
	private PasswordField txt_password;
	@FXML
	private Label lbl_result;
	
	@FXML
	public void btn_login_click() {
		String name = txt_name.getText();
		String pass = txt_password.getText();
		
		if(name.isEmpty() || pass.isEmpty()) {
			lbl_result.setText("Please fill all data");
		}else if(name.equalsIgnoreCase("admin") && pass.equalsIgnoreCase("admin")) {
			lbl_result.setText("Login Success");
		}else {
			lbl_result.setText("Username and password do not match");
		}
	}
	
	@FXML
	public void btn_register_click() {
		try {
			Main.changeScence("Register.fxml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
