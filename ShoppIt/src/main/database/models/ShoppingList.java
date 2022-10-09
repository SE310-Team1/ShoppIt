package database.models;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.FetchMode;

import java.util.*;

@Entity
public class ShoppingList {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    private String title;

    private String description;

    @ManyToMany
    @org.hibernate.annotations.Fetch(FetchMode.SUBSELECT)
    @Cascade(CascadeType.MERGE)
    private Set<FoodItem> items = new HashSet<>();

    @ElementCollection
    @MapKeyColumn(name = "item_id")
    @Column(name = "quantity")
    private Map<Integer, Integer> itemQuantity = new HashMap<>();


    public ShoppingList() {
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public Set<FoodItem> getItems() { return items; }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Map<Integer, Integer> getItemQuantity() {
        return itemQuantity;
    }
}
