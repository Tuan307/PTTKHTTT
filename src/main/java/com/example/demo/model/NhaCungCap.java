package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import lombok.Data;

@Entity(name = "Nhacungcap")
@Data
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
//	@OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "tblDiaChiId", referencedColumnName = "id")
//    private DiaChi diaChi;
	public NhaCungCap() {
		super();
	}
	
	
}
