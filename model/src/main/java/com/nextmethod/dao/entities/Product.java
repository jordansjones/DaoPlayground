package com.nextmethod.dao.entities;

import com.nextmethod.dao.annotation.Column;
import com.nextmethod.dao.annotation.Table;

import java.util.Date;

@Table ("product")
public class Product
{
	@Column ("id")
	private int id;
	@Column ("name")
	private String name;
	@Column ("description")
	private String description;
	@Column ("amount")
	private double amount;
	@Column ("is_active")
	private boolean isActive;
	@Column ("date_added")
	private Date dateAdded;

	public int getId ()
	{
		return id;
	}

	public void setId (final int id)
	{
		this.id = id;
	}

	public String getName ()
	{
		return name;
	}

	public void setName (final String name)
	{
		this.name = name;
	}

	public String getDescription ()
	{
		return description;
	}

	public void setDescription (final String description)
	{
		this.description = description;
	}

	public double getAmount ()
	{
		return amount;
	}

	public void setAmount (final double amount)
	{
		this.amount = amount;
	}

	public boolean isActive ()
	{
		return isActive;
	}

	public void setActive (final boolean active)
	{
		isActive = active;
	}

	public Date getDateAdded ()
	{
		return dateAdded;
	}

	public void setDateAdded (final Date dateAdded)
	{
		this.dateAdded = dateAdded;
	}
}
