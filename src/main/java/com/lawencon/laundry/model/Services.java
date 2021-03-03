package com.lawencon.laundry.model;

import java.math.BigDecimal;

/**
 *
 * @author Galih Dika
 *
 */

public class Services {
	private Long idServices;
	private String nameServies;
	private String durationServices;
	private BigDecimal priceServices;
	private String serviceCode;

	public Long getIdServices() {
		return idServices;
	}

	public void setIdServices(Long idServices) {
		this.idServices = idServices;
	}

	public String getNameServies() {
		return nameServies;
	}

	public void setNameServies(String nameServies) {
		this.nameServies = nameServies;
	}

	public String getDurationServices() {
		return durationServices;
	}

	public void setDurationServices(String durationServices) {
		this.durationServices = durationServices;
	}

	public BigDecimal getPriceServices() {
		return priceServices;
	}

	public void setPriceServices(BigDecimal priceServices) {
		this.priceServices = priceServices;
	}

	public String getServiceCode() {
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}
}
