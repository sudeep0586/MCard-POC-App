package com.mc.demo.app.cardtranssimulator;

import java.sql.Timestamp;

public class TransactionHistory {

	private String transactionid;
	private String accountnumber;
	private String merchantname;
	private String merchantid;
	private double pointscaluclated;
	private String transcationtype;
	private Timestamp transactiontimestamp;
	private String transactionamount;
	private String currencycode;
	private String city;
	private String state;

	public String getTransactionid() {
		return transactionid;
	}

	public void setTransactionid(String transactionid) {
		this.transactionid = transactionid;
	}

	public String getAccountnumber() {
		return accountnumber;
	}

	public void setAccountnumber(String accountnumber) {
		this.accountnumber = accountnumber;
	}

	public String getMerchantname() {
		return merchantname;
	}

	public void setMerchantname(String merchantname) {
		this.merchantname = merchantname;
	}

	public String getMerchantid() {
		return merchantid;
	}

	public void setMerchantid(String merchantid) {
		this.merchantid = merchantid;
	}

	public double getPointscaluclated() {
		return pointscaluclated;
	}

	public void setPointscaluclated(double pointscaluclated) {
		this.pointscaluclated = pointscaluclated;
	}

	public String getTranscationtype() {
		return transcationtype;
	}

	public void setTranscationtype(String transcationtype) {
		this.transcationtype = transcationtype;
	}

	public Timestamp getTransactiontimestamp() {
		return transactiontimestamp;
	}

	public void setTransactiontimestamp(Timestamp transactiontimestamp) {
		this.transactiontimestamp = transactiontimestamp;
	}

	public String getTransactionamount() {
		return transactionamount;
	}

	public void setTransactionamount(String transactionamount) {
		this.transactionamount = transactionamount;
	}

	public String getCurrencycode() {
		return currencycode;
	}

	public void setCurrencycode(String currencycode) {
		this.currencycode = currencycode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}
