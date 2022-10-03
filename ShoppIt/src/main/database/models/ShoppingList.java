package database.models;

import jakarta.persistence.*;
import org.hibernate.annotations.FetchMode;

import java.util.*;

@Entity
public class ShoppingList {

    @Id
    @GeneratedValue
    private Long id;

    private String title;

    private String description;

    @ManyToMany
    @org.hibernate.annotations.Fetch(FetchMode.SUBSELECT)
    private Set<Item> itemList;

    @ElementCollection
    @MapKeyColumn(name = "item_id")
    @Column(name = "quantity")
    private HashMap<Long, Integer> itemQuantity = new HashMap<>();


    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public Set<Item> getItemList() { return itemList; }

    public HashMap<Long, Integer> getItemQuantity() { return itemQuantity; }

    public int getQuantity(Long itemId){ return itemQuantity.get(itemId); }


}
