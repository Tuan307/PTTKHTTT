package com.example.demo.model;


import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import lombok.Data;

@Data
@Entity(name = "tblTheLoai")
public class Kieu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String ten;
    private String mota;
    
    @ManyToMany(mappedBy = "listTheLoai")
    private Collection<TrangPhuc> listTrangPhuc;
}