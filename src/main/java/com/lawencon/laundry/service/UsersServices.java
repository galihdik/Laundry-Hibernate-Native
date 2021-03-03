package com.lawencon.laundry.service;

import java.util.List;

import com.lawencon.laundry.model.Users;

/**
 *
 * @author Galih Dika
 *
 */

public interface UsersServices {
	public Users loginUser(String username, String pswd) throws Exception;

	public void addData(Users usr) throws Exception;

	public Users getCode(String code) throws Exception;

	public List<Users> getUsers() throws Exception;
}
