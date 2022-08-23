package helpers;

import java.util.List;
import database.models.Item;

public class InfoStore {

	private static InfoStore instance = null;
    private List<Item> itemList;
    
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

}
