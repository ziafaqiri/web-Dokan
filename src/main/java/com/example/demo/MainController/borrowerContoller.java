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

import com.example.demo.MainRepository.borrowerRepository;
import com.example.demo.MainService.borrowerSreviceImp;
import com.example.demo.Model.EmployeeModel;
import com.example.demo.Model.borrower;

@Controller
@CrossOrigin(origins = "*")
public class borrowerContoller {
	
	@Autowired
	private borrowerSreviceImp srevice;
	
	@Autowired
	private borrowerRepository borrowerrepository;
	
	@GetMapping(path="/borrower/all")
	public ResponseEntity<List<borrower>> getAllborrower(){
		List<borrower> borrower = srevice.getallborrower();
		return new ResponseEntity<>(borrower , HttpStatus.OK);
	}
	
	
	@PostMapping("/borrower/Add")
	public ResponseEntity<borrower> addEmployee(@RequestBody borrower borrower) {
	
		borrower savedborrower = borrowerrepository.save(borrower);
		
		return new ResponseEntity<>(savedborrower , HttpStatus.CREATED);
	}
	
	
}
