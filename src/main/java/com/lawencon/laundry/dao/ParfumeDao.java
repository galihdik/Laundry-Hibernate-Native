package com.lawencon.laundry.dao;

import java.util.List;

import com.lawencon.laundry.model.Parfumes;

/**
 *
 * @author Galih Dika
 *
 */

public interface ParfumeDao {
	List<Parfumes> getListParfumes() throws Exception;

	void insertData(Parfumes pf) throws Exception;

	public Parfumes getCode(String code) throws Exception;
}
