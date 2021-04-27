package com.example.demo.MainRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.EmployeeModel;


@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository<EmployeeModel , Integer>{

}
