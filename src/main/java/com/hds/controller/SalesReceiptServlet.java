package com.hds.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "salesReceiptServlet", urlPatterns = "/salesReceiptServlet")
public class SalesReceiptServlet extends HttpServlet
{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		if(request.getParameter("Sales Receipt") != null)
		{

			//			Create a list
			//			select *
			//			from database
			//

			//			List<object> saleList;
			//			saleList = 	configDataBase.viewDB();

			//request.setAttribute("saleList", saleList);
			RequestDispatcher rd = request.getRequestDispatcher("/employeeSection/salesReceipt.jsp");
			rd.forward(request, response);
		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{

	}
}
