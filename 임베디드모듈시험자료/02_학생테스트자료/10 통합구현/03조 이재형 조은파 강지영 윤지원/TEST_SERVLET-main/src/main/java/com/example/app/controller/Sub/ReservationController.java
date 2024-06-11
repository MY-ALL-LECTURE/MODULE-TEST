package com.example.app.controller.Sub;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.app.domain.common.dao.common.ConnectionPool;
import com.example.app.domain.common.dto.ReservationDto;
import com.example.app.domain.common.service.ReservationService;
import com.example.app.domain.common.service.ReservationServiceImpl;

public class ReservationController extends SubController {

	private ReservationService reservationService;
	private ConnectionPool connectionPool;

	public ReservationController() {
		try {
			reservationService = ReservationServiceImpl.getInstance();
			connectionPool = ConnectionPool.getInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void selectExecute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	@Override
	public void selectAllExecute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("ReservationController's selectAllExecute() invoke ");

		String method = request.getMethod();
		if (method.contains("GET")) {
			try {
				request.getRequestDispatcher("/WEB-INF/view/reservation/list.jsp").forward(request, response);
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		} else if (method.contains("POST")) {
		}

	}

	@Override
	public void insertExecute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("ReservationController's insertExecute() invoke ");

		String method = request.getMethod();
		if (method.contains("GET")) {
			try {
				request.getRequestDispatcher("/WEB-INF/view/reservation/insert.jsp").forward(request, response);
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		} else if (method.contains("POST")) {
			// 1 parameter
			try {
				int room_info_id = Integer.parseInt(request.getParameter("room_info_id"));
				int user_id = Integer.parseInt(request.getParameter("user_id"));
				boolean reservation_type = Boolean.parseBoolean(request.getParameter("reservation_type"));
				LocalDateTime checkIn = LocalDateTime.parse(request.getParameter("checkIn")).withNano(0);
				LocalDateTime checkOut = LocalDateTime.parse(request.getParameter("checkOut")).withNano(0);
				Timestamp check_in = Timestamp.valueOf(checkIn);
				Timestamp check_out = Timestamp.valueOf(checkOut);

				System.out.println(
						room_info_id + ", " + user_id + ", " + reservation_type + ", " + checkIn + ", " + checkOut);
				ReservationDto reservationDto = new ReservationDto(room_info_id, user_id, reservation_type, check_in,
						check_out);
				// 2 valid
				if (!isValid()) {
					return;
				}
				// 3 service
				boolean isSuccess = reservationService.insertReservation(reservationDto);
				// 4 view
				if (isSuccess) {
					response.sendRedirect(request.getContextPath() + "/");
				} else {
					System.err.println("ERROR!!");
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void updateExecute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteExecute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	private boolean isValid() {
		// TODO Auto-generated method stub
		return true;
	}
}
