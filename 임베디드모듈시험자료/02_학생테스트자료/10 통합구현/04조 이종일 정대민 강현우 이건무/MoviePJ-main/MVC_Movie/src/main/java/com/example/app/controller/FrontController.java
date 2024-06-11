package com.example.app.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.app.controller.movie.MovieAddController;
import com.example.app.controller.movie.MovieDeleteController;
import com.example.app.controller.movie.MovieListController;
import com.example.app.controller.movie.MovieReadController;
import com.example.app.controller.movie.MovieUpdateController;
import com.example.app.controller.user.UserJoinController;
import com.example.app.controller.user.UserLoginController;
import com.example.app.controller.user.UserLogoutController;


public class FrontController extends HttpServlet{
	
	private Map<String,SubController> map;

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("FrontController's init() invoke..");
		
		
		map = new HashMap();
		
		String path = config.getServletContext().getContextPath();
		// '/'
		map.put(path+"/", new HomeController());
		
		//book
		map.put(path+"/movie/add", new MovieAddController());
		map.put(path+"/movie/list", new MovieListController());
		map.put(path+"/movie/read", new MovieReadController());
		map.put(path+"/movie/update", new MovieUpdateController());
		map.put(path+"/movie/delete", new MovieDeleteController());
		
		//user
		map.put(path+"/user/join", new UserJoinController());	//일반회원 | 기업회원 구분
		map.put(path+"/user/login", new UserLoginController());
		map.put(path+"/user/logout", new UserLogoutController());
		
		//lend
		
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//UTF-8
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		
		String uri =  request.getRequestURI();
		System.out.println("FrontController's service() invoke.."+uri);
		
		SubController controller =  map.get(uri);
		if(controller==null) {
			throw new ServletException("해당 페이지는 존재하지 않습니다..");
		}
			
		controller.execute(request, response);
		
		
	}


	
	
}
