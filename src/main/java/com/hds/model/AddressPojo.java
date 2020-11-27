package com.hds.model;

import javax.persistence.*;

@Entity
//@Entity(name = "Address")
@Table(name = "Address")
public class AddressPojo
{

	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "AddressID")
	private int address_id;

	@Column(name = "Street")
	private String street;

	@Column(name = "City")
	private String city;

	@Column(name = "State")
	private String state;

	@Column(name = "Zip")
	private String zip;

	public AddressPojo(int address_id,String street, String city, String state, String zip)
	{
		super();
		this.address_id = address_id;
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}
	public AddressPojo(String city, String state,String street,String zip)
	{
		super();
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}

	public AddressPojo()
	{

	}

	public AddressPojo(int addressId)
	{
		this.address_id = addressId;
	}

	// Getter Setter methods

	public int getAddress_id()
	{
		return address_id;
	}

	public void setAddress_id(int address_id)
	{
		this.address_id = address_id;
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

	public String getZip()
	{
		return zip;
	}

	public void setZip(String zip)
	{
		this.zip = zip;
	}
}
