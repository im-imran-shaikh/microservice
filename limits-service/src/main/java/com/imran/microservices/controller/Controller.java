package com.imran.microservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.imran.microservices.configure.ApplicationConfigure;
import com.imran.microservices.dto.Limits;

@RestController
public class Controller
{
	@Autowired
	private ApplicationConfigure applicationConfigure;
	
	@GetMapping(path = "/getLimits")
	private Limits getLimits()
	{
		return new Limits(applicationConfigure.getMinimum(),applicationConfigure.getMaximum());
	}
}
