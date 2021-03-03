package com.lawencon.laundry.view;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.lawencon.laundry.model.DetailTransactions;
import com.lawencon.laundry.model.Parfumes;
import com.lawencon.laundry.model.Payments;
import com.lawencon.laundry.model.Services;
import com.lawencon.laundry.model.Transactions;
import com.lawencon.laundry.model.Users;
import com.lawencon.laundry.service.ParfumeService;
import com.lawencon.laundry.service.ServService;
import com.lawencon.laundry.service.TransactionService;
import com.lawencon.laundry.util.CallBack;

/**
 *
 * @author Galih Dika
 *
 */

public class MenuCashier {
	private Users user;
	private List<DetailTransactions> detailList = new ArrayList<>();
	private Scanner input = new Scanner(System.in);
	private Scanner input2 = new Scanner(System.in);
	private TransactionService transactionService;
	private ParfumeService parfServ;
	private Integer kuantiti;
	private BigDecimal tampungDetailPrice = BigDecimal.ZERO;
	private BigDecimal tampungDetailPriceTotal = BigDecimal.ZERO;
	private ServService servService;
	private Transactions transactions = new Transactions();
	private Random random = new Random();

	public MenuCashier(TransactionService transactionService, ParfumeService parfServ, ServService servService) {
		this.transactionService = transactionService;
		this.parfServ = parfServ;
		this.servService = servService;
	}

	void show(CallBack cb) {
		this.user = user;
		System.out.println("============ Menu  Cashier ==================");
		System.out.println("1. Input Laundry");
		System.out.println("2. Logout");
		System.out.println("Masukan menu : ");
		byte pilihMenu = input.nextByte();
		if (pilihMenu == 1) {
			addLaundry();
			show(cb);
		} else if (pilihMenu == 2) {
			cb.onDone("");
		}
	}

	void addLaundry() {
		DetailTransactions detailTransactions = new DetailTransactions();
		System.out.println("input nama barang : ");
		String namaBarang = input2.nextLine();
		System.out.println("input jumlah barang : ");
		kuantiti = input.nextInt();
		System.out.println("Masukan total berat :");
		BigDecimal weight = input.nextBigDecimal();
		System.out.println("Masukan kode service");
		String code = input2.nextLine();
		System.out.println("Masukan code parfume yang diinginkan");
		String parfume = input2.nextLine();
		try {
			Services service = servService.getCode(code);
			detailTransactions.setIdServices(service);
			detailTransactions.setPriceDetail(service.getPriceServices());
			System.out.println(service.getPriceServices());
			tampungDetailPrice = service.getPriceServices();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			Parfumes parfum = parfServ.getCode(parfume);
			detailTransactions.setIdParfume(parfum);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (code.equalsIgnoreCase("service1")) {
			tampungDetailPrice = tampungDetailPrice.multiply(BigDecimal.valueOf(kuantiti));
		} else if (code.equalsIgnoreCase("service2")) {
			tampungDetailPrice = tampungDetailPrice.multiply(weight);
		}
		System.out.println(tampungDetailPrice);
		System.out.println(user.getUserId());
		tampungDetailPriceTotal = tampungDetailPriceTotal.add(tampungDetailPrice);
		detailTransactions.setQty(kuantiti);
		detailTransactions.setNameItem(namaBarang);
		detailTransactions.setWeight(weight);
		int tampungRandom = random.nextInt(99999);
		String tampungCode = "trx" + tampungRandom;
		detailTransactions.setCodeDetail(tampungCode);
		detailList.add(detailTransactions);
		transactions.setDetailTransactions(detailList);
		System.out.println("Ingin ulang ? (Y/N) : ");
		String ulang = input.next();
		if (ulang.equalsIgnoreCase("Y")) {
			System.out.println("Barang berhasil ditambah");
			addLaundry();
		} else if (ulang.equalsIgnoreCase("n")) {
			addPayment();
		}
	}

	void addPayment() {
		System.out.println("Harga anda totalnya : " + tampungDetailPriceTotal);
		System.out.println("Ingin bayar pakai apa? (Cash/Cashless)");
		System.out.println("Pilih :");
		String pilih = input.next();
		int tampungRandom = random.nextInt(99999);
		String tampungCode = "trx" + tampungRandom;
		transactions.setIdUsers(user);
		transactions.setStruk(tampungCode);
		Payments payment = new Payments();
		if (pilih.equalsIgnoreCase("cash")) {
			payment.setPaymentsCode("cash");
			transactions.setIdPayments(payment);
			System.out.println("Anda memilih cash");
			System.out.println("Silahkan Bayar : ");
			Integer bayar = input.nextInt();
			if (bayar < tampungDetailPriceTotal.intValue()) {
				System.out.println("Anda bayarnya kurang !");
				addPayment();
			} else
				System.out.println("Kembalian anda : " + (bayar - tampungDetailPrice.intValue()));
			try {
				transactionService.addData(detailList, transactions);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (pilih.equalsIgnoreCase("cashless")) {
			payment.setPaymentsCode("cashless");
			transactions.setIdPayments(payment);
			System.out.println("Anda memilih Cashless");
			try {
				transactionService.addData(detailList, transactions);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("Pembayaran anda telah diambil, terima kasih");
		}
	}
}
