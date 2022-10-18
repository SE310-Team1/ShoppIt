package helpers;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ScreenHandler {
	private static HashMap<String, String> nameMap = new HashMap<>();
	private static Scene main;
	private static Parent currentScreen;

	public static void setScene(Scene main) {
		ScreenHandler.main = main;
	}

	public static void add(String name, String fileName){
		nameMap.put(name, fileName);
	}

	public static void remove(String name){
		nameMap.remove(name);
	}

	// changes screen to other screen
	public static void changeTo(String name){
		try {
			HashMap<String,String> tempMap = nameMap;
			Parent pane = FXMLLoader.load(ScreenHandler.class.getResource("/fxml/" + nameMap.get(name)));
			currentScreen = pane;
			main.setRoot( pane );
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void colourImages(List<ImageView> imageViewList) {
		int themeNum = determineTheme();
		for (ImageView imageView : imageViewList) {

			String imageURL = imageView.getImage().getUrl();
			String imageName = imageURL.substring(imageURL.lastIndexOf('/'),imageURL.lastIndexOf('_'));

			String imagePath = ("./images" + imageName + "_" + themeNum + ".png");
			imageView.setImage(new Image(imagePath));
		}
	}

	public static int determineTheme() {
		if (main.getStylesheets().contains("/css/theme2.css")) {
			return 2;
		} else {
			return 1;
		}
	}

	public static Parent getCurrentScreen() {
		return currentScreen;
	}
}