package database.models;

import jakarta.persistence.*;

@Entity
@Table(name = "ITEM")
public class Item {
    @Id
    @GeneratedValue
    private int id; // this value is for database reference ONLY
    @Column(name = "quantity")
    private int quantity;
    @Column(name = "referencetoitemid")
    private int itemId;
    @Column(name = "listId")
    private int listId;

    public Item() {
    }

    public Item(int quantity, int itemId, int listId) {
        this.quantity = quantity;
        this.itemId = itemId;
        this.listId = listId;
    }

    private int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getItemId() {
        return itemId;
    }

    public int getListId() {
        return listId;
    }
}
