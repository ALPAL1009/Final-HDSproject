package com.hds.controller;

import com.hds.model.JobsForBidPojo;
import com.hds.util.ConfigJobForBidDB;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "jobsForBidServlet", urlPatterns = "/jobsForBidServlet")
public class JobsForBidServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	private ConfigJobForBidDB configJobForBidDB;

	public void init()
	{
		configJobForBidDB = new ConfigJobForBidDB();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		if(request.getParameter("Jobs for Bid") != null)
		{
			List<JobsForBidPojo> bidList;
			bidList = configJobForBidDB.jobForBidViewDB();

			request.setAttribute("bidList", bidList);
			RequestDispatcher rd = request.getRequestDispatcher("/employeeSection/jobsForBid.jsp");
			rd.forward(request, response);
		}

		if(request.getParameter("Edit") != null)
		{
			int jobBidId = Integer.parseInt(request.getParameter("id"));
			List<JobsForBidPojo> bidList;
			bidList = configJobForBidDB.editJobForBidViewDB(jobBidId);

			request.setAttribute("bidList", bidList);
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

		if(request.getParameter("Update Bid") != null)
		{


			List<JobsForBidPojo> bidList;
			bidList = configJobForBidDB.jobForBidViewDB();

			request.setAttribute("bidList", bidList);
			RequestDispatcher rd = request.getRequestDispatcher("/employeeSection/jobsForBid.jsp");
			rd.forward(request, response);
		}

		if(request.getParameter("Delete") != null)
		{
			//get the Attributes and combine them and add new bid
			//and return back to bid records with new bid added
			RequestDispatcher rd = request.getRequestDispatcher("/employeeSection/jobsForBid.jsp");
			rd.forward(request, response);
		}

	}
}
