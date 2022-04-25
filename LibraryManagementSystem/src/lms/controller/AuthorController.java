package lms.controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import lms.LMS_Main;
import lms.mode.service.DatabaseService;
import lms.model.entity.Author;

public class AuthorController implements Initializable {
	@FXML
	private TableView<Author> tbl_author;

	@FXML
	private TableColumn<Author, Integer> tbl_author_id;

	@FXML
	private TableColumn<Author, String> tbl_country;

	@FXML
	private TableColumn<Author, String> tbl_name;

	@FXML
	private TextField txt_author_id;

	@FXML
	private TextField txt_country;

	@FXML
	private TextField txt_name;

	@FXML
	void btn_add_click(ActionEvent event) {
		Author auth = new Author();
		auth.setName(txt_name.getText());
		auth.setCountry(txt_country.getText());
		if (DatabaseService.addAuthor(auth)) {
			loadAuthors();
		} else {
			alertShow(AlertType.ERROR, "Something is wrong!");
		}
		resetAuthor();
	}

	private void alertShow(AlertType type, String body) {
		Alert alert = new Alert(type);
		alert.setTitle("Message");
		alert.setHeaderText(null);
		alert.setContentText(body);
		alert.showAndWait();
	}

	private void resetAuthor() {
		txt_author_id.setText(null);
		txt_name.setText(null);
		txt_country.setText(null);
		tbl_author.getSelectionModel().clearSelection();
	}

	@FXML
	void btn_back_click(ActionEvent event) throws IOException {
		LMS_Main.changeScene("view/Home.fxml");
	}

	@FXML
	void btn_edit_click(ActionEvent event) {
		Author auth = new Author();
		auth.setAuthor_id(Integer.parseInt(txt_author_id.getText()));
		auth.setName(txt_name.getText());
		auth.setCountry(txt_country.getText());
		if (DatabaseService.UpdateAuthor(auth)) {
			loadAuthors();
		} else {
			alertShow(AlertType.ERROR, "Something is wrong!");
		}
		resetAuthor();
	}

	@FXML
	void btn_search_click(ActionEvent event) {
		String name = txt_name.getText();
		String country = txt_country.getText();

		if (name == null && country == null) {
			loadAuthors();
		}
		List<Author> authorlist = DatabaseService.searchAuthors(name, country);
		tbl_author.setItems(FXCollections.observableArrayList(authorlist));
		resetAuthor();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		tbl_author_id.setCellValueFactory(new PropertyValueFactory<>("author_id"));
		tbl_name.setCellValueFactory(new PropertyValueFactory<>("name"));
		tbl_country.setCellValueFactory(new PropertyValueFactory<>("country"));
		loadAuthors();
		txt_name.setText(null);
		txt_country.setText(null);

		tbl_author.getSelectionModel().selectedItemProperty().addListener((obs, oldSelected, newSelected) -> {
			if (newSelected != null) {
				Author auth = tbl_author.getSelectionModel().getSelectedItem();
				txt_author_id.setText(String.valueOf(auth.getAuthor_id()));
				txt_name.setText(auth.getName());
				txt_country.setText(auth.getCountry());
			}
		});

	}

	private void loadAuthors() {
		List<Author> authorlist = DatabaseService.getAllAuthors();

		tbl_author.setItems(FXCollections.observableArrayList(authorlist));
	}
}
