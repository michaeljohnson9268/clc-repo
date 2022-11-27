package com.gcu;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.SessionScope;


import com.gcu.business.ProductsBusinessService;
import com.gcu.business.ProductsBusinessServiceInterface;



@Configuration
public class SpringConfig {

	@Bean()
	@SessionScope	
	public ProductsBusinessServiceInterface getProductsBusiness()
	{
		return new ProductsBusinessService();
	}
	
	
}
