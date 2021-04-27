package com.example.demo.MainRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.ExpenseModel;

@Repository
public interface ExpensiveRepository extends JpaRepository<ExpenseModel, Integer> {
 
}
