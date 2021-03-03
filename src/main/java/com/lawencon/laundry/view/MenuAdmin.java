package com.lawencon.laundry.view;

import java.util.Scanner;

import com.lawencon.laundry.util.CallBack;

/**
 *
 * @author Galih Dika
 *
 */

public class MenuAdmin {
	private AboutView aboutView;
	private CustomerView customerView;
	private ParfumeView parfumeView;
	private PaymentView paymentView;
	private ProfileView profileView;
	private RoleView roleView;
	private ServiceView serviceView;
	private UserView userView;
	private History history;

	public MenuAdmin(AboutView aboutView, CustomerView customerView, ParfumeView parfumeView, PaymentView paymentView,
			ProfileView profileView, RoleView roleView, ServiceView serviceView, UserView userView, History history) {
		this.aboutView = aboutView;
		this.customerView = customerView;
		this.parfumeView = parfumeView;
		this.paymentView = paymentView;
		this.profileView = profileView;
		this.roleView = roleView;
		this.serviceView = serviceView;
		this.userView = userView;
		this.history = history;
	}

	void show(CallBack cb) {
		Scanner input = new Scanner(System.in);
		System.out.println("============ Menu Admin ==================");
		System.out.println("1. CRUD About");
		System.out.println("2. CRUD Customer");
		System.out.println("3. CRUD Parfumes");
		System.out.println("4. CRUD Payments");
		System.out.println("5. CRUD Profiles");
		System.out.println("6. CRUD Roles");
		System.out.println("7. CRUD Services");
		System.out.println("8. CRUD Users");
		System.out.println("9. History");
		System.out.println("10. Logout");
		System.out.println("Pilih Menu : ");
		byte menu = input.nextByte();
		if (menu == 1) {
			aboutView.show(val -> {
				show(cb);
			});
		} else if (menu == 2) {
			customerView.show(val -> {
				show(cb);
			});

		} else if (menu == 3) {
			parfumeView.show(val -> {
				show(cb);
			});
		} else if (menu == 4) {
			paymentView.show(val -> {
				show(cb);
			});
		} else if (menu == 5) {
			profileView.show(val -> {
				show(cb);
			});
		} else if (menu == 6) {
			roleView.show(val -> {
				show(cb);
			});
		} else if (menu == 7) {
			serviceView.show(val -> {
				show(cb);
			});
		} else if (menu == 8) {
			userView.show(val -> {
				show(cb);
			});
		} else if (menu == 9) {
			history.show(val -> {
				show(cb);
			});
		} else if (menu == 10) {
			cb.onDone("");
		}
	}
}
