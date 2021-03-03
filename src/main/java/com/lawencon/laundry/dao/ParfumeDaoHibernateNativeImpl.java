package com.lawencon.laundry.dao;

import java.util.List;

import com.lawencon.laundry.model.Parfumes;

/**
 *
 * @author Galih Dika
 *
 */

public class ParfumeDaoHibernateNativeImpl extends BaseDao implements ParfumeDao {

	@Override
	public List<Parfumes> getListParfumes() throws Exception {
		List<Parfumes> listResult = getSession().createNativeQuery("select * from tb_m_parfumes", Parfumes.class)
				.list();
		return listResult;
	}

	@Override
	public void insertData(Parfumes pf) throws Exception {
		String sql = bBuilder("INSERT INTO tb_m_parfumes (parfume_name, parfume_code)", " VALUES(?1,?2)").toString();
		getSession().createNativeQuery(sql).setParameter(1, pf.getNameParfume()).setParameter(2, pf.getParfumeCode())
				.executeUpdate();
	}

	@Override
	public Parfumes getCode(String code) throws Exception {
		List<Parfumes> listResult = getSession()
				.createNativeQuery("select * from tb_m_parfumes where parfume_code = ?1", Parfumes.class)
				.setParameter(1, code).list();
		return listResult.size() > 0 ? listResult.get(0) : null;
	}

}
