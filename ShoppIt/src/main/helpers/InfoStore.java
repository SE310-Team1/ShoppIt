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
        System.out.println("initial id " + listId);
        if(listId == -1){
            listId = (int)databaseManager.newestListId();
            System.out.println("found id " + listId);
            listId++;
        }

        for (Item item: itemList) {
            if(item.getListId() == 0) {
                System.out.println("Adding to " + listId);
                item.setListId(listId);
                databaseManager.addObject(item);
            }
        }
        listId = -1;
        itemList.clear();
    }

    public void eraseList(){
        itemList.clear();
        listId = -1;
    }
}
