package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class DetailedItemPopUpController {
	
	@FXML
	private Text detailedItemTitle;
	@FXML
	private ImageView detailedItemImage;
	@FXML
	private Text detailedItemInformation;
	@FXML
	private Text detailedItemBrand;
	@FXML
	private Text detailedItemDietClassifcation;
	@FXML
	private Text detailedWeight;
	@FXML
	private Text detailedTotalCalories;
	@FXML
	private Text detailedAddButton;
	@FXML
	private Text detailedExitButton;
	@FXML
	private GridPane detailedGridPane;
	
	private Stage stage;
	
	
	public void addToList(ActionEvent event) {
		
	}
	
	//Method that controls exit button - closes the popup
	public void exitPopUp(ActionEvent event) {
		stage = (Stage) detailedGridPane.getScene().getWindow();
		stage.close();
		
	}
	

}
