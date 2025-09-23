package com.Bite_resturant.entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "orders")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;

    private double amount;

    @ManyToOne
    @JoinColumn(name = "user_email", referencedColumnName = "email")
    private User user;

    @OneToMany(mappedBy = "orders", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems;

    private String orderStatus;

    private Date orderDate;

    public Orders(int id, double amount, User user, String orderStatus, Date orderDate) {
        this.orderId =id;
        this.amount = amount;
        this.user.setEmail(user.getEmail());
        this.orderStatus =orderStatus;
        this.orderDate = orderDate;
    }


    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Orders() {
    }

    public Orders(int orderId, double amount, User user) {
        this.orderId = orderId;
        this.amount = amount;
        this.user = user;
    }

    public Orders(String userEmail, double amount,String status,Date orderDate) {
        this.amount = amount;
        this.user.setEmail(userEmail);
        this.orderStatus =status;
        this.orderDate = orderDate;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }
}
