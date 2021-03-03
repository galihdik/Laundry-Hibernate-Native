package com.lawencon.laundry.dao;

import java.util.List;

import com.lawencon.laundry.model.Payments;

/**
 *
 * @author Galih Dika
 *
 */

public interface PaymentDao {
	List<Payments> getListPayments() throws Exception;

	void insertData(Payments py) throws Exception;

	public Payments getCode(String code) throws Exception;
}
