package com.hds.model;

import javax.persistence.*;

@Entity
@Table(name = "Employee")
public class EmployeePojo
{

	@Id
	@Column(name = "EmployeeID")
	//    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int employee_id;

	@Column(name = "AddressID")
	private int address_id;

	@Column(name = "JobID")
	private int job_id;

	@Column(name = "StatusID")
	private int status_id;

	@Column(name = "OfficeLocationID")
	private int office_location_id;

	@Column(name = "SiteUserID")
	private int site_user_id;

	@Column(name = "LastName")
	private String last_name;

	@Column(name = "FirstName")
	private String first_name;

	@Column(name = "MI")
	private String mi;

	@Column(name = "PhoneNum")
	private String phone_num;

	@Column(name = "OfficeExtension")
	private int office_extension;

	@Column(name = "Email")
	private String email;

	private String position;

	private int payRate;

	private String officeLocation;

	private String street;

	private String city;

	private String state;

	private int zip;

	private int status;

	public EmployeePojo()
	{
	}

	public EmployeePojo(int employee_id, int addressId, int job_id, int status_id, int office_location_id, int site_user_id, String last_name,
			String first_name, String mi, String phone_num, int office_extension, String email)
	{
		this.employee_id = employee_id;
		this.address_id = addressId;
		this.job_id = job_id;
		this.status_id = status_id;
		this.office_location_id = office_location_id;
		this.site_user_id = site_user_id;
		this.last_name = last_name;
		this.first_name = first_name;
		this.mi = mi;
		this.phone_num = phone_num;
		this.office_extension = office_extension;
		this.email = email;
	}

	// Getter Setter methods

	public int getEmployee_id()
	{
		return employee_id;
	}

	public void setEmployee_id(int employee_id)
	{
		this.employee_id = employee_id;
	}

	public int getAddress_id()
	{
		return address_id;
	}

	public void setAddress_id(int address_id)
	{
		this.address_id = address_id;
	}

	public int getJob_id()
	{
		return job_id;
	}

	public void setJob_id(int job_id)
	{
		this.job_id = job_id;
	}

	public int getStatus_id()
	{
		return status_id;
	}

	public void setStatus_id(int status_id)
	{
		this.status_id = status_id;
	}

	public int getOffice_location_id()
	{
		return office_location_id;
	}

	public void setOffice_location_id(int office_location_id)
	{
		this.office_location_id = office_location_id;
	}

	public int getSite_user_id()
	{
		return site_user_id;
	}

	public void setSite_user_id(int site_user_id)
	{
		this.site_user_id = site_user_id;
	}

	public String getLast_name()
	{
		return last_name;
	}

	public void setLast_name(String last_name)
	{
		this.last_name = last_name;
	}

	public String getFirst_name()
	{
		return first_name;
	}

	public void setFirst_name(String first_name)
	{
		this.first_name = first_name;
	}

	public String getMi()
	{
		return mi;
	}

	public void setMi(String mi)
	{
		this.mi = mi;
	}

	public String getPhone_num()
	{
		return phone_num;
	}

	public void setPhone_num(String phone_num)
	{
		this.phone_num = phone_num;
	}

	public int getOffice_extension()
	{
		return office_extension;
	}

	public void setOffice_extension(int office_extension)
	{
		this.office_extension = office_extension;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getPosition()
	{
		return position;
	}

	public void setPosition(String position)
	{
		this.position = position;
	}

	public int getPayRate()
	{
		return payRate;
	}

	public void setPayRate(int payRate)
	{
		this.payRate = payRate;
	}

	public String getOfficeLocation()
	{
		return officeLocation;
	}

	public void setOfficeLocation(String officeLocation)
	{
		this.officeLocation = officeLocation;
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

	public int getStatus()
	{
		return status;
	}

	public void setStatus(int status)
	{
		this.status = status;
	}
}
