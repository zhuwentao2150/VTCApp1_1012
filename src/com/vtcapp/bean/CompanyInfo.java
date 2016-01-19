package com.vtcapp.bean;

import java.io.Serializable;

public class CompanyInfo implements Serializable{
	
	private int companyId;
	private String companyName;
	private String companyTitle;
	private String companyWage;
	private String companyContent;
	private String companyAddress;
	private String companyDate;
	
	public CompanyInfo(){
		
	}
	
	
	public CompanyInfo(String companyName, String companyTitle,
			String companyWage, String companyContent, String companyAddress,
			String companyDate) {
		super();
		this.companyName = companyName;
		this.companyTitle = companyTitle;
		this.companyWage = companyWage;
		this.companyContent = companyContent;
		this.companyAddress = companyAddress;
		this.companyDate = companyDate;
	}


	public int getCompanyId() {
		return companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCompanyTitle() {
		return companyTitle;
	}
	public void setCompanyTitle(String companyTitle) {
		this.companyTitle = companyTitle;
	}
	public String getCompanyWage() {
		return companyWage;
	}
	public void setCompanyWage(String companyWage) {
		this.companyWage = companyWage;
	}
	public String getCompanyContent() {
		return companyContent;
	}
	public void setCompanyContent(String companyContent) {
		this.companyContent = companyContent;
	}
	public String getCompanyAddress() {
		return companyAddress;
	}
	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}
	public String getCompanyDate() {
		return companyDate;
	}
	public void setCompanyDate(String companyDate) {
		this.companyDate = companyDate;
	}
	
	

}
