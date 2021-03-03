package com.lawencon.laundry.service;

import java.util.List;

import com.lawencon.laundry.model.Services;

/**
 *
 * @author Galih Dika
 *
 */

public interface ServService {
	public List<Services> getServices() throws Exception;

	public void addData(Services sr) throws Exception;

	public Services getCode(String code) throws Exception;
}
