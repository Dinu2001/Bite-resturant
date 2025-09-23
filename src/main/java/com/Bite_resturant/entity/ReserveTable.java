package com.Bite_resturant.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class ReserveTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name="reservation_id", nullable=false)
    @JsonBackReference // FK column
    private Reservation reservation;


    private int tableNumber;






    public ReserveTable() {
    }

    public ReserveTable(int id, Reservation reservation, int tableNumber) {
        this.id = id;
        this.reservation = reservation;
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
