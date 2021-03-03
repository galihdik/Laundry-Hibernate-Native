package com.lawencon.laundry.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.lawencon.laundry.model.About;
import com.lawencon.laundry.model.Customers;
import com.lawencon.laundry.model.Payments;
import com.lawencon.laundry.model.Transactions;
import com.lawencon.laundry.model.Users;

/**
 *
 * @author Galih Dika
 *
 */

public class TransactionDaoImpl extends BaseDao implements TransactionDao {

	@Override
	public List<Transactions> getListTransactions() throws Exception {
		List<Transactions> listResult = new ArrayList<>();
		Statement statement = conn().createStatement();
		ResultSet rs = statement.executeQuery("SELECT * FROM tb_r_hdr_transaction");
		while (rs.next()) {
			Transactions tr = new Transactions();
			tr.setIdTransactions(rs.getLong("id_transaction"));
			tr.setTransactionDate(rs.getObject("transaction_date", LocalDateTime.class));
			tr.setPriceTotal(rs.getBigDecimal("price_total"));

			Payments py = new Payments();
			py.setIdPayments(rs.getLong("id_payments"));
			Users us = new Users();
			us.setUserId(rs.getLong("id_users"));
			About ab = new About();
			ab.setIdAbout(rs.getLong("id_about"));
			tr.setStruk(rs.getString("struk"));
			Customers cs = new Customers();
			cs.setIdCustomer(rs.getLong("id_customers"));
			tr.setIdPayments(py);
			tr.setIdUsers(us);
			tr.setIdAbout(ab);
			tr.setIdCustomer(cs);
			listResult.add(tr);
		}
		return listResult;
	}

	@Override
	public Transactions insertData(Transactions transaction) throws Exception {
		String sql = bBuilder(
				"insert into tb_r_hdr_transaction (transaction_date ,price_total, id_payments , id_users , id_about, struk,id_customers)",
				" values (current_timestamp ,?, (select id_payments from tb_m_payments where payment_code = ? ), ",
				"1 , 1, ? ,1) returning id_transaction,price_total").toString();
		PreparedStatement ps = conn().prepareStatement(sql);
		ps.setBigDecimal(1, transaction.getPriceTotal());
		ps.setString(2, transaction.getIdPayments().getPaymentsCode());
		// ps.setString(3, transaction.getIdUsers().getUserCode());
//		ps.setString(4, transaction.getIdAbout().getAboutCode());
		ps.setString(3, transaction.getStruk());
		// ps.setString(4, transaction.getIdCustomer().getCustomerCode());
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			transaction.setIdTransactions(rs.getLong("id_transaction"));
			transaction.setPriceTotal(rs.getBigDecimal("price_total"));
			break;
		}
		return transaction;
	}

	@Override
	public void updateData(Transactions transaction) throws Exception {
		String sql = bBuilder("update tb_r_hdr_transaction h ", "set price_total = (select sum(price_dtl) ",
				"from tb_r_dtl_transaction d ", "group by d.id_transaction ", "having d.id_transaction = ?) ",
				"where id_transaction = ? ", "returning id_transaction").toString();
		PreparedStatement ps = conn().prepareStatement(sql);
		ps.setLong(1, transaction.getIdTransactions());
		ps.setLong(2, transaction.getIdTransactions());
		ResultSet rs = ps.executeQuery();
	}

}
