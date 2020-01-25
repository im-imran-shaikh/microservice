package com.imran.microservices.loggingfilter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class ZuulLoggingFilter extends ZuulFilter
{
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public boolean shouldFilter()
	{
		/**
		 *  should filter function is use for application should execute or not
		 */
		return true;
	}

	@Override
	public Object run() throws ZuulException
	{
		/**
		 *  Here, you main logic will execute
		 */
		
		HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
		logger.info("request -> {} request uri -> {} " + request, request.getRequestURI().toString());
		
		return null;
	}

	@Override
	public String filterType()
	{
		/**
		 * 	filter type is use to execute filter at what period 
		 * 	one can use "pre" for before execution, 
		 * 	"post"  for after execution
		 * 	or "error"  at when application throw error
		 */
		return "pre";
	}

	@Override
	public int filterOrder()
	{
		/**
		 *  filterOder is use to give priority to you filter
		 *  Lets suppose if you have multiple filter likes logging filter, authentication
		 *   filter, security filter, then at that time can giver priority to them 1, 2 3 as well
		 */
		return 1;
	}

}
