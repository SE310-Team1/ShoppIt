package controllers;

import application.Listener;
import database.models.FoodItem;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class IndividualFruitListController {

    @FXML
    private Label foodNameLabel, calorieLabel, priceLabel;

    @FXML
    private ImageView foodImage;

    @FXML
    private void click(ActionEvent actionEvent) {
        listener.onClickListener(item);
    }

    private Listener listener;
    private FoodItem item;

    public void setData(FoodItem item) {
        this.item = item;
        foodNameLabel.setText(item.getProductName());
        calorieLabel.setText("Calories: " + item.getTotalCalories());
        priceLabel.setText(item.getPrice());
        foodImage.setImage(new Image("/images/" + item.getImgFilename()));


    }
}
