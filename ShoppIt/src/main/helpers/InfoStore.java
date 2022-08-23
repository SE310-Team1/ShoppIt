package helpers;

import java.util.List;
import database.models.FoodItem;

public class InfoStore {

	private static InfoStore instance = null;
    private List<FoodItem> itemList;
    private FoodItem item;
    
    public static InfoStore getInstance() {
		if (instance == null) {
			instance = new InfoStore();
		}
		return instance;
	}

    public void setList(List<FoodItem> itemList) {
        this.itemList = itemList;
    }

    public List<FoodItem> getList() {
        return itemList;
    }
    
    public void setItem(FoodItem item) {
        this.item = item;
    }

    public FoodItem getItem() {
        return item;
    }

}
