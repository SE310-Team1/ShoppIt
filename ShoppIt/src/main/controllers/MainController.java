package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import database.DatabaseManager;
import database.models.Item;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import helpers.ScreenHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

public class MainController implements Initializable {

    @FXML
    private ListView<String> MainListView;

    List<List<Item>> lists = new LinkedList<>();

    // Set up lists in main scene
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        DatabaseManager DB = new DatabaseManager();
        lists = DB.getItems();

        for (int i = 0; i < lists.size(); i++) {
            MainListView.getItems().add("List" + Integer.toString(i + 1));
        }

        MainListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
                ScreenHandler.changeTo("individualListScene");
            }
        });
    }

    public void newList(ActionEvent e) {
        ScreenHandler.changeTo("newListScene");
    }

}
