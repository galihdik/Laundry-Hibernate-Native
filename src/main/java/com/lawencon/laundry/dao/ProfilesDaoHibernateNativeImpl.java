package com.lawencon.laundry.dao;

import java.util.List;

import com.lawencon.laundry.model.Profiles;

/**
 *
 * @author Galih Dika
 *
 */

public class ProfilesDaoHibernateNativeImpl extends BaseDao implements ProfilesDao {

	@Override
	public List<Profiles> getListProfiles() throws Exception {
		List<Profiles> listResult = getSession().createNativeQuery("select * from tb_m_profiles", Profiles.class)
				.list();
		return listResult;
	}

	@Override
	public void insertData(Profiles pr) throws Exception {
		String sql = bBuilder("INSERT INTO tb_m_profiles (address_profile, name_profile, profile_code)",
				" VALUES(?1,?2,?3)").toString();
		getSession().createNativeQuery(sql).setParameter(1, pr.getAddressProfile()).setParameter(2, pr.getNameProfile())
				.setParameter(3, pr.getProfileCode()).executeUpdate();
	}

	@Override
	public Profiles getCode(String code) throws Exception {
		List<Profiles> listResult = getSession()
				.createNativeQuery("select * from tb_m_profiles where profile_code = ?1", Profiles.class)
				.setParameter(1, code).list();
		return listResult.size() > 0 ? listResult.get(0) : null;
	}

}
