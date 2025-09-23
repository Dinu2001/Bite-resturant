package com.Bite_resturant.dto;

import com.Bite_resturant.entity.Orders;
import com.Bite_resturant.entity.Reservation;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;


import java.util.List;

public class UserDto {
    private String email;

    private String firstName;
    private String lastName;
    private String number;
    private String address;
    private String password;
    private String role;

    private List<Orders> orders;



    private List<Reservation> reservations;



    public UserDto() {
    }



    public UserDto(String email, String firstName, String lastName, String number, String address,
                   String password, String role, List<Orders>
                           orders, List<Reservation> reservations) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.number = number;
        this.address = address;
        this.password = password;
        this.role = role;
        this.orders = orders;
        this.reservations = reservations;
    }

    public UserDto(String email, String firstName, String lastName,
                   String number, String address, String password, String role) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.number = number;
        this.address = address;
        this.password = password;
        this.role = role;
    }

    public UserDto(String email, String firstName,
                   String lastName, String number, String address, String password, String role, List<Orders> orders) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.number = number;
        this.address = address;
        this.password = password;
        this.role = role;
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
