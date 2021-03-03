package com.lawencon.laundry.dao;

import java.util.List;

import com.lawencon.laundry.model.Services;

/**
 *
 * @author Galih Dika
 *
 */

public class ServiceDaoHibernateNativeImpl extends BaseDao implements ServiceDao {

	@Override
	public List<Services> getListServices() throws Exception {
		List<Services> listResult = getSession().createNativeQuery("select * from tb_m_services", Services.class)
				.list();
		return listResult;
	}

	@Override
	public void insertData(Services sr) throws Exception {
		String sql = bBuilder("INSERT INTO tb_m_services (name_service, duration_service,price_service,service_code)",
				" VALUES(?1,?2,?3,?4)").toString();
		getSession().createNativeQuery(sql).setParameter(1, sr.getNameServies())
				.setParameter(2, sr.getDurationServices()).setParameter(3, sr.getPriceServices())
				.setParameter(4, sr.getServiceCode()).executeUpdate();
	}

	@Override
	public Services getCode(String code) throws Exception {
		List<Services> listResult = getSession()
				.createNativeQuery("select * from tb_m_services where service_code = ?1", Services.class)
				.setParameter(1, code).list();
		return listResult.size() > 0 ? listResult.get(0) : null;
	}

}
