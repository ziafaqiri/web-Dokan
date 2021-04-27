package com.example.demo.MainService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.MainRepository.ToolsRepository;
import com.example.demo.Model.Tools;

@Service
public class ToolsServiceImp implements ToolsSrevice {
	
	@Autowired
	private ToolsRepository repository;

	@Override
	public List<Tools> getAllTolls() {
		
		return repository.findAll();
	}

	@Override
	public Tools AddTool(Tools tool) {
		Tools savedtool  = repository.save(tool);
		
		return savedtool;
	}

}
