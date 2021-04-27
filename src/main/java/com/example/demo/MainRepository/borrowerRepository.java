package com.example.demo.MainRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.borrower;

@Repository
public interface borrowerRepository extends JpaRepository<borrower,Integer>{

}
