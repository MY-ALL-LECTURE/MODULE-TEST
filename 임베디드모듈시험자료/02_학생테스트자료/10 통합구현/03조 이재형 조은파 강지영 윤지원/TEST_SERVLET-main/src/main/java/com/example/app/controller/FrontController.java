package com.example.app.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.app.controller.Sub.MemberController;
import com.example.app.controller.Sub.ReservationController;

public class FrontController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private Map<String, BiConsumer<HttpServletRequest, HttpServletResponse>> map;

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("FrontController's init() invoke..");

		map = new HashMap<>();

		String path = config.getServletContext().getContextPath();
		// '/'
		map.put(path + "/", new MemberController()::indexExecute);
		// reservation
		map.put(path + "/reservation/select", new ReservationController()::selectExecute);
		map.put(path + "/reservation/selectAll", new ReservationController()::selectAllExecute);
		map.put(path + "/reservation/insert", new ReservationController()::insertExecute);
		map.put(path + "/reservation/update", new ReservationController()::updateExecute);
		map.put(path + "/reservation/delete", new ReservationController()::deleteExecute);
		// user
		map.put(path + "/member/select", new MemberController()::selectExecute);
		map.put(path + "/member/selectAll", new MemberController()::selectAllExecute);
		map.put(path + "/member/register", new MemberController()::insertExecute);
		map.put(path + "/member/update", new MemberController()::updateExecute);
		map.put(path + "/member/delete", new MemberController()::deleteExecute);
		map.put(path + "/member/login", new MemberController()::loginExecute);
		map.put(path + "/member/logout", new MemberController()::logoutExecute);
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// UTF-8
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		String uri = request.getRequestURI();
		System.out.println("FrontController's service() invoke.." + uri);

		BiConsumer<HttpServletRequest, HttpServletResponse> serve = map.get(uri);
		if (serve == null) {
			throw new ServletException("해당 페이지는 존재하지 않습니다..");
		}

		serve.accept(request, response);

	}

}
