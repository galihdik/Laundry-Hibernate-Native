package com.lawencon.laundry.dao;

import java.util.List;

import com.lawencon.laundry.model.DetailTransactions;
import com.lawencon.laundry.model.Transactions;

/**
 *
 * @author Galih Dika
 *
 */

public interface DetailTransactionDao {
	List<DetailTransactions> getListDetailTransactions() throws Exception;

	public void insert(DetailTransactions trx, Transactions idTransaction) throws Exception;

	public void updateTime(String code) throws Exception;
}
