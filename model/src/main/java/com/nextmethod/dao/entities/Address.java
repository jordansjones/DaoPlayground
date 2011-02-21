package com.nextmethod.dao.entities;

import com.nextmethod.dao.annotation.Column;
import com.nextmethod.dao.annotation.Table;

@Table ("address")
public class Address
{
	@Column ("id")
	private int id;
	@Column ("user_id")
	private int userId;
	@Column ("street_line")
	private String streetLine;
	@Column ("city")
	private String city;
	@Column ("state")
	private String state;
	@Column ("zip_code")
	private String zipCode;

	public int getId ()
	{
		return id;
	}

	public void setId (final int id)
	{
		this.id = id;
	}

	public int getUserId ()
	{
		return userId;
	}

	public void setUserId (final int userId)
	{
		this.userId = userId;
	}

	public String getStreetLine ()
	{
		return streetLine;
	}

	public void setStreetLine (final String streetLine)
	{
		this.streetLine = streetLine;
	}

	public String getCity ()
	{
		return city;
	}

	public void setCity (final String city)
	{
		this.city = city;
	}

	public String getState ()
	{
		return state;
	}

	public void setState (final String state)
	{
		this.state = state;
	}

	public String getZipCode ()
	{
		return zipCode;
	}

	public void setZipCode (final String zipCode)
	{
		this.zipCode = zipCode;
	}
}
