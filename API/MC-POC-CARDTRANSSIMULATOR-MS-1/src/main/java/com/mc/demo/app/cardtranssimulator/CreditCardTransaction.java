package com.mc.demo.app.cardtranssimulator;

import java.sql.Timestamp;

import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreditCardTransaction {
		
	@JsonProperty(value = "creditCardNumber", required = true)
	@NotEmpty(message = "Card Number is required")
	private String creditCardNumber;
	
	@JsonProperty(value = "merchantname", required = true)
	@NotEmpty(message = "merchantName is required")
	private String merchantName;
	
	@JsonProperty(value = "merchantid", required = true)
	@NotEmpty(message = "MerchantId is required")
	private String merchantId;
	
	@JsonProperty(value = "transcationtype", required = true)
	@NotEmpty(message = "TransactionType is required")
	private String transcationtype;
	
	@JsonProperty(value = "transactionamount", required = true)
	@NotEmpty(message = "Amount is required")
	private String transactionamount;
	
	private String city;
	
	private String state;
	
	private Timestamp transactionTimestamp;
		
	
	/**
	 * @return the creditCardNumber
	 */
	public String getCreditCardNumber() {
		return creditCardNumber;
	}
	/**
	 * @param creditCardNumber the creditCardNumber to set
	 */
	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}
	/**
	 * @return the mechantName
	 */
	public String getMerchantName() {
		return merchantName;
	}
	/**
	 * @param mechantName the mechantName to set
	 */
	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}
	/**
	 * @return the merchantId
	 */
	public String getMerchantId() {
		return merchantId;
	}
	/**
	 * @param merchantId the merchantId to set
	 */
	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}
	/**
	 * @return the transcationtype
	 */
	public String getTranscationtype() {
		return transcationtype;
	}
	/**
	 * @param transcationtype the transcationtype to set
	 */
	public void setTranscationtype(String transcationtype) {
		this.transcationtype = transcationtype;
	}
	/**
	 * @return the transactionamount
	 */
	public String getTransactionamount() {
		return transactionamount;
	}
	/**
	 * @param transactionamount the transactionamount to set
	 */
	public void setTransactionamount(String transactionamount) {
		this.transactionamount = transactionamount;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
	 * @return the transactionTimestamp
	 */
	public Timestamp getTransactionTimestamp() {
		return transactionTimestamp;
	}
	/**
	 * @param transactionTimestamp the transactionTimestamp to set
	 */
	public void setTransactionTimestamp(Timestamp transactionTimestamp) {
		this.transactionTimestamp = transactionTimestamp;
	}
	
}
