package helpers;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import database.DatabaseManager;
import database.dataModels.FoodItem;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class SearchPopUpController implements Initializable {
	
	@FXML
	TextField searchTextField;
	@FXML
	Button searchButton;
	@FXML
	ListView<String> searchResultsList;
	@FXML
	GridPane searchGridPane;
	
	List<String> foodItemNames;
	
	//
	public void search(ActionEvent event) {
		String query = searchTextField.getText();
		searchResultsList.getItems().clear();
		
		if(query.equals(" ")) {
			searchResultsList.getItems().addAll(foodItemNames);
		} else {
		List<String> filteredList = searchList(query,foodItemNames);
		searchResultsList.getItems().addAll(filteredList);
		}
	}
	
	//Method to return a list of all items that matches the user's query
	public List<String> searchList(String query, List<String> listOfStrings) {
		List<String> filteredList = new ArrayList<>();
		
		for(String item: listOfStrings) {
			//Sets both item and query to lowercase to avoid case issues when matching.
			if(item.toLowerCase().contains(query.toLowerCase())) {
				filteredList.add(item);
			}
		}
		
		return filteredList;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		//TO-DO: Need code to get all the food items from database and put in foodItems list.
		//Do this once retrieval method is implemented.
		
		
		/*DatabaseManager databaseManager = new DatabaseManager();
		//List<FoodItem> foodItems = databaseManager.getFoodItems();
		//for(FoodItem foodItem : foodItems) {
			//foodItemNames.add(foodItem.getProductName());
		}*/
		
		//Current foodItemNames for testing, will be replaced with list retrieved from database.
		foodItemNames = Arrays.asList("Orange", "Apple", "Pineapple");
		searchResultsList.getItems().addAll(foodItemNames);
		
	}
	

}
