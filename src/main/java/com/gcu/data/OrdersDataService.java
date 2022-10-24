package com.gcu.data;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import com.gcu.business.ProductsBusinessServiceInterface;
import com.gcu.model.OrderModel;
import com.gcu.model.ProductModel;

@Service
public class OrdersDataService implements DataAccessInterface<OrderModel>{

	
	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	
	
	public OrdersDataService(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	@Override
	public List<OrderModel> findAll() {
		String sql = "SELECT * FROM orders";
		List<OrderModel> orders = new ArrayList<OrderModel>();

		try {
			// Execute SQL Query and loop over result set
			SqlRowSet srs = jdbcTemplateObject.queryForRowSet(sql);
			
			
			while (srs.next()) {
				
				
				orders.add(new OrderModel(srs.getInt("orderId"),srs.getString("orderNumber"),
											srs.getInt("userId"),
											srs.getInt("productId"),
											srs.getInt("quantity")));
			}
		} catch (Exception c) {
			c.printStackTrace();
		}

		return orders;
	}

	@Override
	public OrderModel findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int create(OrderModel order) {
try {
			
			//Creates the SQL
			String sql = "INSERT INTO orders(orderNumber,userId, productId, quantity) VALUES(?, ?, ?, ?)";

			//Inserts the row
			int rows = jdbcTemplateObject.update(sql,
											order.getOrderNumber(),
											order.getCustomer(),
											order.getProduct(),
											order.getQuantity());

			if(rows == 0) {
				//if no row was inserted, return 0
				return 0;
			}
		} catch (Exception c) {
			c.printStackTrace();
			return -1;

		}

		return 1;
	}

	@Override
	public int update(OrderModel order) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(OrderModel order) {
		// TODO Auto-generated method stub
		return 0;
	}

}
