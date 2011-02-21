package com.nextmethod.dao.entities;

import com.nextmethod.dao.annotation.Column;
import com.nextmethod.dao.annotation.Table;

import java.util.Date;
import java.util.List;

@Table ("system_user")
public class User
{

	@Column ("id")
	private int id;
	@Column ("first_name")
	private String firstName;
	@Column ("last_name")
	private String lastName;
	@Column ("email_address")
	private String emailAddress;
	@Column ("birthday")
	private Date birthday;

	@Column ("is_active")
	private boolean isActive;

	// Address
	private List<Address> addresses;

	public int getId ()
	{
		return id;
	}

	public void setId (final int id)
	{
		this.id = id;
	}

	public String getFirstName ()
	{
		return firstName;
	}

	public void setFirstName (final String firstName)
	{
		this.firstName = firstName;
	}

	public String getLastName ()
	{
		return lastName;
	}

	public void setLastName (final String lastName)
	{
		this.lastName = lastName;
	}

	public String getEmailAddress ()
	{
		return emailAddress;
	}

	public void setEmailAddress (final String emailAddress)
	{
		this.emailAddress = emailAddress;
	}

	public Date getBirthday ()
	{
		return birthday;
	}

	public void setBirthday (final Date birthday)
	{
		this.birthday = birthday;
	}

	public List<Address> getAddresses ()
	{
		return addresses;
	}

	public void setAddresses (final List<Address> addresses)
	{
		this.addresses = addresses;
	}

	public boolean isActive ()
	{
		return isActive;
	}

	public void setActive (final boolean active)
	{
		isActive = active;
	}
}
