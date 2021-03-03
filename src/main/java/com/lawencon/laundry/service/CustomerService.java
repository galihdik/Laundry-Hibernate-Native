package com.lawencon.laundry.service;

import java.util.List;

import com.lawencon.laundry.model.Customers;

/**
 *
 * @author Galih Dika
 *
 */

public interface CustomerService {
	public List<Customers> getCustomers() throws Exception;

	public void addData(Customers cs) throws Exception;
}
