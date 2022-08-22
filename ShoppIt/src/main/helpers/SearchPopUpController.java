package helpers;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class SearchPopUpController implements Initializable {
	
	@FXML
	TextField searchTextField;
	@FXML
	Button searchButton;
	@FXML
	ListView<String> searchResultsList;
	
	List<String> foodItemNames;
	
	public void search(ActionEvent event) {
		String query = searchTextField.getText();
		List<String> filteredList = searchList(query,foodItemNames);
		searchResultsList.getItems().addAll(filteredList);
	}
	
	public List<String> searchList(String query, List<String> listOfStrings) {
		List<String> filteredList = new ArrayList<>();
		
		for(String item: listOfStrings) {
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
		searchResultsList.getItems().addAll(foodItemNames);
		
	}
	

}
