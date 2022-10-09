package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import database.models.FoodItem;
import database.models.Item;
import helpers.InfoStore;
import helpers.ScreenHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

//Class that controls the actions of the DetailedItemPopUpScene and DetailedItemPopUpSceneWithAdd 
public class DetailedItemPopUpController{
	
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
	
	
	//Adds item to current new list. Closes item pop up afterwards.
	public void addToList(ActionEvent event) {
		InfoStore infoStore = InfoStore.getInstance();
		//Item currentItem = new Item(1,item.getId());

		//adds the item to the list instance
		infoStore.getList().add(item);
		
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
	

}
