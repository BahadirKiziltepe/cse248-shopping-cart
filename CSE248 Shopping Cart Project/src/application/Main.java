package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.fxml.FXMLLoader;

public class Main extends Application {
	
	public static Stage mainStage;
	
	@Override
	public void start(Stage stg) {
		mainStage = stg;
		
		VBox root = null;
		try {
			root = (VBox) FXMLLoader.load(getClass().getResource("/View/Login.fxml"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("/View/application.css").toExternalForm());
		mainStage.setScene(scene);
		mainStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
