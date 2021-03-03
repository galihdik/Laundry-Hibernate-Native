package com.lawencon.laundry.service;

import java.util.List;

import com.lawencon.laundry.model.About;

/**
 *
 * @author Galih Dika
 *
 */

public interface AboutService {
	public List<About> getAbout() throws Exception;

	public void addData(About about) throws Exception;

	public About getCode(String code) throws Exception;
}
