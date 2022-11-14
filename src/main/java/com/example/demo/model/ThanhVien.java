package com.example.demo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import lombok.Data;
@Entity(name = "tblThanhVien")
@Data
public class ThanhVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String ten;
    private String userName;
    private String address;
    private String password;
    private Date dob;
    private String vitri;
    private String email;
    private String sdt;
	
    
    public ThanhVien(int id, String ten, String userName, String address, String password, Date dob,String vitri, String email,
			String sdt) {
		super();
		this.id = id;
		this.ten = ten;
		this.userName = userName;
		this.address = address;
		this.password = password;
		this.dob = dob;
		this.vitri = vitri;
		this.email = email;
		this.sdt = sdt;
	}
    
	public ThanhVien() {
		super();
	}
	
    
    
    
}
