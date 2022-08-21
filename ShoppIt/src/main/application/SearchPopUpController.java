package application;

import java.net.URL;
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
	
	List<String> foodItems;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		//TO-DO: Need code to get all the food items from database and put in foodItems list.
		//Do this once retrieval method is implemented. 
		searchResultsList.getItems().addAll(foodItems);
		
	}
	

}
