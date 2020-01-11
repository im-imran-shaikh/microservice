package com.imran.microservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.imran.microservices.dao.ExchageValueRepository;
import com.imran.microservices.dto.ExchangeValue;

@RestController
public class Controller
{
	@Autowired
	private Environment environment;
	
	@Autowired
	private ExchageValueRepository exchangeeValueRepository;
	
	@GetMapping(path = "/exchangeValue/from/{from}/to/{to}")
	private ExchangeValue getExchangeValue(@PathVariable String from, @PathVariable String to)
	{
		ExchangeValue exchangeValue = exchangeeValueRepository.findByFromAndTo(from, to);
		exchangeValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
		return exchangeValue;
	}
}
