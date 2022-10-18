package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.*;

import database.models.FoodItem;
import database.models.ShoppingList;
import helpers.CardViewBuilder;
import database.DatabaseManager;

import helpers.InfoStore;
import helpers.ScreenHandler;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

public class MainController implements Initializable {

    @FXML
    public GridPane MainListView;

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
        colourImages();

        DatabaseManager DB = new DatabaseManager();
        // TODO: remove all this when all pull requests are complete
        DB.updateImage("Apples", "apple.png");
        DB.updateImage("Bananas", "banana.png");
        DB.updateImage("Broccoli", "broccoli.png");
        DB.updateImage("Carrots", "carrots.png");
        DB.updateImage("Chicken breast", "chicken_breast.png");
        DB.updateImage("Eggs", "egg.png");
        DB.updateImage("Greek yogurt", "greek_yogurt.png");
        DB.updateImage("Milk", "milk.png");
        DB.updateImage("Olive oil", "olive_oil.png");
        DB.updateImage("Pasta", "pasta.png");
        DB.updateImage("Pistachios", "pistachios.png");
        DB.updateImage("Potatoes", "potatoes.png");
        DB.updateImage("Rice", "rice.png");
        DB.updateImage("Spinach", "spinach.png");
        DB.updateImage("Steak", "steak.png");
        DB.updateImage("Tasty cheese", "tasty_cheese.png");
        DB.updateImage("White bread", "tip_top_bread.png");
        DB.updateImage("Ice cream", "tip_top_ice_cream.png");
        DB.updateImage("Tomatoes", "tomato.png");
        DB.updateImage("Hazelnut Chocolate", "whittakers_hazelnut.png");
        DB.updateImage("Avocado", "avocado.png");
        DB.updateImage("Avocado", "avocado.png");
        DB.updateImage("Capsicum", "capsicum.png");
        DB.updateImage("Butter", "butter.png");
        DB.updateImage("Cream", "cream.png");
        DB.updateImage("Spring Onion", "spring_onions.png");
        DB.updateImage("Camembert", "camembert.png");
        DB.updateImage("Lamb", "lamb.png");
        DB.updateImage("Mushroom", "mushrooms.png");
        DB.updateImage("Wholemeal bread", "tip_top_wholemeal_bread.png");
        DB.updateImage("Tuna", "tuna.png");
        DB.updateImage("Edam cheese", "edam_cheese.png");
        DB.updateImage("Chocolate chippies Cookies", "chocolate_chippies_cookies.png");
        DB.updateImage("Stripes cookies", "stripes_cookies.png");
        DB.updateImage("Berry yogurt", "berry_yogurt.png");
        DB.updateImage("Shaved ham", "beehive_ham.png");
        DB.updateImage("Sesameal crackers", "sesameal_crackers.png");
        DB.updateImage("Weet-Bix", "weet_bix.png");
        DB.updateImage("Canola oil", "canola.png");
        DB.updateImage("Dairy Milk Bar", "dairy_milk_bar.png");
        DB.updateImage("Sour Patch Kids", "sour_patch_kids.png");
        try {
            lists = DB.getTable(ShoppingList.class, "ShoppingList");

            for (int i = 0; i < lists.size(); i++) {

                /* creating input arguments */
                    /* fxml input arg */
                String listCardViewFxmlLocation = "/fxml/IndividualListCardDisplay.fxml";
                    /* card view cotroller input argument */
                Object[] args = new Object[2];
                args[0] = lists.get(i).getTitle(); //set the title
                args[1] = lists.get(i).getDescription(); //set the description

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
        } finally {
            DB.close();
        }
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

        colourImages();

    }

    public void colourImages() {
        List<ImageView> imageViewList = new ArrayList<ImageView>();
        imageViewList.add(titleText);
        ScreenHandler.colourImages(imageViewList);
    }

}
