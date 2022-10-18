package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;

/**
 * controller for the card view that displays overview of each shopping list in the main scene
 */
public class ListCardViewController implements CardViewController {

    @FXML
    private Label listName;
    @FXML
    private Tooltip desptionToolTip;

    /**
     * Set up the list card view to be put into the main scene
     * args[0] - String: List name
     *
     * @param args
     */
    @Override
    public void setup(Object[] args) {
        try {
            /* set card title */
            String name = (String) args[0];
            listName.setText(name);

            /* set tool tip */
            String description = (String) args[1];
            desptionToolTip.setText(description);
        }
        catch(IndexOutOfBoundsException e) {
            System.err.println(e.getMessage() + " -> ListCardViewController input arguments array insufficient");
        }


    }
}
