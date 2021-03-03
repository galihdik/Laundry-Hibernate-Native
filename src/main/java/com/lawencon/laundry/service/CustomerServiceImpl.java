package com.lawencon.laundry.service;

import java.util.List;

import org.springframework.transaction.support.TransactionTemplate;

import com.lawencon.laundry.dao.CustomerDao;
import com.lawencon.laundry.model.Customers;

/**
 *
 * @author Galih Dika
 *
 */

public class CustomerServiceImpl extends BaseService implements CustomerService {
	private CustomerDao customerDao;
	private TransactionTemplate transactionTemplate;

	public CustomerServiceImpl(CustomerDao customerDao, TransactionTemplate transactionTemplate) {
		this.customerDao = customerDao;
		this.transactionTemplate = transactionTemplate;
	}

	@Override
	public List<Customers> getCustomers() throws Exception {
		return getTransactionTemplate().execute(val -> {
			try {
				customerDao.getListCustomers();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		});
	}

	@Override
	public void addData(Customers cs) throws Exception {
		getTransactionTemplate().execute(val -> {
			try {
				customerDao.insertData(cs);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		});

	}

}
