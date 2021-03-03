package com.lawencon.laundry.view;

import java.util.List;
import java.util.Scanner;

import com.lawencon.laundry.model.Roles;
import com.lawencon.laundry.service.RolesService;
import com.lawencon.laundry.util.CallBack;

/**
 *
 * @author Galih Dika
 *
 */

public class RoleView {
	private RolesService roleServices;
	private List<Roles> roles;
	private Roles rls = new Roles();
	private Scanner input = new Scanner(System.in);

	public RoleView(RolesService roleServices) {
		this.roleServices = roleServices;
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
				roles = roleServices.getRoles();
				System.out.println("Id role  | Name role | role Code ");
				roles.forEach(rl -> {
					System.out.printf("|%-8s|%-10s|%-10s\n", rl.getIdRoles(), rl.getNameRoles(), rl.getCodeRoles());

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
		rls.setNameRoles(nama);
		rls.setCodeRoles(code);
		try {
			roleServices.addData(rls);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
