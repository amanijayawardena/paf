package com.telusko.crud.model;

public class crudmodel {

	private int id;
	private String name;
	private String address;
	private int electricityaccountnumber;
	
	
	
	



	public crudmodel(int id, String name, String address, int electricityaccountnumber) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.electricityaccountnumber = electricityaccountnumber;
	}



	public crudmodel() {
		// TODO Auto-generated constructor stub
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public int getElectricityaccountnumber() {
		return electricityaccountnumber;
	}



	public void setElectricityaccountnumber(int electricityaccountnumber) {
		this.electricityaccountnumber = electricityaccountnumber;
	}




	
	
	
}
