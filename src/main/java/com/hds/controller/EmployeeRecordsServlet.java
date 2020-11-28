package com.hds.controller;

import com.hds.model.AddressPojo;
import com.hds.model.CustomerPojo;
import com.hds.model.EmployeePojo;
import com.hds.util.ConfigDatabase;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "employeeRecordsServlet", urlPatterns = "/employeeRecordsServlet")
public class EmployeeRecordsServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	private ConfigDatabase configDatabase;

	public void init()
	{
		configDatabase = new ConfigDatabase();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		//Populate the Employee Records from the Employee page section
		if(request.getParameter("Employee Records") != null)
		{
			System.out.println("Populate Employee list ");

			List<EmployeePojo> employeeList;
			employeeList = configDatabase.employeeViewDB();

			request.setAttribute("employeeList", employeeList);

			request.setAttribute("employeeList", employeeList);
			RequestDispatcher rd = request.getRequestDispatcher("/employeeSection/employeeRecords.jsp");
			rd.forward(request, response);
		}

		//Populates the Edit Employee Page with Employee customer
		if(request.getParameter("Edit") != null)
		{
			//			System.out.println("Updating Employee ");
			int employee_id = Integer.parseInt(request.getParameter("id"));

			List<EmployeePojo> employeeList;
			employeeList = configDatabase.editEmployee(employee_id);

			request.setAttribute("employeeList", employeeList);
			RequestDispatcher rd = request.getRequestDispatcher("/employeeSection/editEmployeeRecords.jsp");
			rd.forward(request, response);
		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		if(request.getParameter("Add New Employee") != null)
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
			//Customer object as a foreign key
			//update address database
			AddressPojo addressPojo = new AddressPojo(customer_address_id, street, city, state, zip);
			configDatabase.addToDataBase(addressPojo);

			//Create the Customer object and update customer database
			CustomerPojo customerPojo = new CustomerPojo(customer_id, customer_address_id, customer_last_name, customer_first_name, customer_mi,
					customer_phone_num,
					customer_email);
			System.out.println("Got info");
			configDatabase.addToDataBase(customerPojo);

			List<CustomerPojo> customerList;
			customerList = configDatabase.customerViewDB();

			request.setAttribute("customerList", customerList);
			RequestDispatcher rd = request.getRequestDispatcher("/employeeSection/customerRecords.jsp");
			rd.forward(request, response);
		}

		if(request.getParameter("Update Employee") != null)
		{
			//Request Parameters from editEmployeeRecords.jsp
			int addressId = Integer.parseInt(request.getParameter("addressId"));
			String street = request.getParameter("street");
			String city = request.getParameter("city");
			String state = request.getParameter("selState");
			String zip = request.getParameter("zip");

			AddressPojo addressPojo = new AddressPojo(addressId, street, city, state, zip);
			configDatabase.updateDatabase(addressPojo);

			int employee_id = Integer.parseInt(request.getParameter("customerId"));
			String last_name = request.getParameter("last_name");
			String first_name = request.getParameter("first_name");
			String mi = request.getParameter("mi");
			int job_id = Integer.parseInt(request.getParameter("jobPosition"));
			int payRate = Integer.parseInt(request.getParameter("payRate"));
			int office_location_id = Integer.parseInt(request.getParameter("selLocation"));
			int site_user_id = Integer.parseInt(request.getParameter("site_user_id"));
			int status_id = Integer.parseInt(request.getParameter("selStatus"));

			EmployeePojo employeePojo = new EmployeePojo(employee_id, addressId, job_id, status_id, office_location_id, site_user_id, last_name,
					first_name, mi, payRate);
			System.out.println("Got info");
			configDatabase.updateDatabase(employeePojo);

			List<EmployeePojo> employeeList;
			employeeList = configDatabase.employeeViewDB();

			request.setAttribute("employeeList", employeeList);
			RequestDispatcher rd = request.getRequestDispatcher("/employeeSection/customerRecords.jsp");
			rd.forward(request, response);
		}

	}
}
