package helpers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

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
	private Text detailedItemDietClassifcation;
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
	
	
	
	public void addToList(ActionEvent event) {
		
	}
	
	//Method that controls exit button - closes the popup
	public void exitPopUp(ActionEvent event) {
		stage = (Stage) detailedItemGridPane.getScene().getWindow();
		stage.close();
	}
	
	public void setDetailedItemTitle(String title) {
		detailedItemTitle.setText(title);
	}

}
