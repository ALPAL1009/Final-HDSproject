package com.hds.util;

import com.hds.model.AddressPojo;
import com.hds.model.EmployeePojo;
import com.hds.model.ProductPojo;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class ConfigProductDB
{

	public void addToDataBase(Object object)
	{
		System.out.println("Adding " + object.toString());
		Transaction transaction = null;
		try (
				Session session = HibernateUtil.getSessionFactory().openSession())
		{
			transaction = session.beginTransaction();

			session.save(object);

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

	public void updateDatabase(Object object)
	{
		System.out.println("Updating " + object.toString());
		Transaction transaction = null;
		try (
				Session session = HibernateUtil.getSessionFactory().openSession())
		{
			transaction = session.beginTransaction();

			session.update(object);

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
					"    productbrand.BrandName,\n" +
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
					product.setInventory_count(Integer.parseInt(row[2].toString()));
				product.setModel_num(row[3].toString());
				product.setSerial_num(Integer.parseInt(row[4].toString()));
				product.setDescription(row[5].toString());
				product.setCost(Double.parseDouble(row[6].toString()));
				product.setList_price(Double.parseDouble(row[7].toString()));
				if(row[8] != null)
					product.setDeliveryCost(Integer.parseInt(row[8].toString()));
				product.setIs_active(row[9].toString());
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

	public List editInventoryView(int productId)
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
					"where product.ProductID = " + productId;

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

	public void deleteProduct(int productId)
	{

	}
}

