package org.dev.commerce.bank.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class MoneyTransfer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6657829447933686859L;

	@Id
	@GeneratedValue
	private String transactionId;

	@NotNull(message = "error.transactionStatus.notnull")
	private String transactionStatus;
	
	private String description;

	@NotNull(message = "error.srcAccount.notnull")
	private Account srcAccount;

	@NotNull(message = "error.destAccount.notnull")
	private Account destAccount;

	@NotNull(message = "error.amount.notnull")
	private Double amount;

	public MoneyTransfer() {}
	
	public MoneyTransfer(String transactionStatus, String description, Account srcAccount, Account destAccount, Double amount) {
		this.srcAccount = srcAccount;
		this.destAccount = destAccount;
		this.description = description;
		this.transactionStatus = transactionStatus;
		this.amount = amount;
	}

	public String getTransactionStatus() {
		return transactionStatus;
	}

	public void setTransactionStatus(String transactionStatus) {
		this.transactionStatus = transactionStatus;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Account getSrcAccount() {
		return srcAccount;
	}

	public void setSrcAccount(Account srcAccount) {
		this.srcAccount = srcAccount;
	}

	public Account getDestAccount() {
		return destAccount;
	}

	public void setDestAccount(Account destAccount) {
		this.destAccount = destAccount;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}
		
}
