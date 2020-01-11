package com.imran.microservices.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.imran.microservices.dto.CurrencyBeans;
import com.imran.microservices.feign.CurrencyExchangeServiceProxy;

@RestController
public class CurrencyConversionController
{
	
	@Autowired
	private CurrencyExchangeServiceProxy proxy;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping(path = "/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyBeans getCurrencyConversion(@PathVariable String from, @PathVariable String to, @PathVariable String quantity)
	{
		System.out.println("inside currency converter function");
		Map<String,String> uriVariable = new HashMap();
		uriVariable.put("from", from);
		uriVariable.put("to", to);
		ResponseEntity<CurrencyBeans> response = restTemplate.getForEntity("http://localhost:8000/exchangeValue/from/{from}/to/{to}", CurrencyBeans.class, uriVariable);
		CurrencyBeans currencyBeans = response.getBody();
		
		return new CurrencyBeans(currencyBeans.getId(), from, to, currencyBeans.getConversionMultiple(), currencyBeans.getPort(), Integer.parseInt(quantity), Integer.parseInt(quantity)*currencyBeans.getConversionMultiple());
	}
	
	
	@GetMapping(path = "/currency-converter-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyBeans getCurrencyConversionFeign(@PathVariable String from, @PathVariable String to, @PathVariable String quantity)
	{
		System.out.println("inside currency converter function");
		
		CurrencyBeans currencyBeans = proxy.getExchangeValue(from, to);
		
		return new CurrencyBeans(currencyBeans.getId(), from, to, currencyBeans.getConversionMultiple(), currencyBeans.getPort(), Integer.parseInt(quantity), Integer.parseInt(quantity)*currencyBeans.getConversionMultiple());
	}
	
	@GetMapping(path = "/hello")
	public String hello()
	{
		return "hello";
	}
}
