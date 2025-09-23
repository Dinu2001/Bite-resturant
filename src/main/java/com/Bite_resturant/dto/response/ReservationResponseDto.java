package com.Bite_resturant.dto.response;

import com.Bite_resturant.dto.request.ReservationTableDto;
import com.Bite_resturant.entity.User;

import java.sql.Date;
import java.sql.Time;

import java.util.Set;

public class ReservationResponseDto {
    private int id;
    private String userEmail;
    private String userFirstNme;
    private String userLastName;
    private String userNumber;
    private Date reserveDate;
    private Time reserveTime;
    private int numberOfPerson;
    private Set<ReservationTableDto> tableDtoList;

    public ReservationResponseDto() {
    }

    public ReservationResponseDto(int id, String userEmail, String userFirstNme, String userLastName, String userNumber, Date reserveDate, Time reserveTime, int numberOfPerson, Set<ReservationTableDto> tableDtoList) {
        this.id = id;
        this.userEmail = userEmail;
        this.userFirstNme = userFirstNme;
        this.userLastName = userLastName;
        this.userNumber = userNumber;
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

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserFirstNme() {
        return userFirstNme;
    }

    public void setUserFirstNme(String userFirstNme) {
        this.userFirstNme = userFirstNme;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(String userNumber) {
        this.userNumber = userNumber;
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
