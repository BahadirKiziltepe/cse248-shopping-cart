package controllers;

import java.util.Set;

import application.Main;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.util.Callback;
import model.Account;
import model.Admin;
import model.Item;

/**
 * This is the page for admin to view users and their informations.
 * 
 * @author bahad
 *
 */
public class AccountsControllerForAdmin {

	private ObservableList<Account> accounts;
	private Set<String> keys;

	private Main main;

	/**
	 * It sets up main.
	 * 
	 * @param main this is the main.
	 */
	public void setMain(Main main) {
		this.main = main;

		updateList();

		main.setViewAccounts(true);
	}

	/**
	 * Initializes the list view
	 */
	public void initialize() {
		accountViewer.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Account>() {

			@Override
			public void changed(ObservableValue<? extends Account> observable, Account oldUser, Account newUser) {
				if (newUser != null) {
					main.setUserPickedByAdmin(newUser);
				}
			}
		});

		accountViewer.setCellFactory(new Callback<ListView<Account>, ListCell<Account>>() {

			@Override
			public ListCell<Account> call(ListView<Account> p) {
				ListCell<Account> newItem = new ListCell<Account>() {
					@Override
					protected void updateItem(Account account, boolean bool) {
						super.updateItem(account, bool);
						if (bool || account == null) {
							setText(null);
						} else {
							setText(account.getUserName());
						}
					}
				};

				return newItem;
			}
		});
	}

	@FXML
	private ListView<Account> accountViewer;

	@FXML
	private TextField searchBar;

	@FXML
	private Button searchBtn;

	@FXML
	private Button backBtn;

	@FXML
	private Button selectAccount;

	@FXML
	private Text userName;

	@FXML
	private Text password;

	@FXML
	private Text email;

	@FXML
	private Text firstName;

	@FXML
	private Text middleName;

	@FXML
	private Text lastName;

	@FXML
	private Text street;

	@FXML
	private Text state;

	@FXML
	private Text city;

	@FXML
	private Text zipcode;

	@FXML
	private Text country;

	/**
	 * Searches the list based on the given search key.
	 * 
	 * @param event use this to find users in the list.
	 */
	@FXML
	void searchUsers(ActionEvent event) {
		main.setUserPickedByAdmin(null);
		ObservableList<Account> accountsToShow = FXCollections.observableArrayList();
		if (searchBar.getText().contentEquals("")) {
			this.accountViewer.setItems(accounts);
		} else {
			for (Account a : accounts) {
				if (a.toString().toLowerCase().contains(searchBar.getText().toLowerCase())) {
					accountsToShow.add(a);
				}
			}
			this.accountViewer.setItems(accountsToShow);
		}
	}

	/**
	 * takes you to edit account page.
	 * 
	 * @param event use this to edit the selected user's informations.
	 */
	@FXML
	void viewAccount(ActionEvent event) {
		main.showEditAccountPage();
	}

	/**
	 * deletes the selected user.
	 * 
	 * @param event use this to delete a user.
	 */
	@FXML
	void deleteAccount(ActionEvent event) {
		if (main.getUserPickedByAdmin() != null) {
			main.getData().getAllAccounts().remove(main.getUserPickedByAdmin().getUserName());
			main.saveData(main.getData());

			updateList();
			main.setUserPickedByAdmin(null);
		}
	}

	/**
	 * updates shown informations based on the selected user.
	 * 
	 * @param event use this to view the selected user's information
	 */
	@FXML
	void getSelected(MouseEvent event) {
		if (main.getUserPickedByAdmin() != null) {
			userName.setText(main.getUserPickedByAdmin().getUserName());
			password.setText(main.getUserPickedByAdmin().getPassword());
			email.setText(main.getUserPickedByAdmin().getEmail());
			firstName.setText(main.getUserPickedByAdmin().getName().getFirstName());
			middleName.setText(main.getUserPickedByAdmin().getName().getMiddleName());
			lastName.setText(main.getUserPickedByAdmin().getName().getLastName());
			street.setText(main.getUserPickedByAdmin().getAddress().getStreet());
			state.setText(main.getUserPickedByAdmin().getAddress().getState());
			city.setText(main.getUserPickedByAdmin().getAddress().getCity());
			zipcode.setText(main.getUserPickedByAdmin().getAddress().getZipCode());
			country.setText(main.getUserPickedByAdmin().getAddress().getCountry());
		}
	}

	/**
	 * updates the list view.
	 */
	public void updateList() {
		accounts = FXCollections.observableArrayList();
		keys = main.getData().getAllAccounts().keySet();

		for (String s : keys) {
			if (main.getData().getAllAccounts().get(s).getClass() != Admin.class) {
				accounts.add(main.getData().getAllAccounts().get(s));
			}
		}
		accountViewer.setItems(accounts);
	}

	/**
	 * Goes back to the previous scene.
	 * 
	 * @param event use to go to the previous scene.
	 */
	@FXML
	void goBack(ActionEvent event) {
		main.setUserPickedByAdmin(null);
		main.showAdminPage();
	}

}
