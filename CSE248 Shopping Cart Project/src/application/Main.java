package application;

import model.Account;
import model.Address;
import model.Admin;
import model.Item;
import model.Name;
import model.StoreDataBase;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import controllers.AccountController;
import controllers.AccountsControllerForAdmin;
import controllers.AdminController;
import controllers.CartController;
import controllers.EditAccountController;
import controllers.ItemsControllerForAdmin;
import controllers.LoginController;
import controllers.MainMenuController;
import controllers.RegisterController;
import controllers.RootController;
import controllers.StoreController;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.fxml.FXMLLoader;

public class Main extends Application {

	private Stage mainStage = new Stage();
	private BorderPane root = new BorderPane();

	private Account currentUser = null, userPickedByAdmin = null;
	private StoreDataBase data = new StoreDataBase();

	private Item selectedItem = null;

	private boolean viewAccounts = false;

	@Override
	public void start(Stage stg) {
		System.out.println(data);
		readData();
		System.out.println(data);

		Name adminName = new Name("Admin", "Admin");
		Address adminAddress = new Address("a", "b", "c", "123", "d");
		Account admin = new Admin("admin", "111", adminName, adminAddress, "@");

		data.getAllAccounts().put(admin.getUserName(), admin);

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
			RegisterController register = loader.getController();
			register.setMain(this);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void showAdminPage() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(this.getClass().getResource("/view/Admin.fxml"));
			VBox loginBox = new VBox();
			loginBox = (VBox) loader.load();
			root.setCenter(loginBox);
			AdminController admin = loader.getController();
			admin.setMain(this);

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
			MainMenuController mainMenu = loader.getController();
			mainMenu.setMain(this);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void showAccountPage() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(this.getClass().getResource("/view/Account.fxml"));
			VBox loginBox = new VBox();
			loginBox = (VBox) loader.load();
			root.setCenter(loginBox);
			AccountController account = loader.getController();
			account.setMain(this);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void showEditAccountPage() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(this.getClass().getResource("/view/EditAccount.fxml"));
			VBox loginBox = new VBox();
			loginBox = (VBox) loader.load();
			root.setCenter(loginBox);
			EditAccountController edit = loader.getController();
			edit.setMain(this);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void showStorePage() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(this.getClass().getResource("/view/Store.fxml"));
			VBox loginBox = new VBox();
			loginBox = (VBox) loader.load();
			root.setCenter(loginBox);
			StoreController store = loader.getController();
			store.setMain(this);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void showCartPage() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(this.getClass().getResource("/view/Cart.fxml"));
			VBox loginBox = new VBox();
			loginBox = (VBox) loader.load();
			root.setCenter(loginBox);
			CartController cart = loader.getController();
			cart.setMain(this);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void showAccountsForAdmin() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(this.getClass().getResource("/view/AccountsForAdmin.fxml"));
			VBox loginBox = new VBox();
			loginBox = (VBox) loader.load();
			root.setCenter(loginBox);
			AccountsControllerForAdmin accounts = loader.getController();
			accounts.setMain(this);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void showItemsForAdmin() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(this.getClass().getResource("/view/ItemsForAdmin.fxml"));
			VBox loginBox = new VBox();
			loginBox = (VBox) loader.load();
			root.setCenter(loginBox);
			ItemsControllerForAdmin items = loader.getController();
			items.setMain(this);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void showOrdersForAdmin() {

	}

	public void showWareHouseForAdmin() {

	}

	public void goBack() {

	}

	public void readData() {
		try {
			data = (StoreDataBase) StoreDataBase.readObjectFromFile("data\\StoreDataBase.bin", true);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void saveData(StoreDataBase data) {
		StoreDataBase.writeObjectToFile(data, "data\\StoreDataBase.bin", false);
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

	public Account getUserPickedByAdmin() {
		return userPickedByAdmin;
	}

	public void setUserPickedByAdmin(Account userPickedByAdmin) {
		this.userPickedByAdmin = userPickedByAdmin;
	}

	public boolean isViewAccounts() {
		return viewAccounts;
	}

	public void setViewAccounts(boolean viewAccounts) {
		this.viewAccounts = viewAccounts;
	}

	public Item getSelectedItem() {
		return selectedItem;
	}

	public void setSelectedItem(Item selectedItem) {
		this.selectedItem = selectedItem;
	}

}
