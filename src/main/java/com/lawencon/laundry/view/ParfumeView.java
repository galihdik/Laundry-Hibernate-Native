package com.lawencon.laundry.view;

import java.util.List;
import java.util.Scanner;

import com.lawencon.laundry.model.Parfumes;
import com.lawencon.laundry.service.ParfumeService;
import com.lawencon.laundry.util.CallBack;

/**
 *
 * @author Galih Dika
 *
 */

public class ParfumeView {
	private ParfumeService parfServices;
	private List<Parfumes> parfume;
	private Parfumes parf = new Parfumes();
	private Scanner input = new Scanner(System.in);

	public ParfumeView(ParfumeService parfServices) {
		this.parfServices = parfServices;
	}

	void show(CallBack cb) {
		System.out.println("===== Parfume ====");
		System.out.println("1. Create Parfume");
		System.out.println("2. Read Parfume");
		System.out.println("3. Search by Code");
		System.out.println("4. Back");

		System.out.println("Pilih : ");
		byte pilih = input.nextByte();
		if (pilih == 1) {
			addAbout();
			show(cb);
		} else if (pilih == 2) {
			try {
				parfume = parfServices.getParfumes();
				System.out.println("Id parfume  | Name parfume | parfume Code ");
				parfume.forEach(prf -> {
					System.out.printf("|%-8s|%-10s|%-10s\n", prf.getIdParfume(), prf.getNameParfume(),
							prf.getParfumeCode());

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
		parf.setNameParfume(nama);
		parf.setParfumeCode(code);
		try {
			parfServices.addData(parf);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
