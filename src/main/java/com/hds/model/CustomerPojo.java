package com.hds.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
//@Entity(name = "Customer")
@Table(name = "Customer")
public class CustomerPojo
{

	@Id
	//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CustomerID")
	private int customer_id;

	// **this is the original
	@Column(name = "AddressID")
	private int customer_address_id;

	@Column(name = "LastName")
	private String customer_last_name;

	@Column(name = "FirstName")
	private String customer_first_name;

	@Column(name = "MI")
	private String customer_mi;

	@Column(name = "PhoneNum")
	private String customer_phone_num;

	@Column(name = "Email")
	private String customer_email;

	@Column(name = "OrderCount")
	private int customer_order_count;

	@Column(name = "AccountBalance")
	private double customer_account_balance;

	private String street;

	private String city;

	private String state;

	private int zip;

	//Constructors

	public CustomerPojo()
	{
	}

	public CustomerPojo(int customerId)
	{
		this.customer_id = customerId;
	}

	public CustomerPojo(int customer_id, int customer_address_id, String customer_last_name, String customer_first_name, String customer_mi,
			String customer_phone_num,
			String customer_email)
	{
		this.customer_id = customer_id;
		this.customer_address_id = customer_address_id;
		this.customer_last_name = customer_last_name;
		this.customer_first_name = customer_first_name;
		this.customer_mi = customer_mi;
		this.customer_phone_num = customer_phone_num;
		this.customer_email = customer_email;
	}

	// Getter Setter methods

	public int getCustomer_id()
	{
		return customer_id;
	}

	public void setCustomer_id(int customer_id)
	{
		this.customer_id = customer_id;
	}

	public int getCustomer_address_id()
	{
		return customer_address_id;
	}

	public void setCustomer_address_id(int customer_address_id)
	{
		this.customer_address_id = customer_address_id;
	}

	public String getCustomer_last_name()
	{
		return customer_last_name;
	}

	public void setCustomer_last_name(String customer_last_name)
	{
		this.customer_last_name = customer_last_name;
	}

	public String getCustomer_first_name()
	{
		return customer_first_name;
	}

	public void setCustomer_first_name(String customer_first_name)
	{
		this.customer_first_name = customer_first_name;
	}

	public String getCustomer_mi()
	{
		return customer_mi;
	}

	public void setCustomer_mi(String customer_mi)
	{
		this.customer_mi = customer_mi;
	}

	public String getCustomer_phone_num()
	{
		return customer_phone_num;
	}

	public void setCustomer_phone_num(String customer_phone_num)
	{
		this.customer_phone_num = customer_phone_num;
	}

	public String getCustomer_email()
	{
		return customer_email;
	}

	public void setCustomer_email(String customer_email)
	{
		this.customer_email = customer_email;
	}

	public int getCustomer_order_count()
	{
		return customer_order_count;
	}

	public void setCustomer_order_count(int customer_order_count)
	{
		this.customer_order_count = customer_order_count;
	}

	public double getCustomer_account_balance()
	{
		return customer_account_balance;
	}

	public void setCustomer_account_balance(double customer_account_balance)
	{
		this.customer_account_balance = customer_account_balance;
	}

	public String getStreet()
	{
		return street;
	}

	public void setStreet(String street)
	{
		this.street = street;
	}

	public String getCity()
	{
		return city;
	}

	public void setCity(String city)
	{
		this.city = city;
	}

	public String getState()
	{
		return state;
	}

	public void setState(String state)
	{
		this.state = state;
	}

	public int getZip()
	{
		return zip;
	}

	public void setZip(int zip)
	{
		this.zip = zip;
	}
}
