package com.lawencon.laundry.dao;

import java.util.List;

import com.lawencon.laundry.model.Users;

/**
 *
 * @author Galih Dika
 *
 */

public interface UsersDao {
	public Users login(String username, String pswd) throws Exception;

	void insertData(Users usr) throws Exception;

	List<Users> getListUsers() throws Exception;

	public Users getCode(String code) throws Exception;
}
