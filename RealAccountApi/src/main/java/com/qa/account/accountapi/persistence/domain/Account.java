package com.qa.account.accountapi.persistence.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Account {
    @Id
    @GeneratedValue
    private Long accountId;

    private String username;

    private String password;

    private String roomNumber;
    
    private String isBooked;

    public Account() {
    }

    public Account(Long accountId, String username, String password, String roomNumber, String isBooked) {
        this.username = username;
        this.password = password;
        this.roomNumber = roomNumber;
        this.accountId = accountId;
        this.isBooked = isBooked;
    }

    public Long getId() {
        return accountId;
    }

    public void setId(Long id) {
        this.accountId = id;
    }
    
    public String getIsBooked()
    {
    	return isBooked;
    }
    
    public void setIsBooked(String booked) {
    	this.isBooked = booked;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    
    public String toString() {
    	return this.accountId + this.username + this.password + this.roomNumber;
    }
}
