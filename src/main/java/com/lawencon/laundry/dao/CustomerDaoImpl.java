package com.lawencon.laundry.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.lawencon.laundry.model.Customers;

/**
 *
 * @author Galih Dika
 *
 */

public class CustomerDaoImpl extends BaseDao implements CustomerDao {

	@Override
	public List<Customers> getListCustomers() throws Exception {
		List<Customers> listResult = new ArrayList<>();
		String sql = "SELECT * FROM tb_m_customers";
		PreparedStatement ps = conn().prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Customers cs = new Customers();
			cs.setIdCustomer(rs.getLong("id_customers"));
			cs.setNameCustomer(rs.getString("name_customers"));
			cs.setCustomerCode(rs.getString("customer_code"));
			cs.setAddressCustomer(rs.getString("address_customers"));
			listResult.add(cs);
		}
		return listResult;
	}

	@Override
	public void insertData(Customers cs) throws Exception {
		String sql = bBuilder(
				"insert into tb_m_about (name_customers,customer_code,address_customers) values (? , ? , ?) ")
						.toString();
		PreparedStatement ps = conn().prepareStatement(sql);
		ps.setString(1, cs.getNameCustomer());
		ps.setString(2, cs.getCustomerCode());
		ps.setString(3, cs.getAddressCustomer());
		ps.executeUpdate();
	}

	@Override
	public Customers getCode(String code) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
