package com.Bite_resturant.dto.request;



import java.util.Date;
import java.util.List;

public class OrderRequestDto {
    private String userEmail;
    private double amount;
    private String status;
    private List<ListItemDto> itemDtoList;




    public OrderRequestDto() {
    }

    public OrderRequestDto(String userEmail, double amount, String status, List<ListItemDto> itemDtoList) {
        this.userEmail = userEmail;
        this.amount = amount;
        this.status = status;
        this.itemDtoList = itemDtoList;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
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
