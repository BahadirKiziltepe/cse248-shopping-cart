package newPro;

import java.io.IOException;

import View.LoginScene;
import application.BorderPane;
import application.FXMLLoader;
import application.Main;
import application.Scene;
import application.VBox;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	
	private Stage stg = new Stage();

	@Override
	public void start(Stage stg) throws Exception {
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public void init() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getClass().getClassLoader().getResource("View/Root.fxml"));
			root = (BorderPane) loader.load();
			showLoginPage();
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getClassLoader().getResource("/View/application.css").toExternalForm());
			mainStage.setScene(scene);
			mainStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void showLoginPage() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getClass().getClassLoader().getResource("/View/Login.fxml"));
			VBox loginBox = (VBox) loader.load();
			root.setCenter(loginBox);
			LoginScene login = loader.getController();
			login.setMain(this);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
