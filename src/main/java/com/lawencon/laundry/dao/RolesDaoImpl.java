
package com.lawencon.laundry.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.lawencon.laundry.model.Roles;

/**
 *
 * @author Galih Dika
 *
 */

public class RolesDaoImpl extends BaseDao implements RolesDao {

	@Override
	public List<Roles> getListRoles() throws Exception {
		List<Roles> listResult = new ArrayList<>();
		String sql = "SELECT * FROM tb_m_roles";
		PreparedStatement ps = conn().prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Roles rl = new Roles();
			rl.setIdRoles(rs.getLong("id_roles"));
			rl.setNameRoles(rs.getString("name_roles"));
			rl.setCodeRoles(rs.getString("code_roles"));
			listResult.add(rl);
		}
		return listResult;
	}

	@Override
	public void insertData(Roles rl) throws Exception {
		String sql = bBuilder("insert into tb_m_roles (name_roles,code_roles) values ( ? , ? ) ").toString();
		PreparedStatement ps = conn().prepareStatement(sql);
		ps.setString(1, rl.getNameRoles());
		ps.setString(2, rl.getCodeRoles());
		ps.executeUpdate();
	}

	@Override
	public Roles getCode(String code) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
