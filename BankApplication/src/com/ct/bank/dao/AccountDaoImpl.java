package com.ct.bank.dao;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import com.ct.bank.exception.AccountNotFound;
import com.ct.bank.model.Account;
import com.ct.bank.model.Transaction;

public class AccountDaoImpl implements AccountDao {

	HashMap<Long, Account> accounts = new HashMap<>();
	HashMap<Integer, Transaction> transactions = new HashMap<>();
	int transactionId = 0;

	@Override
	public long createAccount(Account account) {
		accounts.put(account.getAccNo(), account);
		return account.getAccNo();
	}

	@Override
	public Account getAccountDetails(Long accountNo) {
		Account account=accounts.get(accountNo);
		if(account!=null)
		    return account;
		else
			throw new AccountNotFound("Enter Valid Account Number");		
	}

	@Override
	public String withdraw(Long accountNo, int withdrawlAmount) {
		Account account = accounts.get(accountNo);
		if (account !=null && account.getBalance() > withdrawlAmount) {
		int balance = account.getBalance();//2000
		
		int updatedBalance = balance - withdrawlAmount;//3000
		account.setBalance(updatedBalance);
		accounts.put(accountNo, account);
		Transaction trans = new Transaction(transactionId++, accountNo, 0, "withdraw", LocalDateTime.now(), balance,
				updatedBalance);
		transactions.put(transactionId, trans);
		return "After Withdraw your updated balance :" + updatedBalance;
	}
		else
			throw new AccountNotFound("Enter Valid Account Number");
	}
	@Override
	public String deposit(Long accountNo, int depositAmount) {
		Account account = accounts.get(accountNo);
		int balance = account.getBalance();
		int updatedBalance = account.getBalance() - depositAmount;
		account.setBalance(updatedBalance);
		accounts.put(accountNo, account);
		Transaction trans = new Transaction(transactionId++, accountNo, 0, "withdraw", LocalDateTime.now(), balance,
				updatedBalance);
		transactions.put(transactionId, trans);
		return "After Deposit your updated balance :" + updatedBalance;
	}

	@Override
	public String fundtransfer(Long fromaccountNo, Long ToAccountNo, int transferAmount) {
		Account fromAccount = accounts.get(fromaccountNo);
		int balance = fromAccount.getBalance();
		int fromUpdatedBalance = fromAccount.getBalance() - transferAmount;
		Account toAccount = accounts.get(ToAccountNo);
		int toUpdatedBalance = toAccount.getBalance() + transferAmount;
		fromAccount.setBalance(fromUpdatedBalance);
		toAccount.setBalance(toUpdatedBalance);
		accounts.put(fromaccountNo, fromAccount);
		accounts.put(ToAccountNo, toAccount);
		Transaction trans = new Transaction(transactionId++, fromaccountNo, ToAccountNo, "fundtransfer",
				LocalDateTime.now(), balance, fromUpdatedBalance);
		transactions.put(transactionId, trans);
		return "After Fundtransfer updated balance :" + fromUpdatedBalance;
	}

	@Override
	public List<Transaction> printTransactions() {
		Set<Entry<Integer, Transaction>> trans = transactions.entrySet();
		Iterator<Entry<Integer, Transaction>> itr = trans.iterator();
		ArrayList<Transaction> al=new ArrayList<Transaction>();
        while(itr.hasNext()) 
        {
        	Entry<Integer,Transaction> result = itr.next();
        	
        	al.add(result.getValue());
        }
		return al;
	}

}
