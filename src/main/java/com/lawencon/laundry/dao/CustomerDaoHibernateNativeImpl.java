package com.lawencon.laundry.dao;

import java.util.List;

import com.lawencon.laundry.model.Customers;

/**
 *
 * @author Galih Dika
 *
 */

public class CustomerDaoHibernateNativeImpl extends BaseDao implements CustomerDao {

	@Override
	public List<Customers> getListCustomers() throws Exception {
		List<Customers> listResult = getSession().createNativeQuery("select * from tb_m_customers", Customers.class)
				.list();
		return listResult;
	}

	@Override
	public void insertData(Customers cs) throws Exception {
		String sql = bBuilder("INSERT INTO tb_m_customers (name_customers, customer_code, address_customers)",
				" VALUES(?1,?2,?3)").toString();
		getSession().createNativeQuery(sql).setParameter(1, cs.getNameCustomer()).setParameter(2, cs.getCustomerCode())
				.setParameter(3, cs.getAddressCustomer()).executeUpdate();
	}

	@Override
	public Customers getCode(String code) throws Exception {
		List<Customers> listResult = getSession()
				.createNativeQuery("select * from tb_m_customers where customer_code = ?1", Customers.class)
				.setParameter(1, code).list();
		return listResult.size() > 0 ? listResult.get(0) : null;
	}

}
