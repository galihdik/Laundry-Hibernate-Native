package com.lawencon.laundry.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.lawencon.laundry.model.Parfumes;

/**
 *
 * @author Galih Dika
 *
 */

public class ParfumeDaoImpl extends BaseDao implements ParfumeDao {

	@Override
	public List<Parfumes> getListParfumes() throws Exception {
		List<Parfumes> listResult = new ArrayList<>();
		String sql = "SELECT * FROM tb_m_parfumes where parfume_code = ?";
		PreparedStatement ps = conn().prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Parfumes pf = new Parfumes();
			pf.setIdParfume(rs.getLong("id_parfume"));
			pf.setNameParfume(rs.getString("parfume_name"));
			pf.setParfumeCode(rs.getString("parfume_code"));
			listResult.add(pf);
		}
		return listResult;
	}

	@Override
	public void insertData(Parfumes pf) throws Exception {
		String sql = bBuilder("insert into tb_m_parfumes (parfume_name,parfume_code) values (? , ? ) ").toString();
		PreparedStatement ps = conn().prepareStatement(sql);
		ps.setString(1, pf.getNameParfume());
		ps.setString(2, pf.getParfumeCode());
		ps.executeUpdate();
	}

	@Override
	public Parfumes getCode(String code) throws Exception {
		Parfumes pf = new Parfumes();
		String sql = "SELECT * FROM tb_m_parfumes where parfume_code = ?";
		PreparedStatement ps = conn().prepareStatement(sql);
		ps.setString(1, code);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			pf.setIdParfume(rs.getLong("id_parfume"));
			pf.setNameParfume(rs.getString("parfume_name"));
			pf.setParfumeCode(rs.getString("parfume_code"));
			return pf;
		}
		return null;
	}

}
