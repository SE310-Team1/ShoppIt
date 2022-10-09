package helpers;

import java.util.ArrayList;
import java.util.List;

import database.DatabaseManager;
import database.models.FoodItem;
import database.models.Item;

public class DisplayFoodItems {

    public static List<String> ListFoodItems(List<FoodItem> foodList) {
        List<String> foodItems = new ArrayList<String>();

        for (int i = 0; i < foodList.size(); i++) {
            //String foodName = getFoodName(List.get(i));
            String productName = foodList.get(i).getProductName();
            foodItems.add(productName);
        }

        return foodItems;
    }

    private static String getFoodName(FoodItem Item) {
        int foodID = Item.getId();
        DatabaseManager DB = new DatabaseManager();
        List<FoodItem> foodItems;
        foodItems = DB.getFromDatabase(FoodItem.class, "FROM FoodItem item WHERE item.id = " +Integer.toString(foodID));
        return foodItems.get(0).getProductName();
    }
}
