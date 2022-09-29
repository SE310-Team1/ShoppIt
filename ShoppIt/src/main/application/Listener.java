package application;

import database.models.FoodItem;

public interface Listener {
    void onClickListener(FoodItem item);
}
