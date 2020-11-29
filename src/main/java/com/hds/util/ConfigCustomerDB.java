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

public class ConfigCustomerDB
{
	//________________________________
	//	Customer Section
	//________________________________

	//	//Get the next primary key in the address table
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

	//Get the next primary key in the customer table
	public int getNextCustomerId()
	{
		Transaction transaction = null;
		int customerID = 0;
		try (Session session = HibernateUtil.getSessionFactory().openSession())
		{
			session.beginTransaction();
			String queryString = "select max(customer.CustomerID) from hds.customer";
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

	//View the WHOLE customer table
	public List customerViewDB()
	{
		Transaction transaction = null;
		List customerList = new ArrayList<CustomerPojo>();
		try (Session session = HibernateUtil.getSessionFactory().openSession())
		{
			session.beginTransaction();
			String queryString = "SELECT \n" +
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
					"    a.Zip,\n" +
					"    a.AddressID\n" +
					"FROM\n" +
					"    hds.customer c\n" +
					"        INNER JOIN\n" +
					"    hds.address a ON c.AddressID = a.AddressID";
			SQLQuery query = session.createSQLQuery(queryString);

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

	//Query the Customer and Address database where Customer Id = customerId
	public List editCustomer(int customerId)
	{
		Transaction transaction = null;
		List customerList = new ArrayList<CustomerPojo>();
		try (Session session = HibernateUtil.getSessionFactory().openSession())
		{
			session.beginTransaction();
			String queryString = "SELECT \n" +
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
					"    a.Zip,\n" +
					"    a.AddressID\n" +
					"FROM\n" +
					"    hds.customer c\n" +
					"        INNER JOIN\n" +
					"    hds.address a ON c.AddressID = a.AddressID\n" +
					"    where CustomerID =" + customerId;

			SQLQuery query = session.createSQLQuery(queryString);

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
				customer.setCustomer_address_id(Integer.parseInt(row[12].toString()));
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

	//Add Object to their matching database
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

	//Update Object in their corresponding table
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

	//Delete customer with matching ID from customer table
	public void deleteCustomer(int customerId)
	{
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession())
		{
			transaction = session.beginTransaction();

			CustomerPojo customerPojo = session.get(CustomerPojo.class, customerId);
			if(customerPojo != null)
			{
				session.delete(customerPojo);
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

	////Delete address with matching ID from address table
	public void deleteAddress(int idToDoList)
	{
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession())
		{
			transaction = session.beginTransaction();

			AddressPojo addressPojo = session.get(AddressPojo.class, idToDoList);
			if(addressPojo != null)
			{
				session.delete(addressPojo);
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
}

