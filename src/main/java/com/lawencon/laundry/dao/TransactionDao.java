package com.lawencon.laundry.dao;

import java.util.List;

import com.lawencon.laundry.model.Transactions;

/**
 *
 * @author Galih Dika
 *
 */

public interface TransactionDao {
	List<Transactions> getListTransactions() throws Exception;

	public Transactions insertData(Transactions transaction) throws Exception;

	public void updateData(Transactions transaction) throws Exception;
}
