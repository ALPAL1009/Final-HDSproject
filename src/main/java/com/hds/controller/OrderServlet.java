package com.hds.controller;

import com.hds.model.CustomerPojo;
import com.hds.model.OrderPojo;
import com.hds.util.ConfigCustomerDB;
import com.hds.util.ConfigOrderDB;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "orderServlet",urlPatterns = "/orderServlet")
public class OrderServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	private ConfigOrderDB configOrderDB;

	public void init()
	{
		configOrderDB = new ConfigOrderDB();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
        if(request.getParameter("Order Records") != null)
        {
			List<OrderPojo> orderList;
			orderList = configOrderDB.orderViewDB();

			request.setAttribute("orderList", orderList);
            RequestDispatcher rd = request.getRequestDispatcher("/employeeSection/orderRecords.jsp");
            rd.forward(request, response);
        }
		if(request.getParameter("Edit") != null)
		{
			int orderId = Integer.parseInt(request.getParameter("id"));
			List<OrderPojo> orderList;
			orderList = configOrderDB.editOrderView(orderId);

			request.setAttribute("orderList", orderList);
			RequestDispatcher rd = request.getRequestDispatcher("/employeeSection/editOrderRecords.jsp");
			rd.forward(request, response);
		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		if(request.getParameter("Add New Order") != null)
		{
			//get the Attributes and combine them and add new Order
			//and return back to Order records with new Order added
			RequestDispatcher rd = request.getRequestDispatcher("/employeeSection/orderRecords.jsp");
			rd.forward(request, response);
		}

		if(request.getParameter("Update Order") != null)
		{
			//get the Attributes and combine them and add new Order
			//and return back to Order records with new Order added
			RequestDispatcher rd = request.getRequestDispatcher("/employeeSection/orderRecords.jsp");
			rd.forward(request, response);
		}
		if(request.getParameter("Delete") != null)
		{
			//get the Attributes and combine them and add new Order
			//and return back to Order records with new Order added
			RequestDispatcher rd = request.getRequestDispatcher("/employeeSection/orderRecords.jsp");
			rd.forward(request, response);
		}

	}
}
