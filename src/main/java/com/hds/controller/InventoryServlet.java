package com.hds.controller;

import com.hds.model.CustomerPojo;
import com.hds.model.ProductPojo;
import com.hds.util.ConfigDatabase;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "inventoryServlet", urlPatterns = "/inventoryServlet")
public class InventoryServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	private ConfigDatabase configDatabase;

	public void init()
	{
		configDatabase = new ConfigDatabase();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		if(request.getParameter("Inventory") != null)
		{
			List<ProductPojo> productList;
			productList = configDatabase.inventoryViewDB();

			request.setAttribute("productList", productList);
			RequestDispatcher rd = request.getRequestDispatcher("/employeeSection/inventory.jsp");
			rd.forward(request, response);
		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		if(request.getParameter("Add New Product") != null)
		{
			//get the Attributes and combine them and add new product
			//and return back to product records with new product added
			RequestDispatcher rd = request.getRequestDispatcher("/employeeSection/inventory.jsp");
			rd.forward(request, response);
		}

	}
}
