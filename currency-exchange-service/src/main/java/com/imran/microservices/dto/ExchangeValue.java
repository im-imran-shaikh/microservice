package com.imran.microservices.dto;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class ExchangeValue
{
	@Id
	@GeneratedValue
	private int id;
	
	@Column(name = "valueFrom")
	private String from;
	
	@Column(name = "valueTo")
	private String to;
	private float conversionMultiple;
	private int port;
	
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
}
