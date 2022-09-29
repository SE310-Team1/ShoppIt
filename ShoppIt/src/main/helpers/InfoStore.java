package helpers;

import java.util.List;

import database.DatabaseManager;
import database.models.Item;

public class InfoStore {

	private static InfoStore instance = null;
    private List<Item> itemList;
    private static int listId = 1;
    
    public static InfoStore getInstance() {
		if (instance == null) {
			instance = new InfoStore();
		}
		return instance;
	}

    public void setList(List<Item> itemList) {
        this.itemList = itemList;
    }

    public List<Item> getList() {
        return itemList;
    }

    public void persistList(){
        for (Item item: itemList) {
            item.setListId(listId);
            DatabaseManager databaseManager = new DatabaseManager();
            databaseManager.addObject(item);
        }
        listId++;
        itemList.clear();
    }

    public void eraseList(){
        itemList.clear();
    }
}
