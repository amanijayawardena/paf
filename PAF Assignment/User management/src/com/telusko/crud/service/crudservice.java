package com.telusko.crud.service;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.telusko.crud.model.crudmodel;


public class crudservice {

	
	Connection con;
	
	
	public crudservice() {
		
		try {
		 String url=String.format("jdbc:mysql://localhost:3306/user");
		 String uname="root";
		 String pwd="Amani12@3";
		 
	
	     Class.forName("com.mysql.cj.jdbc.Driver");
	     con=DriverManager.getConnection(url,uname,pwd);
	     
	}catch(Exception e) {
		System.out.println(e+"data insert unsucess.");
	  }
	
	}	
	
	
	
	/* CREATE*/
	public crudmodel insertUser(crudmodel user) {
		String insert= "insert into person(id,name,address,electricityaccountnumber) values(?,?,?,?)";
		
		try {
			PreparedStatement ps = con.prepareStatement(insert);
			ps.setInt(1,user.getId());
			ps.setString(2,user.getName());
			ps.setString(3,user.getAddress());
			ps.setInt(4,user.getElectricityaccountnumber());
			
			ps.execute();
		}catch(Exception e) {
			System.out.println(e +"data insert unsucess.");
		}
		return user;
	}
	
	
	
	/*READ*/
	public ArrayList<crudmodel> getUser() throws SQLException{
		ArrayList<crudmodel> data = new ArrayList<crudmodel>();
		
		String select = "select * from person";
		PreparedStatement ps= con.prepareStatement(select);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			crudmodel model= new crudmodel();
			
			
			model.setId(rs.getInt("id"));
			model.setName(rs.getString("name"));// column name
			model.setAddress(rs.getString("address"));
			model.setElectricityaccountnumber(rs.getInt("electricityaccountnumber"));
			
			data.add(model);
		}
		
		return data;
		}
	
	
	
	/*READ USING ID*/
	public ArrayList<crudmodel> getUserById(int id) throws SQLException{
		
		
		ArrayList<crudmodel> data = new ArrayList<crudmodel>();
		String select = "select * from person where id=? ";
		PreparedStatement ps= con.prepareStatement(select);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			crudmodel model= new crudmodel();
			
			model.setId(rs.getInt("id"));
			model.setName(rs.getString("name"));// column name
			model.setAddress(rs.getString("address"));
			model.setElectricityaccountnumber(rs.getInt("electricityaccountnumber"));
			
			data.add(model);
		}
		
		return data;
	}
	
	
	
	/*UPDATE*/
	public crudmodel updateUser(crudmodel user) {
		String insert= "update  person set name=? ,address=?, id=electricityaccountnumber=?";
		
		try {
			PreparedStatement ps = con.prepareStatement(insert);
			
			ps.setInt(1,user.getId());
			ps.setString(2,user.getName());
			ps.setString(3,user.getAddress());
			ps.setInt(4,user.getElectricityaccountnumber());
			
			ps.execute();
		}catch(Exception e) {
			System.out.println(e +"data insert unsucess.");
		}
		return user;
	}
	
	
	
	/*DELETE*/
	public int deleteUser(int id) {
		String insert= "delete from where id=?";
		
		try {
			PreparedStatement ps = con.prepareStatement(insert);
		  	
			ps.setInt(1,id);
			
			ps.execute();
		}catch(Exception e) {
			System.out.println(e +"data insert unsucess.");
		}
		return id;
	}
	
	
	}

