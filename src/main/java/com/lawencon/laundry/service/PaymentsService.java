package com.lawencon.laundry.service;

import java.util.List;

import com.lawencon.laundry.model.Payments;

/**
 *
 * @author Galih Dika
 *
 */

public interface PaymentsService {
	public List<Payments> getPayment() throws Exception;

	public void addData(Payments py) throws Exception;

	public Payments getCode(String code) throws Exception;
}
