package com.example.demo.repository;


import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.HoaDonNhap;



public interface HoaDonNhapDAO extends JpaRepository<HoaDonNhap,Integer> {
    @Query("select * from tblHoaDonNhap H where H.trangPhuc.id = ?1")
    HoaDonNhap getByTrangPhucId(int id);
}