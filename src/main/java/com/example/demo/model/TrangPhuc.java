package com.example.demo.model;

import java.util.Collection;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity(name = "tblTrangPhuc")
public class TrangPhuc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String ten;
    private String anh;
    private int gia;
    private String xuatxu;
    private String mota;
    private int soluongconchothue;
    
    @OneToMany(mappedBy =  "trangPhuc")
    private Collection<HoaDonNhap> listHoaDonNhap;

    @ManyToMany
    @JoinTable(name = "tbl_Kieu",joinColumns = @JoinColumn(name="trang_phuc_id"),inverseJoinColumns = @JoinColumn(name="kieu_id"))
    private Collection<Kieu> listTheLoai;
}
