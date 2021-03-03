package com.lawencon.laundry.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.lawencon.laundry.model.Profiles;

/**
 *
 * @author Galih Dika
 *
 */

public class ProfilesDaoImpl extends BaseDao implements ProfilesDao {

	@Override
	public List<Profiles> getListProfiles() throws Exception {
		List<Profiles> listResult = new ArrayList<>();
		String sql = "SELECT * FROM tb_m_profiles";
		PreparedStatement ps = conn().prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Profiles pr = new Profiles();
			pr.setIdProfiles(rs.getLong("id_profiles"));
			pr.setAddressProfile(rs.getString("address_profile"));
			pr.setNameProfile(rs.getString("name_profile"));
			pr.setProfileCode(rs.getString("profile_code"));
			listResult.add(pr);
		}
		return listResult;
	}

	@Override
	public void insertData(Profiles pr) throws Exception {
		String sql = bBuilder(
				"insert into tb_m_profiles (address_profile,name_profile,profile_code) values (?, ? , ? ) ").toString();
		PreparedStatement ps = conn().prepareStatement(sql);
		ps.setString(1, pr.getAddressProfile());
		ps.setString(2, pr.getNameProfile());
		ps.setString(3, pr.getProfileCode());
		ps.executeUpdate();
	}

	@Override
	public Profiles getCode(String code) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
