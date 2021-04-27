package com.example.demo.MainService;

import java.util.List;

import com.example.demo.Model.EmployeeModel;

public interface service {

	
	public List<EmployeeModel> GetAllEmployee();
	
	public void SaveEmployee(EmployeeModel employee);
}
