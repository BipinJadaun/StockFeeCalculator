package com.genius.model;

import java.util.Date;

public class Transaction {

	private String extTransactionId;
	private String clientID;
	private String securityID;
	private String transactionType;
	private Date transactionDate;
	private double marketValue;
	private String priority;
	private double processingFee;
	
	
	public String getExtTransactionId() {
		return extTransactionId;
	}
	public void setExtTransactionId(String extTransactionId) {
		this.extTransactionId = extTransactionId;
	}
	public String getClientID() {
		return clientID;
	}
	public void setClientID(String clientID) {
		this.clientID = clientID;
	}
	public String getSecurityID() {
		return securityID;
	}
	public void setSecurityID(String securityID) {
		this.securityID = securityID;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public Date getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
	public double getMarketValue() {
		return marketValue;
	}
	public void setMarketValue(double marketValue) {
		this.marketValue = marketValue;
	}	
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public double getProcessingFee() {
		return processingFee;
	}
	public void setProcessingFee(double processingFee) {
		this.processingFee = processingFee;
	}
	@Override
	public String toString() {
		return "Transaction [extTransactionId=" + extTransactionId + ", clientID=" + clientID + ", securityID="
				+ securityID + ", transactionType=" + transactionType + ", transactionDate=" + transactionDate
				+ ", marketValue=" + marketValue + ", priority=" + priority + ", processingFee=" + processingFee + "]";
	}
}
