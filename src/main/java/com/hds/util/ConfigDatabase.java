package com.hds.util;

import com.hds.model.AddressPojo;
import com.hds.model.CustomerPojo;
import com.hds.model.ProductPojo;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class ConfigDatabase
{
	public int getNextAddressId()
	{
		Transaction transaction = null;
		int addressID = 0;
		try (Session session = HibernateUtil.getSessionFactory().openSession())
		{
			session.beginTransaction();
			String queryString = "select max(address.AddressID) from hds.address";
			List IDResult = session.createSQLQuery(queryString).list();
			addressID = Integer.parseInt(IDResult.get(0).toString()) + 1;

		}catch(Exception e)
		{
			if(transaction != null)
			{
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return addressID;
	}

	public int getNextCustomerId()
	{
		Transaction transaction = null;
		int customerID = 0;
		try (Session session = HibernateUtil.getSessionFactory().openSession())
		{
			session.beginTransaction();
			String queryString = "select max(CustomerID) from hds.customer";
			List customerIDResult = session.createSQLQuery(queryString).list();
			customerID = Integer.parseInt(customerIDResult.get(0).toString()) + 1;

		}catch(Exception e)
		{
			if(transaction != null)
			{
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return customerID;
	}
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



//	public void deleteItem(int idToDoList)
//	{
//		Transaction transaction = null;
//		try (Session session = HibernateUtil.getSessionFactory().openSession())
//		{
//			transaction = session.beginTransaction();
//
//			CustomerPojo customerPojo = session.get(CustomerPojo.class, idToDoList);
//			if(customerPojo != null)
//			{
//				// deleting to_do item
//				session.delete(customerPojo);
//				System.out.println("Deleted todolistEntity item");
//			}
//
//			transaction.commit();
//		}catch(Exception e)
//		{
//			if(transaction != null)
//			{
//				transaction.rollback();
//			}
//			e.printStackTrace();
//		}
//	}

//	public CustomerPojo getItem(int id)
//	{
//		Transaction transaction = null;
//		CustomerPojo customerPojo = null;
//		try (Session session = HibernateUtil.getSessionFactory().openSession())
//		{
//			transaction = session.beginTransaction();
//
//			customerPojo = session.get(CustomerPojo.class, id);
//
//			transaction.commit();
//		}catch(Exception e)
//		{
//			if(transaction != null)
//			{
//				transaction.rollback();
//			}
//			e.printStackTrace();
//		}
//		return customerPojo;
//	}

	public List inventoryViewDB()
	{
		Transaction transaction = null;
		List productList = new ArrayList<ProductPojo>();
		try (Session session = HibernateUtil.getSessionFactory().openSession())
		{
			session.beginTransaction();

			SQLQuery query = session.createSQLQuery("SELECT \n" +
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
					"    hds.product \n" +
					"    join hds.productbrand\n" +
					"\t\ton product.BrandID = productbrand.BrandID;  ");
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

	public List customerViewDB()
	{
		Transaction transaction = null;
		List customerList = new ArrayList<CustomerPojo>();
		try (Session session = HibernateUtil.getSessionFactory().openSession())
		{
			session.beginTransaction();

			SQLQuery query = session.createSQLQuery("SELECT \n" +
					"    c.CustomerID,\n" +
					"    c.LastName,\n" +
					"    c.FirstName,\n" +
					"    c.MI,\n" +
					"    c.PhoneNum,\n" +
					"    c.Email,\n" +
					"    c.OrderCount,\n" +
					"    c.AccountBalance,\n" +
					"    a.Street,\n" +
					"    a.City,\n" +
					"    a.State,\n" +
					"    a.Zip\n" +
					"FROM\n" +
					"    hds.customer c\n" +
					"        INNER JOIN\n" +
					"    hds.address a ON c.AddressID = a.AddressID");
			List<Object[]> rows = query.list();
			for(Object[] row : rows)
			{
				CustomerPojo customer = new CustomerPojo();
				customer.setCustomer_id(Integer.parseInt(row[0].toString()));
				// skip row[1] since we don't need to display addressID
				customer.setCustomer_last_name(row[1].toString());
				customer.setCustomer_first_name(row[2].toString());
				customer.setCustomer_mi(row[3].toString());
				if(row[4] != null)
					customer.setCustomer_phone_num(row[4].toString());
				if(row[5] != null)
					customer.setCustomer_email(row[5].toString());
				customer.setCustomer_order_count(Integer.parseInt(row[6].toString()));
				customer.setCustomer_account_balance(Double.parseDouble(row[7].toString()));
				customer.setStreet(row[8].toString());
				customer.setCity(row[9].toString());
				customer.setState(row[10].toString());
				customer.setZip(Integer.parseInt(row[11].toString()));
				customerList.add(customer);
			}

		}catch(Exception e)
		{
			if(transaction != null)
			{
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return customerList;
	}
}

