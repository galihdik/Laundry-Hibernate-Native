package com.lawencon.laundry.view;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.lawencon.laundry.model.About;
import com.lawencon.laundry.service.AboutService;
import com.lawencon.laundry.util.CallBack;

/**
 *
 * @author Galih Dika
 *
 */

public class AboutView {
	private AboutService aboutServices;
	private List<About> about;
	private About abt = new About();
	private Scanner input = new Scanner(System.in);

	public AboutView(AboutService aboutServices) {
		this.aboutServices = aboutServices;
	}

	void show(CallBack cb) {
		System.out.println("===== About ====");
		System.out.println("1. Create About");
		System.out.println("2. Read About");
		System.out.println("3. Search by Code");
		System.out.println("4. Back");

		System.out.println("Pilih : ");
		byte pilih = input.nextByte();
		if (pilih == 1) {
			addAbout();
			show(cb);
		} else if (pilih == 2) {
			try {
				about = aboutServices.getAbout();
				System.out.println("User Id  | Name     | Location");
				about.forEach(abt -> {
					System.out.printf("|%-8s|%-10s|%-10s\n", abt.getIdAbout(), abt.getNameAbout(),
							abt.getLocationAbout());

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
		System.out.println("Masukan lokasi : ");
		String lokasi = input.next();
		Random random = new Random();
		int tampungRandom = random.nextInt(999);
		String tampungCode = "spl" + tampungRandom;
		abt.setNameAbout(nama);
		abt.setLocationAbout(lokasi);
		abt.setAboutCode(tampungCode);
		try {
			aboutServices.addData(abt);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
