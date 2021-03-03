package com.lawencon.laundry.dao;

import java.util.List;

import com.lawencon.laundry.model.Customers;

/**
 *
 * @author Galih Dika
 *
 */

public interface CustomerDao {
	List<Customers> getListCustomers() throws Exception;

	void insertData(Customers cs) throws Exception;

	public Customers getCode(String code) throws Exception;
}
