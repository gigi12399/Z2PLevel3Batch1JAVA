package application;

import java.io.IOException;
import java.time.LocalDate;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class RegisterController {
	@FXML
	private TextField txt_name;
	@FXML
	private PasswordField txt_pass;
	@FXML
	private DatePicker birthday_picker;
	@FXML
	private ComboBox<String> cbo_city;
	@FXML
	private ToggleGroup radio_group;
	@FXML
	private CheckBox chk_java,chk_mysql,chk_js;
	@FXML
	private TextArea edu_textarea;
	
	@FXML
	public void btn_login_click() throws IOException {
		Main.changeScence("Sample.fxml");
	}
	
	@FXML
	public void btn_register_click() {
		String name = txt_name.getText();
		String pass = txt_pass.getText();
		LocalDate birthday = birthday_picker.getValue();
		System.out.println("Name: " + name);
		System.out.println("Password: " + pass);
		System.out.println("Birthday: " + birthday);
	}
}
