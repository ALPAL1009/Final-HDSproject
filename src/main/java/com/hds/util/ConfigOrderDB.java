package com.hds.util;

import com.hds.model.OrderPojo;
import com.hds.model.ProductPojo;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

import java.util.List;

public class ConfigOrderDB
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
	//	Order Section
	//________________________________
	public List orderViewDB()
	{
		Transaction transaction = null;
		List orderList = new ArrayList<OrderPojo>();
		try (Session session = HibernateUtil.getSessionFactory().openSession())
		{
			session.beginTransaction();
			String queryString = "SELECT \n" +
					"    o.OrderID,\n" +
					"    o.CustomerID,\n" +
					"    a.Street,\n" +
					"    a.City,\n" +
					"    a.State,\n" +
					"    a.Zip,\n" +
					"    o.ShippingCost,\n" +
					"    o.TotalCost,\n" +
					"    o.DateOrdered,\n" +
					"    o.DateDelivered\n" +
					"FROM\n" +
					"    hds.order o\n" +
					"    join address a on o.addressID = a.addressId;";
			SQLQuery query = session.createSQLQuery(queryString);
			List<Object[]> rows = query.list();
			for(Object[] row : rows)
			{
				OrderPojo order = new OrderPojo();
				order.setOrder_id(Integer.parseInt(row[0].toString()));
				order.setCustomer_id(Integer.parseInt(row[1].toString()));
				order.setStreet(row[2].toString());
				order.setCity(row[3].toString());
				order.setState(row[4].toString());
				order.setZip(Integer.parseInt(row[5].toString()));
				order.setShipping_cost(Double.parseDouble(row[6].toString()));
				order.setTotal_cost(Double.parseDouble(row[7].toString()));
				order.setDate_ordered(LocalDate.parse(row[8].toString()));
				order.setDate_delivered(LocalDate.parse(row[9].toString()));

				orderList.add(order);
			}

		}catch(Exception e)
		{
			if(transaction != null)
			{
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return orderList;
	}

	public List editOrderView(int orderId)
	{
		Transaction transaction = null;
		List orderList = new ArrayList<OrderPojo>();
		try (Session session = HibernateUtil.getSessionFactory().openSession())
		{
			session.beginTransaction();
			String queryString = "SELECT \n" +
					"    o.OrderID,\n" +
					"    o.CustomerID,\n" +
					"    a.Street,\n" +
					"    a.City,\n" +
					"    a.State,\n" +
					"    a.Zip,\n" +
					"    o.ShippingCost,\n" +
					"    o.TotalCost,\n" +
					"    o.DateOrdered,\n" +
					"    o.DateDelivered,\n" +
					"    o.AddressID\n" +
					"FROM\n" +
					"    hds.order o\n" +
					"    join address a on o.addressID = a.addressId\n" +
					"    where o.OrderID =" + orderId;

			SQLQuery query = session.createSQLQuery(queryString);
			List<Object[]> rows = query.list();
			for(Object[] row : rows)
			{
				OrderPojo order = new OrderPojo();
				order.setOrder_id(Integer.parseInt(row[0].toString()));
				order.setCustomer_id(Integer.parseInt(row[1].toString()));
				order.setStreet(row[2].toString());
				order.setCity(row[3].toString());
				order.setState(row[4].toString());
				order.setZip(Integer.parseInt(row[5].toString()));
				order.setShipping_cost(Double.parseDouble(row[6].toString()));
				order.setTotal_cost(Double.parseDouble(row[7].toString()));
				order.setDate_ordered(LocalDate.parse(row[8].toString()));
				order.setDate_delivered(LocalDate.parse(row[9].toString()));
				order.setAddress_id(Integer.parseInt(row[10].toString()));

				orderList.add(order);
			}

		}catch(Exception e)
		{
			if(transaction != null)
			{
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return orderList;
	}

	public int getNextOrderId()
	{
		Transaction transaction = null;
		int order_id = 0;
		try (Session session = HibernateUtil.getSessionFactory().openSession())
		{
			session.beginTransaction();
			String queryString = "SELECT max(order.OrderID)FROM hds.order";
			List customerIDResult = session.createSQLQuery(queryString).list();
			order_id = Integer.parseInt(customerIDResult.get(0).toString()) + 1;

		}catch(Exception e)
		{
			if(transaction != null)
			{
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return order_id;
	}

	public void deleteOrder(int productId)
	{

	}
}

