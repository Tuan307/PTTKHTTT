package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.ThanhVien;

public interface ThanhVienDAO extends JpaRepository<ThanhVien, Integer>{

	ThanhVien findByUserName(String username);
}
