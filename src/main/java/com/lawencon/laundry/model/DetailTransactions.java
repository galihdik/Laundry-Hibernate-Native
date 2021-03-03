package com.lawencon.laundry.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 *
 * @author Galih Dika
 *
 */

public class DetailTransactions {
	private Long idDetailTransactions;
	private Integer qty;
	private Transactions idTransactions;
	private String nameItem;
	private Services idServices;
	private Parfumes idParfume;
	private BigDecimal weight;
	private BigDecimal priceDetail;
	private LocalDateTime returnTime;
	private String codeDetail;

	public Long getIdDetailTransactions() {
		return idDetailTransactions;
	}

	public void setIdDetailTransactions(Long idDetailTransactions) {
		this.idDetailTransactions = idDetailTransactions;
	}

	public Integer getQty() {
		return qty;
	}

	public void setQty(Integer qty) {
		this.qty = qty;
	}

	public Transactions getIdTransactions() {
		return idTransactions;
	}

	public void setIdTransactions(Transactions idTransactions) {
		this.idTransactions = idTransactions;
	}

	public Services getIdServices() {
		return idServices;
	}

	public void setIdServices(Services idServices) {
		this.idServices = idServices;
	}

	public String getNameItem() {
		return nameItem;
	}

	public void setNameItem(String nameItem) {
		this.nameItem = nameItem;
	}

	public Parfumes getIdParfume() {
		return idParfume;
	}

	public void setIdParfume(Parfumes idParfume) {
		this.idParfume = idParfume;
	}

	public BigDecimal getWeight() {
		return weight;
	}

	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}

	public BigDecimal getPriceDetail() {
		return priceDetail;
	}

	public void setPriceDetail(BigDecimal priceDetail) {
		this.priceDetail = priceDetail;
	}

	public LocalDateTime getReturnTime() {
		return returnTime;
	}

	public void setReturnTime(LocalDateTime returnTime) {
		this.returnTime = returnTime;
	}

	public String getCodeDetail() {
		return codeDetail;
	}

	public void setCodeDetail(String codeDetail) {
		this.codeDetail = codeDetail;
	}
}
