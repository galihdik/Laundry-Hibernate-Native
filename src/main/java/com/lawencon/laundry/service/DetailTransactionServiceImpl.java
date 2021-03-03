package com.lawencon.laundry.service;

import java.util.List;

import org.springframework.transaction.support.TransactionTemplate;

import com.lawencon.laundry.dao.DetailTransactionDao;
import com.lawencon.laundry.model.DetailTransactions;
import com.lawencon.laundry.model.Transactions;

/**
 *
 * @author Galih Dika
 *
 */

public class DetailTransactionServiceImpl extends BaseService implements DetailTransactionService {
	private DetailTransactionDao transactionDetailDao;
	private TransactionTemplate transactionTemplate;

	public DetailTransactionServiceImpl(DetailTransactionDao transactionDetailDao,
			TransactionTemplate transactionTemplate) {
		this.transactionDetailDao = transactionDetailDao;
		this.transactionTemplate = transactionTemplate;
	}

	@Override
	public void addData(List<DetailTransactions> trx, Transactions idTransaction) throws Exception {
		for (DetailTransactions detailTransactions : trx) {
			transactionDetailDao.insert(detailTransactions, idTransaction);
		}
	}

	@Override
	public List<DetailTransactions> getTransaction() throws Exception {
		return getTransactionTemplate().execute(val -> {
			try {
				transactionDetailDao.getListDetailTransactions();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		});
	}

	@Override
	public void update(String code) throws Exception {
		getTransactionTemplate().execute(val -> {
			try {
				transactionDetailDao.updateTime(code);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		});
	}

}
