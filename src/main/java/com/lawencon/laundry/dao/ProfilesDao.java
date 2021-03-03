package com.lawencon.laundry.dao;

import java.util.List;

import com.lawencon.laundry.model.Profiles;

/**
 *
 * @author Galih Dika
 *
 */

public interface ProfilesDao {
	List<Profiles> getListProfiles() throws Exception;

	void insertData(Profiles pr) throws Exception;

	public Profiles getCode(String code) throws Exception;
}
