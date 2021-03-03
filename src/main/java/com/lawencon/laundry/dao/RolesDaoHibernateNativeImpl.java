package com.lawencon.laundry.dao;

import java.util.List;

import com.lawencon.laundry.model.Roles;

/**
 *
 * @author Galih Dika
 *
 */

public class RolesDaoHibernateNativeImpl extends BaseDao implements RolesDao {

	@Override
	public List<Roles> getListRoles() throws Exception {
		List<Roles> listResult = getSession().createNativeQuery("select * from tb_m_roles", Roles.class).list();
		return listResult;
	}

	@Override
	public void insertData(Roles rl) throws Exception {
		String sql = bBuilder("INSERT INTO tb_m_roles (name_roles, code_roles)", " VALUES(?1,?2,?3)").toString();
		getSession().createNativeQuery(sql).setParameter(1, rl.getNameRoles()).setParameter(2, rl.getCodeRoles())
				.executeUpdate();
	}

	@Override
	public Roles getCode(String code) throws Exception {
		List<Roles> listResult = getSession()
				.createNativeQuery("select * from tb_m_roles where code_roles = ?1", Roles.class).setParameter(1, code)
				.list();
		return listResult.size() > 0 ? listResult.get(0) : null;
	}

}
