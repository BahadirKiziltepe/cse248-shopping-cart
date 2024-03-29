package controllers;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import model.CreditCard;
import model.User;

/**
 * Credit card informations.
 * 
 * @author bahad
 *
 */
public class CardController {

	private Main main;

	/**
	 * It sets up main.
	 * 
	 * @param main this is the main.
	 */
	public void setMain(Main main) {
		this.main = main;

		if (((User) main.getCurrentUser()).getSavedCard() != null) {
			cardNumber.setText(((User) main.getCurrentUser()).getSavedCard().getCardNumber());
			sCode.setText(Integer.toString(((User) main.getCurrentUser()).getSavedCard().getSecurityCode()));
			date.setText(Integer.toString(((User) main.getCurrentUser()).getSavedCard().getExpirationDate()));
		}
	}

	@FXML
	private TextField cardNumber;

	@FXML
	private TextField sCode;

	@FXML
	private TextField date;

	@FXML
	private Button saveBtn;

	@FXML
	private Text cancel;

	/**
	 * cancels the changes
	 * 
	 * @param event use this if you do not want to save changes.
	 */
	@FXML
	void cancel(MouseEvent event) {
		main.showMainMenuPage();
	}

	/**
	 * saves the entered informations as credit card
	 * 
	 * @param event use this to update an existing credit card or to enter a new
	 *              credit card.
	 */
	@FXML
	void saveCard(ActionEvent event) {
		if (!(cardNumber.getText().equals("") || sCode.getText().equals("") || date.getText().equals(""))) {
			CreditCard card = new CreditCard(cardNumber.getText(), Integer.parseInt(sCode.getText()),
					Integer.parseInt(date.getText()));
			((User) main.getCurrentUser()).setSavedCard(card);
			main.showMainMenuPage();
		}
	}

}
