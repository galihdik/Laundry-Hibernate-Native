package com.lawencon.laundry.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.lawencon.laundry.model.Services;

/**
 *
 * @author Galih Dika
 *
 */

public class ServiceDaoImpl extends BaseDao implements ServiceDao {

	@Override
	public List<Services> getListServices() throws Exception {
		List<Services> listResult = new ArrayList<>();
		String sql = "SELECT * FROM tb_m_services";
		PreparedStatement ps = conn().prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Services sr = new Services();
			sr.setIdServices(rs.getLong("id_services"));
			sr.setDurationServices(rs.getString("duration_service"));
			sr.setPriceServices(rs.getBigDecimal("price_service"));
			sr.setServiceCode(rs.getString("service_code"));
			listResult.add(sr);
		}
		return listResult;
	}

	@Override
	public void insertData(Services sr) throws Exception {
		String sql = bBuilder(
				"insert into tb_m_services (name_service,duration_service,price_service,service_code) values (?,?, ? , ? ) ")
						.toString();
		PreparedStatement ps = conn().prepareStatement(sql);
		ps.setString(1, sr.getNameServies());
		ps.setString(2, sr.getDurationServices());
		ps.setBigDecimal(3, sr.getPriceServices());
		ps.setString(4, sr.getServiceCode());
		ps.executeUpdate();
	}

	@Override
	public Services getCode(String code) throws Exception {
		Services sr = new Services();
		String sql = "SELECT * FROM tb_m_services where service_code = ?";
		PreparedStatement ps = conn().prepareStatement(sql);
		ps.setString(1, code);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			sr.setIdServices(rs.getLong("id_services"));
			sr.setDurationServices(rs.getString("duration_service"));
			sr.setPriceServices(rs.getBigDecimal("price_service"));
			sr.setServiceCode(rs.getString("service_code"));
			return sr;
		}
		return null;
	}

}
