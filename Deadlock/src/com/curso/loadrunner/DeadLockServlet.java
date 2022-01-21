package com.curso.loadrunner;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DeadLock")
public class DeadLockServlet extends HttpServlet {
	/**
	* 
	*/
	private static final long serialVersionUID = 6046016960018422719L;
	public static Object s = new Object();
	public static Object s1 = new Object();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int demora = Integer.parseInt(request.getParameter("demora"));
		synchronized (s) {
			System.out.println("Got lock of s in get");
			try {
				Thread.sleep(demora);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("waiting for lock of s1 in get");
			synchronized (s1) {
				System.out.println("Got lock of s1 in get");
			}
		}
		response.getWriter().write("Salgo con exito de la seccion critica");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int demora = Integer.parseInt(request.getParameter("demora"));
		synchronized (s1) {
			System.out.println("Got lock of s1 in post");
			try {
				Thread.sleep(demora);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("waiting for lock of s in post");
			synchronized (s) {
				System.out.println("Got lock of s in  post");
			}
		}
		response.getWriter().write("Salgo con exito de la seccion critica");
	}

}