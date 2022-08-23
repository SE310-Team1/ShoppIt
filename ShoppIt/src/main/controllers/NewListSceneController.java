package controllers;

import helpers.InfoStore;
import helpers.ScreenHandler;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import java.util.List;
import database.models.FoodItem;

/*
 * Controller for the new/edit list page
 */
public class NewListSceneController {

	InfoStore store = InfoStore.getInstance();
	List<FoodItem> itemList = store.getList();

	// @FXML private Button gamesModuleButton = new Button();
	// @FXML private Button quitButton = new Button();
	// @FXML private ChoiceBox<String> topicChoiceBox = new ChoiceBox<>();
	// @FXML private Label achievementsLabel = new Label();
	// @FXML private Label helpLabel = new Label();

	// Runs when an item is pressed
	public void activateItemPopup(ActionEvent e) {
		// ScreenHandler.changeTo("gameTopic");
	}

	// Runs when the search button is pressed
	public void activateSearchPopup(ActionEvent e) {
		// ScreenHandler.changeTo("gameTopic");
	}

	// Runs when the back button is pressed
	public void buttonBack(ActionEvent e) {
		ScreenHandler.changeTo("main");
	}

	/// Runs when the submit button is pressed
	public void buttonSubmit(ActionEvent e) {
		ScreenHandler.changeTo("main");
		//insert submission to database
	}

}
