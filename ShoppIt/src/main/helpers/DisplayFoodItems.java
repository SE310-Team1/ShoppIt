package helpers;

import java.util.ArrayList;
import java.util.List;

import database.DatabaseManager;
import database.models.FoodItem;
import database.models.Item;

public class DisplayFoodItems {

    public static List<String> ListFoodItems(List<FoodItem> foodList) {
        List<String> foodItems = new ArrayList<>();

        for (FoodItem foodItem : foodList) {
            String productName = foodItem.getProductName();
            foodItems.add(productName);
        }
        return foodItems;
    }
}
