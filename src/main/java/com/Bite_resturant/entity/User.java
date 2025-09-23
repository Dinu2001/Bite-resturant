package com.Bite_resturant.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "user")
public class User {

    @Id
    @Column(unique = true,nullable = false)
    private String email;

    private String firstName;
    private String lastName;
    private String number;
    private String address;
    private String password;
    private String role;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    @JsonManagedReference
    private List<Reservation> reservations;


    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Orders> orders;


    public User() {
    }

    public User(String email, String firstName, String lastName, String number, String address, String password, String role) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.number = number;
        this.address = address;
        this.password = password;
        this.role = role;
    }

    public User(String email, String firstName, String lastName, String number, String address, String password, String role, List<Reservation> reservations, List<Orders> orders) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.number = number;
        this.address = address;
        this.password = password;
        this.role = role;
        this.reservations = reservations;
        this.orders = orders;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
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

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }
}
