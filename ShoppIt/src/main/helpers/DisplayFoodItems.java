package helpers;

import java.util.ArrayList;
import java.util.List;

import database.DatabaseManager;
import database.models.FoodItem;
import database.models.Item;

public class DisplayFoodItems {

    public static List<String> ListFoodItems(List<Item> List) {
        List<String> foodItems = new ArrayList<String>();

        for (int i = 0; i < List.size(); i++) {
            String foodName = getFoodName(List.get(i));
            foodItems.add(foodName);
        }

        return foodItems;
    }

    private static String getFoodName(Item Item) {
        int foodID = Item.getItemId();
        DatabaseManager DB = new DatabaseManager();
        Class<FoodItem> FoodItem = null;
        List<FoodItem> foodItems = new ArrayList<FoodItem>();
        foodItems = DB.getFromDatabase(FoodItem, "FROM FoodItem item WHERE item.id = " +Integer.toString(foodID));
        return foodItems.get(0).getProductName();
    }
}
