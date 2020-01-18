package com.imran.microservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.imran.microservices")
@EnableDiscoveryClient
public class CurrencyConversionServiceApplication
{
	public static void main(String[] args)
	{
		SpringApplication.run(CurrencyConversionServiceApplication.class, args);
	}
}
