package com.imran.microservices.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigureBeans
{
	@Bean
	public RestTemplate getRestTemplate()
	{
		return new RestTemplate();
	}
}
