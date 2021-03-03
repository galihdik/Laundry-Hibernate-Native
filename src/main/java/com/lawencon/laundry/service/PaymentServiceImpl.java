package com.lawencon.laundry.service;

import java.util.List;

import org.springframework.transaction.support.TransactionTemplate;

import com.lawencon.laundry.dao.PaymentDao;
import com.lawencon.laundry.model.Payments;

/**
 *
 * @author Galih Dika
 *
 */

public class PaymentServiceImpl extends BaseService implements PaymentsService {
	private PaymentDao paymentDao;
	private TransactionTemplate transactionTemplate;

	public PaymentServiceImpl(PaymentDao paymentDao, TransactionTemplate transactionTemplate) {
		this.paymentDao = paymentDao;
		this.transactionTemplate = transactionTemplate;
	}

	@Override
	public List<Payments> getPayment() throws Exception {
		return getTransactionTemplate().execute(val -> {
			try {
				paymentDao.getListPayments();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		});
	}

	@Override
	public void addData(Payments py) throws Exception {
		getTransactionTemplate().execute(val -> {
			try {
				paymentDao.insertData(py);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		});
	}

	@Override
	public Payments getCode(String code) throws Exception {
		return getTransactionTemplate().execute(val -> {
			try {
				paymentDao.getCode(code);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		});
	}

}
