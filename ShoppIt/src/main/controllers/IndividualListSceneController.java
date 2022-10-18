package controllers;

import database.models.FoodItem;
import helpers.DisplayFoodItems;
import helpers.InfoStore;
import helpers.ScreenHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/*
 * Controller for the display individual list page
 */
public class IndividualListSceneController {

	@FXML
    private ListView<String> ItemListView;

	@FXML
	ImageView arrowImageView;
	
	InfoStore store = InfoStore.getInstance();
	Set<FoodItem> itemSet;

	 @FXML private Text IndividualListSceneTitle;
	 @FXML private Text IndividualListSceneDescription;

	@FXML
	public void initialize() {

		colourImages();

		itemSet = store.getItems();

		List<String> foodNames = DisplayFoodItems.ListFoodItems(itemSet.stream().toList());
		ItemListView.getItems().addAll(foodNames);

		// Load list title and description
		IndividualListSceneTitle.setText(store.getTitle());
		IndividualListSceneDescription.setText(store.getDescription());
	}

	// Runs when an item is pressed
	public void activateItemPopup(ActionEvent e) {}

	// Runs when the search button is pressed
    // (only in edit list)
	public void activateSearchPopup(ActionEvent e) {}

	// Runs when the back button is pressed
	public void buttonBack(ActionEvent e) {
		store.resetInfoStore();
		ScreenHandler.changeTo("main");
	}

	/// Runs when the edit button is pressed
	public void buttonEdit(ActionEvent e) {
		ScreenHandler.changeTo("newListScene");
	}

	public void colourImages() {
		List<ImageView> imageViewList = new ArrayList<ImageView>();
		imageViewList.add(arrowImageView);
		ScreenHandler.colourImages(imageViewList);
	}

}
