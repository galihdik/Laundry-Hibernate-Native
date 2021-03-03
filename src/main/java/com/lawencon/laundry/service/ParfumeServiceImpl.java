package com.lawencon.laundry.service;

import java.util.List;

import org.springframework.transaction.support.TransactionTemplate;

import com.lawencon.laundry.dao.ParfumeDao;
import com.lawencon.laundry.model.Parfumes;

/**
 *
 * @author Galih Dika
 *
 */

public class ParfumeServiceImpl extends BaseService implements ParfumeService {
	private ParfumeDao parfumeDao;
	private TransactionTemplate transactionTemplate;

	public ParfumeServiceImpl(ParfumeDao parfumeDao, TransactionTemplate transactionTemplate) {
		this.parfumeDao = parfumeDao;
		this.transactionTemplate = transactionTemplate;
	}

	@Override
	public List<Parfumes> getParfumes() throws Exception {
		return getTransactionTemplate().execute(val -> {
			try {
				parfumeDao.getListParfumes();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		});
	}

	@Override
	public void addData(Parfumes pf) throws Exception {
		getTransactionTemplate().execute(val -> {
			try {
				parfumeDao.insertData(pf);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		});
	}

	@Override
	public Parfumes getCode(String code) throws Exception {
		return getTransactionTemplate().execute(val -> {
			try {
				parfumeDao.getCode(code);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		});
	}

}
