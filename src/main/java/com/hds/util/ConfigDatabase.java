package com.hds.util;

import com.hds.model.AddressPojo;
import com.hds.model.CustomerPojo;
import com.hds.model.EmployeePojo;
import com.hds.model.ProductPojo;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class ConfigDatabase
{
	//________________________________
	//	Customer Section
	//________________________________


	//________________________________
	//	Employee Section
	//________________________________

	public int getNextEmployeeId()
	{
		Transaction transaction = null;
		int employee_id = 0;
		try (Session session = HibernateUtil.getSessionFactory().openSession())
		{
			session.beginTransaction();
			String queryString = "select max(employee.EmployeeID) from hds.employee";
			List customerIDResult = session.createSQLQuery(queryString).list();
			employee_id = Integer.parseInt(customerIDResult.get(0).toString()) + 1;

		}catch(Exception e)
		{
			if(transaction != null)
			{
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return employee_id;
	}

	public List employeeViewDB()
	{
		Transaction transaction = null;
		List employeeList = new ArrayList<EmployeePojo>();
		try (Session session = HibernateUtil.getSessionFactory().openSession())
		{
			session.beginTransaction();
			String queryString = "SELECT \n" +
					"    emp.EmployeeID,\n" +
					"    emp.LastName,\n" +
					"    emp.FirstName,\n" +
					"    emp.MI,\n" +
					"    position.JobTitle,\n" +
					"    job.YearlySalary,\n" +
					"    location.Name,\n" +
					"    emp.SiteUserID,\n" +
					"    emp.PhoneNum,\n" +
					"    emp.OfficeExtension,\n" +
					"    emp.Email,\n" +
					"    address.Street,\n" +
					"    address.City,\n" +
					"    address.State,\n" +
					"    address.Zip,\n" +
					"    emp.StatusID\n" +
					"FROM\n" +
					"    hds.employee emp\n" +
					"        JOIN hds.job ON emp.JobID = job.JobID\n" +
					"        JOIN hds.jobposition position ON job.JobID = position.JobPositionID\n" +
					"        JOIN hds.officelocation location ON emp.OfficeLocationID = location.LocationID\n" +
					"        JOIN hds. address ON emp.AddressID = address.AddressID;";
			SQLQuery query = session.createSQLQuery(queryString);

			List<Object[]> rows = query.list();
			for(Object[] row : rows)
			{
				EmployeePojo employee = new EmployeePojo();
				employee.setEmployee_id(Integer.parseInt(row[0].toString()));
				if(row[1] != null)
					employee.setLast_name(row[1].toString());
				if(row[2] != null)
					employee.setFirst_name(row[2].toString());
				if(row[3] != null)
					employee.setMi(row[3].toString());
				if(row[4] != null)
					employee.setPosition(row[4].toString());
				if(row[5] != null)
					employee.setPayRate(Integer.parseInt(row[5].toString()));
				if(row[6] != null)
					employee.setOfficeLocation(row[6].toString());
				if(row[7] != null)
					employee.setSite_user_id(Integer.parseInt(row[7].toString()));
				if(row[8] != null)
					employee.setPhone_num(row[8].toString());
				if(row[9] != null)
					employee.setOffice_extension(Integer.parseInt(row[9].toString()));
				if(row[10] != null)
					employee.setEmail(row[10].toString());
				if(row[11] != null)
					employee.setStreet(row[11].toString());
				if(row[12] != null)
					employee.setCity(row[12].toString());
				if(row[13] != null)
					employee.setState(row[13].toString());
				if(row[14] != null)
					employee.setZip(Integer.parseInt(row[14].toString()));
				if(row[15] != null)
					employee.setStatus(Integer.parseInt(row[15].toString()));

				employeeList.add(employee);
			}

		}catch(Exception e)
		{
			if(transaction != null)
			{
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return employeeList;
	}

	public List editEmployee(int employee_id)
	{
		Transaction transaction = null;
		List employeeList = new ArrayList<EmployeePojo>();
		try (Session session = HibernateUtil.getSessionFactory().openSession())
		{
			session.beginTransaction();
			String queryString = "SELECT \n" +
					"    emp.EmployeeID,\n" +
					"    emp.LastName,\n" +
					"    emp.FirstName,\n" +
					"    emp.MI,\n" +
					"    position.JobTitle,\n" +
					"    job.YearlySalary,\n" +
					"    location.Name,\n" +
					"    emp.SiteUserID,\n" +
					"    emp.PhoneNum,\n" +
					"    emp.OfficeExtension,\n" +
					"    emp.Email,\n" +
					"    address.Street,\n" +
					"    address.City,\n" +
					"    address.State,\n" +
					"    address.Zip,\n" +
					"    emp.StatusID\n" +
					"FROM hds.employee emp\n" +
					"JOIN hds.job ON emp.JobID = job.JobID\n" +
					"JOIN hds.jobposition position ON job.JobID = position.JobPositionID\n" +
					"JOIN hds.officelocation location ON emp.OfficeLocationID = location.LocationID\n" +
					"JOIN hds.address ON emp.AddressID = address.AddressID\n" +
					"WHERE EmployeeID = "+ employee_id;
			SQLQuery query = session.createSQLQuery(queryString);

			List<Object[]> rows = query.list();
			for(Object[] row : rows)
			{
				EmployeePojo employee = new EmployeePojo();
				employee.setEmployee_id(Integer.parseInt(row[0].toString()));
				if(row[1] != null)
					employee.setLast_name(row[1].toString());
				if(row[2] != null)
					employee.setFirst_name(row[2].toString());
				if(row[3] != null)
					employee.setMi(row[3].toString());
				if(row[4] != null)
					employee.setPosition(row[4].toString());
				if(row[5] != null)
					employee.setPayRate(Integer.parseInt(row[5].toString()));
				if(row[6] != null)
					employee.setOfficeLocation(row[6].toString());
				if(row[7] != null)
					employee.setSite_user_id(Integer.parseInt(row[7].toString()));
				if(row[8] != null)
					employee.setPhone_num(row[8].toString());
				if(row[9] != null)
					employee.setOffice_extension(Integer.parseInt(row[9].toString()));
				if(row[10] != null)
					employee.setEmail(row[10].toString());
				if(row[11] != null)
					employee.setStreet(row[11].toString());
				if(row[12] != null)
					employee.setCity(row[12].toString());
				if(row[13] != null)
					employee.setState(row[13].toString());
				if(row[14] != null)
					employee.setZip(Integer.parseInt(row[14].toString()));
				if(row[15] != null)
					employee.setStatus(Integer.parseInt(row[15].toString()));

				employeeList.add(employee);
			}
		}catch(Exception e)
		{
			if(transaction != null)
			{
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return employeeList;
	}
	public void deleteEmployee(int employee_id)
	{
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession())
		{
			transaction = session.beginTransaction();

			EmployeePojo employeePojo = session.get(EmployeePojo.class, employee_id);
			if(employeePojo != null)
			{
				session.delete(employeePojo);
			}
			transaction.commit();
		}catch(Exception e)
		{
			if(transaction != null)
			{
				transaction.rollback();
			}
			e.printStackTrace();
		}

	}

	//________________________________
	//	Inventory Section
	//________________________________
	public List inventoryViewDB()
	{
		Transaction transaction = null;
		List productList = new ArrayList<ProductPojo>();
		try (Session session = HibernateUtil.getSessionFactory().openSession())
		{
			session.beginTransaction();
			String queryString = "SELECT \n" +
					"    product.ProductID,\n" +
					"    productbrand.ProductName,\n" +
					"    product.CategoryID,\n" +
					"    product.InventoryCount,\n" +
					"    product.ModelNum,\n" +
					"    product.SerialNum,\n" +
					"    product.Description,\n" +
					"    product.Cost,\n" +
					"    product.ListPrice,\n" +
					"    product.DeliveryCost,\n" +
					"    product.IsActive\n" +
					"FROM\n" +
					"    hds.product\n" +
					"JOIN hds.productbrand ON product.BrandID = productbrand.BrandID;";
			SQLQuery query = session.createSQLQuery(queryString);
			List<Object[]> rows = query.list();
			for(Object[] row : rows)
			{
				ProductPojo product = new ProductPojo();
				product.setProduct_id(Integer.parseInt(row[0].toString()));
				product.setBrandName(row[1].toString());
				if(row[2] != null)
					product.setCategoryName(row[2].toString());
				if(row[3] != null)
					product.setInventory_count(Integer.parseInt(row[3].toString()));
				product.setModel_num(row[4].toString());
				product.setSerial_num(Integer.parseInt(row[5].toString()));
				product.setDescription(row[6].toString());
				product.setCost(Double.parseDouble(row[7].toString()));
				product.setList_price(Double.parseDouble(row[8].toString()));
				if(row[9] != null)
					product.setDeliveryCost(Integer.parseInt(row[9].toString()));
				product.setIs_active(row[10].toString());
				productList.add(product);
			}

		}catch(Exception e)
		{
			if(transaction != null)
			{
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return productList;
	}

	public List<ProductPojo> editProduct(int productId)
	{
		Transaction transaction = null;
		List productList = new ArrayList<ProductPojo>();
		try (Session session = HibernateUtil.getSessionFactory().openSession())
		{
			session.beginTransaction();
			String queryString = "SELECT \n" +
					"    product.ProductID,\n" +
					"    productbrand.ProductName,\n" +
					"    product.CategoryID,\n" +
					"    product.InventoryCount,\n" +
					"    product.ModelNum,\n" +
					"    product.SerialNum,\n" +
					"    product.Description,\n" +
					"    product.Cost,\n" +
					"    product.ListPrice,\n" +
					"    product.DeliveryCost,\n" +
					"    product.IsActive\n" +
					"FROM\n" +
					"    hds.product\n" +
					"JOIN hds.productbrand ON product.BrandID = productbrand.BrandID\n" +
					"where product.ProductID = "+ productId;

			SQLQuery query = session.createSQLQuery(queryString);
			List<Object[]> rows = query.list();
			for(Object[] row : rows)
			{
				ProductPojo product = new ProductPojo();
				product.setProduct_id(Integer.parseInt(row[0].toString()));
				product.setBrandName(row[1].toString());
				if(row[2] != null)
					product.setCategoryName(row[2].toString());
				if(row[3] != null)
					product.setInventory_count(Integer.parseInt(row[3].toString()));
				product.setModel_num(row[4].toString());
				product.setSerial_num(Integer.parseInt(row[5].toString()));
				product.setDescription(row[6].toString());
				product.setCost(Double.parseDouble(row[7].toString()));
				product.setList_price(Double.parseDouble(row[8].toString()));
				if(row[9] != null)
					product.setDeliveryCost(Integer.parseInt(row[9].toString()));
				product.setIs_active(row[10].toString());
				productList.add(product);
			}

		}catch(Exception e)
		{
			if(transaction != null)
			{
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return productList;
	}

	public int getNextProductId()
	{
		Transaction transaction = null;
		int product_id = 0;
		try (Session session = HibernateUtil.getSessionFactory().openSession())
		{
			session.beginTransaction();
			String queryString = "SELECT max(product.ProductID)FROM hds.product";
			List customerIDResult = session.createSQLQuery(queryString).list();
			product_id = Integer.parseInt(customerIDResult.get(0).toString()) + 1;

		}catch(Exception e)
		{
			if(transaction != null)
			{
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return product_id;
	}
}

