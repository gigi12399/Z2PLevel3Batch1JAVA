package application;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class RegisterController implements Initializable {
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
		
		RadioButton selectedRadio = (RadioButton) radio_group.getSelectedToggle();
		
		String skillsets = "";
		if(chk_java.isSelected()) {
			skillsets += chk_java.getText() + ", ";
		}
		if(chk_mysql.isSelected()) {
			skillsets += chk_mysql.getText() + ", ";
		}
		if(chk_js.isSelected()) {
			skillsets += chk_js.getText() + ", ";
		}
		
		int index = cbo_city.getSelectionModel().getSelectedIndex();
		if(index == -1) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Message");
			alert.setContentText("Please choose city");
			alert.setHeaderText(null);
			alert.showAndWait();
			return;
		}
		
		String city = cbo_city.getSelectionModel().getSelectedItem();
		
		System.out.println("Name: " + name);
		System.out.println("Password: " + pass);
		System.out.println("Birthday: " + birthday);
		System.out.println("City: " + city);
		System.out.println("Gender: " + selectedRadio.getText());
		System.out.println("Skill Set:	" + skillsets.substring(0, skillsets.lastIndexOf(", ")));
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		List<String> cities = List.of("Yangon", "Mandalay", "Monywa");
		
		cbo_city.setItems(FXCollections.observableArrayList(cities));
		
	}
}
