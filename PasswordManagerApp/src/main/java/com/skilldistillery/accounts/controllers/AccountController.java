package com.skilldistillery.accounts.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.skilldistillery.accounts.PasswordGenerator;
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

	@RequestMapping(path = "createAccount.do", params = { "action", "name", "username", "password", "url",
			"notes" }, method = RequestMethod.POST)
	public ModelAndView createAccount(String action, String name, String username, String password, String url, String notes,
			Model model) {
		ModelAndView mv = new ModelAndView();
		if (action.equals("Save")) {
		Account account = new Account(name, username, password, url, notes);
		mv.addObject("account", account);
		mv.setViewName("index");
		dao.create(account);
		} else if (action.equals("GeneratePassword")) {
			String securePass = PasswordGenerator.generateStrongPassword();
			Account account = new Account(name, username, securePass, url, notes);
			mv.addObject("account", account);
			mv.setViewName("generate");
		}
		model.addAttribute("accounts", dao.accounts());
		return mv;
	}

	@RequestMapping(path = "showDetails.do", params = "id", method = RequestMethod.POST)
	public ModelAndView showDetails(int id, Model model) {
		ModelAndView mv = new ModelAndView();
		Account account = null;
		account = dao.display(id);
		mv.addObject("account", account);
		mv.setViewName("index");
		model.addAttribute("accounts", dao.accounts());
		return mv;
	}

	@RequestMapping(path = "editAccount.do", params = { "action", "id", "name", "username", "password", "url",
			"notes" }, method = RequestMethod.POST)
	public ModelAndView editAccount(int id, String action, String name, String username, String password, String url,
			String notes, Model model) {
		ModelAndView mv = new ModelAndView();
		if (action.equals("Edit")) {
			mv.addObject("account", dao.display(id));
			mv.setViewName("update");
		} else if (action.equals("Delete")) {
			dao.destroy(id);
			mv.setViewName("index");
		} else if (action.equals("Update")) {
			Account account = new Account(name, username, password, url, notes);
			dao.update(id, account);
			mv.addObject("account", dao.display(id));
			mv.setViewName("index");
		} else if (action.equals("GeneratePassword")) {
			String securePass = PasswordGenerator.generateStrongPassword();
			Account account = new Account(name, username, securePass, url, notes);
			dao.update(id, account);
			mv.addObject("account", dao.display(id));
			mv.setViewName("update");
		}
		model.addAttribute("accounts", dao.accounts());
		return mv;
	}
}
