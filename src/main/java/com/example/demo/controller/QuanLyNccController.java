package com.example.demo.controller;





import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.NhaCungCap;
import com.example.demo.repository.NhaCungCapDAO;


@Controller
public class QuanLyNccController {
    @Autowired
    private NhaCungCapDAO nhaCungCapDAO;
    
    @GetMapping("/managencc")
    public String getManage(){
        return "managencc/QuanLyThongTinNCCView";
    }
    @GetMapping("/managencc/add")
    public String getAddManage(){
        return "managencc/add/ThemNccView";
    }
    @PostMapping("/managencc/add")
    public String postAddManage(@ModelAttribute NhaCungCap nhaCungCap){
        nhaCungCapDAO.save(nhaCungCap);
        return "redirect:/managencc";
    }
    @GetMapping("/managencc/edit/search")
    public String getEditSearch(@Param("keyword") String keyword,Model model){
        if(keyword == null) return "managencc/edit/searchncc" ;
        List<NhaCungCap> listNcc = nhaCungCapDAO.findAllByTenContaining(keyword);
        model.addAttribute("listNcc", listNcc);
        return "managencc/edit/TimKiemNCCView.html";
    }
    @GetMapping("/managencc/edit/{id}")
    public String getEdit(@PathVariable(name="id") int id,Model model){
        Optional<NhaCungCap> nhaCungCap = nhaCungCapDAO.findById(id);
        if(nhaCungCap.isEmpty()) return "error"; 
         model.addAttribute("nhaCungCap", nhaCungCap.get());
         System.out.print("Haha");
        return "managencc/SuaNccView";
    }
    @PostMapping("/managencc/edit/{id}")
    public String postEdit(@PathVariable(name="id") int id,@ModelAttribute NhaCungCap nhaCungCap){
        nhaCungCapDAO.save(nhaCungCap);
        System.out.print("Hehe");
        return "redirect:/managencc/edit/search";
    }
//    @GetMapping("/manage/delete/search")
//    public String getDeleteSearch(@Param("keyword") String keyword,Model model){
//        if(keyword == null) return "SearchDeleteNccView" ;
//        List<NhaCungCap> listNcc = nhaCungCapDAO.findAllByTenContaining(keyword);
//        model.addAttribute("listNcc", listNcc);
//        return "SearchDeleteNccView";
//    }
    @GetMapping("/managencc/delete/{id}")
    public String getDelete(@PathVariable(name="id") int id,Model model){
        Optional<NhaCungCap> nhaCungCap = nhaCungCapDAO.findById(id);
        if(nhaCungCap.isEmpty()) return "error"; 
        model.addAttribute("nhaCungCap", nhaCungCap.get());
        
        return "managencc/delete/DeleteNccView";
    }
    @PostMapping("/managencc/delete/{id}")
    public String postDelete(@PathVariable(name="id") int id,@ModelAttribute NhaCungCap nhaCungCap){
        nhaCungCapDAO.deleteById(id);;
        return "redirect:/managencc/edit/search";
    }
}