package com.example.app.domain.common.service;

import com.example.app.domain.common.dao.ReservationDao;
import com.example.app.domain.common.dao.ReservationDaoImpl;
import com.example.app.domain.common.dao.common.ConnectionPool;
import com.example.app.domain.common.dto.ReservationDto;

public class ReservationServiceImpl implements ReservationService {
	private ReservationDao reservationDao;
	private ConnectionPool connectionPool;

	private static ReservationService instance;

	public static ReservationService getInstance() throws Exception {
		if (instance == null)
			instance = new ReservationServiceImpl();
		return instance;
	}

	private ReservationServiceImpl() throws Exception {
		reservationDao = ReservationDaoImpl.getInstance();
		this.connectionPool = ConnectionPool.getInstance();
	}

	@Override
	public boolean insertReservation(ReservationDto reservationDto) throws Exception {
		connectionPool.txStart();
		boolean isSuccess = reservationDao.insert(reservationDto);
		connectionPool.txCommit();
		return isSuccess;
	}
}
