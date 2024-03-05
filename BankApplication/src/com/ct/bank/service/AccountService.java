package com.ct.bank.service;

import java.util.List;

import com.ct.bank.model.Account;
import com.ct.bank.model.Transaction;

public interface AccountService {

	public abstract long createAccount(Account account);

	public abstract Account getAccountDetails(Long accountNo);

	public abstract String withdraw(Long accountNo, int withdrawlAmount);

	public abstract String deposit(Long accountNo, int depositAmount);

	public abstract String fundtransfer(Long fromaccountNo, Long ToAccountNo, int transferAmount);

	public abstract List<Transaction> printTransactions();

}
