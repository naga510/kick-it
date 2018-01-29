package com.src.kick.domain;

import java.util.Date;

public class Player {

	private String name;
	private String position;
	private Integer jerseyNumber;
	private Date dateOfBirth;	
	private String nationality;
	private Date contractUntil;
	private String marketValue;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public Integer getJerseyNumber() {
		return jerseyNumber;
	}
	public void setJerseyNumber(Integer jerseyNumber) {
		this.jerseyNumber = jerseyNumber;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public Date getContractUntil() {
		return contractUntil;
	}
	public void setContractUntil(Date contractUntil) {
		this.contractUntil = contractUntil;
	}
	public String getMarketValue() {
		return marketValue;
	}
	public void setMarketValue(String marketValue) {
		this.marketValue = marketValue;
	}
	
	
	
}
