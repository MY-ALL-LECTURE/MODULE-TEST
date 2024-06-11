package com.example.app.domain.common.dao;

import com.example.app.domain.common.dao.common.CommonDao;
import com.example.app.domain.common.dto.ReservationDto;

public class ReservationDaoImpl extends CommonDao implements ReservationDao {

	private static ReservationDao instance;

	public static ReservationDao getInstance() throws Exception {
		if (instance == null)
			instance = new ReservationDaoImpl();
		return instance;
	}

	private ReservationDaoImpl() throws Exception {
		System.out.println("[DAO] ReservationDaoImpl's INIT " + conn);
	}

	@Override
	public boolean insert(ReservationDto dto) throws Exception {
		pstmt = conn.prepareStatement("insert into reservation values(0,?,?,?,?,?)");
		pstmt.setInt(1, dto.getRoom_info_id());
		pstmt.setInt(2, dto.getUser_id());
		pstmt.setBoolean(3, dto.isReservation_type());
		pstmt.setTimestamp(4, dto.getCheckIn());
		pstmt.setTimestamp(5, dto.getCheckOut());

		int result = pstmt.executeUpdate();
		freeConnection(pstmt);
		return result > 0;
	}
}
