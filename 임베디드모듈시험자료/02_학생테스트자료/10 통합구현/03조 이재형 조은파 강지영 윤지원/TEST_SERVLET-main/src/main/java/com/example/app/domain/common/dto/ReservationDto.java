package com.example.app.domain.common.dto;

import java.sql.Timestamp;

public class ReservationDto {
	private int room_info_id;
	private int user_id;
	private boolean reservation_type;
	private Timestamp checkIn;
	private Timestamp checkOut;

	public ReservationDto() {
		super();
	}

	public ReservationDto(int room_info_id, int user_id, boolean reservation_type, Timestamp checkIn,
			Timestamp checkOut) {
		super();
		this.room_info_id = room_info_id;
		this.user_id = user_id;
		this.reservation_type = reservation_type;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public int getRoom_info_id() {
		return room_info_id;
	}

	public void setRoom_info_id(int room_info_id) {
		this.room_info_id = room_info_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public boolean isReservation_type() {
		return reservation_type;
	}

	public void setReservation_type(boolean reservation_type) {
		this.reservation_type = reservation_type;
	}

	public Timestamp getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(Timestamp checkIn) {
		this.checkIn = checkIn;
	}

	public Timestamp getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(Timestamp checkOut) {
		this.checkOut = checkOut;
	}

	@Override
	public String toString() {
		return "ReservationDto [room_info_id=" + room_info_id + ", user_id=" + user_id + ", reservation_type="
				+ reservation_type + ", checkIn=" + checkIn + ", checkOut=" + checkOut + "]";
	}

}
