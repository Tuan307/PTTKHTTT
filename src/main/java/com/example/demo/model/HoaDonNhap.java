package com.example.demo.model;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity(name = "tblHoaDonNhap")
public class HoaDonNhap {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private  int id;
    private Date ngayNhap;
    @ManyToOne
    @JoinColumn(name = "nha_cung_cap_id")
    private NhaCungCap nhaCungCap;
    @ManyToOne 
    @JoinColumn(name = "trang_phuc_id")
    private TrangPhuc trangPhuc;
}
