package com.lawencon.laundry.service;

import java.util.List;

import org.springframework.transaction.support.TransactionTemplate;

import com.lawencon.laundry.dao.ProfilesDao;
import com.lawencon.laundry.model.Profiles;

/**
 *
 * @author Galih Dika
 *
 */

public class ProfileServiceImpl extends BaseService implements ProfileService {
	private ProfilesDao profileDao;
	private TransactionTemplate transactionTemplate;

	public ProfileServiceImpl(ProfilesDao profileDao, TransactionTemplate transactionTemplate) {
		this.profileDao = profileDao;
		this.transactionTemplate = transactionTemplate;
	}

	@Override
	public List<Profiles> getProfiles() throws Exception {
		return getTransactionTemplate().execute(val -> {
			try {
				profileDao.getListProfiles();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		});
	}

	@Override
	public void addData(Profiles pr) throws Exception {
		getTransactionTemplate().execute(val -> {
			try {
				profileDao.insertData(pr);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		});
	}

	@Override
	public Profiles getCode(String code) throws Exception {
		return getTransactionTemplate().execute(val -> {
			try {
				return profileDao.getCode(code);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		});
	}

}
