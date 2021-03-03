package com.lawencon.laundry.model;

/**
 *
 * @author Galih Dika
 *
 */

public class Payments {
	private Long idPayments;
	private String namePayments;
	private String paymentsCode;

	public Long getIdPayments() {
		return idPayments;
	}

	public void setIdPayments(Long idPayments) {
		this.idPayments = idPayments;
	}

	public String getNamePayments() {
		return namePayments;
	}

	public void setNamePayments(String namePayments) {
		this.namePayments = namePayments;
	}

	public String getPaymentsCode() {
		return paymentsCode;
	}

	public void setPaymentsCode(String paymentsCode) {
		this.paymentsCode = paymentsCode;
	}
}
