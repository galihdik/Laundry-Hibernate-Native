package com.lawencon.laundry.service;

import java.util.List;

import com.lawencon.laundry.model.Parfumes;

/**
 *
 * @author Galih Dika
 *
 */

public interface ParfumeService {
	public List<Parfumes> getParfumes() throws Exception;

	public void addData(Parfumes pf) throws Exception;

	public Parfumes getCode(String code) throws Exception;
}
