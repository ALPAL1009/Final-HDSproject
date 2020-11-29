package com.hds.controller;

import com.hds.model.AddressPojo;
import com.hds.model.CustomerPojo;
import com.hds.model.EmployeePojo;
import com.hds.model.EmployeeSiteUserPojo;
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
			System.out.println("Add New Employee");

			//----Address----//
			int addressId = configDatabase.getNextAddressId();
			//			System.out.println("Next Address Id is: " + addressId);
			String street = request.getParameter("street");
			String city = request.getParameter("city");
			String state = request.getParameter("selState");
			String zip = request.getParameter("zip");

			//----Site user ID----//
			System.out.println();
			System.out.println("Adding site user id");
			int employee_id = configDatabase.getNextEmployeeId();
			System.out.println("Next EMP ID is: " + employee_id);
			int site_user_id = employee_id;
			System.out.println("site_user_id = " + site_user_id);
			System.out.println("employee_id = " + employee_id);
			String last_name = request.getParameter("last_name");
			String username = last_name;
			System.out.println("username = " + username);
			String first_name = request.getParameter("first_name");

			String password = first_name;
			System.out.println("password = " + password);
			String is_admin = "1";
			System.out.println("is_admin = " + is_admin);

			//----Employee info----//
			System.out.println("Employee Information");
			System.out.println("last_name = " + last_name);
			System.out.println("first_name = " + first_name);
			String mi = request.getParameter("mi");
			System.out.println("mi = " + mi);
			int job_id = Integer.parseInt(request.getParameter("payRate"));
			System.out.println("job_id = " + job_id);
			System.out.println("addressId = " + addressId);
			int office_location_id = Integer.parseInt(request.getParameter("selLocation"));
			System.out.println("office_location_id = " + office_location_id);
			String phone_num = request.getParameter("phone_num");
			System.out.println("phone_num = " + phone_num);
			int office_extension = Integer.parseInt(request.getParameter("office_extension"));
			System.out.println("office_extension = " + office_extension);
			String email = request.getParameter("email");
			System.out.println("email = " + email);
			int status_id = Integer.parseInt(request.getParameter("selStatus"));
			System.out.println("status_id = " + status_id);

			AddressPojo addressPojo = new AddressPojo(addressId, street, city, state, zip);
			configDatabase.addToDataBase(addressPojo);

			//			EmployeeSiteUserPojo employeeSiteUserPojo = new EmployeeSiteUserPojo(site_user_id, employee_id, username, password, is_admin);
			//			configDatabase.addToDataBase(employeeSiteUserPojo);

			EmployeePojo employeePojo = new EmployeePojo(employee_id, addressId, job_id, status_id, office_location_id, site_user_id, last_name,
					first_name, mi, phone_num, office_extension, email);
			configDatabase.addToDataBase(employeePojo);

			List<EmployeePojo> employeeList;
			employeeList = configDatabase.employeeViewDB();

			request.setAttribute("employeeList", employeeList);
			RequestDispatcher rd = request.getRequestDispatcher("/employeeSection/employeeRecords.jsp");
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
			String phone_num = request.getParameter("phone_num");
			int office_extension = Integer.parseInt(request.getParameter("office_extension"));
			String email = request.getParameter("email");
			int office_location_id = Integer.parseInt(request.getParameter("selLocation"));
			int site_user_id = Integer.parseInt(request.getParameter("site_user_id"));
			int status_id = Integer.parseInt(request.getParameter("selStatus"));

			EmployeePojo employeePojo = new EmployeePojo(employee_id, addressId, job_id, status_id, office_location_id, site_user_id, last_name,
					first_name, mi, phone_num, office_extension, email);
			System.out.println("Got info");
			configDatabase.updateDatabase(employeePojo);

			List<EmployeePojo> employeeList;
			employeeList = configDatabase.employeeViewDB();

			request.setAttribute("employeeList", employeeList);
			RequestDispatcher rd = request.getRequestDispatcher("/employeeSection/employeeRecords.jsp");
			rd.forward(request, response);
		}
		if(request.getParameter("Delete") != null)
		{
			System.out.println("Delete Employee");
			int employee_id = Integer.parseInt(request.getParameter("del_employee_id"));
			System.out.print("Delete employee with id: " + employee_id);
			configDatabase.deleteEmployee(employee_id);

			int addressId = Integer.parseInt(request.getParameter("del_addressId"));
			//			System.out.print(addressId);
			configDatabase.deleteAddress(addressId);

			List<EmployeePojo> employeeList;
			employeeList = configDatabase.employeeViewDB();

			request.setAttribute("employeeList", employeeList);
			RequestDispatcher rd = request.getRequestDispatcher("/employeeSection/employeeRecords.jsp");
			rd.forward(request, response);
		}

	}
}
