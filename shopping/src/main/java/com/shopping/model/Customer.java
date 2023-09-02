package com.shopping.model;

public class Customer {

	private int customerId;
	private String customerName;
	private String Gender;
	private long contactNo;
	private String email;
	private String address;
	private int pincode;
	private String username;
	private String password;
	

	public Customer(int customerId, String customerName, String gender, long contactNo, String email, String address,
			int pincode, String username, String password) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		Gender = gender;
		this.contactNo = contactNo;
		this.email = email;
		this.address = address;
		this.pincode = pincode;
		this.username = username;
		this.password = password;
	}
	
	
	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public long getContactNo() {
		return contactNo;
	}
	public void setContactNo(long contactNo) {
		this.contactNo = contactNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	
}
