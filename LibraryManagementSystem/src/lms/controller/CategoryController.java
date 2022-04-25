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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import lms.LMS_Main;
import lms.mode.service.DatabaseService;
import lms.model.entity.Category;

public class CategoryController implements Initializable {
	@FXML
	private TableView<Category> tbl_category;

	@FXML
	private TableColumn<Category, Integer> tbl_category_id;

	@FXML
	private TableColumn<Category, String> tbl_name;

	@FXML
	private TextField txt_category_id;

	@FXML
	private TextField txt_name;

	@FXML
	void btn_add_click(ActionEvent event) {
		String name = txt_name.getText();
		if(DatabaseService.addCategory(name)) {
			loadCategories();
		}else {
			alertShow(AlertType.ERROR, "Something is wrong!");
		}
		resetCategory();
	}
	
	private void alertShow(AlertType type, String body) {
		Alert alert = new Alert(type);
		alert.setTitle("Message");
		alert.setHeaderText(null);
		alert.setContentText(body);
		alert.showAndWait();
	}

	private void resetCategory() {
		txt_category_id.setText(null);
		txt_name.setText(null);
		tbl_category.getSelectionModel().clearSelection();
	}

	@FXML
	void btn_back_click(ActionEvent event) throws IOException {
		LMS_Main.changeScene("view/Home.fxml");
	}

	@FXML
	void btn_edit_click(ActionEvent event) {
		int category_id = Integer.parseInt(txt_category_id.getText());
		String name = txt_name.getText();
		if(DatabaseService.updateCategory(category_id, name)) {
			loadCategories();
		}else {
			alertShow(AlertType.ERROR, "Something is wrong!");
		}
		resetCategory();
	}

	@FXML
	void btn_search_click(ActionEvent event) {
		String name = txt_name.getText();
		
		if(name == null) {
			loadCategories();
		}else {
			List<Category> categorylist = DatabaseService.searchCategories(name);
			tbl_category.setItems(FXCollections.observableArrayList(categorylist));
		}
		resetCategory();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		tbl_category_id.setCellValueFactory(new PropertyValueFactory<>("category_id"));
		tbl_name.setCellValueFactory(new PropertyValueFactory<>("name"));
		
		loadCategories();
		
		tbl_category.getSelectionModel().selectedItemProperty().addListener(
				(obs, oldSelected, newSelected) -> {
					if(newSelected != null) {
						Category cate = tbl_category.getSelectionModel().getSelectedItem();
						txt_category_id.setText(String.valueOf(cate.getCategory_id()));
						txt_name.setText(cate.getName());
					}
				}
				);
		
	}

	private void loadCategories() {
		List<Category> categorylist = DatabaseService.getAllCategories();
		tbl_category.setItems(FXCollections.observableArrayList(categorylist));
	}
}
