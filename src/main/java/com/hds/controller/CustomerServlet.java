package com.hds.controller;

import com.hds.model.AddressPojo;
import com.hds.model.CustomerPojo;
import com.hds.util.ConfigCustomerDB;

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
	private ConfigCustomerDB configCustomerDB;

	public void init()
	{
		configCustomerDB = new ConfigCustomerDB();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		//Populate the Customer Records from the Employee page section
		if(request.getParameter("Customer Records") != null)
		{
			//			System.out.println("Populate customer list ");
			List<CustomerPojo> customerList;
			customerList = configCustomerDB.customerViewDB();

			request.setAttribute("customerList", customerList);
			RequestDispatcher rd = request.getRequestDispatcher("/employeeSection/customerRecords.jsp");
			rd.forward(request, response);
		}

		//Populates the Edit Customer Page with Single customer
		if(request.getParameter("Edit") != null)
		{
			//			System.out.println("Updating Customer ");
			int customerId = Integer.parseInt(request.getParameter("id"));

			List<CustomerPojo> customerList;
			customerList = configCustomerDB.editCustomerView(customerId);

			request.setAttribute("customerList", customerList);
			RequestDispatcher rd = request.getRequestDispatcher("/employeeSection/editCustomerRecords.jsp");
			rd.forward(request, response);
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		//Adds new customer to the Customer database
		//Adds new address to Address database
		if(request.getParameter("Add New Customer") != null)
		{
			//			System.out.println("Get ADD");

			//Request Parameters from customerRecords.jsp
			int customer_address_id = configCustomerDB.getNextAddressId();
			System.out.println("Next Id is: " + customer_address_id);
			String street = request.getParameter("address_street");
			System.out.println(street);
			String city = request.getParameter("address_city");
			System.out.println(city);
			String state = request.getParameter("selState");
			System.out.println(state);
			String zip = request.getParameter("address_zip");
			System.out.println(zip);
			int customer_id = configCustomerDB.getNextCustomerId();
			System.out.println("Next Id is: " + customer_id);
			String customer_last_name = request.getParameter("cus_last_name");
			String customer_first_name = request.getParameter("cus_first_name");
			String customer_mi = request.getParameter("cus_mi");
			String customer_phone_num = request.getParameter("cus_phone_num");
			String customer_email = request.getParameter("cus_email");

			//Create the Address object first
			//Address object is created first because the AddressId is needed for
			//Customer object as a foreign key
			//update address database
			AddressPojo addressPojo = new AddressPojo(customer_address_id, street, city, state, zip);
			configCustomerDB.addToDataBase(addressPojo);

			//Create the Customer object and update customer database
			CustomerPojo customerPojo = new CustomerPojo(customer_id, customer_address_id, customer_last_name, customer_first_name, customer_mi,
					customer_phone_num,
					customer_email);
			System.out.println("Got info");
			configCustomerDB.addToDataBase(customerPojo);

			List<CustomerPojo> customerList;
			customerList = configCustomerDB.customerViewDB();

			request.setAttribute("customerList", customerList);
			RequestDispatcher rd = request.getRequestDispatcher("/employeeSection/customerRecords.jsp");
			rd.forward(request, response);
		}

		//Pull the existing Customer and Update their information
		if(request.getParameter("Update Customer") != null)
		{
			//			System.out.println("Update Customer ");

			//Request Parameters from customerRecords.jsp
			int customer_address_id = Integer.parseInt(request.getParameter("addressId"));
			String street = request.getParameter("address_street");
			System.out.println(street);
			String city = request.getParameter("address_city");
			System.out.println(city);
			String state = request.getParameter("selState");
			System.out.println(state);
			String zip = request.getParameter("address_zip");
			System.out.println(zip);
			int customer_id = Integer.parseInt(request.getParameter("customerId"));
			String customer_last_name = request.getParameter("cus_last_name");
			String customer_first_name = request.getParameter("cus_first_name");
			String customer_mi = request.getParameter("cus_mi");
			String customer_phone_num = request.getParameter("cus_phone_num");
			String customer_email = request.getParameter("cus_email");

			AddressPojo addressPojo = new AddressPojo(customer_address_id, street, city, state, zip);
			configCustomerDB.updateDatabase(addressPojo);

			//Create the Customer object and update customer database
			CustomerPojo customerPojo = new CustomerPojo(customer_id, customer_address_id, customer_last_name, customer_first_name, customer_mi,
					customer_phone_num,
					customer_email);
			System.out.println("Got info");
			configCustomerDB.updateDatabase(customerPojo);

			List<CustomerPojo> customerList;
			customerList = configCustomerDB.customerViewDB();

			request.setAttribute("customerList", customerList);
			RequestDispatcher rd = request.getRequestDispatcher("/employeeSection/customerRecords.jsp");
			rd.forward(request, response);
		}

		//Delete Customer and their corresponding address
		if(request.getParameter("Delete") != null)
		{
			//			System.out.println("Get Delete");
			int customerId = Integer.parseInt(request.getParameter("customerId"));
			//			System.out.print(customerId);
			configCustomerDB.deleteCustomer(customerId);

			int addressId = Integer.parseInt(request.getParameter("addressId"));
			//			System.out.print(addressId);
			configCustomerDB.deleteAddress(addressId);

			List<CustomerPojo> customerList;
			customerList = configCustomerDB.customerViewDB();

			request.setAttribute("customerList", customerList);
			RequestDispatcher rd = request.getRequestDispatcher("/employeeSection/customerRecords.jsp");
			rd.forward(request, response);
		}
	}
}
