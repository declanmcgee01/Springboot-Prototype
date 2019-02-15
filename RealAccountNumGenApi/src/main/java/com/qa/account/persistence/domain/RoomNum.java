package com.qa.account.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class RoomNum {
	@Id
	private String roomNum;
	private String booked;
	
	public RoomNum() {}
	
	public RoomNum(String roomNum, String booked) {
		this.roomNum = roomNum;
		this.booked = booked;
	}
	
	public String getRoomNum() {
		return roomNum;
	}
	
	public String getBooked() {
		return booked;
	}
}
