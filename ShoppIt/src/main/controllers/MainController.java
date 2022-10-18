package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.*;

import database.models.FoodItem;
import database.models.ShoppingList;
import helpers.CardViewBuilder;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import database.DatabaseManager;

import helpers.InfoStore;
import helpers.ScreenHandler;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainController implements Initializable {

    @FXML
    public GridPane MainListView;

    InfoStore store = InfoStore.getInstance();
    //List<List<Item>> lists = new LinkedList<>();
    List<ShoppingList> lists = new ArrayList<>();

    // Set up lists in main scene
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        DatabaseManager DB = new DatabaseManager();

        lists = DB.getTable(ShoppingList.class, "ShoppingList");

        /* changed to setting up the card views, using the list */
        for (int i = 0; i < lists.size(); i++) {

            /* creating input arguments */
            String listCardViewFxmlLocation = "/fxml/Individual_List_CardDisplay.fxml";
            Object[] args = new Object[1];
            args[0] = "TEST LIST NAME";

            /* try to create view */
            try {
                /* create a card view and append to grid pane */
                AnchorPane pane = CardViewBuilder.createCardView(listCardViewFxmlLocation,args);
                MainListView.add(pane,1,MainListView.getRowCount()); //1 since only 1 column, row count gets the index of the next row

                /* set the click listener for the view */
                pane.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        Integer rowIndex = MainListView.getRowIndex(pane);
                        store.setShoppingList(lists.get(rowIndex));
                        ScreenHandler.changeTo("individualListScene");
                    }
                });

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void newList(ActionEvent e) {
        Set<FoodItem> newList = new HashSet<>();
        store.setItems(newList);
        ScreenHandler.changeTo("newListScene");
    }
}
