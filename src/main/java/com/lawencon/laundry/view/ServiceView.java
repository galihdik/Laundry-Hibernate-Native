package com.lawencon.laundry.view;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

import com.lawencon.laundry.model.Services;
import com.lawencon.laundry.service.ServService;
import com.lawencon.laundry.util.CallBack;

/**
 *
 * @author Galih Dika
 *
 */

public class ServiceView {
	private ServService servServices;
	private List<Services> service;
	private Services serv = new Services();
	private Scanner input = new Scanner(System.in);
	private Scanner input2 = new Scanner(System.in);

	public ServiceView(ServService servServices) {
		this.servServices = servServices;
	}

	void show(CallBack cb) {
		System.out.println("===== Parfume ====");
		System.out.println("1. Create Parfume");
		System.out.println("2. Read Parfume");
		System.out.println("3. Search by Code");
		System.out.println("4. Back");

		System.out.println("Pilih : ");
		byte pilih = input2.nextByte();
		if (pilih == 1) {
			addAbout();
			show(cb);
		} else if (pilih == 2) {
			try {
				service = servServices.getServices();
				System.out.println("Id service  | Name service | duration service | price service | service code");
				service.forEach(sr -> {
					System.out.printf("|%-8s|%-10s|%-10s|%-10s|%-10s\n", sr.getIdServices(), sr.getNameServies(),
							sr.getDurationServices(), sr.getPriceServices(), sr.getServiceCode());

				});
			} catch (Exception e) {
				e.printStackTrace();
			}
			show(cb);
		} else if (pilih == 3) {

		} else if (pilih == 4) {
			cb.onDone("");
		}
	}

	void addAbout() {
		System.out.println("Masukan Nama : ");
		String nama = input.next();
		System.out.println("Masukan duration service: ");
		String duration = input.next();
		System.out.println("Masukan price service : ");
		BigDecimal price = input2.nextBigDecimal();
		System.out.println("Masukan code : ");
		String code = input.next();
		serv.setNameServies(nama);
		serv.setDurationServices(duration);
		serv.setPriceServices(price);
		serv.setServiceCode(code);
		try {
			servServices.addData(serv);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
