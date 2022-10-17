package helpers;

import controllers.CardViewController;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

/**
 * Builds a card view with the necessary initialization required
 */
public class CardViewBuilder {

    /**
     * builds a new card view referenced from its anchor pane
     * This anchor pane can be added to a new grid pane in runtime for it to work
     */
    public static AnchorPane createCardView(Object[] args) throws IOException {
        /* creates the new card view */
        FXMLLoader fxmlloader = new FXMLLoader();
        fxmlloader.setLocation(CardViewController.class.getResource("/com/example/a1project/SingleTaskDisplay.fxml"));
        AnchorPane anchor = fxmlloader.load();

        CardViewController cardController = fxmlloader.getController();
        cardController.setup(args);

        return anchor;
    }

}
