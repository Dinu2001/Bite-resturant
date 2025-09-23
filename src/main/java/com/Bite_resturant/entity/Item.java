package com.Bite_resturant.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Item {

    @Id
    @Column(unique = true, nullable = false)
    private String itemCode;

    private String itemName;

    @Column(length = 1000)
    private String description;

    private double price;
    private String imagePath;
    private String type;
    private boolean status;

    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems;

    public Item() {
    }

    public Item(String itemCode, String itemName, String description, double price, String imagePath, String type, boolean status) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.description = description;
        this.price = price;
        this.imagePath = imagePath;
        this.type = type;
        this.status = status;
    }

    public Item(String itemCode, String itemName,
                String description, double price, String imagePath,
                String type, boolean status, List<OrderItem> orderItems) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.description = description;
        this.price = price;
        this.imagePath = imagePath;
        this.type = type;
        this.status = status;
        this.orderItems = orderItems;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }
}
