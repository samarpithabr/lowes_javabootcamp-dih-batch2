package com.labs.spring.cloud.fundservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="funds_transfer")
public class FundTransfer {

	@Id
	@GeneratedValue
	private int id;
	private String description;
	private Integer sourceAccountId;
	private Integer destinationAccountId;
	private Double amount;
	private Integer	transactionId;
	private String status;
	private String type;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getSourceAccountId() {
		return sourceAccountId;
	}
	public void setSourceAccountId(Integer sourceAccountId) {
		this.sourceAccountId = sourceAccountId;
	}
	public Integer getDestinationAccountId() {
		return destinationAccountId;
	}
	public void setDestinationAccountId(Integer destinationAccountId) {
		this.destinationAccountId = destinationAccountId;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public Integer getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(Integer transactionId) {
		this.transactionId = transactionId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}


}