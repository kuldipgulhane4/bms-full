package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.Account;
import com.app.model.TraHistory;
import com.app.service.AccountServicei;

@RestController
@CrossOrigin("*")
public class AccountController {
	@Autowired
	AccountServicei as;

	@PostMapping("/adddata")
	public Account addData(@RequestBody Account ac) {
		return as.createData(ac);

	}

	@GetMapping("/login/{un}/{pass}")
	public Account login(@PathVariable("un") String username, @PathVariable("pass") String password) {

		return as.login(username, password);
	}

	@GetMapping("/checkbalance/{accno}")
	public Double checkBalance(@PathVariable Long accno) {

		Double a = as.checkBalance(accno);
		System.out.println("Account balance is: " + a);
		return a;
	}

	@GetMapping("/deposite/{accno}/{amount}")
	public Account deposteMoney(@PathVariable Long accno, @PathVariable Double amount) {
		return as.depositMoney(accno, amount);

	}

	@GetMapping("/withdraw/{accno}/{amount}")
	public Account withdrawMoney(@PathVariable Long accno, @PathVariable Double amount) {
		return as.withdrawMoney(accno, amount);

	}

	@GetMapping("/bankstatement/{accno}")
	public List<TraHistory> accountStatement(@PathVariable Long accno) {
		List<TraHistory> tl = as.viewTransactionHistory(accno);
		return tl;

	}

	@GetMapping("/searchac/{accno}")
	public Account searchAccount(@PathVariable Long accno) {
		Account a = as.searchCustomer(accno);
		return a;

	}

	@GetMapping("/viewall")
	public List<Account> viewcustomer() {
		List<Account> a = as.viewAllCustomerDetails();
		return a;

	}

	@PutMapping("/update/{accno}")
	public Account updateCustomer(@PathVariable Long accno, @RequestBody Account a) {
		return as.updateCustomerDetails(accno, a);
	}

	@GetMapping("/getsingle/{id}")
	public Account getSingleCustomer(@PathVariable Integer id) {
		return as.getCustomer(id);
	}

}
