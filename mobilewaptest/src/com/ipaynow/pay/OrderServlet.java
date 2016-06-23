package com.ipaynow.pay;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OrderServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4156227648893559991L;
	
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getRequestDispatcher("order.jsp").forward(req, resp);
	}
	
	
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
	
	
	

}
