package bms.controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import bms.BMS_Main;
import bms.model.entity.Author;
import bms.model.entity.Book;
import bms.model.entity.Category;
import bms.model.service.DatabaseService;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class BookEditController implements Initializable {
	@FXML
    private ComboBox<String> cbo_author;

    @FXML
    private ComboBox<String> cbo_category;

    @FXML
    private TextField txt_code;

    @FXML
    private DatePicker txt_publish;

    @FXML
    private TextField txt_title;
    
    private List<Author> authorList;
    private List<Category> categoryList;

    @FXML
    void btn_back_click(ActionEvent event) throws IOException {
    	BMS_Main.changeScene("view/books.fxml");
    }

    @FXML
    void btn_search_click(ActionEvent event) {
    	int code = Integer.parseInt(txt_code.getText());
    	Book searchBook = DatabaseService.findBookByCode(code);
    	if(searchBook != null) {
    		txt_title.setText(searchBook.getTitle());
    		txt_publish.setValue(searchBook.getPublish_date());
    		cbo_author.getSelectionModel().select(searchBook.getAuthorName());
    		cbo_category.getSelectionModel().select(searchBook.getCategoryName());
    	}else {
    		showAlert(AlertType.ERROR,"No Book with this Code - " + code);
    	}
    }

    private void showAlert(AlertType type, String msg) {
    	Alert alert = new Alert(type);
		alert.setTitle("Message");
		alert.setContentText(msg);
		alert.setHeaderText(null);
		alert.showAndWait();
		
	}

	@FXML
    void btn_update_click(ActionEvent event) {
    	Book book = new Book();
    	book.setCode(Integer.parseInt(txt_code.getText()));
    	book.setTitle(txt_title.getText());
    	book.setPublish_date(txt_publish.getValue());
    	
    	int author_index = cbo_author.getSelectionModel().getSelectedIndex();
    	int cat_index = cbo_category.getSelectionModel().getSelectedIndex();
    	
    	book.setAuthor(authorList.get(author_index));
    	book.setCategory(categoryList.get(cat_index));
    	
    	if(DatabaseService.updateBook(book)) {
    		showAlert(AlertType.INFORMATION, "Update Success");
    		txt_code.setText(null);
    		txt_title.setText(null);
    		txt_publish.setValue(null);
    		cbo_author.getSelectionModel().clearSelection();
    		cbo_category.getSelectionModel().clearSelection();
    	}else {
    		showAlert(AlertType.ERROR, "Something is wrong");
    	}
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		loadAuthors();
		loadCategory();
		
	}

	private void loadCategory() {
		categoryList =	DatabaseService.getAllCategory();
		
		List<String> names = categoryList.stream()
										.map(cat -> cat.getName())
										.collect(Collectors.toList());
		cbo_category.setItems(FXCollections.observableArrayList(names));
		
	}

	private void loadAuthors() {
		authorList = DatabaseService.getAllAuthors();
		
		List<String> names = authorList.stream()
									.map(a -> a.getName())
									.collect(Collectors.toList());
		
		cbo_author.setItems(FXCollections.observableArrayList(names));
		
	}
}
