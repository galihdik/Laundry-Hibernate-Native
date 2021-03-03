package com.lawencon.laundry.view;

import java.util.List;
import java.util.Scanner;

import com.lawencon.laundry.model.Profiles;
import com.lawencon.laundry.service.ProfileService;
import com.lawencon.laundry.util.CallBack;

/**
 *
 * @author Galih Dika
 *
 */

public class ProfileView {
	private ProfileService profServices;
	private List<Profiles> profile;
	private Profiles prof = new Profiles();
	private Scanner input = new Scanner(System.in);

	public ProfileView(ProfileService profServices) {
		this.profServices = profServices;
	}

	void show(CallBack cb) {
		System.out.println("===== Profiles ====");
		System.out.println("1. Create Profiles");
		System.out.println("2. Read Profiles");
		System.out.println("3. Search by Code");
		System.out.println("4. Back");

		System.out.println("Pilih : ");
		byte pilih = input.nextByte();
		if (pilih == 1) {
			addAbout();
			show(cb);
		} else if (pilih == 2) {
			try {
				profile = profServices.getProfiles();
				System.out.println("Id profile  | address | name profile | profile code");
				profile.forEach(prf -> {
					System.out.printf("|%-8s|%-10s|%-10s|%-10s\n", prf.getIdProfiles(), prf.getAddressProfile(),
							prf.getNameProfile(), prf.getProfileCode());

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
		System.out.println("Masukan address : ");
		String address = input.next();
		System.out.println("Masukan name : ");
		String nama = input.next();
		System.out.println("Masukan code : ");
		String code = input.next();
		prof.setAddressProfile(address);
		prof.setNameProfile(nama);
		prof.setProfileCode(code);
		try {
			profServices.addData(prof);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
