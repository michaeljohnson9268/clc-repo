package com.gcu;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.SessionScope;

import com.gcu.business.OrdersBusinessService;
import com.gcu.business.OrdersBusinessServiceInterface;
import com.gcu.business.ProductsBusinessService;
import com.gcu.business.ProductsBusinessServiceInterface;
import com.gcu.business.TrucksBusinessService;
import com.gcu.business.TrucksBusinessServiceInterface;
import com.gcu.business.UsersBusinessService;
import com.gcu.business.UsersBusinessServiceInterface;


@Configuration
public class SpringConfig {

	@Bean()
	@SessionScope	
	public ProductsBusinessServiceInterface getProductsBusiness()
	{
		return new ProductsBusinessService();
	}
	
	@Bean()
	@SessionScope	
	public UsersBusinessServiceInterface getUsersBusiness()
	{
		return new UsersBusinessService();
	}
	
	@Bean()
	@SessionScope	
	public OrdersBusinessServiceInterface getOrdersBusiness()
	{
		return new OrdersBusinessService();
	}
	@Bean()
	@SessionScope	
	public TrucksBusinessServiceInterface getTrucksBusiness()
	{
		return new TrucksBusinessService();
	}
}
