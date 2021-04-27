package com.example.demo.MainService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.MainRepository.Repository;
import com.example.demo.Model.EmployeeModel;

@Service
public class EmployeeService implements service {

	@Autowired
	private Repository repository;
	
	@Override
	public  List<EmployeeModel> GetAllEmployee() {
		return repository.findAll();
	}

	@Override
	public void SaveEmployee(EmployeeModel employee) {
		
		this.repository.save(employee);
		
	}

	
	
}
