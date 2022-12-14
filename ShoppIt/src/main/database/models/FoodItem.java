package database.models;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "FOOD_ITEMS")
public class FoodItem {
    @Id
    @GeneratedValue
    private int id;
    @Column(name = "product_name", unique = true)
    private String productName;
    @Column(name = "image_filename")
    private String imgFilename;
    @Column(name = "brand")
    private String brand;
    @Column(name = "price")
    private String price;
    @Column(name = "diet_classification")
    private String dietClassification;
    @Column(name = "weight")
    private String weight;
    @Column(name = "total_calories")
    private int totalCalories;


    public FoodItem(String productName, String imgFilename, String brand, String price, String dietClassification, String weight, int totalCalories) {
        this.productName = productName;
        this.imgFilename = imgFilename;
        this.brand = brand;
        this.price = price;
        this.dietClassification = dietClassification;
        this.weight = weight;
        this.totalCalories = totalCalories;
    }

    public FoodItem() {
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

    public String getPrice() {
        return price;
    }

    public String getDietClassification() {
        return dietClassification;
    }

    public String getWeight() {
        return weight;
    }

    public int getTotalCalories() {
        return totalCalories;
    }

    public int getId() {
        return id;
    }

    public void setImgFilename(String imgFilename) {
        this.imgFilename = imgFilename;
    }

   @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FoodItem foodItem = (FoodItem) o;
        return id == foodItem.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

