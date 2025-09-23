package com.Bite_resturant.entity;

import com.Bite_resturant.dto.request.ReservationTableDto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Time;
import java.util.Set;

@Entity
@Table(name="reservation")
public class    Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_email", nullable = false)
    @JsonBackReference
    private User user;

    private String userFirstName;
    private String userLastName;
    private String contactNumber;
    private Date reserveDate;
    private Time reserveTime;
    private int numberOfPerson;

    @OneToMany(mappedBy="reservation", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private Set<ReserveTable> reserveTable;





    public Reservation() {
    }


    public Reservation(int id, User user, String userFirstName, String userLastName, String contactNumber, Date reserveDate, Time reserveTime, int numberOfPerson, Set<ReserveTable> reserveTable) {
        this.id = id;
        this.user = user;
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.contactNumber = contactNumber;
        this.reserveDate = reserveDate;
        this.reserveTime = reserveTime;
        this.numberOfPerson = numberOfPerson;
        this.reserveTable = reserveTable;
    }

    public Reservation(int id, User user, String firstName, String lastName, String number, Date reserveDate, Time reserveTime, int numberOfPerson) {
        this.id = id;
        this.user = user;
        this.userFirstName = firstName;
        this.userLastName = lastName;
        this.contactNumber = number;
        this.reserveDate = reserveDate;
        this.reserveTime = reserveTime;
        this.numberOfPerson = numberOfPerson;

    }


    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public Reservation(int id, User user, Date reserveDate, Time reserveTime, int numberOfPerson, Set<ReserveTable> reserveTable) {
        this.id = id;
        this.user = user;
        this.reserveDate = reserveDate;
        this.reserveTime = reserveTime;
        this.numberOfPerson = numberOfPerson;
        this.reserveTable = reserveTable;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getReserveDate() {
        return reserveDate;
    }

    public void setReserveDate(Date reserveDate) {
        this.reserveDate = reserveDate;
    }

    public Time getReserveTime() {
        return reserveTime;
    }

    public void setReserveTime(Time reserveTime) {
        this.reserveTime = reserveTime;
    }

    public int getNumberOfPerson() {
        return numberOfPerson;
    }

    public void setNumberOfPerson(int numberOfPerson) {
        this.numberOfPerson = numberOfPerson;
    }

    public Set<ReserveTable> getReserveTable() {
        return reserveTable;
    }

    public void setReserveTable(Set<ReserveTable> reserveTable) {
        this.reserveTable = reserveTable;
    }
}
