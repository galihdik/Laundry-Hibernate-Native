package com.lawencon.laundry.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.lawencon.laundry.model.About;

/**
 *
 * @author Galih Dika
 *
 */

public class AboutDaoImpl extends BaseDao implements AboutDao {

	@Override
	public List<About> getListAbout() throws Exception {
		List<About> listResult = new ArrayList<>();
		String sql = "SELECT * FROM tb_m_about";
		PreparedStatement ps = conn().prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			About about = new About();
			about.setIdAbout(rs.getLong("id_about"));
			about.setNameAbout(rs.getString("name_about"));
			about.setLocationAbout(rs.getString("location_about"));
			listResult.add(about);
		}
		return listResult;
	}

	@Override
	public void insertData(About about) throws Exception {
		String sql = bBuilder("insert into tb_m_about (name_about,location_about,about_code) values (? , ? ,?) ")
				.toString();
		PreparedStatement ps = conn().prepareStatement(sql);
		ps.setString(1, about.getNameAbout());
		ps.setString(2, about.getLocationAbout());
		ps.setString(3, about.getAboutCode());
		ps.executeUpdate();
	}

	@Override
	public About getCode(String code) throws Exception {
		About about = new About();
		String sql = "SELECT * FROM tb_m_about where about_code = ?";
		PreparedStatement ps = conn().prepareStatement(sql);
		ps.setString(1, code);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			about.setIdAbout(rs.getLong("id_about"));
			about.setNameAbout(rs.getString("name_about"));
			about.setLocationAbout(rs.getString("location_about"));
			return about;
		}
		return null;
	}

}
