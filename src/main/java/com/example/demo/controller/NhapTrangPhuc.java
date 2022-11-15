package com.example.demo.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.model.HoaDonNhap;
import com.example.demo.model.NhaCungCap;
import com.example.demo.model.ThanhVien;
import com.example.demo.model.TrangPhuc;
import com.example.demo.repository.HoaDonNhapDAO;
import com.example.demo.repository.NhaCungCapDAO;
import com.example.demo.repository.TrangPhucDAO;

@Controller
public class NhapTrangPhuc {
    @Autowired
    private TrangPhucDAO trangPhucDAO;
    @Autowired
    private NhaCungCapDAO nhaCungCapDAO;
    @Autowired
    private HoaDonNhapDAO hoaDonNhapDAO;
    
    @GetMapping("/nhaptp/SearchNcc")
    public String getSearchNcc(@Param("keyword") String keyword,Model model/*HttpSession session*/){
//    	ThanhVien tv = (ThanhVien) session.getAttribute("tv");
//    	if(tv == null) return "redirect:/login";
        if(keyword == null) return "nhaptrangphuc/TimKiemNCCView" ;
        List<NhaCungCap> listNcc = nhaCungCapDAO.findAllByTenContaining(keyword);
        if(listNcc.isEmpty()) return "error";
        model.addAttribute("listNcc", listNcc);
        return "nhaptrangphuc/TimKiemNCCView";
    }
    @GetMapping("/nhaptp/ncc/{id}")
    public String getSearchPhim(@PathVariable(name="id") int id,@Param("keyword") String keyword,Model model){
        if(keyword == null) return "nhaptrangphuc/TimKiemTrangPhuc" ;
        keyword = "%"+keyword+"%";
        List<TrangPhuc> listPhim = trangPhucDAO.getAllByNcc(id, keyword.toString());
        if(listPhim.isEmpty()) return "error";
        model.addAttribute("listPhim",listPhim);
        model.addAttribute("id",id);
        return "nhaptrangphuc/TimKiemTrangPhuc";
    }
    @GetMapping("/nhaptp/{nccId}/{tpId}")
    String getNhapTP(@PathVariable("tpId") int id, Model model){
        Optional<TrangPhuc> tp = trangPhucDAO.findById(id);
        if(tp.isEmpty()) return "error";
        model.addAttribute("tp", tp.get()); 
        return "nhaptrangphuc/nhaptp";
    }
    @PostMapping("/nhaptp/{nccId}/{tpId}")
    String postNhapPhim(@PathVariable("nccId") int nccId,@PathVariable("tpId") int tpId, @ModelAttribute("count") int count){
        Optional<TrangPhuc> tp = trangPhucDAO.findById(tpId);
        if(tp.isEmpty()) return "error";
        tp.get().setSoluongconchothue(tp.get().getSoluongconchothue()+count);
        trangPhucDAO.save(tp.get());
        Optional<NhaCungCap> ncc = nhaCungCapDAO.findById(nccId);
        HoaDonNhap h = new HoaDonNhap();
        h.setNhaCungCap(ncc.get());
        h.setTrangPhuc(tp.get());
        h.setNgayNhap(new Date());
        hoaDonNhapDAO.save(h);
        return "redirect:/nhaptp/SearchNcc";
    }
}