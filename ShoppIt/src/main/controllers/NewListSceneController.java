package controllers;

import database.models.FoodItem;
import helpers.DisplayFoodItems;
import helpers.InfoStore;
import helpers.ScreenHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/*
 * Controller for the new/edit list page
 */
public class NewListSceneController {

	@FXML
    private ListView<String> newListListView;

	InfoStore store = InfoStore.getInstance();
	Set<FoodItem> itemList = store.getItems();

	@FXML
	public void initialize() {
		itemList = store.getItems();

		List<String> foodNames = new ArrayList<String>();
		foodNames = DisplayFoodItems.ListFoodItems(itemList.stream().toList());
		newListListView.getItems().addAll(foodNames);
		// load stuff into labels
		// individualListSceneTitle.setText("HI");
		// individualListSceneDescription.setText("HI");
		// evaluationText.setText("HI");
		
	}

	// @FXML private Button gamesModuleButton = new Button();
	// @FXML private Button quitButton = new Button();
	// @FXML private ChoiceBox<String> topicChoiceBox = new ChoiceBox<>();
	// @FXML private Label achievementsLabel = new Label();
	// @FXML private Label helpLabel = new Label();

	// Runs when an item is pressed
	public void activateItemPopup(ActionEvent e) {
		 ScreenHandler.changeTo("searchScene");
	}

	// Runs when the search button is pressed
	public void activateSearchPopup(ActionEvent e) {
		// ScreenHandler.changeTo("gameTopic");
	}

	// Runs when the back button is pressed
	public void buttonBack(ActionEvent e) {
		store.resetInfoStore();
		ScreenHandler.changeTo("main");
	}

	/// Runs when the submit button is pressed
	public void buttonSubmit(ActionEvent e) {

		store.persistItems();
		ScreenHandler.changeTo("main");
		//insert submission to database
	}

}
