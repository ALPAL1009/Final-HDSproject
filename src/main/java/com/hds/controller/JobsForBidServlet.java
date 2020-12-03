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
import java.time.LocalDate;
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
			RequestDispatcher rd = request.getRequestDispatcher("/employeeSection/editJobsForBid.jsp");
			rd.forward(request, response);
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		if(request.getParameter("Add New Job Bid") != null)
		{
			int new_job_bid_id = configJobForBidDB.getNextBidId();
			String new_description = request.getParameter("new_description");
			Double new_bidAmount = Double.parseDouble(request.getParameter("new_bidAmount"));
			LocalDate new_dateOpen = LocalDate.parse(request.getParameter("new_dateOpen"));
			LocalDate new_dateClosed = LocalDate.parse(request.getParameter("new_dateClosed"));

			JobsForBidPojo jobsForBidPojo = new JobsForBidPojo( new_job_bid_id,  new_description,  new_bidAmount,  new_dateOpen, new_dateClosed);
			configJobForBidDB.addToDataBase(jobsForBidPojo);

			List<JobsForBidPojo> bidList;
			bidList = configJobForBidDB.jobForBidViewDB();

			request.setAttribute("bidList", bidList);
			RequestDispatcher rd = request.getRequestDispatcher("/employeeSection/jobsForBid.jsp");
			rd.forward(request, response);
		}

		if(request.getParameter("Update Bid") != null)
		{
			int update_job_bid_id = Integer.parseInt(request.getParameter("id"));
			String update_description = request.getParameter("update_description");
			Double update_bidAmount = Double.parseDouble(request.getParameter("update_bidAmount"));
			LocalDate update_dateOpen = LocalDate.parse(request.getParameter("update_dateOpen"));
			LocalDate update_dateClosed = LocalDate.parse(request.getParameter("update_dateClosed"));

			JobsForBidPojo jobsForBidPojo = new JobsForBidPojo( update_job_bid_id,  update_description,  update_bidAmount,  update_dateOpen, update_dateClosed);
			configJobForBidDB.updateDatabase(jobsForBidPojo);


			List<JobsForBidPojo> bidList;
			bidList = configJobForBidDB.jobForBidViewDB();

			request.setAttribute("bidList", bidList);
			RequestDispatcher rd = request.getRequestDispatcher("/employeeSection/jobsForBid.jsp");
			rd.forward(request, response);
		}

		if(request.getParameter("Delete") != null)
		{
			int delete_job_bid_id = Integer.parseInt(request.getParameter("id"));
			configJobForBidDB.deleteBid(delete_job_bid_id);

			List<JobsForBidPojo> bidList;
			bidList = configJobForBidDB.jobForBidViewDB();

			request.setAttribute("bidList", bidList);
			RequestDispatcher rd = request.getRequestDispatcher("/employeeSection/jobsForBid.jsp");
			rd.forward(request, response);
		}

	}
}
