package application;

import database.DatabaseManager;
import database.dataModels.FoodItem;
import helpers.ScreenHandler;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import java.util.ArrayList;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/*
 * Main class
 */
public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {

		try {
			Scene scene = new Scene(new Pane(), 800, 600);
			scene.getStylesheets().add(getClass().getResource("/css/application.css").toExternalForm());
			// scene.getStylesheets().add("https://fonts.googleapis.com/css2?family=Fredoka+One");

			setScreens(scene);

			// primaryStage.setResizable(false);
			primaryStage.setTitle("ShoppIt");
			primaryStage.setScene(scene);
			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void setScreens(Scene scene) {
		ScreenHandler.setScene(scene);
		ScreenHandler.add("main", "Main.fxml");
		ScreenHandler.add("individualListScene", "IndividualListScene.fxml");
		ScreenHandler.add("newListScene", "NewListScene.fxml");
		ScreenHandler.changeTo("main"); // starting screen
	}

	public static void main(String[] args) {
		launch(args);
	}
}