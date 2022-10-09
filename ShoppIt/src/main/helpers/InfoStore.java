package helpers;

import java.util.Set;
import database.DatabaseManager;
import database.models.FoodItem;
import database.models.ShoppingList;

public class InfoStore {

	private static InfoStore instance = null;
    private static Set<FoodItem> items;
    private static ShoppingList newShoppingList = null;
    
    public static InfoStore getInstance() {
		if (instance == null) {
			instance = new InfoStore();
		}
		return instance;
	}

    public static void setItems(Set<FoodItem> items) {
        InfoStore.items = items;
    }

    public static void setShoppingList(ShoppingList newShoppingList){
        InfoStore.newShoppingList = newShoppingList;
        items = newShoppingList.getItems();
    }

    public Set<FoodItem> getItems() {
        return items;
    }

    public static void persistItems(){

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
            newShoppingList.getItems().addAll(items);
            databaseManager.addObject(newShoppingList);

        } else {
            newShoppingList.getItems().addAll(items);
            databaseManager.updateObject(newShoppingList);
        }
       resetInfoStore();
    }

    public static void resetInfoStore(){
        items.clear();
        newShoppingList = null;

    }
}
