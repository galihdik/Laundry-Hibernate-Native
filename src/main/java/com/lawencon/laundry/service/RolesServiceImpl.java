package com.lawencon.laundry.service;

import java.util.List;

import org.springframework.transaction.support.TransactionTemplate;

import com.lawencon.laundry.dao.RolesDao;
import com.lawencon.laundry.model.Roles;

/**
 *
 * @author Galih Dika
 *
 */

public class RolesServiceImpl extends BaseService implements RolesService {
	private RolesDao rolesDao;
	private TransactionTemplate transactionTemplate;

	public RolesServiceImpl(RolesDao rolesDao, TransactionTemplate transactionTemplate) {
		this.rolesDao = rolesDao;
		this.transactionTemplate = transactionTemplate;
	}

	@Override
	public List<Roles> getRoles() throws Exception {
		return getTransactionTemplate().execute(val -> {
			try {
				rolesDao.getListRoles();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		});
	}

	@Override
	public void addData(Roles rl) throws Exception {
		getTransactionTemplate().execute(val -> {
			try {
				rolesDao.insertData(rl);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		});
	}

	@Override
	public Roles getCode(String code) throws Exception {
		return getTransactionTemplate().execute(val -> {
			try {
				rolesDao.getCode(code);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		});
	}

}
