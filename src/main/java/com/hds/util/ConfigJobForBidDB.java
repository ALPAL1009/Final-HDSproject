package com.hds.util;

import com.hds.model.JobsForBidPojo;
import com.hds.model.OrderPojo;
import com.hds.model.ProductPojo;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ConfigJobForBidDB
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
	public List jobForBidViewDB()
	{
		Transaction transaction = null;
		List bidList = new ArrayList<JobsForBidPojo>();
		try (Session session = HibernateUtil.getSessionFactory().openSession())
		{
			session.beginTransaction();
			String queryString = "";
			SQLQuery query = session.createSQLQuery(queryString);
			List<Object[]> rows = query.list();
			for(Object[] row : rows)
			{
				JobsForBidPojo jobBid = new JobsForBidPojo();
				jobBid.setJob_bid_id(Integer.parseInt(row[0].toString()));
				jobBid.setDescription(row[1].toString());
				jobBid.setBid_amount(Double.parseDouble(row[2].toString()));
				jobBid.setDate_open(LocalDate.parse(row[3].toString()));
				jobBid.setDate_closed(LocalDate.parse(row[4].toString()));

				bidList.add(jobBid);
			}

		}catch(Exception e)
		{
			if(transaction != null)
			{
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return bidList;
	}

	public List editJobForBidViewDB(int jobBidId)
	{
		Transaction transaction = null;
		List bidList = new ArrayList<JobsForBidPojo>();
		try (Session session = HibernateUtil.getSessionFactory().openSession())
		{
			session.beginTransaction();
			String queryString = " " + jobBidId;

			SQLQuery query = session.createSQLQuery(queryString);
			List<Object[]> rows = query.list();
			for(Object[] row : rows)
			{
				JobsForBidPojo jobBid = new JobsForBidPojo();
				jobBid.setJob_bid_id(Integer.parseInt(row[0].toString()));
				jobBid.setDescription(row[1].toString());
				jobBid.setBid_amount(Double.parseDouble(row[2].toString()));
				jobBid.setDate_open(LocalDate.parse(row[3].toString()));
				jobBid.setDate_closed(LocalDate.parse(row[4].toString()));

				bidList.add(jobBid);
			}

		}catch(Exception e)
		{
			if(transaction != null)
			{
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return bidList;
	}

	public int getNextBidId()
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

	public void deleteBid(int productId)
	{

	}
}

