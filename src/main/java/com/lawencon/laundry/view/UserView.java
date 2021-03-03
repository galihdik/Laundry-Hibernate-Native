package com.lawencon.laundry.view;

import java.util.List;
import java.util.Scanner;

import com.lawencon.laundry.model.Profiles;
import com.lawencon.laundry.model.Roles;
import com.lawencon.laundry.model.Users;
import com.lawencon.laundry.service.UsersServices;
import com.lawencon.laundry.util.CallBack;

/**
 *
 * @author Galih Dika
 *
 */

public class UserView {
	private UsersServices userServices;
	private List<Users> user;
	private Users usr = new Users();
	private Scanner input = new Scanner(System.in);
	private Scanner input2 = new Scanner(System.in);

	public UserView(UsersServices userServices) {
		this.userServices = userServices;
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
				user = userServices.getUsers();
				System.out.println("Id User  | Username | Password | id roles | id profile | user code");
				user.forEach(us -> {
					System.out.printf("|%-8s|%-10s|%-10s|%-10s|%-10s|%-10s\n", us.getUserId(), us.getUsername(),
							us.getPswd(), us.getIdRoles().getIdRoles(), us.getIdProfiles().getIdProfiles(),
							us.getUserCode());

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
		System.out.println("Masukan username : ");
		String nama = input.next();
		System.out.println("Masukan pswd : ");
		String pswd = input.next();
		System.out.println("Masukan id roles : ");
		Integer idRoles = input2.nextInt();
		System.out.println("Masukan id profile : ");
		Integer idProfile = input2.nextInt();
		System.out.println("Masukan code : ");
		String code = input.next();
		usr.setUsername(nama);
		usr.setPswd(pswd);
		Roles rl = new Roles();
		rl.setIdRoles(idRoles.longValue());
		usr.setIdRoles(rl);
		Profiles prf = new Profiles();
		prf.setIdProfiles(idProfile.longValue());
		usr.setIdProfiles(prf);
		usr.setUserCode(code);
		try {
			userServices.addData(usr);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
