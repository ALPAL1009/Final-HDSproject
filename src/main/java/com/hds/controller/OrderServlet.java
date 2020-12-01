package com.hds.controller;

import com.hds.model.CustomerPojo;
import com.hds.model.OrderPojo;
import com.hds.model.Receipt;
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
		if(request.getParameter("Get Customer Order") != null)
		{
			List<OrderPojo> orderList;
			orderList = configOrderDB.customerOrderView();

			request.setAttribute("orderList", orderList);
			RequestDispatcher rd = request.getRequestDispatcher("/employeeSection/listCustomerOrders.jsp");
			rd.forward(request, response);
		}
		if(request.getParameter("Get Order") != null)
		{
			int customer_id =Integer.parseInt(request.getParameter("customer_id"));
			String lastName = request.getParameter("lastName");
			String first = request.getParameter("first");
			String street = request.getParameter("first");
			String city = request.getParameter("first");
			String state = request.getParameter("first");
			String zip = request.getParameter("first");
			String date_ordered = request.getParameter("date_ordered");
			int orderId = Integer.parseInt(request.getParameter("id"));
			List<OrderPojo> order;
			order = configOrderDB.receiptOrderView(orderId);

			request.setAttribute("customer_id", customer_id);
			request.setAttribute("first", first);
			request.setAttribute("lastName", lastName);
			request.setAttribute("street", street);
			request.setAttribute("city", city);
			request.setAttribute("state", state);
			request.setAttribute("zip", zip);
			request.setAttribute("date_ordered", date_ordered);
			request.setAttribute("order", order);
			RequestDispatcher rd = request.getRequestDispatcher("/employeeSection/salesReceipt.jsp");
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
