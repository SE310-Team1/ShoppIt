package application;

import database.models.FoodItem;

public interface Listener {
    public void onClickListener(FoodItem item);
}
