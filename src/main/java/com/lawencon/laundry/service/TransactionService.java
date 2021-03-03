package com.lawencon.laundry.service;

import java.util.List;

import com.lawencon.laundry.model.DetailTransactions;
import com.lawencon.laundry.model.Transactions;

/**
 *
 * @author Galih Dika
 *
 */

public interface TransactionService {
	public void addData(List<DetailTransactions> trxDetail, Transactions transaction) throws Exception;

	public List<Transactions> getTransaction() throws Exception;

	public void updateDetailTime(String code) throws Exception;

	public List<DetailTransactions> getTransactionDetail() throws Exception;
}
