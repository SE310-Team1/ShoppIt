package database.dataModels;

public class foodItem {
    private String productName;
    private String imgFilename;
    private String brand;
    private String department;
    private String dietClassification;
    private int weight;
    private int totalCalories;

    public foodItem(String productName, String imgFilename, String brand, String department, String dietClassification, int weight, int totalCalories) {
        this.productName = productName;
        this.imgFilename = imgFilename;
        this.brand = brand;
        this.department = department;
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

    public String getDepartment() {
        return department;
    }

    public String getDietClassification() {
        return dietClassification;
    }

    public int getWeight() {
        return weight;
    }

    public int getTotalCalories() {
        return totalCalories;
    }
}

