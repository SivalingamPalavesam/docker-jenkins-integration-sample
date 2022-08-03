package com.docker.entity.postgres;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="account")
public class Account {

	@Id
	@Column(name = "id")
	private Integer id;
	@Column(name = "balance")
	private Double balance;

	@Column(name = "account_name")
	private String accountName;

	@Column(name = "date_opened")
	private String dateOpened;

	public Account() {
		super();
	}

	public Account(Integer id, Double balance, String accountName, String dateOpened) {
		super();
		this.id = id;
		this.balance = balance;
		this.accountName = accountName;
		this.dateOpened = dateOpened;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getDateOpened() {
		return dateOpened;
	}

	public void setDateOpened(String dateOpened) {
		this.dateOpened = dateOpened;
	}
}