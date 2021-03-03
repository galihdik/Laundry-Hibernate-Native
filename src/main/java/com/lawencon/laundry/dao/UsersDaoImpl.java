package com.lawencon.laundry.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.lawencon.laundry.model.Profiles;
import com.lawencon.laundry.model.Roles;
import com.lawencon.laundry.model.Users;

/**
 *
 * @author Galih Dika
 *
 */

public class UsersDaoImpl extends BaseDao implements UsersDao {

	@Override
	public Users login(String username, String pswd) throws Exception {
		Users u = new Users();
		String sql = bBuilder(
				"select u.id_user,u.username,u.pswd,u.id_roles,u.id_profiles,r.code_roles from tb_m_users u ",
				"inner join tb_m_roles r on r.id_roles = u.id_roles ",
				"inner join tb_m_profiles p on p.id_profiles = u.id_profiles ", "where u.username = ? and u.pswd = ?")
						.toString();
		PreparedStatement ps = conn().prepareStatement(sql);
		ps.setString(1, username);
		ps.setString(2, pswd);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			u.setUserId(rs.getLong("id_user"));
			u.setUsername(rs.getString("username"));
			u.setPswd(rs.getString("pswd"));

			Roles rl = new Roles();
			rl.setIdRoles(rs.getLong("id_roles"));
			rl.setCodeRoles(rs.getString("code_roles"));
			Profiles pf = new Profiles();
			pf.setIdProfiles(rs.getLong("id_profiles"));
			u.setIdRoles(rl);
			u.setIdProfiles(pf);
			return u;
		}
		return null;
	}

	@Override
	public void insertData(Users usr) throws Exception {
		String sql = bBuilder("insert into tb_m_users (username,pswd,id_roles,id_profiles,user_code)",
				" values (? , ? ,? , ? ,?) ").toString();
		PreparedStatement ps = conn().prepareStatement(sql);
		ps.setString(1, usr.getUsername());
		ps.setString(2, usr.getPswd());
		ps.setLong(3, usr.getIdRoles().getIdRoles());
		ps.setLong(4, usr.getIdProfiles().getIdProfiles());
		ps.setString(5, usr.getUserCode());
		ps.executeUpdate();
	}

	@Override
	public Users getCode(String code) throws Exception {
		Users sr = new Users();
		String sql = "SELECT * FROM tb_m_users where user_code = ?";
		PreparedStatement ps = conn().prepareStatement(sql);
		ps.setString(1, code);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			sr.setUserId(rs.getLong("id_user"));
			sr.setUsername(rs.getString("username"));
			sr.setPswd(rs.getString("pswd"));
			Roles rl = new Roles();
			rl.setIdRoles(rs.getLong("id_roles"));
			sr.setIdRoles(rl);
			Profiles pf = new Profiles();
			pf.setIdProfiles(rs.getLong("id_profiles"));
			sr.setIdProfiles(pf);
			sr.setUserCode(code);
			return sr;
		}
		return null;
	}

	@Override
	public List<Users> getListUsers() throws Exception {
		List<Users> listResult = new ArrayList<>();
		String sql = "SELECT * FROM tb_m_users";
		PreparedStatement ps = conn().prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Users us = new Users();
			us.setUserId(rs.getLong("id_user"));
			us.setUsername(rs.getString("username"));
			us.setPswd(rs.getString("pswd"));
			Roles rl = new Roles();
			rl.setIdRoles(rs.getLong("id_roles"));
			us.setIdRoles(rl);
			Profiles pf = new Profiles();
			pf.setIdProfiles(rs.getLong("id_profiles"));
			us.setIdProfiles(pf);
			us.setUserCode(rs.getString("user_code"));
			listResult.add(us);
		}
		return listResult;
	}
}