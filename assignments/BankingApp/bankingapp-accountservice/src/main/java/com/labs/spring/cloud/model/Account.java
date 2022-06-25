package com.labs.spring.cloud.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
//@XmlRootElement
@Entity
//@Table(name = "account")
public class Account {
	@Id
	@GeneratedValue
	private Integer id;
	@NotEmpty
	private String name;
	
	// @Enumerated(EnumType.STRING)
	// private AccountType type;
	private String type;
	
	// @Enumerated(EnumType.STRING)
	// private AccountStatus status;
	private String status;

	private double balance;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

//	public void setType(AccountType type) {
//		this.type = type;
//	}
//
//	public void setStatus(AccountStatus status) {
//		this.status = status;
//	}

}