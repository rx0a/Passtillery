package com.skilldistillery.accounts.data;

import java.util.List;

import com.skilldistillery.accounts.entities.Account;

public interface AccountDAO {
	
	Account display(int id);

	Account create(Account account);

	Account update(int id, Account account);

	boolean destroy(int id);

	List<Account> find(String keyword);

	List<Account> accounts();
	
}
