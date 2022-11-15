package com.example.demo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;
import javax.persistence.Id;
import javax.persistence.Inheritance;

import lombok.Data;
@Entity(name = "tblThanhVien")
@Inheritance(strategy= InheritanceType.TABLE_PER_CLASS)
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
	
//    @ManyToOne
//    @JoinColumn(name = "tblDiaChiId")
//    private DiaChi diaChi;
    
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
