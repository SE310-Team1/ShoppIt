package helpers;

import java.util.Set;
import database.DatabaseManager;
import database.models.FoodItem;
import database.models.ShoppingList;

public class InfoStore {

	private static InfoStore instance = null;
    private static Set<FoodItem> items;
    private static ShoppingList newShoppingList = null;
    private static String title;
    private static String description;
    
    public static InfoStore getInstance() {
		if (instance == null) {
			instance = new InfoStore();
		}
		return instance;
	}

    public void setItems(Set<FoodItem> items) {
        InfoStore.items = items;
    }

    public void setShoppingList(ShoppingList newShoppingList){
        InfoStore.newShoppingList = newShoppingList;
        items = newShoppingList.getItems();
        title = newShoppingList.getTitle();
        description = newShoppingList.getDescription();
    }

    public Set<FoodItem> getItems() {
        return items;
    }

    public  ShoppingList getShoppingList() {
        return newShoppingList;
    }

    public  String getTitle() {
        return title;
    }

    public  void setTitle(String title) {
        InfoStore.title = title;
    }

    public  String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        InfoStore.description = description;
    }

    public void persistItems(){

        if(items.isEmpty()){
            resetInfoStore();
            return;
        }

        DatabaseManager databaseManager = new DatabaseManager();

        /*
        if a shopping list is in infostore then we are updating it, so we need to
         */
        if(newShoppingList == null){
            newShoppingList = new ShoppingList();

            makeShoppingList();
            databaseManager.addObject(newShoppingList);

        } else {
            makeShoppingList();
            databaseManager.updateObject(newShoppingList);
        }
       resetInfoStore();
    }

    private static void makeShoppingList(){
        newShoppingList.getItems().addAll(items);

        if (title == null) {
            title = "New list";
        }
        newShoppingList.setTitle(title);
        newShoppingList.setDescription(description);

    }

    public void resetInfoStore(){
        items.clear();
        title = null;
        description = null;
        newShoppingList = null;

    }
}
