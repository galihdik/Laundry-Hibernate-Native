package com.lawencon.laundry.view;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import com.lawencon.laundry.model.DetailTransactions;
import com.lawencon.laundry.model.Transactions;
import com.lawencon.laundry.service.TransactionService;
import com.lawencon.laundry.util.CallBack;

/**
 *
 * @author Galih Dika
 *
 */

public class History {
	private TransactionService transactionServices;
	private List<Transactions> transaction;
	private List<DetailTransactions> dTransaction;
	private Scanner input = new Scanner(System.in);
	private Scanner input2 = new Scanner(System.in);

	public History(TransactionService transactionServices) {
		this.transactionServices = transactionServices;
	}

	void show(CallBack cb) {
		System.out.println("===== History ====");
		System.out.println("1. Read History");
		System.out.println("2. Update pemulangan Laundry");
		System.out.println("3. Back");
		System.out.println("Pilih : ");
		byte pilih = input.nextByte();
		if (pilih == 1) {
			try {
				transaction = transactionServices.getTransaction();
				System.out.println(
						"Id Transaction  | Transaction Date | Price Total | Id Payment | Id User | Id About |Struk Code | Id Customer");
				transaction.forEach(trx -> {
					System.out.printf("|%-15s|%-15s|%-10s|%-15s|%-10s|%-10s|%-10s|%-10s\n", trx.getIdTransactions(),
							trx.getTransactionDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),
							trx.getPriceTotal(), trx.getIdPayments().getIdPayments(), trx.getIdUsers().getUserId(),
							trx.getIdAbout().getIdAbout(), trx.getStruk(), trx.getIdCustomer().getIdCustomer());

				});
			} catch (Exception e) {
				e.printStackTrace();
			}
			show(cb);
		} else if (pilih == 2) {
			try {
				dTransaction = transactionServices.getTransactionDetail();
				System.out.println(
						"Id Detail Transaction  | Kuantiti | Id transaction | Id Service | Id Parfume | weight  | price dtl  |     Return Time    | Name item | code detail");
				dTransaction.forEach(val -> {
					if (val.getReturnTime() != null) {
						System.out.printf("|%-22s|%-10s|%-15s|%-15s|%-10s|%-9s|%-12s|%-15s|%-11s|%-13s\n",
								val.getIdDetailTransactions(), val.getQty(),
								val.getIdTransactions().getIdTransactions(), val.getIdServices().getIdServices(),
								val.getIdParfume().getIdParfume(), val.getWeight(), val.getPriceDetail(),
								val.getReturnTime() != null
										? val.getReturnTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
										: "",
								val.getNameItem(), val.getCodeDetail());
					}

				});
				System.out.println("Masukan kode detail transaksi : ");
				String code = input2.nextLine();
				transactionServices.updateDetailTime(code);
				System.out.println("Data berhasil diupdate");
			} catch (Exception e) {
				e.printStackTrace();
			}
			show(cb);
		} else if (pilih == 3) {
			cb.onDone("");
		}
	}
}
