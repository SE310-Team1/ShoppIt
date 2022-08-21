package helpers;

import java.io.IOException;
import java.util.HashMap;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

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
			Parent pane = FXMLLoader.load(ScreenHandler.class.getResource("/resources/fxml/" + nameMap.get(name)));
			currentScreen = pane;
			main.setRoot( pane );
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Parent getCurrentScreen() {
		return currentScreen;
	}
}