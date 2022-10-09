package helpers;

import java.util.Set;

import database.DatabaseManager;
import database.models.FoodItem;
import database.models.ShoppingList;

public class InfoStore {

	private static InfoStore instance = null;
    private Set<FoodItem> itemList;
    private static int listId = -1;

    private static ShoppingList newShoppingList = null;
    
    public static InfoStore getInstance() {
		if (instance == null) {
			instance = new InfoStore();
		}
		return instance;
	}

    public void setList(Set<FoodItem> itemList) {
        this.itemList = itemList;
    }

    public void setShoppingList(ShoppingList newShoppingList){
        this.newShoppingList = newShoppingList;
        this.itemList = newShoppingList.getItems();
    }

    public Set<FoodItem> getList() {
        return itemList;
    }

    public void persistList(){

        DatabaseManager databaseManager = new DatabaseManager();

        //checks if id has already been provided to the infoStore
        /*if(listId == -1){
            listId = (int)databaseManager.newestListId();
            listId++;
        }

         */

        if(newShoppingList == null){
            newShoppingList = new ShoppingList();
            newShoppingList.getItems().addAll(itemList);
            databaseManager.addObject(newShoppingList);

        } else {
            newShoppingList.getItems().addAll(itemList);
            System.out.println(newShoppingList.getItems().size());
            for (FoodItem item : newShoppingList.getItems()) {
                System.out.println(item.getId());
            }
            databaseManager.updateObject(newShoppingList);
        }
       resetInfoStore();
    }

    public void resetInfoStore(){
        itemList.clear();
        newShoppingList = null;
        listId = -1;
    }
}
