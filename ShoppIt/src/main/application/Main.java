package application;

import helpers.ScreenHandler;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/*
 * Main class
 */
public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {

		try {
			Scene scene = new Scene(new Pane());
			scene.getStylesheets().add(getClass().getResource("/css/application.css").toExternalForm());
			scene.getStylesheets().add(getClass().getResource("/css/theme1.css").toExternalForm());
			setScreens(scene);
			
			primaryStage.setTitle("ShoppIt");
			primaryStage.setScene(scene);
			primaryStage.setMinHeight(700);
			primaryStage.setMinWidth(800);
			primaryStage.setMaxWidth(800);

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
		ScreenHandler.add("searchScene", "SearchPopUpScene.fxml");
		ScreenHandler.changeTo("main"); // starting screen
	}

	public static void main(String[] args) {
		launch(args);
	}
}