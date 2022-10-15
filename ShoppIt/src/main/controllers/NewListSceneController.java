package controllers;

import database.models.FoodItem;
import helpers.DisplayFoodItems;
import helpers.InfoStore;
import helpers.ScreenHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/*
 * Controller for the new/edit list page
 */
public class NewListSceneController {

	@FXML
    private ListView<String> newListListView;
	@FXML
	private TextField newListTitle;
	@FXML
	private TextField newListDescription;

	InfoStore store = InfoStore.getInstance();
	Set<FoodItem> itemList = store.getItems();

	@FXML
	public void initialize() {
		itemList = store.getItems();

		List<String>  foodNames = DisplayFoodItems.ListFoodItems(itemList.stream().toList());
		newListListView.getItems().addAll(foodNames);
		// load stuff into labels
		String title = store.getTitle();
		String description = store.getDescription();

		newListTitle.setText(title);
		newListDescription.setText(description);
		
	}

	// Runs when an item is pressed
	public void activateItemPopup(ActionEvent e) {
		 ScreenHandler.changeTo("searchScene");
	}

	// Runs when the back button is pressed
	public void buttonBack(ActionEvent e) {
		store.resetInfoStore();
		ScreenHandler.changeTo("main");
	}

	/// Runs when the submit button is pressed
	public void buttonSubmit(ActionEvent e) {

		store.setTitle(newListTitle.getText());
		store.setDescription(newListDescription.getText());
		store.persistItems();

		ScreenHandler.changeTo("main");
		//insert submission to database
	}

}
