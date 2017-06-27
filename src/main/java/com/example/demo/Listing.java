package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Listing {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@NotNull
	@Size(min=2, max=30)
	private String address;
	@NotNull
	@Size(min=2, max=30)
	private String city;
	@NotNull
	@Size(min=2, max=30)
	private String state;
	@NotNull
	@Size(min=2, max=30)
	private String price;
	
	private String description;
	private String rules;
	private String wifi;
	private String cable;
	private String privateBathroom;
	private String isRented;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getRules() {
		return rules;
	}
	public void setRules(String rules) {
		this.rules = rules;
	}
	public String getWifi() {
		return wifi;
	}
	public void setWifi(String wifi) {
		this.wifi = wifi;
	}
	public String getCable() {
		return cable;
	}
	public void setCable(String cable) {
		this.cable = cable;
	}
	public String getPrivateBathroom() {
		return privateBathroom;
	}
	public void setPrivateBathroom(String privateBathroom) {
		this.privateBathroom = privateBathroom;
	}
	public String getIsRented() {
		return isRented;
	}
	public void setIsRented(String isRented) {
		this.isRented = isRented;
	}
	
	
}
