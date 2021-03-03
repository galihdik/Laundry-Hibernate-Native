package com.lawencon.laundry.dao;

import java.util.List;

import com.lawencon.laundry.model.About;

/**
 *
 * @author Galih Dika
 *
 */

public class AboutDaoHibernateNativeImpl extends BaseDao implements AboutDao {

	@Override
	public List<About> getListAbout() throws Exception {
		List<About> listResult = getSession().createNativeQuery("select * from tb_m_about", About.class).list();
		return listResult;
	}

	@Override
	public void insertData(About about) throws Exception {
		String sql = bBuilder("INSERT INTO tb_m_about (name_about, location_about, about_code)", " VALUES(?,?,?)")
				.toString();
		getSession().createNativeQuery(sql).setParameter(1, about.getNameAbout())
				.setParameter(2, about.getLocationAbout()).setParameter(3, about.getAboutCode()).executeUpdate();
	}

	@Override
	public About getCode(String code) throws Exception {
		List<About> listResult = getSession()
				.createNativeQuery("select * from tb_m_about where aboutCode = ?1", About.class).setParameter(1, code)
				.list();
		return listResult.size() > 0 ? listResult.get(0) : null;
	}

}
