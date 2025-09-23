package com.Bite_resturant.dto.request;

public class ListItemDto {
    private String itemCode;
    private int quantity;


    public ListItemDto() {
    }

    public ListItemDto(String itemCode, int quantity) {
        this.itemCode = itemCode;
        this.quantity = quantity;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
