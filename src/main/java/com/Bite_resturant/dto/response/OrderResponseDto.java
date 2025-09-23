package com.Bite_resturant.dto.response;

import com.Bite_resturant.dto.request.ListItemDto;


import java.util.Date;
import java.util.List;

public class OrderResponseDto {
    private int id;
    private String email;
    private String firstName;
    private String lastName;
    private double amount;
    private String orderStatus;
    private List<ListItemDto> itemDtoList;
    private Date date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public OrderResponseDto(String email, String firstName, String lastName, double amount, String orderStatus, List<ListItemDto> itemDtoList, Date date) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.amount = amount;
        this.orderStatus = orderStatus;
        this.itemDtoList = itemDtoList;
        this.date = date;
    }

    public OrderResponseDto(int id, String email, String firstName, String lastName, double amount, String orderStatus, List<ListItemDto> itemDtoList, Date date) {
        this.id = id;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.amount = amount;
        this.orderStatus = orderStatus;
        this.itemDtoList = itemDtoList;
        this.date = date;
    }

    public OrderResponseDto() {
    }


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public List<ListItemDto> getItemDtoList() {
        return itemDtoList;
    }

    public void setItemDtoList(List<ListItemDto> itemDtoList) {
        this.itemDtoList = itemDtoList;
    }
}
