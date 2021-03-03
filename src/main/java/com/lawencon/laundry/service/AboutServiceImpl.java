package com.lawencon.laundry.service;

import java.util.List;

import org.springframework.transaction.support.TransactionTemplate;

import com.lawencon.laundry.dao.AboutDao;
import com.lawencon.laundry.model.About;

/**
 *
 * @author Galih Dika
 *
 */

public class AboutServiceImpl extends BaseService implements AboutService {
	private AboutDao aboutDao;
	private TransactionTemplate transactionTemplate;

	public AboutServiceImpl(AboutDao aboutDao, TransactionTemplate transactionTemplate) {
		this.aboutDao = aboutDao;
		this.transactionTemplate = transactionTemplate;
	}

	@Override
	public List<About> getAbout() throws Exception {
		return getTransactionTemplate().execute(val -> {
			try {
				aboutDao.getListAbout();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		});
	}

	@Override
	public void addData(About about) throws Exception {
		getTransactionTemplate().execute(val -> {
			try {
				aboutDao.insertData(about);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		});
	}

	@Override
	public About getCode(String code) throws Exception {
		return getTransactionTemplate().execute(val -> {
			try {
				aboutDao.getCode(code);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		});
	}

}
