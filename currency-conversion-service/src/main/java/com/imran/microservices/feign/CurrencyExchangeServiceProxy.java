package com.imran.microservices.feign;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.imran.microservices.dto.CurrencyBeans;


//@FeignClient(name = "currency-exchange-service", url = "localhost:8000")
//@FeignClient(name = "currency-exchange-service")
@FeignClient(name = "netflix-zuul-api-gateway-server")
@RibbonClient(name = "currency-exchange-service")
public interface CurrencyExchangeServiceProxy
{
	//@GetMapping(path = "/exchangeValue/from/{from}/to/{to}")
	@GetMapping(path = "/currency-exchange-service/exchangeValue/from/{from}/to/{to}")
	public CurrencyBeans getExchangeValue(@PathVariable String from, @PathVariable String to);
}
