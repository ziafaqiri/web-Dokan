package com.example.demo.MainRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.SellModel;

@org.springframework.stereotype.Repository
public interface SellRepository extends JpaRepository<SellModel, Integer>{

}
