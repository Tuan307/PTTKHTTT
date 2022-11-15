package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.TrangPhuc;

public interface TrangPhucDAO extends JpaRepository<TrangPhuc, Integer>{
	 @Query(value =  "SELECT TP FROM tblTrangPhuc TP INNER JOIN tblHoaDonNhap H ON TP.id = H.trangPhuc.id AND H.nhaCungCap.id = :id AND H.ngayNhap IS NULL WHERE TP.ten LIKE :ten")
	    List<TrangPhuc> getAllByNcc(@Param("id") int id,@Param("ten") String ten);
}
