package com.example.demo.MainService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.MainRepository.ExpensiveRepository;
import com.example.demo.Model.ExpenseModel;

@Service
public class ExpensiveSreviceimpl implements ExpensiveSrevice {
	
	@Autowired
	private ExpensiveRepository repository;

	@Override
	public List<ExpenseModel> getallExpensive() {
	
		return repository.findAll();
	}

	
	
}
