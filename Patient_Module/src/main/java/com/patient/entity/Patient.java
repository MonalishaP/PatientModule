package com.patient.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity //it calls the entity class
@Table(name="pat")  //it specifies the table in database

public class Patient {
    @Id  //it specifies the primary key of the entity
    @GeneratedValue(strategy = GenerationType.UUID) //it is used for conjuction 
    //UUID(universally unique identifier) it is used for identify information
    private String patientid;
    private String name;
    private String address;
    
    private String email;
    private String mobile;
	public String getPatientid() {
		return patientid;
	}
	public void setPatientid(String patientid) {
		this.patientid = patientid;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public Patient(String patientid, String name, String address,
		
			String mobile) {
		super();
		this.patientid = patientid;
		this.name = name;
		this.address = address;
		this.email = email;
		this.mobile = mobile;
	}
	public Patient() {
		super();
	}
    }

