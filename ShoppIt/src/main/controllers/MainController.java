package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.*;

import database.models.FoodItem;
import database.models.ShoppingList;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import database.DatabaseManager;

import helpers.InfoStore;
import helpers.ScreenHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class MainController implements Initializable {

    @FXML
    private ListView<String> MainListView;

    @FXML
    private Button AddListButton;

    @FXML
    private ImageView titleText;

    InfoStore store = InfoStore.getInstance();
    //List<List<Item>> lists = new LinkedList<>();
    List<ShoppingList> lists = new ArrayList<>();

    // Set up lists in main scene
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        DatabaseManager DB = new DatabaseManager();

        lists = DB.getFromDatabase(ShoppingList.class, "FROM ShoppingList s");

        for (int i = 0; i < lists.size(); i++) {
            MainListView.getItems().add("List" + Integer.toString(i));
        }

        MainListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
                int position = MainListView.getSelectionModel().getSelectedIndex();
                store.setShoppingList(lists.get(position));
                
                ScreenHandler.changeTo("individualListScene");
            }
        });
    }

    public void newList(ActionEvent e) {
        Set<FoodItem> newList = new HashSet<>();
        store.setItems(newList);
        ScreenHandler.changeTo("newListScene");
    }

    public void changeTheme(ActionEvent e) {
        Scene scene = AddListButton.getScene();
        int newTheme;
        if (scene.getStylesheets().contains("/css/theme2.css")){
            scene.getStylesheets().remove("/css/theme2.css");
            scene.getStylesheets().add("/css/theme1.css");
            newTheme = 1;
        } else {
            scene.getStylesheets().remove("/css/theme1.css");
            scene.getStylesheets().add("/css/theme2.css");
            newTheme = 2;
        }

        updateImageColours(newTheme);

    }

    public void updateImageColours(int themeNum) {
        titleText.setImage(new Image("./images/name_" + themeNum + ".png"));
    }

}
