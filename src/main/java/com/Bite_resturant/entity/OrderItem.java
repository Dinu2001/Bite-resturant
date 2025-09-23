package com.Bite_resturant.entity;

import jakarta.persistence.*;



@Entity
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Orders orders;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    private int quantity;



    public OrderItem() {
    }

    public OrderItem(int id, Orders orders, Item item) {
        this.id = id;
        this.orders = orders;
        this.item = item;
    }

    public OrderItem(int id, Orders orders, Item item, int quantity) {
        this.id = id;
        this.orders = orders;
        this.item = item;
        this.quantity = quantity;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
