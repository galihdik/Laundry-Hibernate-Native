package com.lawencon.laundry.dao;

import java.util.List;

import com.lawencon.laundry.model.Services;

/**
 *
 * @author Galih Dika
 *
 */

public interface ServiceDao {
	List<Services> getListServices() throws Exception;

	void insertData(Services sr) throws Exception;

	public Services getCode(String code) throws Exception;
}
