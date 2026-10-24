package com.app.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.Account;
import com.app.model.TraHistory;
import com.app.repository.BankRepo;

@Service
public class AccountServiceimpl implements AccountServicei {
	@Autowired
	BankRepo br;

	@Override
	public Account createData(Account ac) {
		System.out.println("account created Successfully..!!");
		return br.save(ac);

	}

	@Override
	public Account login(String username, String password) {

		return br.findByUsernameAndPassword(username, password);

	}

	@Override
	public Double checkBalance(Long accno) {
		Account a = br.findByAccno(accno);
		Double bal = a.getBalance();
		System.out.println("Account Balance is: " + bal);
		return bal;
	}

	@Override
	public Account depositMoney(Long accno, Double amount) {
		Account ac = br.findByAccno(accno);

		Double oldbal = ac.getBalance();

		ac.setBalance(oldbal + amount);

		TraHistory th = new TraHistory();
		th.setTraType("deposite");
		th.setTraAmount(amount);
		th.setTraDate(LocalDate.now().toString());
		ac.getTlist().add(th);

		br.save(ac);
		return ac;
	}

	@Override
	public Account withdrawMoney(Long accno, Double amount) {

		Account ac = br.findByAccno(accno);

		Double oldbal = ac.getBalance();

		ac.setBalance(oldbal - amount);

		TraHistory th = new TraHistory();
		th.setTraType("withdraw");
		th.setTraAmount(amount);
		th.setTraDate(LocalDate.now().toString());
		ac.getTlist().add(th);

		br.save(ac);
		return ac;

	}

	@Override
	public List<TraHistory> viewTransactionHistory(Long accno) {
		Account a = br.findByAccno(accno);
		return a.getTlist();
	}

	@Override
	public Account searchCustomer(Long accno) {
		return br.findByAccno(accno);

	}

	@Override
	public List<Account> viewAllCustomerDetails() {
		return br.findAll();

	}

	@Override
	public Account updateCustomerDetails(Long accno, Account ac) {
		Account old = br.findByAccno(accno);
		old.setAccno(ac.getAccno());
		old.setAccountType(ac.getAccountType());
		old.setAge(ac.getAge());
		old.setBalance(ac.getBalance());
		old.setContact(ac.getContact());
		old.setDob(ac.getDob());
		old.setName(ac.getName());
		old.setPassword(ac.getPassword());
		old.setTlist(ac.getTlist());
		old.setUsername(ac.getUsername());
		br.save(old);
		return old;
	}

	@Override
	public Account getCustomer(Integer id) {
		Optional<Account> ac = br.findById(id);
		if (ac.isPresent()) {
			return ac.get();
		}
		return null;
	}

}
