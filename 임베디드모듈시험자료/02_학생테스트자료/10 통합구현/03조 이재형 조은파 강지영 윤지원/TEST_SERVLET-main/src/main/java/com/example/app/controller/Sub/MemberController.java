package com.example.app.controller.Sub;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.app.domain.common.dao.common.ConnectionPool;
import com.example.app.domain.common.dto.MemberDto;
import com.example.app.domain.common.service.MemberService;
import com.example.app.domain.common.service.MemberServiceImpl;

public class MemberController extends SubController {

	private MemberService memberService;
	private ConnectionPool connectionPool;

	public MemberController() {

		try {

			memberService = MemberServiceImpl.getInstance();
			connectionPool = ConnectionPool.getInstance();

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public void indexExecute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("MemberController's indexExecute() invoke..");
		try {
			request.getRequestDispatcher("/WEB-INF/view/index.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void selectExecute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		System.out.println("MemberController's selectExecute() invoke ");
		try {
			request.getRequestDispatcher("/WEB-INF/views/member/read.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void selectAllExecute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		System.out.println("MemberController's selectAllExecute() invoke ");
		try {
			List<MemberDto> list = memberService.selectAll();
			request.setAttribute("list", list);
			request.getRequestDispatcher("/WEB-INF/view/member/list.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void insertExecute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		System.out.println("MemberController's insertExecute() invoke ");
		try {
			String method = request.getMethod();
			if (method.contains("GET")) {
				request.getRequestDispatcher("/WEB-INF/view/member/register.jsp").forward(request, response);
				return;
			}
			if (method.contains("POST")) {
				// 1 파라미터
				int id = 0;
				String realname = request.getParameter("realname");
				String birth = request.getParameter("birth");
				boolean gender = Boolean.parseBoolean(request.getParameter("gender"));
				String phone = request.getParameter("phone");
				String email = request.getParameter("email");
				String username = request.getParameter("username");
				String password = request.getParameter("password");
				String confrimPassword = request.getParameter("confrimPassword");

				// 2 유효성
				if (!isValid()) {
					return;
				}
				// 3 서비스
				MemberDto memberDto = new MemberDto(id, realname, birth, gender, phone, email, username, password,
						confrimPassword);
				boolean isSuccess = memberService.register(memberDto);
				if (!isSuccess) {
					System.err.println("ERROR!!!!!!!!!!");
				} else {
					// 4 뷰
					request.getRequestDispatcher("/WEB-INF/view/member/login.jsp").forward(request, response);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateExecute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		System.out.println("MemberController's updateExecute() invoke ");
		try {

			String method = request.getMethod();
			if (method.contains("GET")) {
				request.getRequestDispatcher("/WEB-INF/view/member/read.jsp").forward(request, response);
				return;
			}
			// 1 파라미터
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String email = request.getParameter("email");
			String phone = request.getParameter("phone");
			// 2 유효성
			if (!isValid()) {
				return;
			}
			// 3 서비스
//			MemberDto memberDto = new MemberDto(username, password, email, phone);
			boolean isUpdated = memberService.update(username, password, email, phone);
			// 4 뷰
			if (isUpdated) {
				response.sendRedirect(request.getContextPath() + "/member/read?username=" + username);
			} else {
				response.sendRedirect(request.getContextPath() + "/member/read");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteExecute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		System.out.println("MemberController's deleteExecute() invoke ");
		try {
			// GET 요청
			String method = request.getMethod();
			if (method.contains("GET")) {
				request.getRequestDispatcher("/WEB-INF/view/member/delete.jsp").forward(request, response);
				return;
			}
			// POST 요청(etc Method)
			// 1
			int id = Integer.parseInt(request.getParameter("id"));
			// 2 validation
			if (!isValid()) {
				return;
			}
			// 3 service
			memberService.deleteMember(id);
			// 4 view
		} catch (Exception e) {
			e.printStackTrace();
			// 예외페이지로 넘기기..or new ServletException("message") 처ㅣ
			try {
				connectionPool.txRollBack();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}

	@Override
	public void loginExecute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		System.out.println("MemberController's loginExecute() invoke ");
		try {
			String method = request.getMethod();
			if (method.contains("GET")) {
				request.getRequestDispatcher("/WEB-INF/view/member/login.jsp").forward(request, response);
				return;
			}
			if (method.contains("POST")) {
				// 1 parameter
				String username = request.getParameter("username");
				String password = request.getParameter("password");
				HttpSession session = request.getSession();

				// 2 validation
				if (!isValid()) {
					return;
				}
				// 3 service
				boolean isSuccess = memberService.login(username, password, session);
				// 4 view
				if (isSuccess) {
					response.sendRedirect(request.getContextPath() + "/");
				} else {
					System.err.println("ERROR!!!");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void logoutExecute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("MemberController's logoutExecute() invoke ");
		// TODO Auto-generated method stub
		String method = request.getMethod();

		try {
			if (method.contains("GET")) {
				request.getRequestDispatcher("WEB-INF/view/member/delete.jsp").forward(request, response);
				return;
			}
			if (method.contains("POST")) {
				// 1 parameter : none

				// 2 validation : none

				// 3 service
//				memberService.logout();
				// 4 view
			}
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private boolean isValid() {

		return true;
	}

}
