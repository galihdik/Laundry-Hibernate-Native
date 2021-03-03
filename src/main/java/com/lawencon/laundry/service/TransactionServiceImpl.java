package com.lawencon.laundry.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.transaction.support.TransactionTemplate;

import com.lawencon.laundry.dao.TransactionDao;
import com.lawencon.laundry.model.About;
import com.lawencon.laundry.model.DetailTransactions;
import com.lawencon.laundry.model.Transactions;
import com.lawencon.laundry.model.UserSessionCache;
import com.lawencon.laundry.model.Users;

/**
 *
 * @author Galih Dika
 *
 */

public class TransactionServiceImpl extends BaseService implements TransactionService {
	private TransactionDao transactionDao;
	private DetailTransactionService detailTransactionService;
	private ServService servServ;
	private AboutService aboutServ;
	private PaymentsService paymentServ;
	private UserSessionCache usrCache;
	private TransactionTemplate transactionTemplate;

	public TransactionServiceImpl(TransactionDao transactionDao, DetailTransactionService detailTransactionService,
			ServService servServ, AboutService aboutServ, PaymentsService paymentServ, UserSessionCache usrCache,
			TransactionTemplate transactionTemplate) {
		this.transactionDao = transactionDao;
		this.detailTransactionService = detailTransactionService;
		this.servServ = servServ;
		this.aboutServ = aboutServ;
		this.paymentServ = paymentServ;
		this.usrCache = usrCache;
		this.transactionTemplate = transactionTemplate;
	}

	@Override
	public void addData(List<DetailTransactions> trxDetail, Transactions transaction) throws Exception {
		getTransactionTemplate().execute(val -> {
			try {
				About aboutCode = aboutServ.getCode("1");
				Users activedUsr = usrCache.getActiveUser();
				transaction.setIdUsers(activedUsr);
				transaction.setIdAbout(aboutCode);
				Transactions idTransaction = transactionDao.insertData(transaction);
				BigDecimal totalHarga = BigDecimal.ZERO;

				for (DetailTransactions detailTransactions : trxDetail) {
					detailTransactions.setPriceDetail((detailTransactions.getIdServices().getPriceServices()
							.multiply(new BigDecimal(detailTransactions.getQty()))));
					detailTransactions.setIdTransactions(idTransaction);
					totalHarga = totalHarga.add(detailTransactions.getIdServices().getPriceServices()
							.multiply(new BigDecimal(detailTransactions.getQty())));
				}
				detailTransactionService.addData(trxDetail, idTransaction);
				idTransaction.setPriceTotal(totalHarga);
				transactionDao.updateData(idTransaction);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		});
		Transactions idTransaction = transactionDao.insertData(transaction);
		detailTransactionService.addData(trxDetail, idTransaction);
		transactionDao.updateData(transaction);
	}

	@Override
	public List<Transactions> getTransaction() throws Exception {
		return getTransactionTemplate().execute(val -> {
			try {
				transactionDao.getListTransactions();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		});
	}

	@Override
	public void updateDetailTime(String code) throws Exception {
		getTransactionTemplate().execute(val -> {
			try {
				detailTransactionService.update(code);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		});
	}

	@Override
	public List<DetailTransactions> getTransactionDetail() throws Exception {
		return getTransactionTemplate().execute(val -> {
			try {
				detailTransactionService.getTransaction();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		});
	}

}
