package com.hds.controller;

import com.hds.model.CustomerPojo;
import com.hds.model.ProductPojo;
import com.hds.util.ConfigProductDB;

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
	private ConfigProductDB configProductDB;

	public void init()
	{
		configProductDB = new ConfigProductDB();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		if(request.getParameter("Inventory") != null)
		{
			List<ProductPojo> productList;
			productList = configProductDB.inventoryViewDB();

			request.setAttribute("productList", productList);
			RequestDispatcher rd = request.getRequestDispatcher("/employeeSection/inventory.jsp");
			rd.forward(request, response);
		}
		if(request.getParameter("Edit") != null)
		{
			//			System.out.println("Updating Customer ");
			int productId = Integer.parseInt(request.getParameter("id"));

			List<ProductPojo> productList;
			productList = configProductDB.editInventoryView(productId);

			request.setAttribute("productList", productList);
			RequestDispatcher rd = request.getRequestDispatcher("/employeeSection/editInventory.jsp");
			rd.forward(request, response);
		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		if(request.getParameter("Add New Product") != null)
		{
			int product_id = configProductDB.getNextProductId();
			System.out.println("product_id = " + product_id);
			int brand_id = Integer.parseInt(request.getParameter("productBrand"));
			System.out.println("brand_id = " + brand_id);
			int category_id = Integer.parseInt(request.getParameter("new_category_name"));
			System.out.println("category_id = " + category_id);
			int inventory_count = Integer.parseInt(request.getParameter("new_inventory_count"));
			System.out.println("inventory_count = " + inventory_count);
			String model_num = request.getParameter("new_model_num");
			System.out.println("model_num = " + model_num);
			int serial_num = Integer.parseInt(request.getParameter("new_serial_num"));
			System.out.println("serial_num = " + serial_num);
			String description = request.getParameter("new_description");
			System.out.println("description = " + description);
			int cost = Integer.parseInt(request.getParameter("new_cost"));
			System.out.println("cost = " + cost);
			int list_price = Integer.parseInt(request.getParameter("new_list_price"));
			System.out.println("list_price = " + list_price);
			String is_active = request.getParameter("selectActive");
			System.out.println("is_active = " + is_active);

			ProductPojo productPojo = new ProductPojo( product_id,  brand_id,   category_id,  inventory_count,
			 model_num,  serial_num,  description,  cost,  list_price,  is_active);
			configProductDB.addToDataBase(productPojo);

			List<ProductPojo> productList;
			productList = configProductDB.inventoryViewDB();

			request.setAttribute("productList", productList);
			RequestDispatcher rd = request.getRequestDispatcher("/employeeSection/inventory.jsp");
			rd.forward(request, response);
		}
		if(request.getParameter("Update Product") != null)
		{
			int product_id = configProductDB.getNextProductId();
			System.out.println("product_id = " + product_id);
			int brand_id = Integer.parseInt(request.getParameter("productBrand"));
			System.out.println("brand_id = " + brand_id);
			int category_id = Integer.parseInt(request.getParameter("new_category_name"));
			System.out.println("category_id = " + category_id);
			int inventory_count = Integer.parseInt(request.getParameter("new_inventory_count"));
			System.out.println("inventory_count = " + inventory_count);
			String model_num = request.getParameter("new_model_num");
			System.out.println("model_num = " + model_num);
			int serial_num = Integer.parseInt(request.getParameter("new_serial_num"));
			System.out.println("serial_num = " + serial_num);
			String description = request.getParameter("new_description");
			System.out.println("description = " + description);
			int cost = Integer.parseInt(request.getParameter("new_cost"));
			System.out.println("cost = " + cost);
			int list_price = Integer.parseInt(request.getParameter("new_list_price"));
			System.out.println("list_price = " + list_price);
			String is_active = request.getParameter("selectActive");
			System.out.println("is_active = " + is_active);

			ProductPojo productPojo = new ProductPojo( product_id,  brand_id,   category_id,  inventory_count,
					model_num,  serial_num,  description,  cost,  list_price,  is_active);
			configProductDB.updateDatabase(productPojo);

			List<ProductPojo> productList;
			productList = configProductDB.inventoryViewDB();

			request.setAttribute("productList", productList);
			RequestDispatcher rd = request.getRequestDispatcher("/employeeSection/inventory.jsp");
			rd.forward(request, response);
		}

	}
}
