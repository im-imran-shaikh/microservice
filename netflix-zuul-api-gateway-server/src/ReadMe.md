How to pass the currency-exchange-service to api gateway when you trigger 
from currency-conversion-service

->  First got to feign proxy of currency-converssion-service
	pass the netflix-zuul-api-gateway-server application name in feign
	@FeignClient(name = "netflix-zuul-api-gateway-server")
	
	also append this in feign @getmapping path
	@GetMapping(path = "/currency-exchange-service/exchangeValue/from/{from}/to/{to}")
	
	here, currency-exchange-service is the application from where currency-conversio-service is 
	getting the data and /exchangeValue/from/{from}/to/{to} is the path
	
	
In above scenario, what we did we have currency-conversion-service and currency-exchange-service which is talking to database
->	we hit http://localhost:8100/currency-converter-feign/from/USD/to/INR/quantity/100
 	here, The first request go currency-conversion-service then it travel to 
 	api gateway i.e netflix-zuul-api-gateway-server (here we have configure logger) and then zuul redirect to currency-exchange-service

 	
How does zuul redirect to appropriate request
->	we have configure netfliz-zuul-api=gateway-server to eureka naming server 
	from eureka, zuul redirect to application
	
	
	
What suppose if we want to immpliment zuul before the currency-conversion-service
->	Then, hit this url http://localhost:8765/currency-conversion-service/currency-converter-feign/from/USD/to/INR/quantity/100
	NOTE : 8765 is the zuul port which we have configure in properties file
	
	Here, request first go to zull then, currency-conversion-service after currency-conversion-serive reguest again visit to zull as we configure the, from zuul to it regirect to exchange service.
