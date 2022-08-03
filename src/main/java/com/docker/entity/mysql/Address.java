package com.docker.entity.mysql;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "address")
public class Address {

    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "street")
    private String street;
    @Column(name = "country")
    private String country;
    
	public Address() {
		super();
	}
	public Address(Integer id, String street, String country) {
		super();
		this.id = id;
		this.street = street;
		this.country = country;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
}