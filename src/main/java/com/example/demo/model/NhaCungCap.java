package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "Nhacungcap")
public class NhaCungCap {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	private String ten;
	private String diachi;
	private String sodienthoai;
	private String email;
	public NhaCungCap(int id, String ten, String diachi, String sodienthoai, String email) {
		super();
		this.id = id;
		this.ten = ten;
		this.diachi = diachi;
		this.sodienthoai = sodienthoai;
		this.email = email;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public String getDiachi() {
		return diachi;
	}
	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}
	public String getSodienthoai() {
		return sodienthoai;
	}
	public void setSodienthoai(String sodienthoai) {
		this.sodienthoai = sodienthoai;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public NhaCungCap() {
		super();
	}
	
	
}
