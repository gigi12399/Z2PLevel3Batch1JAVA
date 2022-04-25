package lms;
	
import lms.LMS_Main;

import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;


public class LMS_Main extends Application {
	private static Stage primaryStage;
	@Override
	public void start(Stage Stage) {
		try {
			primaryStage = Stage;
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("view/Login.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Library Management System");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	public static void main(String[] args) {
		launch(args);
	}



	public static void changeScene(String view) throws IOException {
		Parent root = FXMLLoader.load(LMS_Main.class.getResource(view));
		Scene scene = new Scene(root);
		primaryStage.hide();
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
}
