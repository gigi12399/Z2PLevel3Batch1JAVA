package lms.controller;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
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
import lms.model.entity.Librarian;
public class LibrarianController implements Initializable {
	@FXML
    private TableColumn<Librarian, LocalDate> col_created_at;

    @FXML
    private TableColumn<Librarian, Integer> col_id;

    @FXML
    private TableColumn<Librarian, String> col_nrcno;

    @FXML
    private TableColumn<Librarian, String> col_password;

    @FXML
    private TableColumn<Librarian, String> col_phone;

    @FXML
    private TableColumn<Librarian, String> col_username;

    @FXML
    private TableView<Librarian> tbl_librarian;

    @FXML
    private TextField txt_id;

    @FXML
    private TextField txt_nrcno;

    @FXML
    private TextField txt_password;

    @FXML
    private TextField txt_phone;

    @FXML
    private TextField txt_username;

    @FXML
    void btn_add_click(ActionEvent event) {
    	Librarian lib = new Librarian();
    	lib.setUsername(txt_username.getText());
    	lib.setPassword(txt_password.getText());
    	lib.setNrcno(txt_nrcno.getText());
    	lib.setPhone(txt_phone.getText());
    	
    	if(DatabaseService.addLibrarian(lib)) {
    		loadLibrarian();
    	}else {
    		alertShow(AlertType.ERROR, "Something is wrong!! Please try again.");
    	}
    	resetLibrarian();
    }
    
    private void resetLibrarian() {
		txt_id.setText(null);
		txt_username.setText(null);
		txt_password.setText(null);
		txt_nrcno.setText(null);
		txt_phone.setText(null);
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
    	Librarian lib = new Librarian();
    	lib.setId(Integer.parseInt(txt_id.getText()));
    	lib.setUsername(txt_username.getText());
    	lib.setPassword(txt_password.getText());
    	lib.setNrcno(txt_nrcno.getText());
    	lib.setPhone(txt_phone.getText());
    	
    	if(DatabaseService.updateLibrarian(lib)) {
    		loadLibrarian();
    	}else {
    		alertShow(AlertType.ERROR, "Something is wrong!! Please try again.");
    	}
    	resetLibrarian();
    }

    @FXML
    void btn_search_click(ActionEvent event) {
    	Librarian lib = new Librarian();
    	lib.setUsername(txt_username.getText());
    	lib.setPassword(txt_password.getText());
    	lib.setNrcno(txt_nrcno.getText());
    	lib.setPhone(txt_phone.getText());
    	
    	if(lib.getUsername() == null && lib.getPassword() == null && lib.getNrcno() == null && lib.getPhone() == null) {
    		loadLibrarian();
    	}
    	List<Librarian> librarianList = DatabaseService.searchLibrarian(lib);
    	tbl_librarian.setItems(FXCollections.observableArrayList(librarianList));
    	
    	resetLibrarian();
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
		col_username.setCellValueFactory(new PropertyValueFactory<>("username"));
		col_password.setCellValueFactory(new PropertyValueFactory<>("password"));
		col_nrcno.setCellValueFactory(new PropertyValueFactory<>("nrcno"));
		col_phone.setCellValueFactory(new PropertyValueFactory<>("phone"));
		col_created_at.setCellValueFactory(new PropertyValueFactory<>("created_at"));
		
		resetLibrarian();
		
		loadLibrarian();
		
		tbl_librarian.getSelectionModel().selectedItemProperty().addListener(
				(obs, oldSelected, newSelected) -> {
					if(newSelected != null) {
						Librarian lib = tbl_librarian.getSelectionModel().getSelectedItem();
						txt_id.setText(String.valueOf(lib.getId()));
						txt_username.setText(lib.getUsername());
						txt_password.setText(lib.getPassword());
						txt_nrcno.setText(lib.getNrcno());
						txt_phone.setText(lib.getPhone());
					}
				}
				);
		
		
	}

	private void loadLibrarian() {
		List<Librarian> librarianlist = DatabaseService.getAllLibrarian();
		tbl_librarian.setItems(FXCollections.observableArrayList(librarianlist));
	}

}
