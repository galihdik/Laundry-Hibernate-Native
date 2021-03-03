package com.lawencon.laundry.service;

import java.util.List;

import com.lawencon.laundry.model.Roles;

/**
 *
 * @author Galih Dika
 *
 */

public interface RolesService {
	public List<Roles> getRoles() throws Exception;

	public void addData(Roles rl) throws Exception;

	public Roles getCode(String code) throws Exception;
}
