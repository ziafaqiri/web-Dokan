package com.example.demo.MainService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.MainRepository.CrediatorRepository;
import com.example.demo.Model.CrediatorModel;

@Service
public class CrediatorSreviceImp implements CrediatorSrevice{

	@Autowired
	private CrediatorRepository crediatorrepository;
	
	@Override
	public List<CrediatorModel> getAllCrediator() {
		return crediatorrepository.findAll();
	}

	@Override
	public void savedCrediator(CrediatorModel crediator) {
		
		 crediatorrepository.save(crediator);
	}

}
