package com.shopping.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.shopping.model.Customer;
import com.shopping.service.CustomerDaoService;
import com.shopping.util.DButil;

@Service 
public class customerDaoServiceImpl implements CustomerDaoService{

	ArrayList<Customer> customerList=new ArrayList<>();
	
	private static Connection connection = null;	
	public customerDaoServiceImpl() {
		try {
			connection = DButil.getConnection();
			System.out.println("connection: "+connection);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Override
	public List<Customer> getCustomer() {
		customerList.clear();
		String getCustomerQuery="SELECT * FROM customer";
		PreparedStatement stmt;
		
		try {
			stmt = connection.prepareStatement(getCustomerQuery);
			ResultSet rs =   stmt.executeQuery();//cust data will be stored in rs
			while(rs.next()) {
				Customer cust = new Customer();
				cust.setCustomerId(rs.getInt(1));  //1 is in database 1st colm
				cust.setCustomerName(rs.getString(2));
				cust.setGender(rs.getString(3));
				cust.setContactNo(rs.getLong(4));
				cust.setEmail(rs.getString(5));
				cust.setAddress(rs.getString(6));
				cust.setPincode(rs.getInt(7));
				cust.setUsername(rs.getString(8));
				cust.setPassword(rs.getString(9));
				customerList.add(cust);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return customerList;
	}

	@Override
	public void addCustomer(Customer customer) {
		int customerId=customer.getCustomerId();
		String customerName=customer.getCustomerName();
		String Gender=customer.getGender();
		long contactNo=customer.getContactNo();
		String email=customer.getEmail();
		String address=customer.getAddress();
		int pincode=customer.getPincode();
		
		String insertQuery ="INSERT INTO Customer VALUES("+ customerId+",'"+customerName+"','"+Gender+"',"+contactNo+",'"+email+"','"+address+"',"+pincode+")";
		
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement(insertQuery);
			stmt.executeUpdate();
			System.out.println("customer added successfully!!");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//ResultSet rs =   stmt.executeQuery();
	}

	@Override
	public boolean customerLoginValidation(String username, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		int customerId=customer.getCustomerId();
		String customerName=customer.getCustomerName();
		String Gender=customer.getGender();
		long contactNo=customer.getContactNo();
		String email=customer.getEmail();
		String address=customer.getAddress();
		int pincode=customer.getPincode();
		String username=customer.getUsername();
		String password=customer.getPassword();
		
		
		
		String updateQuery="UPDATE customer SET customerName='"+customerName+"',Gender='"+Gender+"',contactNo="+contactNo+",email='"+email+"',address='"+address+"',pincode="+pincode+",username='"+username+"',password='"+password+"' WHERE customerId='"+customerId+"'";
		//String updateQuery="UPDATE customer SET customerId="+customerId+",Gender='"+Gender+"',contactNo="+contactNo+",email='"+email+"',address='"+address+"',pincode="+pincode+",username='"+username+"',password='"+password+"' WHERE customerName='"+customerName+"'";

		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement(updateQuery);
			stmt.executeUpdate();
			System.out.println("customer data updated successfully!!");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deleteCustomer(String username) {

		//DELETE FROM CUSTOMER WHERE username=""
		String deleteQuery="DELETE FROM CUSTOMER WHERE username= '"+username+"'";
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement(deleteQuery);
			stmt.executeUpdate();
			System.out.println("customer data delete successfully!!");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
}
