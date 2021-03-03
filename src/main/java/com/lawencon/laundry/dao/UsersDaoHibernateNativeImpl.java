package com.lawencon.laundry.dao;

import java.util.List;

import com.lawencon.laundry.model.Users;

/**
 *
 * @author Galih Dika
 *
 */

public class UsersDaoHibernateNativeImpl extends BaseDao implements UsersDao {

	@Override
	public Users login(String username, String pswd) throws Exception {
		String sql = bBuilder(
				"select u.id_user,u.username,u.pswd,u.id_roles,u.id_profiles,r.code_roles from tb_m_users u ",
				"inner join tb_m_roles r on r.id_roles = u.id_roles ",
				"inner join tb_m_profiles p on p.id_profiles = u.id_profiles ", "where u.username = ? and u.pswd = ?")
						.toString();
		List<?> listResult = getSession().createNativeQuery(sql).setParameter(1, username).setParameter(2, pswd)
				.getResultList();

		return (Users) listResult;
	}

	@Override
	public void insertData(Users usr) throws Exception {
		String sql = bBuilder("INSERT INTO tb_m_users (username, pswd, id_roles,id_profiles,user_code)",
				" VALUES(?1,?2,?3,?4,?5)").toString();
		getSession().createNativeQuery(sql).setParameter(1, usr.getUsername()).setParameter(2, usr.getPswd())
				.setParameter(3, usr.getIdRoles().getIdRoles()).setParameter(4, usr.getIdProfiles().getIdProfiles())
				.setParameter(5, usr.getUserCode()).executeUpdate();
	}

	@Override
	public Users getCode(String code) throws Exception {
		List<Users> listResult = getSession()
				.createNativeQuery("select * from tb_m_users where user_code = ?1", Users.class).setParameter(1, code)
				.list();
		return listResult.size() > 0 ? listResult.get(0) : null;
	}

	@Override
	public List<Users> getListUsers() throws Exception {
		List<Users> listResult = getSession().createNativeQuery("select * from tb_m_users", Users.class).list();
		return listResult;
	}

}
