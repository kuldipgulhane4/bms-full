package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.app.model.Account;
import com.app.model.TraHistory;
import com.app.repository.BankRepo;

public interface AccountServicei {
	
	//Customer Module
	
	public Account createData(Account ac);
	public Account login(String username,String password);//customer+admin
	public Account getCustomer(Integer id);
	public Double checkBalance(Long accno);
	public Account depositMoney(Long accno,Double amount);
	public Account withdrawMoney(Long accno,Double amount);
	public List<TraHistory> viewTransactionHistory(Long accno);
//	
//	//Admin Module
//	
public Account searchCustomer(Long accno);
	public List<Account> viewAllCustomerDetails();
	public Account updateCustomerDetails(Long accno,Account ac);
	

}
