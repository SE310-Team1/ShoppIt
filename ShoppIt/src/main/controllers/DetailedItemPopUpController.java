package controllers;

import database.models.FoodItem;
import helpers.InfoStore;
import helpers.ScreenHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

//Class that controls the actions of the DetailedItemPopUpScene and DetailedItemPopUpSceneWithAdd 
public class DetailedItemPopUpController {

	@FXML
	private ImageView arrowImageView;
	@FXML
	private Text detailedItemTitle;
	@FXML
	private ImageView detailedItemImage;
	@FXML
	private Text detailedItemInformation;
	@FXML
	private Text detailedItemBrand;
	@FXML
	private Text detailedItemPrice;
	@FXML
	private Text detailedItemDietClassification;
	@FXML
	private Text detailedItemWeight;
	@FXML
	private Text detailedItemTotalCalories;
	@FXML
	private Button detailedItemAddButton;
	@FXML
	private Button detailedItemExitButton;
	@FXML
	private GridPane detailedItemGridPane;
	
	private Stage stage;
	
	private FoodItem item = new FoodItem();

	@FXML
	public void initialize() {
		colourImages();
	}
	
	//Adds item to current new list. Closes item pop up afterwards.
	public void addToList(ActionEvent event) {
		InfoStore infoStore = InfoStore.getInstance();
		//Item currentItem = new Item(1,item.getId());

		//adds the item to the list instance
		infoStore.getItems().add(item);
		
		stage = (Stage) detailedItemGridPane.getScene().getWindow();
		stage.close();
		ScreenHandler.changeTo("newListScene");
	}
	
	//Method that controls exit button - closes the popup
	public void exitPopUp(ActionEvent event) {
		stage = (Stage) detailedItemGridPane.getScene().getWindow();
		stage.close();
	}
	
	
	public void setDetailedItemTitle(String title) {
		detailedItemTitle.setText(title);
	}
	
	public void setDetailedItemImage(Image image) {
		detailedItemImage.setImage(image);
	}
	
	public void setDetailedItemPrice(String price) {
		detailedItemPrice.setText(price);
	}
	
	public void setDetailedItemBrand(String brand) {
		detailedItemBrand.setText(brand);
	}
	
	public void setDetailedItemDietClassification(String dietClassification) {
		detailedItemDietClassification.setText(dietClassification);
	}
	
	public void setDetailedItemWeight(String weight) {
		detailedItemWeight.setText(weight);
	}
	
	public void setDetailedItemTotalCalories(String totalCalories) {
		detailedItemTotalCalories.setText(totalCalories);
	}
	
	public void setItem(FoodItem item) {
		this.item = item;
	}

	public void colourImages() {
		List<ImageView> imageViewList = new ArrayList<ImageView>();
		imageViewList.add(arrowImageView);
		ScreenHandler.colourImages(imageViewList);
	}

}
