package com.lawencon.laundry.view;

import java.util.List;
import java.util.Scanner;

import com.lawencon.laundry.model.Payments;
import com.lawencon.laundry.service.PaymentsService;
import com.lawencon.laundry.util.CallBack;

/**
 *
 * @author Galih Dika
 *
 */

public class PaymentView {
	private PaymentsService paymServices;
	private List<Payments> payment;
	private Payments paym = new Payments();
	private Scanner input = new Scanner(System.in);

	public PaymentView(PaymentsService paymServices) {
		this.paymServices = paymServices;
	}

	void show(CallBack cb) {
		System.out.println("===== Payment ====");
		System.out.println("1. Create Payment");
		System.out.println("2. Read Payment");
		System.out.println("3. Search by Code");
		System.out.println("4. Back");

		System.out.println("Pilih : ");
		byte pilih = input.nextByte();
		if (pilih == 1) {
			addAbout();
			show(cb);
		} else if (pilih == 2) {
			try {
				payment = paymServices.getPayment();
				System.out.println("Id payment  | Name payment | payment Code ");
				payment.forEach(py -> {
					System.out.printf("|%-8s|%-10s|%-10s\n", py.getIdPayments(), py.getNamePayments(),
							py.getPaymentsCode());

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
		System.out.println("Masukan code : ");
		String code = input.next();
		paym.setNamePayments(nama);
		paym.setPaymentsCode(code);
		try {
			paymServices.addData(paym);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
