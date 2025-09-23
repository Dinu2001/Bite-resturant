package com.Bite_resturant.dto.request;

import com.Bite_resturant.entity.Reservation;


public class ReservationTableDto {
    private int id;
    private Reservation reservation;
    private int tableNumber;

    public ReservationTableDto() {
    }


    public ReservationTableDto(int id, Reservation reservation, int tableNumber) {
        this.id = id;
        this.reservation = reservation;
        this.tableNumber = tableNumber;
    }

    public ReservationTableDto(int id, int tableNumber) {
        this.id = id;
        this.tableNumber = tableNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }
}
