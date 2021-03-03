package com.lawencon.laundry.dao;

import java.util.List;

import com.lawencon.laundry.model.DetailTransactions;
import com.lawencon.laundry.model.Transactions;

/**
 *
 * @author Galih Dika
 *
 */

public class DetailTransactionDaoHibernateNativeImpl extends BaseDao implements DetailTransactionDao {

	@Override
	public List<DetailTransactions> getListDetailTransactions() throws Exception {
		List<DetailTransactions> listResult = getSession()
				.createNativeQuery("select * from tb_r_dtl_transaction", DetailTransactions.class).list();
		return listResult;
	}

	@Override
	public void insert(DetailTransactions trx, Transactions idTransaction) throws Exception {
		String sql2 = bBuilder(
				"INSERT INTO tb_r_dtl_transaction (qty, id_transaction,name_item,id_services,id_parfume,weight,price_dtl,return_time,code_dtl)",
				" VALUES(?1,?2,?3,?4,?5,?6,?7,?8,?9)").toString();
		getSession().createNativeQuery(sql2).setParameter(1, trx.getQty())
				.setParameter(2, idTransaction.getIdTransactions()).setParameter(3, trx.getNameItem())
				.setParameter(4, trx.getIdServices().getIdServices()).setParameter(5, trx.getIdParfume().getIdParfume())
				.setParameter(6, trx.getWeight()).setParameter(7, trx.getPriceDetail())
				.setParameter(8, trx.getReturnTime()).setParameter(9, trx.getCodeDetail()).executeUpdate();
	}

	@Override
	public void updateTime(String code) throws Exception {
		String sql = bBuilder("update tb_r_dtl_transaction ", "set return_time = current_timestamp ",
				"where code_dtl = ?1").toString();
		getSession().createNativeQuery(sql).setParameter(1, code).executeUpdate();
	}

}
