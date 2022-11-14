package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.dtos.AuthDTO;
import com.example.demo.model.ThanhVien;
import com.example.demo.repository.ThanhVienDAO;

@Controller
public class LoginController {
	
	@Autowired
	private ThanhVienDAO thanhVienDAO;
	
	@GetMapping("/")
	public String loginScreen() {
		return "LoginView";
	}
	
	@PostMapping("/")
	public String doLogin(@ModelAttribute AuthDTO authDTO) {
		ThanhVien thanhVien = thanhVienDAO.findByUserName(authDTO.getUserName());
		if(thanhVien == null) {
			return "error";
		}
		if(!authDTO.getPassword().equals(thanhVien.getPassword())) {
			return "error";
		}
		
		return "NhanvienquanlyView";
	}
}
