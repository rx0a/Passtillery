package com.skilldistillery.accounts.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.skilldistillery.accounts.entities.Account;

@Service
@Transactional
public class AccountDAOJPAImpl implements AccountDAO {

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("AccountPU");
	
	@Override
	public Account display(int id) {
		EntityManager em = emf.createEntityManager();
		return em.find(Account.class, id);
	}

	@Override
	public List<Account> accounts() {
		EntityManager em = emf.createEntityManager();
		String jpql = "SELECT a FROM Account a";
		List<Account> accounts = em.createQuery(jpql, Account.class).getResultList();
		return accounts;
	}

	@Override
	public List<Account> find(String keyword) {
		EntityManager em = emf.createEntityManager();
		String jpql = "SELECT a FROM Account a WHERE a.name LIKE :k OR a.username LIKE :k OR a.notes LIKE :k OR a.url LIKE :k";
		keyword = "%" + keyword + "%";
		List<Account> accounts = em.createQuery(jpql, Account.class).setParameter("k", keyword).getResultList();
		return accounts;
	}

	@Override
	public Account create(Account account) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(account);
		em.flush();
		em.getTransaction().commit();
		em.close();
		return account;
	}

	@Override
	public Account update(int id, Account account) {
		EntityManager em = emf.createEntityManager();
		Account dbAccount = em.find(Account.class, id);
		em.getTransaction().begin();
		dbAccount.setName(account.getName());
		dbAccount.setUsername(account.getUsername());
		dbAccount.setPassword(account.getPassword());
		dbAccount.setUrl(account.getUrl());
		dbAccount.setNotes(account.getNotes());
		em.persist(account);
		em.flush();
		em.getTransaction().commit();
		em.close();
		return dbAccount;
	}

	@Override
	public boolean destroy(int id) {
		EntityManager em = emf.createEntityManager();
		Account account = em.find(Account.class, id);
		em.getTransaction().begin();
		em.remove(account);
		boolean deleted = !em.contains(account);
		em.getTransaction().commit();
		em.close();
		return deleted;
	}
}
