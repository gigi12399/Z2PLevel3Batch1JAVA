package lms.controller;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import lms.LMS_Main;
import lms.mode.service.DatabaseService;
import lms.model.entity.Author;
import lms.model.entity.Book;
import lms.model.entity.Category;

public class BookController implements Initializable {
	@FXML
    private ToggleGroup available_gp;

    @FXML
    private ComboBox<String> cbo_author;

    @FXML
    private ComboBox<String> cbo_category;

    @FXML
    private TableColumn<Book, Integer> col_author_id;

    @FXML
    private TableColumn<Book, Integer> col_category_id;

    @FXML
    private TableColumn<Book, Integer> col_code;

    @FXML
    private TableColumn<Book, String> col_is_available;

    @FXML
    private TableColumn<Book, String> col_title;

    @FXML
    private TableView<Book> tbl_book;

    @FXML
    private TextField txt_code;

    @FXML
    private TextField txt_title;
    
    @FXML
    private RadioButton no_radio_btn;
    
    @FXML
    private RadioButton yes_radio_btn;
    
    List<Author> authorlist = new ArrayList<>();
    List<Category> categorylist = new ArrayList<>();

    @FXML
    void btn_add_click(ActionEvent event) {
    	Book book = new Book();
    	RadioButton selected_gp = (RadioButton) available_gp.getSelectedToggle();
    	
    	if(txt_code.getText() == null) {
    		alertShow(AlertType.WARNING, "Please enter Code!!");
    		return;
    	}
    	if(txt_code.getText() == null) {
    		alertShow(AlertType.WARNING, "Please enter Title!!");
    		return;
    	}
    	if(cbo_author.getSelectionModel().getSelectedIndex() == -1) {
    		alertShow(AlertType.WARNING, "Please choose Author!!");
    		return;
    	}
    	if(cbo_category.getSelectionModel().getSelectedIndex() == -1) {
    		alertShow(AlertType.WARNING, "Please choose Category!!");
    		return;
    	}
    	
    	book.setCode(Integer.parseInt(txt_code.getText()));
    	book.setTitle(txt_title.getText());
    	book.setAuthor(authorlist.get(cbo_author.getSelectionModel().getSelectedIndex()));
    	book.setCategory(categorylist.get(cbo_category.getSelectionModel().getSelectedIndex()));
    	book.setIs_available(selected_gp.getText());
    	
    	if(DatabaseService.addBook(book)) {
    		loadBooks();
    	}else {
    		alertShow(AlertType.ERROR, "Something is wrong!! Please try again.");
    	}
    	resetBook();
    }
    
    private void resetBook() {
		txt_code.setText(null);
		txt_title.setText(null);
		cbo_author.getSelectionModel().clearSelection();
		cbo_category.getSelectionModel().clearSelection();
		yes_radio_btn.setSelected(false);
		no_radio_btn.setSelected(false);
	}

	private void alertShow(AlertType type, String body) {
		Alert alert = new Alert(type);
		alert.setTitle("Message");
		alert.setHeaderText(null);
		alert.setContentText(body);
		alert.showAndWait();
	}

    @FXML
    void btn_back_click(ActionEvent event) throws IOException {
    	LMS_Main.changeScene("view/Home.fxml");
    }

    @FXML
    void btn_edit_click(ActionEvent event) {
    	Book book = new Book();
    	RadioButton selected_gp = (RadioButton) available_gp.getSelectedToggle();
    	
    	book.setCode(Integer.parseInt(txt_code.getText()));
    	book.setTitle(txt_title.getText());
    	book.setAuthor(authorlist.get(cbo_author.getSelectionModel().getSelectedIndex()));
    	book.setCategory(categorylist.get(cbo_category.getSelectionModel().getSelectedIndex()));
    	book.setIs_available(selected_gp.getText());
    	
    	if(DatabaseService.editBook(book)) {
    		loadBooks();
    	}else {
    		alertShow(AlertType.ERROR, "Something is wrong!! Please try again.");
    	}
    	resetBook();
    }

    @FXML
    void btn_search_click(ActionEvent event) {
    	Book book = new Book();
    	RadioButton selected_gp = (RadioButton) available_gp.getSelectedToggle();
    	
    	String codeString = txt_code.getText();
    	int codeInt;
    	if(codeString == null) {
    		codeString = "-1";
    		codeInt = Integer.parseInt(codeString);
    		book.setCode(codeInt);
    	}else {
    		book.setCode(Integer.parseInt(codeString));
    	}
    	
    	book.setTitle(txt_title.getText());
    	if(cbo_author.getSelectionModel().getSelectedIndex() == -1) {
    		book.setAuthor(null);
    	}else {
    		book.setAuthor(authorlist.get(cbo_author.getSelectionModel().getSelectedIndex()));
    	}
    	if(cbo_category.getSelectionModel().getSelectedIndex() == -1) {
    		book.setCategory(null);
    	}else {
    		book.setCategory(categorylist.get(cbo_category.getSelectionModel().getSelectedIndex()));
    	}
    	if(selected_gp != null) {
    		book.setIs_available(selected_gp.getText());
    	}
    	List<Book> booklist = DatabaseService.searchBooks(book);
    	tbl_book.setItems(FXCollections.observableArrayList(booklist));
    	
    	resetBook();
    }
    
    @FXML
    void btn_search_all_click(ActionEvent event) {
    	loadBooks();
    	resetBook();
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		loadBooks();
		loadAuthors();
		loadCategories();
		txt_code.setText(null);
		txt_title.setText(null);
		
		
		tbl_book.getSelectionModel().selectedItemProperty().addListener(
				(obs, oldSelected, newSelected) -> {
					if(newSelected != null) {
						Book book = tbl_book.getSelectionModel().getSelectedItem();
						txt_code.setText(String.valueOf(book.getCode()));
						txt_title.setText(book.getTitle());
						cbo_author.getSelectionModel().select(book.getAuthor_name());
						cbo_category.getSelectionModel().select(book.getCategory_name());
						if(book.getIs_available().equalsIgnoreCase("yes")) {
							yes_radio_btn.setSelected(true);
						}else {
							no_radio_btn.setSelected(true);
						}
					}
				}
				);
	}

	private void loadCategories() {
		categorylist = DatabaseService.getAllCategories();
		
		List<String> namelist = categorylist.stream()
								.map(s -> s.getName())
								.collect(Collectors.toList());
		cbo_category.setItems(FXCollections.observableArrayList(namelist));
		
	}

	private void loadAuthors() {
		authorlist = DatabaseService.getAllAuthors();
		List<String> namelist = authorlist.stream()
								.map(s -> s.getName())
								.collect(Collectors.toList());
		cbo_author.setItems(FXCollections.observableArrayList(namelist));
	}

	private void loadBooks() {
		col_code.setCellValueFactory(new PropertyValueFactory<>("code"));
		col_title.setCellValueFactory(new PropertyValueFactory<>("title"));
		col_author_id.setCellValueFactory(new PropertyValueFactory<>("author_name"));
		col_category_id.setCellValueFactory(new PropertyValueFactory<>("category_name"));
		col_is_available.setCellValueFactory(new PropertyValueFactory<>("is_available"));
		
		List<Book> booklist = DatabaseService.getAllBooks();
		tbl_book.setItems(FXCollections.observableArrayList(booklist));
	}
}
