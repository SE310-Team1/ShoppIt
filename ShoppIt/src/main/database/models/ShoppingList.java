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
    private Long id;

    @ManyToMany
    @org.hibernate.annotations.Fetch(FetchMode.SUBSELECT)
    @Cascade(CascadeType.MERGE)
    private Set<FoodItem> items = new HashSet<>();

    public ShoppingList() {
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public Set<FoodItem> getItems() { return items; }

}
