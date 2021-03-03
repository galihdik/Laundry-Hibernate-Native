package com.lawencon.laundry.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author Galih Dika
 *
 */

public class Transactions {
	private Long idTransactions;
	private LocalDateTime transactionDate;
	private BigDecimal priceTotal;
	private About idAbout;
	private Payments idPayments;
	private Users idUsers;
	private String struk;
	private List<DetailTransactions> detailTransactions;
	private Customers idCustomer;

	public Long getIdTransactions() {
		return idTransactions;
	}

	public void setIdTransactions(Long idTransactions) {
		this.idTransactions = idTransactions;
	}

	public LocalDateTime getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(LocalDateTime transactionDate) {
		this.transactionDate = transactionDate;
	}

	public BigDecimal getPriceTotal() {
		return priceTotal;
	}

	public void setPriceTotal(BigDecimal priceTotal) {
		this.priceTotal = priceTotal;
	}

	public About getIdAbout() {
		return idAbout;
	}

	public void setIdAbout(About idAbout) {
		this.idAbout = idAbout;
	}

	public Payments getIdPayments() {
		return idPayments;
	}

	public void setIdPayments(Payments idPayments) {
		this.idPayments = idPayments;
	}

	public Users getIdUsers() {
		return idUsers;
	}

	public void setIdUsers(Users idUsers) {
		this.idUsers = idUsers;
	}

	public String getStruk() {
		return struk;
	}

	public void setStruk(String struk) {
		this.struk = struk;
	}

	public Customers getIdCustomer() {
		return idCustomer;
	}

	public void setIdCustomer(Customers idCustomer) {
		this.idCustomer = idCustomer;
	}

	public List<DetailTransactions> getDetailTransactions() {
		return detailTransactions;
	}

	public void setDetailTransactions(List<DetailTransactions> detailTransactions) {
		this.detailTransactions = detailTransactions;
	}
}
