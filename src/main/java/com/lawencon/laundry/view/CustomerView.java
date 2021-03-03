package com.lawencon.laundry.view;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.lawencon.laundry.model.Customers;
import com.lawencon.laundry.service.CustomerService;
import com.lawencon.laundry.util.CallBack;

/**
 *
 * @author Galih Dika
 *
 */

public class CustomerView {
	private CustomerService custServices;
	private List<Customers> customer;
	private Customers cs = new Customers();
	private Scanner input = new Scanner(System.in);

	public CustomerView(CustomerService custServices) {
		this.custServices = custServices;
	}

	void show(CallBack cb) {
		System.out.println("===== Customer ====");
		System.out.println("1. Create Customers");
		System.out.println("2. Read Customers");
		System.out.println("3. Search by Code");
		System.out.println("4. Back");

		System.out.println("Pilih : ");
		byte pilih = input.nextByte();
		if (pilih == 1) {
			addAbout();
			show(cb);
		} else if (pilih == 2) {
			try {
				customer = custServices.getCustomers();
				System.out.println("Id Customer  | Name Customer | Customer Code | Address Customer");
				customer.forEach(abt -> {
					System.out.printf("|%-8s|%-10s|%-10s|%-10s\n", cs.getIdCustomer(), cs.getNameCustomer(),
							cs.getAddressCustomer());

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
		System.out.println("Masukan address : ");
		String lokasi = input.next();
		Random random = new Random();
		int tampungRandom = random.nextInt(999);
		String tampungCode = "spl" + tampungRandom;
		cs.setNameCustomer(nama);
		cs.setAddressCustomer(lokasi);
		cs.setCustomerCode(tampungCode);
		try {
			custServices.addData(cs);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
