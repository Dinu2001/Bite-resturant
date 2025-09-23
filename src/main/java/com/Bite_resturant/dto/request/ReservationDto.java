package com.Bite_resturant.dto.request;

import com.Bite_resturant.entity.User;


import java.sql.Date;
import java.sql.Time;
import java.util.Set;

public class ReservationDto {

    private int id;
    private User user;

    private Date reserveDate;
    private Time reserveTime;

    private int numberOfPerson;
    private Set<ReservationTableDto> tableDtoList;


    public ReservationDto() {
    }

    public ReservationDto(int id, User user, Date reserveDate, Time reserveTime, int numberOfPerson, Set<ReservationTableDto> tableDtoList) {
        this.id = id;
        this.user = user;
        this.reserveDate = reserveDate;
        this.reserveTime = reserveTime;
        this.numberOfPerson = numberOfPerson;
        this.tableDtoList = tableDtoList;
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

    public Set<ReservationTableDto> getTableDtoList() {
        return tableDtoList;
    }

    public void setTableDtoList(Set<ReservationTableDto> tableDtoList) {
        this.tableDtoList = tableDtoList;
    }
}
