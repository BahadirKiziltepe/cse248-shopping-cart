package Controllers;

import java.io.IOException;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LoginScene {
	
	private StoreDataBase data;
	
	public LoginScene(StoreDataBase data) {
		this.data = data;
	}

	@FXML
	private PasswordField password;

	@FXML
	private TextField username;

	@FXML
	private Button btnLogn;

	@FXML
	private Text createAccount;

	@FXML
	void Login(ActionEvent event) {
		if (LoginCheck()) {
			VBox root = null;
			try {
				root = (VBox) FXMLLoader.load(getClass().getResource("/View/MainMenu.fxml"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			Scene scene = new Scene(root);
			Main.mainStage.setScene(scene);
		}
	}

	boolean LoginCheck() {
		if(data.getAllAccounts().containsKey(username)) {
			if(data.getAllAccounts().get(username).equals(password)) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}

	@FXML
	void mouseOnButton(MouseEvent event) {
		btnLogn.setCursor(Cursor.HAND);
		btnLogn.setUnderline(true);
	}

	@FXML
	void mouseNotOnButton(MouseEvent event) {
		btnLogn.setUnderline(false);
	}

	@FXML
	void createNewAccount(MouseEvent event) {
		VBox root = null;
		try {
			root = (VBox) FXMLLoader.load(getClass().getResource("/View/Register.fxml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Scene scene = new Scene(root);
		Main.mainStage.setScene(scene);
	}

	@FXML
	void hyperEnter(MouseEvent event) {
		createAccount.setCursor(Cursor.HAND);
		createAccount.setUnderline(true);
		createAccount.setFill(Color.CYAN);
	}

	@FXML
	void hyperOut(MouseEvent event) {
		createAccount.setUnderline(false);
		createAccount.setFill(Color.BLACK);
	}

}
