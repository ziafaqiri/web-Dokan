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

import com.example.demo.MainRepository.CrediatorRepository;
import com.example.demo.MainService.CrediatorSreviceImp;
import com.example.demo.Model.CrediatorModel;
import com.example.demo.Model.borrower;

@Controller
@CrossOrigin("*")
public class CrediatorContoller {
	
	@Autowired
	private CrediatorSreviceImp srevice;

	@Autowired
	private CrediatorRepository repository;
	
	@GetMapping(path="/crediator/all")
	public ResponseEntity<List<CrediatorModel>> getallCrediator(){
	List<CrediatorModel> savedCrediator = srevice.getAllCrediator();
	
	return new ResponseEntity<List<CrediatorModel>>(savedCrediator ,  HttpStatus.OK);
	}
	
	
	@PostMapping("/crediator/Add")
	public ResponseEntity<CrediatorModel> addCrediator(@RequestBody CrediatorModel crediator) {
	
		CrediatorModel savedcredaitor = repository.save(crediator);
		
		return new ResponseEntity<CrediatorModel>(savedcredaitor , HttpStatus.CREATED);
	}
	
}
