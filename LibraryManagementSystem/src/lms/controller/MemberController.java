package lms.controller;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.Year;
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
import lms.model.entity.Member;

public class MemberController implements Initializable {
	@FXML
	private TableColumn<Member, Year> col_acedemic_year;

	@FXML
	private TableColumn<Member, Integer> col_card_id;

	@FXML
	private TableColumn<Member, String> col_class_year;

	@FXML
	private TableColumn<Member, LocalDate> col_created_date;

	@FXML
	private TableColumn<Member, LocalDate> col_expired_date;

	@FXML
	private TableColumn<Member, String> col_name;

	@FXML
	private TableColumn<Member, String> col_roll_no;

	@FXML
	private TableView<Member> tbl_member;

	@FXML
	private TextField txt_acedemic_year;

	@FXML
	private TextField txt_card_id;

	@FXML
	private TextField txt_class_year;

	@FXML
	private TextField txt_name;

	@FXML
	private TextField txt_roll_no;

	@FXML
	void btn_add_click(ActionEvent event) {
		Member member = new Member();
		member.setCard_id(Integer.parseInt(txt_card_id.getText()));
		member.setName(txt_name.getText());
		member.setRoll_no(txt_roll_no.getText());
		member.setClass_year(txt_class_year.getText());
		member.setAcedemic_year(Integer.parseInt(txt_acedemic_year.getText()));
		LocalDate date = LocalDate.now();
		member.setCreated_date(date);
		member.setExpired_date(date.plusYears(1));

		if (DatabaseService.addMember(member)) {
			loadMembers();
		} else {
			alertShow(AlertType.ERROR, "Something is wrong!! Please try again.");
		}
		resetMember();
	}

	private void resetMember() {
		txt_card_id.setText(null);
		txt_name.setText(null);
		txt_roll_no.setText(null);
		txt_class_year.setText(null);
		txt_acedemic_year.setText(null);
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
		Member member = new Member();
		member.setCard_id(Integer.parseInt(txt_card_id.getText()));
		member.setName(txt_name.getText());
		member.setRoll_no(txt_roll_no.getText());
		member.setClass_year(txt_class_year.getText());
		member.setAcedemic_year(Integer.parseInt(txt_acedemic_year.getText()));
		if (DatabaseService.updateMember(member)) {
			loadMembers();
		} else {
			alertShow(AlertType.ERROR, "Something is wrong!! Please try again.");
		}
		resetMember();
	}

	@FXML
	void btn_search_click(ActionEvent event) {
		Member member = new Member();
		if (txt_card_id.getText() == null) {
			member.setCard_id(-1);
		}else {
			member.setCard_id(Integer.parseInt(txt_card_id.getText()));
		}

		member.setName(txt_name.getText());
		member.setRoll_no(txt_roll_no.getText());
		member.setClass_year(txt_class_year.getText());

		if (txt_acedemic_year.getText() == null) {
			member.setAcedemic_year(-1);
		}else {
			member.setAcedemic_year(Integer.parseInt(txt_acedemic_year.getText()));
		}

		if (member.getCard_id() == -1 && member.getName() == null && member.getRoll_no() == null
				&& member.getClass() == null && member.getAcedemic_year() == -1) {
			loadMembers();
		}
		List<Member> memberlist = DatabaseService.searchMembers(member);
		tbl_member.setItems(FXCollections.observableArrayList(memberlist));

		resetMember();

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		col_card_id.setCellValueFactory(new PropertyValueFactory<>("card_id"));
		col_name.setCellValueFactory(new PropertyValueFactory<>("name"));
		col_roll_no.setCellValueFactory(new PropertyValueFactory<>("roll_no"));
		col_class_year.setCellValueFactory(new PropertyValueFactory<>("class_year"));
		col_acedemic_year.setCellValueFactory(new PropertyValueFactory<>("acedemic_year"));
		col_created_date.setCellValueFactory(new PropertyValueFactory<>("created_date"));
		col_expired_date.setCellValueFactory(new PropertyValueFactory<>("expired_date"));
		resetMember();
		loadMembers();

		tbl_member.getSelectionModel().selectedItemProperty().addListener((obs, oldSelected, newSelected) -> {
			if (newSelected != null) {
				Member member = tbl_member.getSelectionModel().getSelectedItem();
				txt_card_id.setText(String.valueOf(member.getCard_id()));
				txt_name.setText(member.getName());
				txt_roll_no.setText(member.getRoll_no());
				txt_class_year.setText(member.getClass_year());
				txt_acedemic_year.setText(String.valueOf(member.getAcedemic_year()));
			}
		});
	}

	private void loadMembers() {
		List<Member> memberlist = DatabaseService.getAllMembers();
		tbl_member.setItems(FXCollections.observableArrayList(memberlist));
	}
}
