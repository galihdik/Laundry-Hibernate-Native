package com.lawencon.laundry.dao;

import java.util.List;

import com.lawencon.laundry.model.Payments;

/**
 *
 * @author Galih Dika
 *
 */

public class PaymentDaoHibernateNativeImpl extends BaseDao implements PaymentDao {

	@Override
	public List<Payments> getListPayments() throws Exception {
		List<Payments> listResult = getSession().createNativeQuery("select * from tb_m_payments", Payments.class)
				.list();
		return listResult;
	}

	@Override
	public void insertData(Payments py) throws Exception {
		String sql = bBuilder("INSERT INTO tb_m_payments (name_payments, payment_code)", " VALUES(?1,?2)").toString();
		getSession().createNativeQuery(sql).setParameter(1, py.getNamePayments()).setParameter(2, py.getPaymentsCode())
				.executeUpdate();
	}

	@Override
	public Payments getCode(String code) throws Exception {
		List<Payments> listResult = getSession()
				.createNativeQuery("select * from tb_m_payments where payment_code = ?1", Payments.class)
				.setParameter(1, code).list();
		return listResult.size() > 0 ? listResult.get(0) : null;
	}

}
