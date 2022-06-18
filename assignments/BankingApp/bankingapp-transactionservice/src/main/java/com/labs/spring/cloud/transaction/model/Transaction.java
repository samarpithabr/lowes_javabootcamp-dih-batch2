package com.labs.spring.cloud.transaction.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Transaction {
	@Id
	int id;
	String status;
	String type;
	String description;
	double amount;
	Account AccountNumber;
	public int getId() {
		return id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Account getAccountNumber() {
		return AccountNumber;
	}
	public void setAccountNumber(Account accountNumber) {
		AccountNumber = accountNumber;
	}
}
