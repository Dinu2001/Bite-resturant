package com.Bite_resturant.dto.request;

public class OrderDetailsUpdateDto {
    private int orderId;
    private String orderStatus;

    public OrderDetailsUpdateDto() {
    }

    public OrderDetailsUpdateDto(int orderId, String orderStatus) {
        this.orderId = orderId;
        this.orderStatus = orderStatus;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }
}
