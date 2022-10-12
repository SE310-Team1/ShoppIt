package controllers;

import application.Listener;
import database.models.FoodItem;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class IndividualFruitListController {

    @FXML
    private Label fruitNameLabel;

    @FXML
    private void click(ActionEvent actionEvent) {
        listener.onClickListener(item);
    }

    private Listener listener;
    private FoodItem item;

    public void setData(FoodItem item) {
        this.item = item;
        fruitNameLabel.setText(item.getProductName());


    }
}
