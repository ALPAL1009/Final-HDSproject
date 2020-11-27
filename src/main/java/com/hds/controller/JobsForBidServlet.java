package com.hds.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "jobsForBidServlet", urlPatterns = "/jobsForBidServlet")
public class JobsForBidServlet extends HttpServlet
{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		if(request.getParameter("Jobs for Bid") != null)
		{

			//			Create a list
			//			select *
			//			from database
			//

			//			List<object> bidList;
			//			bidList = 	configDataBase.viewDB();

			//request.setAttribute("bidList", bidList);
			RequestDispatcher rd = request.getRequestDispatcher("/employeeSection/jobsForBid.jsp");
			rd.forward(request, response);
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		if(request.getParameter("Add New Job Bid") != null)
		{
			//get the Attributes and combine them and add new bid
			//and return back to bid records with new bid added
			RequestDispatcher rd = request.getRequestDispatcher("/employeeSection/jobsForBid.jsp");
			rd.forward(request, response);
		}

	}
}
