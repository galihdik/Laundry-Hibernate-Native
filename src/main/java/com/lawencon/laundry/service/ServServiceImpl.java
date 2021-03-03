package com.lawencon.laundry.service;

import java.util.List;

import org.springframework.transaction.support.TransactionTemplate;

import com.lawencon.laundry.dao.ServiceDao;
import com.lawencon.laundry.model.Services;

/**
 *
 * @author Galih Dika
 *
 */

public class ServServiceImpl extends BaseService implements ServService {
	private ServiceDao serviceDao;
	private TransactionTemplate transactionTemplate;

	public ServServiceImpl(ServiceDao serviceDao, TransactionTemplate transactionTemplate) {
		this.serviceDao = serviceDao;
		this.transactionTemplate = transactionTemplate;
	}

	@Override
	public List<Services> getServices() throws Exception {
		return getTransactionTemplate().execute(val -> {
			try {
				serviceDao.getListServices();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		});
	}

	@Override
	public void addData(Services sr) throws Exception {
		getTransactionTemplate().execute(val -> {
			try {
				serviceDao.insertData(sr);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		});
	}

	@Override
	public Services getCode(String code) throws Exception {
		return getTransactionTemplate().execute(val -> {
			try {
				serviceDao.getCode(code);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		});
	}

}
