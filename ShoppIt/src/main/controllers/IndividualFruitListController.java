package controllers;

import database.models.FoodItem;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class IndividualFruitListController {

    @FXML
    private Label fruitNameLabel;

    public void setData(String item) {
        fruitNameLabel.setText(item);

    }
}
