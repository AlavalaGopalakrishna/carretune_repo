package com.ct.bank.dao;

import java.util.List;
import java.util.Set;

import com.ct.bank.model.Account;
import com.ct.bank.model.Transaction;

public interface AccountDao {

	public long createAccount(Account account);
	
	public Account getAccountDetails(Long accountNo);
	
	public abstract String withdraw(Long accountNo,int withdrawlAmount);
	
	public abstract String deposit(Long accountNo,int depositAmount);
	
	public abstract String fundtransfer(Long fromaccountNo,Long ToAccountNo,int withdrawlAmount);
	
	public abstract List<Transaction> printTransactions();
}
