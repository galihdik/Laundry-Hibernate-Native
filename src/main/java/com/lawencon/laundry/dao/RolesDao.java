package com.lawencon.laundry.dao;

import java.util.List;

import com.lawencon.laundry.model.Roles;

/**
 *
 * @author Galih Dika
 *
 */

public interface RolesDao {
	List<Roles> getListRoles() throws Exception;

	void insertData(Roles rl) throws Exception;

	public Roles getCode(String code) throws Exception;
}
