package com.lawencon.laundry.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.lawencon.laundry.model.Payments;

/**
 *
 * @author Galih Dika
 *
 */

public class PaymentDaoImpl extends BaseDao implements PaymentDao {

	@Override
	public List<Payments> getListPayments() throws Exception {
		List<Payments> listResult = new ArrayList<>();
		String sql = "SELECT * FROM tb_m_payments";
		PreparedStatement ps = conn().prepareStatement(sql);

		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Payments py = new Payments();
			py.setIdPayments(rs.getLong("id_payments"));
			py.setNamePayments(rs.getString("name_payments"));
			py.setPaymentsCode(rs.getString("payment_code"));
			listResult.add(py);
		}
		return listResult;
	}

	@Override
	public void insertData(Payments py) throws Exception {
		String sql = bBuilder("insert into tb_m_payments (name_payments,payment_code) values (? , ? ) ").toString();
		PreparedStatement ps = conn().prepareStatement(sql);
		ps.setString(1, py.getNamePayments());
		ps.setString(2, py.getPaymentsCode());
		ps.executeUpdate();
	}

	@Override
	public Payments getCode(String code) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
