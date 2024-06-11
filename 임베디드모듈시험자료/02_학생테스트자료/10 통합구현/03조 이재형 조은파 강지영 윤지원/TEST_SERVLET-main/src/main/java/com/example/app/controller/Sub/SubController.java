package com.example.app.controller.Sub;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class SubController {
	public abstract void selectExecute(HttpServletRequest request, HttpServletResponse response);

	public abstract void selectAllExecute(HttpServletRequest request, HttpServletResponse response);

	public abstract void insertExecute(HttpServletRequest request, HttpServletResponse response);

	public abstract void updateExecute(HttpServletRequest request, HttpServletResponse response);

	public abstract void deleteExecute(HttpServletRequest request, HttpServletResponse response);

	public void loginExecute(HttpServletRequest request, HttpServletResponse response) {
	}

	public void logoutExecute(HttpServletRequest request, HttpServletResponse response) {
	}
}
