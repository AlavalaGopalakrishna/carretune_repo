package com.ct.bank.service;

import java.util.List;

import com.ct.bank.dao.AccountDao;
import com.ct.bank.dao.AccountDaoImpl;
import com.ct.bank.model.Account;
import com.ct.bank.model.Transaction;

public class AccountServiceImpl implements AccountService{

	AccountDao dao = new AccountDaoImpl();
	@Override
	public long createAccount(Account account) {
		long accNo = account.getContactNo() - 200000;
		account.setAccNo(accNo);
		return dao.createAccount(account);
	}

	@Override
	public Account getAccountDetails(Long accountNo) {
		
		return dao.getAccountDetails(accountNo);
	}

	@Override
	public String withdraw(Long accountNo, int withdrawlAmount) {
		
		return dao.withdraw(accountNo, withdrawlAmount);
	}

	@Override
	public String deposit(Long accountNo, int depositAmount) {
		
		return dao.deposit(accountNo, depositAmount);
	}

	@Override
	public String fundtransfer(Long fromaccountNo, Long ToAccountNo, int transferAmount) {
	   
		return dao.fundtransfer(fromaccountNo, ToAccountNo, transferAmount);
	}

	@Override
	public List<Transaction> printTransactions() {
		
		return dao.printTransactions();
	}

}
