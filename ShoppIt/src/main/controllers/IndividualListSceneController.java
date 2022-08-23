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
import database.models.Item;

/*
 * Controller for the display individual list page
 */
public class IndividualListSceneController {
	
	InfoStore store = InfoStore.getInstance();
	List<Item> itemList;

	// @FXML private Button gamesModuleButton = new Button();
	// @FXML private Button quitButton = new Button();
	// @FXML private ChoiceBox<String> topicChoiceBox = new ChoiceBox<>();
	// @FXML private Label achievementsLabel = new Label();
	// @FXML private Label helpLabel = new Label();

	// @FXML private Text individualListSceneTitle = new Text();
	// @FXML private Text individualListSceneDescription = new Text();
	// @FXML private ListView itemListView = new ListView();
	// @FXML private Text evaluationText = new Text();

	@FXML
	public void initialize() {
		itemList = store.getList();
		// load stuff into labels
		// individualListSceneTitle.setText("HI");
		// individualListSceneDescription.setText("HI");
		// evaluationText.setText("HI");
		
	}

	// Runs when an item is pressed
	public void activateItemPopup(ActionEvent e) {
		// ScreenHandler.changeTo("gameTopic");
	}

	// Runs when the search button is pressed
    // (only in edit list)
	public void activateSearchPopup(ActionEvent e) {
		// ScreenHandler.changeTo("gameTopic");
	}

	// Runs when the back button is pressed
	public void buttonBack(ActionEvent e) {
		ScreenHandler.changeTo("main");
	}

	/// Runs when the edit button is pressed
	public void buttonEdit(ActionEvent e) {
		ScreenHandler.changeTo("newListScene");
	}

}
