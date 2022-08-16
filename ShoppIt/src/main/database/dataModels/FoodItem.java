package database.dataModels;

import jakarta.persistence.*;

@Entity
@Table(name = "FOOD_ITEMS")
public class FoodItem {
    @Id
    @GeneratedValue
    private int id;
    @Column(name = "product_name")
    private String productName;
    @Column(name = "image_filename")
    private String imgFilename;
    @Column(name = "brand")
    private String brand;
    @Column(name = "diet_classification")
    private String dietClassification;
    @Column(name = "weight")
    private int weight;
    @Column(name = "total_calories")
    private int totalCalories;


    public FoodItem(String productName, String imgFilename, String brand, String dietClassification, int weight, int totalCalories) {
        this.productName = productName;
        this.imgFilename = imgFilename;
        this.brand = brand;
        this.dietClassification = dietClassification;
        this.weight = weight;
        this.totalCalories = totalCalories;
    }

    public String getProductName() {
        return productName;
    }

    public String getImgFilename() {
        return imgFilename;
    }

    public String getBrand() {
        return brand;
    }

    public String getDietClassification() {
        return dietClassification;
    }

    /**
     * @return weight in grams
     */
    public int getWeight() {
        return weight;
    }

    public int getTotalCalories() {
        return totalCalories;
    }

    public int getId() {
        return id;
    }
}

