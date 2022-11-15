//package com.example.demo.model;
//
//import lombok.Data;
//
//import javax.persistence.*;
//import java.util.Set;
//
//@Entity
//@Table(name = "tblDiaChi")
//@Data
//public class DiaChi {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
//    private Integer id;
//
//    @Column(name = "sonha")
//    private String soNha;
//
//    @Column(name = "toanha")
//    private String toaNha;
//
//    @Column(name = "xompho")
//    private String xomPho;
//
//    @Column(name = "phuongxa")
//    private String phuongXa;
//
//    @Column(name = "quanhuyen")
//    private String quanHuyen;
//
//    @Column(name = "tinhthanh")
//    private String tinhThanh;
//
//    @OneToMany(mappedBy = "diaChi")
//    private Set<ThanhVien> thanhViens;
//
//    @OneToOne(mappedBy = "diaChi")
//    private NhaCungCap nhaCungCap;
//
//    public DiaChi() {
//    }
//}
