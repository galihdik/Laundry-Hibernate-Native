package com.lawencon.laundry.dao;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.lawencon.laundry.model.DetailTransactions;
import com.lawencon.laundry.model.Parfumes;
import com.lawencon.laundry.model.Services;
import com.lawencon.laundry.model.Transactions;

/**
 *
 * @author Galih Dika
 *
 */

public class DetailTransactionDaoImpl extends BaseDao implements DetailTransactionDao {

	@Override
	public List<DetailTransactions> getListDetailTransactions() throws Exception {
		List<DetailTransactions> listResult = new ArrayList<>();
		Statement statement = conn().createStatement();
		ResultSet rs = statement.executeQuery("SELECT * FROM tb_r_dtl_transaction");
		while (rs.next()) {
			DetailTransactions tr = new DetailTransactions();
			tr.setIdDetailTransactions(rs.getLong("id_detail_transaction"));
			tr.setQty(rs.getInt("qty"));
			Transactions trx = new Transactions();
			trx.setIdTransactions(rs.getLong("id_transaction"));
			tr.setIdTransactions(trx);
			Services srv = new Services();
			srv.setIdServices(rs.getLong("id_services"));
			tr.setIdServices(srv);
			Parfumes prf = new Parfumes();
			prf.setIdParfume(rs.getLong("id_parfume"));
			tr.setIdParfume(prf);
			tr.setWeight(rs.getBigDecimal("weight"));
			tr.setPriceDetail(rs.getBigDecimal("price_dtl"));
			tr.setReturnTime(rs.getObject("return_time", LocalDateTime.class));
			tr.setNameItem(rs.getString("name_item"));
			tr.setCodeDetail(rs.getString("code_dtl"));
			listResult.add(tr);
		}
		return listResult;
	}

	@Override
	public void insert(DetailTransactions trx, Transactions idTransaction) throws Exception {
		String sql = bBuilder("insert into tb_r_dtl_transaction ",
				"(qty,id_transaction,id_services,id_parfume,weight, price_dtl ,return_time , name_item , code_dtl) values ",
				"(?, (select id_transaction from tb_r_hdr_transaction where struk = ?) ,(select id_services from tb_m_services where service_code = ?),",
				" (select id_parfume from tb_m_parfumes where parfume_code = ?), ? , ? , ? , ? , ?)").toString();
		PreparedStatement ps = conn().prepareStatement(sql);
		BigDecimal tampung = BigDecimal.ZERO;
		ps.setInt(1, trx.getQty());
		ps.setString(2, idTransaction.getStruk());
		ps.setString(3, trx.getIdServices().getServiceCode());
		ps.setString(4, trx.getIdParfume().getParfumeCode());
		ps.setBigDecimal(5, trx.getWeight());
		ps.setBigDecimal(6, trx.getIdServices().getPriceServices().multiply(tampung.valueOf(trx.getQty())));
		ps.setObject(7, trx.getReturnTime());
		ps.setString(8, trx.getNameItem());
		ps.setString(9, trx.getCodeDetail());
		ps.executeUpdate();
	}

	@Override
	public void updateTime(String code) throws Exception {
		String sql = bBuilder("update tb_r_dtl_transaction ", "set return_time = current_timestamp ",
				"where code_dtl = ?").toString();
		PreparedStatement ps = conn().prepareStatement(sql);
		ps.setString(1, code);
		ps.executeUpdate();
	}

}
