package com.hds.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "employeeRecordsServlet", urlPatterns = "/employeeRecordsServlet")
public class EmployeeRecordsServlet extends HttpServlet
{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		if(request.getParameter("Employee Records") != null)
		{

			//			Create a list
			//			select *
			//			from database
			//

			//			List<object> employeeList;
			//			employeeList = 	configDataBase.viewDB();

			//request.setAttribute("employeeList", employeeList);
			RequestDispatcher rd = request.getRequestDispatcher("/employeeSection/employeeRecords.jsp");
			rd.forward(request, response);
		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		if(request.getParameter("Add New Employee") != null)
		{
				//get the Attributes and combine them and add new employee
				//and return back to employee records with new employee added
			RequestDispatcher rd = request.getRequestDispatcher("/employeeSection/employeeRecords.jsp");
			rd.forward(request, response);
		}

	}
}
