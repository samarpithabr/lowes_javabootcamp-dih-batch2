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
	private Integer source_account_id;
	private Integer target_accound_id;
	private Double amount;

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
	public Integer getSource_account_id() {
		return source_account_id;
	}
	public void setSource_account_id(Integer source_account_id) {
		this.source_account_id = source_account_id;
	}
	public Integer getTarget_accound_id() {
		return target_accound_id;
	}
	public void setTarget_accound_id(Integer target_accound_id) {
		this.target_accound_id = target_accound_id;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
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