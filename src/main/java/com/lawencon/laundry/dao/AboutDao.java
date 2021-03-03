package com.lawencon.laundry.dao;

import java.util.List;

import com.lawencon.laundry.model.About;

/**
 *
 * @author Galih Dika
 *
 */

public interface AboutDao {
	List<About> getListAbout() throws Exception;

	void insertData(About about) throws Exception;

	public About getCode(String code) throws Exception;
}
