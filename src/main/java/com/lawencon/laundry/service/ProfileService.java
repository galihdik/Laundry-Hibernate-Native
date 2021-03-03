package com.lawencon.laundry.service;

import java.util.List;

import com.lawencon.laundry.model.Profiles;

/**
 *
 * @author Galih Dika
 *
 */

public interface ProfileService {
	public List<Profiles> getProfiles() throws Exception;

	public void addData(Profiles pr) throws Exception;

	public Profiles getCode(String code) throws Exception;
}
