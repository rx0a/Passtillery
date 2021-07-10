package com.skilldistillery.accounts.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.skilldistillery.accounts.data.AccountDAO;
import com.skilldistillery.accounts.entities.Account;

@Controller
public class AccountController {
	@Autowired
	private AccountDAO dao;

	@RequestMapping(path = { "/", "index.do" })
	public String index(Model model) {
		model.addAttribute("accounts", dao.accounts());
		return "index";
	}
	
	@RequestMapping(path = "getAccount.do", params = "keyword", method = RequestMethod.POST)
	public String getAccount(String keyword, Model model) {
		model.addAttribute("accounts", dao.find(keyword));
		return "index";
	}
	
	@RequestMapping(path = "createAccount.do", params = { "name", "username", "password", "url", "notes" }, method = RequestMethod.POST)
	public String createAccount(String name, String username, String password, String url, String notes, Model model) {
		String favicon = url + "/favicon.ico";
		Account account = new Account(name, username, password, url, notes, favicon);
		dao.create(account);
		model.addAttribute("accounts", dao.accounts());
		return "index";
	}
	
	@RequestMapping(path = "editAccount.do", params = { "action", "id", "name", "username", "password", "url", "notes" }, method = RequestMethod.POST)
	public String editAccount(int id, String action, String name, String username, String password, String url, String notes, Model model) {
		if (action.equals("Edit")) {
			Account account = new Account(name, username, password, url, notes);
			dao.update(id, account);
		} else if (action.equals("Delete")) {
			dao.destroy(id);
		}
		model.addAttribute("accounts", dao.accounts());
		return "index";
	}
	
	@RequestMapping(path = "showDetails.do", params = "id", method = RequestMethod.POST )
	public ModelAndView showDetails(int id, Model model) {
		ModelAndView mv = new ModelAndView();
		Account account = null;
		System.out.println("this is the id: " + id);
		account = dao.display(id);
		mv.addObject("account", account);
		mv.setViewName("index");
		model.addAttribute("accounts", dao.accounts());
		return mv;
	}
	
//	@RequestMapping(path = "updateAccount.do", params = { "id", "name", "username", "password", "url", "notes" }, method = RequestMethod.POST)
//	public String updateAccount(int id, String name, String username, String password, String url, String notes, Model model) {
//		Account account = new Account(name, username, password, url, notes);
//		dao.update(id, account);
//		model.addAttribute("accounts", dao.accounts());
//		return "index";
//	}
//
//	@RequestMapping(path = "destroyAccount.do", params = { "id" }, method = RequestMethod.POST)
//	public String destroyAccount(int id, Model model) {
//		dao.destroy(id);
//		model.addAttribute("accounts", dao.accounts());
//		return "index";
//	}
}
