package com.example.demo.MainRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.Tools;

@Repository
public interface ToolsRepository extends JpaRepository<Tools, Integer> {

}
