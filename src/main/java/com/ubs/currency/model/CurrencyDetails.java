package com.ubs.currency.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class CurrencyDetails implements Serializable {
	private static final long serialVersionUID = 1L;
	public int companyCode;
	public String account;
	public String city;
	public String country;
	public String creditRating;
	public String currency;
	public BigDecimal amount;
	public BigDecimal amountUSD;
	public BigDecimal amountEUR;
	public double amountDoubleEUR;
	public double getAmountDoubleEUR() {
		return amountDoubleEUR;
	}
	public void setAmountDoubleEUR(double amountDoubleEUR) {
		this.amountDoubleEUR = amountDoubleEUR;
	}
	public BigDecimal getAmountUSD() {
		return amountUSD;
	}
	public void setAmountUSD(BigDecimal amountUSD) {
		this.amountUSD = amountUSD;
	}
	public BigDecimal getAmountEUR() {
		return amountEUR;
	}
	public void setAmountEUR(BigDecimal amountEUR) {
		this.amountEUR = amountEUR;
	}
	public CurrencyDetails() {
		super();
	}
	public CurrencyDetails(int companyCode, String account, String city, String country, String creditRating,
			String currency, BigDecimal amount, BigDecimal amountUSD, BigDecimal amountEUR,
			double amountDoubleEUR) {
		super();
		this.companyCode = companyCode;
		this.account = account;
		this.city = city;
		this.country = country;
		this.creditRating = creditRating;
		this.currency = currency;
		this.amount = amount;
		this.amountUSD = amountUSD;
		this.amountEUR = amountEUR;
		this.amountDoubleEUR = amountDoubleEUR;
	}
	public int getCompanyCode() {
		return companyCode;
	}
	public void setCompanyCode(int companyCode) {
		this.companyCode = companyCode;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return this.country != null ? this.country:this.city;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCreditRating() {
		return creditRating;
	}
	public void setCreditRating(String creditRating) {
		this.creditRating = creditRating;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "CurrencyDetails [companyCode=" + companyCode + ", account=" + account + ", city=" + city + ", country="
				+ country + ", creditRating=" + creditRating + ", currency=" + currency + ", amount=" + amount
				+ ", amountUSD=" + amountUSD + ", amountEUR=" + amountEUR + ", amountDoubleEUR=" + amountDoubleEUR
				+ "]";
	}
}
