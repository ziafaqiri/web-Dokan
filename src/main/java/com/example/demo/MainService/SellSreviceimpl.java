package com.example.demo.MainService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.MainRepository.SellRepository;
import com.example.demo.Model.SellModel;

@Service
public class SellSreviceimpl  implements SellSrevice{

	@Autowired
	private SellRepository repository;
	
	@Override
	public List<SellModel> gerallSell() {
		
		return repository.findAll();
	}

}
