package com.lawencon.laundry.service;

import java.util.List;

import com.lawencon.laundry.model.DetailTransactions;
import com.lawencon.laundry.model.Transactions;

/**
 *
 * @author Galih Dika
 *
 */

public interface DetailTransactionService {

	public void addData(List<DetailTransactions> trx, Transactions idTransaction) throws Exception;

	public List<DetailTransactions> getTransaction() throws Exception;

	public void update(String code) throws Exception;
}
