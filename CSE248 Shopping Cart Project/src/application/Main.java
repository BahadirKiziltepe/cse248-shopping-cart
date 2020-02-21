package application;

import model.Account;
import model.StoreDataBase;

import java.io.IOException;

import controllers.LoginController;
import controllers.MainMenuController;
import controllers.RegisterController;
import controllers.RootController;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.fxml.FXMLLoader;

public class Main extends Application {

	private Stage mainStage = new Stage();
	private BorderPane root = new BorderPane();
	
	private Account currentUser = null;
	private StoreDataBase data = new StoreDataBase();

	@Override
	public void start(Stage stg) {
		initialize();
	}

	public static void main(String[] args) {
		launch(args);
	}

	public void initialize() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(this.getClass().getResource("/view/Root.fxml"));
			root = (BorderPane) loader.load();
			RootController controller = loader.getController();
			controller.setMain(this);
			Scene scene = new Scene(root);
			showLoginPage();
			mainStage.setScene(scene);
			mainStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void showLoginPage() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(this.getClass().getResource("/view/Login.fxml"));
			VBox loginBox = new VBox();
			loginBox = (VBox) loader.load();
			root.setCenter(loginBox);
			LoginController login = loader.getController();
			login.setMain(this);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void showRegisterPage() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(this.getClass().getResource("/view/Register.fxml"));
			VBox loginBox = new VBox();
			loginBox = (VBox) loader.load();
			root.setCenter(loginBox);
			RegisterController login = loader.getController();
			login.setMain(this);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void showMainMenuPage() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(this.getClass().getResource("/view/MainMenu.fxml"));
			VBox loginBox = new VBox();
			loginBox = (VBox) loader.load();
			root.setCenter(loginBox);
			MainMenuController login = loader.getController();
			login.setMain(this);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void showAccountPage() {
		
	}
	
	public void showStorePage() {
		
	}
	
	public void showCartPage() {
		
	}

	public StoreDataBase getData() {
		return data;
	}

	public Account getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(Account currentUser) {
		this.currentUser = currentUser;
	}
}
