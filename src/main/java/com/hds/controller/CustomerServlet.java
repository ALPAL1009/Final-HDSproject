package com.hds.controller;

import com.hds.model.AddressPojo;
import com.hds.model.CustomerPojo;
import com.hds.util.ConfigDatabase;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "customerServlet", urlPatterns = "/customerServlet")
public class CustomerServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	private ConfigDatabase configDatabase;

	public void init()
	{
		configDatabase = new ConfigDatabase();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		if(request.getParameter("Customer Records") != null)
		{
			System.out.println("Populate customer list ");

			List<CustomerPojo> customerList;
			customerList = configDatabase.customerViewDB();

			request.setAttribute("customerList", customerList);
			RequestDispatcher rd = request.getRequestDispatcher("/employeeSection/customerRecords.jsp");
			rd.forward(request, response);
		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		if(request.getParameter("Get Customer") != null)
		{
			System.out.println("Getting Customer");
			String cusInfo = request.getParameter("requestCusId");

			//			CODE SOMETHING LIKE
			//				SELECT *
			//						FROM CUSTOMER (TABLE)
			//				WHRERE ID = cusInfo

			request.setAttribute("requestCusId", cusInfo);
			RequestDispatcher rd = request.getRequestDispatcher("/employeeSection/salesReceipt.jsp");
			rd.forward(request, response);
		}

		if(request.getParameter("Add New Customer") != null)
		{
			System.out.println("Get ADD");

			//Request Parameters from customerRecords.jsp
			int customer_address_id = configDatabase.getNextAddressId();
			System.out.println("Next Id is: " + customer_address_id);
			String street = request.getParameter("address_street");
			System.out.println(street);
			String city = request.getParameter("address_city");
			System.out.println(city);
			String state = request.getParameter("selState");
			System.out.println(state);
			String zip = request.getParameter("address_zip");
			System.out.println(zip);
			int customer_id = configDatabase.getNextCustomerId();
			System.out.println("Next Id is: " + customer_id);
			String customer_last_name = request.getParameter("cus_last_name");
			String customer_first_name = request.getParameter("cus_first_name");
			String customer_mi = request.getParameter("cus_mi");
			String customer_phone_num = request.getParameter("cus_phone_num");
			String customer_email = request.getParameter("cus_email");

			//Create the Address object first
			//Address object is created first because the AddressId is needed for
			//Customer object
			//update address database
			AddressPojo addressPojo = new AddressPojo(customer_address_id, street, city, state, zip);
			configDatabase.addToDataBase(addressPojo);

			//Create the Customer object and update customer database
			CustomerPojo customerPojo = new CustomerPojo(customer_id, customer_address_id, customer_last_name, customer_first_name, customer_mi, customer_phone_num,
					customer_email);
			System.out.println("Got info");
			configDatabase.addToDataBase(customerPojo);

			List<CustomerPojo> customerList;
			customerList = configDatabase.customerViewDB();

			request.setAttribute("customerList", customerList);
			RequestDispatcher rd = request.getRequestDispatcher("/employeeSection/customerRecords.jsp");
			rd.forward(request, response);
		}

	}
}
