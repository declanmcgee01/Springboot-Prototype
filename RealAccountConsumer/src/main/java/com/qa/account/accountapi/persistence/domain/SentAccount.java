package com.qa.account.accountapi.persistence.domain;

public class SentAccount {

    private Long accountId;

    private String username;

    private String password;

    private String roomNumber;

    private SentPrize sentPrize;

    public SentAccount() {
    }

    public SentAccount(Long accountId, String username, String password, String roomNumber, SentPrize sentPrize) {
        this.username = username;
        this.password = password;
        this.roomNumber = roomNumber;
        this.accountId = accountId;
        this.sentPrize = sentPrize;
    }

    public Long getId() {
        return accountId;
    }

    public void setId(Long id) {
        this.accountId = id;
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

    public SentPrize getSentPrize() {
        return sentPrize;
    }

    public void setSentPrize(SentPrize sentPrize) {
        this.sentPrize = sentPrize;
    }

}