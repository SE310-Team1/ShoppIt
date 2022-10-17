package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**
 * controller for the card view that displays overview of each shopping list in the main scene
 */
public class ListCardViewController implements CardViewController {

    @FXML
    private Label listName;

    /**
     * Set up the list card view to be put into the main scene
     * args[0] - String: List name
     *
     * @param args
     */
    @Override
    public void setup(Object[] args) {
        try {
            String name = (String) args[0];
            listName.setText(name);
        }
        catch(IndexOutOfBoundsException e) {
            System.err.println(e.getMessage() + " -> ListCardViewController input arguments array insufficient");
        }


    }
}
