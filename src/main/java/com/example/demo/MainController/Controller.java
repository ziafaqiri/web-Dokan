package com.example.demo.MainController;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.MainService.EmployeeService;
import com.example.demo.Model.EmployeeModel;
import org.apache.tomcat.util.buf.Utf8Decoder;
import org.apache.tomcat.util.buf.Utf8Encoder;
@org.springframework.stereotype.Controller
@CrossOrigin(origins = "*")

public class Controller {

	@Autowired
	private com.example.demo.MainRepository.Repository repository;
	
	@Autowired
	private EmployeeService service;
 	
	
	
	@PostMapping("/Employee/Add")
	public ResponseEntity<EmployeeModel> addEmployee(@RequestBody EmployeeModel employee) {
	
		EmployeeModel savedemployee = repository.save(employee);
		
		return new ResponseEntity<>(savedemployee , HttpStatus.CREATED);
	}
	
	@GetMapping("/employee/all")
	public ResponseEntity<List<EmployeeModel>> getallEmployee(){
		
		List<EmployeeModel> Employee = service.GetAllEmployee();
		return new ResponseEntity<>(Employee , HttpStatus.OK);
	}
	
	
	
	
}











