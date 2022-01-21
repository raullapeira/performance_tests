package com.curso.loadrunner;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ServletAJAX")
public class ServletAJAX extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Thread.sleep(Integer.parseInt(request.getParameter("retardo")));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		response.getWriter().append("GET").append(new Date().getTime()+ "");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Thread.sleep(Integer.parseInt(request.getParameter("retardo")));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		response.getWriter().append("POST ").append(new Date().getTime()+ "");
	}

}
