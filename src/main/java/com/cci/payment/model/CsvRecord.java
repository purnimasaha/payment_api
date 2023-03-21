package com.cci.payment.model;
//import com.opencsv.bean.CsvBindByPosition; 
public class CsvRecord {
	//@CsvBindByPosition(position = 0)
	public String accountId;
	//@CsvBindByPosition(position = 9)
	public String name;

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		}
}