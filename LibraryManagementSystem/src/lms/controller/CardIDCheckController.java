package lms.controller;
import java.io.IOException;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import lms.LMS_Main;
import lms.mode.service.DatabaseService;
import lms.model.entity.BorrowBook;
import lms.model.entity.Member;

public class CardIDCheckController {
	public static Member login_member;
	@FXML
    private TextField txt_card_id;

    @FXML
    void btn_back_click(ActionEvent event) throws IOException {
    	LMS_Main.changeScene("view/ChooseAboutBorrow.fxml");
    }
    
    @FXML
    void btn_home_click(ActionEvent event) throws IOException {
    	LMS_Main.changeScene("view/Home.fxml");
    }

    @FXML
    void btn_search_click(ActionEvent event) throws IOException {
    	String card_id = txt_card_id.getText();
    	int count = 0;
    	if(card_id == null || card_id.isEmpty()) {
    		alertShow(AlertType.WARNING, "Enter Card ID");
    		return;
    	}else {
    		Member mem = DatabaseService.searchCardID(card_id);
    		if(mem != null) {
    			
    			List<BorrowBook> borrowBooksList =  DatabaseService.searchBorrowBooksByMember(Integer.parseInt(card_id));
    			for(var i = 0; i < borrowBooksList.size(); i++) {
    				if(borrowBooksList.get(i).getFine_fees() > 0) {
    					count ++;
    				}
    			}
    			if(count > 3) {
    				alertShow(AlertType.INFORMATION, "Not allow to borrow to this Card ID!!");
    			}else {
    				login_member = mem;
            		LMS_Main.changeScene("view/CardBorrowBooks.fxml");
    			}
    			
        	}else {
        		alertShow(AlertType.INFORMATION, "Does not exit this Card ID!!");
        	}
    	}
    	
    }
    
    private void alertShow(AlertType type, String body) {
		Alert alert = new Alert(type);
		alert.setTitle("Message");
		alert.setHeaderText(null);
		alert.setContentText(body);
		alert.showAndWait();
	}
}
