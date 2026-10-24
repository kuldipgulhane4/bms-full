package com.app.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.autoconfigure.web.WebProperties.Resources.Chain.Strategy;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;


@Entity
public class Account {
     @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private Long accno;
	private String name;
	
	private String dob;
	private Long contact;
	private Integer age;
	private String gender;
	private String accountType;
	private Double balance;
	private String username;
	private String password;
	@OneToMany(cascade = CascadeType.ALL)
	private List<TraHistory> tlist=new ArrayList<>();
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Long getAccno() {
		return accno;
	}
	public void setAccno(Long accno) {
		this.accno = accno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public Long getContact() {
		return contact;
	}
	public void setContact(Long contact) {
		this.contact = contact;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<TraHistory> getTlist() {
		return tlist;
	}
	public void setTlist(List<TraHistory> tlist) {
		this.tlist = tlist;
	}
	@Override
	public String toString() {
		return "Account [id=" + id + ", accno=" + accno + ", name=" + name + ", dob=" + dob + ", contact=" + contact
				+ ", age=" + age + ", gender=" + gender + ", accountType=" + accountType + ", balance=" + balance
				+ ", username=" + username + ", password=" + password + ", tlist=" + tlist + "]";
	}
	
	
		
}
