package controllers;

import java.util.Set;

import application.Main;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import model.Admin;

public class AccountsControllerForAdmin {

	private ObservableList<String> accounts;
	private Set<String> keys;

	private Main main;

	public void setMain(Main main) {
		this.main = main;

		accounts = FXCollections.observableArrayList();
		keys = main.getData().getAllAccounts().keySet();

		for (String s : keys) {
			if (main.getData().getAllAccounts().get(s).getClass() != Admin.class) {
				accounts.add(s);
			}
		}

		accountViewer.setItems(accounts);
	}

	@FXML
	private ListView<String> accountViewer;

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

	@FXML
	void searchUsers(ActionEvent event) {

	}

	@FXML
	void getSelected(MouseEvent event) {
		accountViewer.getSelectionModel().selectedItemProperty()
				.addListener((ObservableValue<? extends String> ov, String old_val, String new_val) -> {
					main.setUserPickedByAdmin(main.getData().getAllAccounts().get(new_val));
				});
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

	@FXML
	void viewAccount(ActionEvent event) {
		main.showEditAccountPage();
	}
	

    @FXML
    void goBack(ActionEvent event) {
    	main.showAdminPage();
    }

}
