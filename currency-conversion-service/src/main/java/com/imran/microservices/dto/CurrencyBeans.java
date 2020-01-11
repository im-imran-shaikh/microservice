package com.imran.microservices.dto;

public class CurrencyBeans
{
	private int id;
	private String from;
	private String to;
	private float conversionMultiple;
	private int port;
	private int quantity;
	private float total;
	
	
	public CurrencyBeans()
	{
		super();
	}


	public CurrencyBeans(int id, String from, String to, float conversionMultiple, int port, int quantity, float total)
	{
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.conversionMultiple = conversionMultiple;
		this.port = port;
		this.quantity = quantity;
		this.total = total;
	}


	public int getId()
	{
		return id;
	}


	public void setId(int id)
	{
		this.id = id;
	}


	public String getFrom()
	{
		return from;
	}


	public void setFrom(String from)
	{
		this.from = from;
	}


	public String getTo()
	{
		return to;
	}


	public void setTo(String to)
	{
		this.to = to;
	}


	public float getConversionMultiple()
	{
		return conversionMultiple;
	}


	public void setConversionMultiple(float conversionMultiple)
	{
		this.conversionMultiple = conversionMultiple;
	}


	public int getPort()
	{
		return port;
	}


	public void setPort(int port)
	{
		this.port = port;
	}


	public int getQuantity()
	{
		return quantity;
	}


	public void setQuantity(int quantity)
	{
		this.quantity = quantity;
	}


	public float getTotal()
	{
		return total;
	}


	public void setTotal(float total)
	{
		this.total = total;
	}
}
