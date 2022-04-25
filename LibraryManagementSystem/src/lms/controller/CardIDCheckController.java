package lms.controller;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import lms.LMS_Main;
import lms.mode.service.DatabaseService;

public class CardIDCheckController {
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
    	if(card_id == null || card_id.isEmpty()) {
    		alertShow(AlertType.WARNING, "Enter Card ID");
    		return;
    	}else {
    		if(DatabaseService.searchCardID(card_id)) {
        		LMS_Main.changeScene("view/CardAboutBorrow.fxml");
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
