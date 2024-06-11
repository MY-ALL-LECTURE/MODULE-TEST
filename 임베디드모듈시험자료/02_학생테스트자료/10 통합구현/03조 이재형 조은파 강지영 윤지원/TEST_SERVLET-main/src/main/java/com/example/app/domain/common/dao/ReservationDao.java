package com.example.app.domain.common.dao;

import com.example.app.domain.common.dto.ReservationDto;

public interface ReservationDao {

	boolean insert(ReservationDto dto) throws Exception;
}
