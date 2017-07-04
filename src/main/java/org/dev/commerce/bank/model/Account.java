package org.dev.commerce.bank.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Account implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6092680786377511039L;

	@Id
	@GeneratedValue
	private String accountId;

	@NotNull(message = "error.accountStatus.notnull")
	private String accountStatus;
	
	private String description;

	@NotNull(message = "error.accountName.notnull")
	private String accountName;
	
	private Double amount;

	public Account() {}
	
	public Account(String accountStatus, String description, String accountName, Double amount) {
		this.accountName = accountName;
		this.description = description;
		this.accountStatus = accountStatus;
		this.amount = amount;
	}

	public String getAccountId() {
		return accountId;
	}
	
	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
	public String getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	
}
