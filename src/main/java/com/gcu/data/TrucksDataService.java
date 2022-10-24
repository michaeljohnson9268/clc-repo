package com.gcu.data;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import com.gcu.model.TruckModel;

@Service
public class TrucksDataService implements DataAccessInterface<TruckModel> {

	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	/*
	 * Non Default contructor for constructor injection
	 */

	public TrucksDataService(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	// CRUD: finder to return all entities
	@Override
	public List<TruckModel> findAll() {
		String sql = "SELECT * FROM trucks";
		List<TruckModel> orders = new ArrayList<TruckModel>();

		try {
			// Execute SQL Query and loop over result set
			SqlRowSet srs = jdbcTemplateObject.queryForRowSet(sql);
			while (srs.next()) {
				orders.add(new TruckModel(srs.getInt("truckId"), srs.getString("truckCompany"),
						srs.getString("truckNumber")));
			}
		} catch (Exception c) {
			c.printStackTrace();
		}

		return orders;

	}

	@Override
	public TruckModel findById(int id) {

		// Sets the query
		String sql = "SELECT * FROM trucks WHERE `truckId` = ?";

		// Creates product
		TruckModel newTruck = null;

		try {

			// find the correct id
			SqlRowSet srs = jdbcTemplateObject.queryForRowSet(sql, id);

			while (srs.next()) {
				// Sets the product
				newTruck = new TruckModel(srs.getInt("truckId"), srs.getString("truckCompany"),
						srs.getString("truckNumber"));
			}
		}

		catch (Exception ex) {
			return null;
		}

		// Returns the product
		return newTruck;

	}

	@Override
	public int create(TruckModel truck) {

		try {

			// Creates the SQL
			String sql = "insert into trucks(truckCompany, truckNumber, tare) values VALUES(?, ?, ?)";

			// Inserts the row
			int rows = jdbcTemplateObject.update(sql, truck.getTruckCompany(), truck.getTruckNumber());

			if (rows == 0) {
				// if no row was inserted, return 0
				return 0;
			}
		} catch (Exception c) {
			c.printStackTrace();
			return -1;

		}

		return 1;
	}

	@Override
	public int update(TruckModel truck) {

		try {

			// Sets the SQL
			String sql = "UPDATE trucks SET truckId = ?, truckCompany = ?, truckNumber = ?, tare = ? WHERE truckId = ?";

			// Makes the inserted row
			int rowInserted = jdbcTemplateObject.update(sql, truck.getTruckId(), truck.getTruckCompany(),
					truck.getTruckNumber(), truck.getTruckId());

			if (rowInserted == 0) {
				// if no row was inserted, return 0
				return 0;
			}
		} catch (Exception ex) {
			return -1;
		}
		// if new row was inserted we return 1
		return 1;
	}

	@Override
	public int delete(TruckModel product) {
		try {
			String sql = "DELETE FROM `products` WHERE `productId` = ?";
			int rowInserted = jdbcTemplateObject.update(sql, product.getTruckId());

			if (rowInserted == 0) {
				// if no row was inserted, return 0
				return 0;
			}
		} catch (Exception e) {
			return -1;
		}
		// if new row was inserted we return 1
		return 1;
	}

}
