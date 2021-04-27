package com.example.demo.MainRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.CrediatorModel;

@Repository
public interface CrediatorRepository extends JpaRepository<CrediatorModel, Integer> {

}
