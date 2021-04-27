package com.example.demo.MainController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.MainRepository.ExpensiveRepository;
import com.example.demo.MainService.ExpensiveSreviceimpl;
import com.example.demo.Model.ExpenseModel;
import com.example.demo.Model.borrower;

@Controller
@CrossOrigin("*")
public class ExpensiveContoroller {

	@Autowired
	private ExpensiveSreviceimpl srevice;
	
	
	@Autowired
	private ExpensiveRepository repository;
	
	
	@GetMapping(path="/expensive/all")
	public ResponseEntity<List<ExpenseModel>> getAllExpensive(){
		List<ExpenseModel> expensive = srevice.getallExpensive();
		return new ResponseEntity<>(expensive , HttpStatus.OK);
	}
	
	
	@PostMapping("/expensive/Add")
	public ResponseEntity<ExpenseModel> addEmployee(@RequestBody ExpenseModel expensive) {
	
		ExpenseModel savedExpensive = repository.save(expensive);
		
		return new ResponseEntity<>(savedExpensive , HttpStatus.CREATED);
	}
	
	
}
