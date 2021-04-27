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

import com.example.demo.MainRepository.SellRepository;
import com.example.demo.MainService.SellSreviceimpl;
import com.example.demo.Model.CrediatorModel;
import com.example.demo.Model.SellModel;

@Controller
@CrossOrigin("*")
public class SellController {

	@Autowired
	private SellSreviceimpl srevice;
	
	@Autowired
	private SellRepository repository;
	
	@GetMapping(path="/sell/all")
	public ResponseEntity<List<SellModel>> getallSell(){
		List<SellModel> savedSell = srevice.gerallSell();
		
		return new ResponseEntity<List<SellModel>>(savedSell ,  HttpStatus.OK);
		}
	
	
	@PostMapping(path="/sell/Add")
	public ResponseEntity<SellModel> addSell(@RequestBody SellModel sell) {
	
		SellModel savedsell = repository.save(sell);
		
		return new ResponseEntity<SellModel>(savedsell , HttpStatus.CREATED);
	}
}
