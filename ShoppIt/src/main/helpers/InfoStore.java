package helpers;

import java.util.List;

import database.DatabaseManager;
import database.models.Item;

public class InfoStore {

	private static InfoStore instance = null;
    private List<Item> itemList;
    private static int listId = -1;
    
    public static InfoStore getInstance() {
		if (instance == null) {
			instance = new InfoStore();
		}
		return instance;
	}

    public void setList(List<Item> itemList) {
        this.itemList = itemList;
    }

    public void setList(List<Item> itemList, int listID){
        this.itemList = itemList;
        this.listId = listID;
    }
    public List<Item> getList() {
        return itemList;
    }

    public void persistList(){

        DatabaseManager databaseManager = new DatabaseManager();

        //checks if id has already been provided to the infoStore
        if(listId == -1){
            listId = (int)databaseManager.newestListId();
            listId++;
        }

        for (Item item: itemList) {
            //If an item is not part of a list, then set it list Id to be that of the current list
            if(item.getListId() == 0) {
                item.setListId(listId);
                databaseManager.addObject(item);
            }
        }
       resetInfoStore();
    }

    public void resetInfoStore(){
        itemList.clear();
        listId = -1;
    }
}
