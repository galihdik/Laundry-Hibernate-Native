package com.lawencon.laundry.view;

import java.util.Scanner;

import com.lawencon.laundry.model.UserSessionCache;
import com.lawencon.laundry.model.Users;
import com.lawencon.laundry.service.UsersServices;
import com.lawencon.laundry.util.CallBack;

/**
 *
 * @author Galih Dika
 *
 */

public class Login {
	private UsersServices usrServ;
	private MenuAdmin menuAdmin;
	private MenuCashier menuCashier;
	private UserSessionCache usrCache;

	public Login(UsersServices usrServ, MenuAdmin menuAdmin, MenuCashier menuCashier, UserSessionCache usrCache) {
		this.usrServ = usrServ;
		this.menuAdmin = menuAdmin;
		this.menuCashier = menuCashier;
		this.usrCache = usrCache;
	}

	void show(CallBack cb) {
		Scanner input = new Scanner(System.in);
		System.out.println("============ Silahkan Login ==================");
		System.out.println("=== Silahkan Login ===");
		System.out.println("Masukan Username");
		String username = input.nextLine();
		System.out.println("Masukan Password");
		String pswd = input.nextLine();
		try {
			Users user = usrServ.loginUser(username, pswd);
			System.out.println(user);
			if (user.getIdRoles().getCodeRoles().equalsIgnoreCase("1")) {
				usrCache.setActiveUser(user);
				menuAdmin.show(val -> {
					show(cb);
				});
			} else if (user.getIdRoles().getCodeRoles().equalsIgnoreCase("2")) {
				usrCache.setActiveUser(user);
				menuCashier.show(val -> {
					show(cb);
				});
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("User tidak ada !!");
			show(cb);
		}
	}
}
