package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.model.Account;
@Repository
public interface BankRepo extends JpaRepository<Account, Integer> {

	public Account findByUsernameAndPassword(String username,String password );
	//public Account findByIdAccount(Integer id );
	public Account findByAccno(Long accno );

}
