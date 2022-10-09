package controllers;

import database.models.FoodItem;
import helpers.DisplayFoodItems;
import helpers.InfoStore;
import helpers.ScreenHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import java.util.List;
import java.util.Set;
import database.models.Item;

/*
 * Controller for the display individual list page
 */
public class IndividualListSceneController {

	@FXML
    private ListView<String> ItemListView;
	
	InfoStore store = InfoStore.getInstance();
	Set<FoodItem> itemSet;

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
		itemSet = store.getItems();

		List<String> foodNames = DisplayFoodItems.ListFoodItems(itemSet.stream().toList());
		ItemListView.getItems().addAll(foodNames);
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
		store.resetInfoStore();
		ScreenHandler.changeTo("main");
	}

	/// Runs when the edit button is pressed
	public void buttonEdit(ActionEvent e) {
		ScreenHandler.changeTo("newListScene");
	}

}
