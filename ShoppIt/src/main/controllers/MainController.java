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

import helpers.InfoStore;
import helpers.ScreenHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

public class MainController implements Initializable {

    @FXML
    private ListView<String> MainListView;

    InfoStore store = InfoStore.getInstance();
    List<List<Item>> lists = new LinkedList<>();

    // Set up lists in main scene
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        DatabaseManager DB = new DatabaseManager();



        lists = DB.getItems();

        // i set to 1 because lists variable has a null at index 0
        for (int i = 1; i < lists.size(); i++) {
            MainListView.getItems().add("List" + Integer.toString(i));
        }

        MainListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
                int position = MainListView.getSelectionModel().getSelectedIndex()+1;
                store.setList(lists.get(position),position);
                ScreenHandler.changeTo("individualListScene");
            }
        });
    }

    public void newList(ActionEvent e) {
        List<Item> newList = new ArrayList<Item>();
        store.setList(newList);
        ScreenHandler.changeTo("newListScene");
    }

}
