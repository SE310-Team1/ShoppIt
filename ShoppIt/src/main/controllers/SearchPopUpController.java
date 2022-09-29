package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.ResourceBundle;

import database.DatabaseManager;
import database.models.FoodItem;
import helpers.ScreenHandler;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;


//Class that controls the actions of the SearchPopUpScene 
public class SearchPopUpController implements Initializable {
	
	@FXML
	TextField searchTextField;
	@FXML
	Button searchButton;
	@FXML
	ListView<String> searchResultsList;
	@FXML
	GridPane gridPane;
	
	List<FoodItem> foodItemObjects = new ArrayList<>();
	HashMap<FoodItem,String> foodItems = new HashMap<>();

	private Stage stage;
	private Scene scene;
	private Parent root;
	
	private FXMLLoader loader;
	private int column=0;
	private int row=0;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		//Retrieves all food items for the database 
		DatabaseManager databaseManager = new DatabaseManager();
		// can remove these lines once the code is ran once as the database is preserved afterwards
		databaseManager.updateImage("Carrots","carrots.png");
		databaseManager.updateImage("Spring Onion","spring_onions.jpg");
		databaseManager.updateImage("Mushroom","mushrooms.png");
		List<FoodItem> foodItemObjects = databaseManager.getFromDatabase(FoodItem.class,"FROM FoodItem");

		try {
			for (FoodItem item : foodItemObjects) {
				setCards(item);
				//Puts foodItem and its corresponding product name in a hashmap. Name required to populate search results list.
				foodItems.put(item, item.getProductName());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	//Method to search list and return search results based on user query when search button is pressed 
	public void search(ActionEvent event) {
		String query = searchTextField.getText();
		gridPane.getChildren().clear();
		
		//Checks if query input is null, if so return all items in the list.
		if(query.equals(" ")) {
			for (FoodItem item : foodItemObjects) {
				setCards(item);
			}

		} else {
			List<String> filteredList = searchList(query,foodItems.values());
			for(String item : filteredList) {
				FoodItem currentItem = getItemKeyByValue(item);
				setCards(currentItem);
			}
		}
	}
	
	//Method to return a list of all items that matches the user's query
	public List<String> searchList(String query, Collection<String> listOfStrings) {
		List<String> filteredList = new ArrayList<>();
		
		for(String itemName: listOfStrings) {
			//Sets both item and query to lowercase to avoid case issues when matching.
			if(itemName.toLowerCase().contains(query.toLowerCase())) {
				filteredList.add(itemName);
			}
		}
		
		return filteredList;
	}
	
	public FoodItem getItemKeyByValue(String value) {
		for(Entry<FoodItem,String> entry : foodItems.entrySet()) {
			if (Objects.equals(value, entry.getValue())) {
	            return entry.getKey();
	        }
		}
		return null;
	}


	public void buttonBack(ActionEvent e) {
		ScreenHandler.changeTo("newListScene");
	}

	/**
	 * Individual cards within search pop up screen are loaded by injecting data into a card view
	 *
	 * @param item Specific item being added
	 */
	public void setCards(FoodItem item) {
		try {
			FXMLLoader fxmlloader = new FXMLLoader();
			fxmlloader.setLocation(getClass().getResource("/fxml/IndividualFruitList.fxml"));
			AnchorPane anchor = fxmlloader.load();

			// Implementation of click functionality of items in list
			anchor.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
				public void handle(MouseEvent mouseEvent) {
					try {
						FoodItem currentItem = item;

						loader = new FXMLLoader(getClass().getResource("/fxml/DetailedItemPopUpSceneWithAdd.fxml"));
						root = (Parent) loader.load();

						//Sets values in detailed item scene
						DetailedItemPopUpController detailedItemPopUpController = loader.getController();
						detailedItemPopUpController.setDetailedItemTitle(currentItem.getProductName());
						detailedItemPopUpController.setDetailedItemImage(new Image("/images/" + currentItem.getImgFilename()));
						detailedItemPopUpController.setDetailedItemPrice("Price: " + currentItem.getPrice());
						detailedItemPopUpController.setDetailedItemBrand("Brand: " + currentItem.getBrand());
						detailedItemPopUpController.setDetailedItemDietClassification("Diet Classification: " + currentItem.getDietClassification());
						detailedItemPopUpController.setDetailedItemWeight("Weight: " + currentItem.getWeight());
						detailedItemPopUpController.setDetailedItemTotalCalories("Total Calories: " + Integer.toString(currentItem.getTotalCalories()));

						detailedItemPopUpController.setItem(currentItem);

						scene = new Scene(root);
						stage = new Stage();
						stage.setResizable(false);
						stage.setScene(scene);

						//Disables underlying window
						stage.initModality(Modality.APPLICATION_MODAL);
						stage.showAndWait();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			});

			IndividualFruitListController cardView = fxmlloader.getController();

			cardView.setData(item);

			gridPane.add(anchor, column, row++);
			GridPane.setMargin(anchor, new Insets(10));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
