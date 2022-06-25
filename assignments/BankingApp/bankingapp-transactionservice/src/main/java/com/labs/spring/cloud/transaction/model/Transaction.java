package com.labs.spring.cloud.transaction.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "transaction")
public class Transaction {

	@Id
	@GeneratedValue
	private Integer id;  //transaction Id	
	private int fromaccountid; //acct if from which the transaction is happening
	private int toaccountid;
	private double amount; //amt to be transacted
	private String type; //debit or credit type
	private String status; //approved/rejected status
	private String description; // transaction description

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
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

	public int getFromaccountid() {
		return fromaccountid;
	}

	public void setFromaccountid(int fromaccountid) {
		this.fromaccountid = fromaccountid;
	}

	public int getToaccountid() {
		return toaccountid;
	}

	public void setToaccountid(int toaccountid) {
		this.toaccountid = toaccountid;
	}	

}