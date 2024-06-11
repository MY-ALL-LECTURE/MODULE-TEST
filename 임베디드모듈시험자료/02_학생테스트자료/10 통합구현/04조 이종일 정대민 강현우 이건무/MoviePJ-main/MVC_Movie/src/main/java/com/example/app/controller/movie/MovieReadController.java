package com.example.app.controller.movie;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.app.controller.SubController;

public class MovieReadController  implements SubController{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("MovieReadController's execute() invoke");		
	}

}
