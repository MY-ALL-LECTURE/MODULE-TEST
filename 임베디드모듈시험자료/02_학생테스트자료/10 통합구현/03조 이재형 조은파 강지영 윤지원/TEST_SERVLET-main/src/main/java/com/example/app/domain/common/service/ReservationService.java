package com.example.app.domain.common.service;

import com.example.app.domain.common.dto.ReservationDto;

public interface ReservationService {

	boolean insertReservation(ReservationDto reservationDto) throws Exception;
}
