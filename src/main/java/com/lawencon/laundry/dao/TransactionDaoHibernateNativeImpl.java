package com.lawencon.laundry.dao;

import java.util.List;

import com.lawencon.laundry.model.Transactions;

/**
 *
 * @author Galih Dika
 *
 */

public class TransactionDaoHibernateNativeImpl extends BaseDao implements TransactionDao {

	@Override
	public List<Transactions> getListTransactions() throws Exception {
		List<Transactions> listResult = getSession()
				.createNativeQuery("select * from tb_r_hdr_transaction", Transactions.class).list();
		return listResult;
	}

	@Override
	public Transactions insertData(Transactions transaction) throws Exception {
//		String sql = bBuilder(
//				"insert into tb_r_hdr_transaction (transaction_date ,price_total, id_payments , id_users , id_about, struk,id_customers)",
//				" values (current_timestamp ,?1, (select id_payments from tb_m_payments where payment_code = ?2 ), ",
//				"1 , 1, ? ,1) returning id_transaction,price_total").toString();
		String sql2 = bBuilder(
				"INSERT INTO tb_r_hdr_transaction (transaction_date, price_total,id_about,id_payments,id_users,struk,id_customers)",
				" VALUES(current_timestamp,?1,?2,?3,?4,?5,?6)").toString();
		List<?> listTransaction = getSession().createNativeQuery(sql2).setParameter(1, transaction.getPriceTotal())
				.setParameter(2, transaction.getIdAbout().getIdAbout())
				.setParameter(3, transaction.getIdPayments().getIdPayments())
				.setParameter(4, transaction.getIdUsers().getUserId()).setParameter(5, transaction.getStruk())
				.setParameter(6, transaction.getIdCustomer().getIdCustomer()).list();
		Long id = listTransaction.size() > 0 ? Long.valueOf(listTransaction.get(0).toString()) : null;
		transaction.setIdTransactions(id);
		return transaction;
	}

	@Override
	public void updateData(Transactions transaction) throws Exception {
		String sql = bBuilder("update tb_r_hdr_transaction h ", "set price_total = (select sum(price_dtl) ",
				"from tb_r_dtl_transaction d ", "group by d.id_transaction ", "having d.id_transaction = ?1) ",
				"where id_transaction = ?2 ", "returning id_transaction").toString();
		getSession().createNativeQuery(sql).setParameter(1, transaction.getIdTransactions())
				.setParameter(2, transaction.getIdTransactions()).executeUpdate();
	}

}
