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

import com.example.demo.MainRepository.ToolsRepository;
import com.example.demo.MainService.ToolsSrevice;
import com.example.demo.Model.CrediatorModel;
import com.example.demo.Model.Tools;

@Controller
@CrossOrigin("*")
public class ToolsContoller {
	
	@Autowired
	private ToolsSrevice srevice;
	
	@Autowired
	private ToolsRepository reposiotry;
	
	

	@GetMapping(path="/tool/all")
	public ResponseEntity<List<Tools>> getalltools(){
		
		List<Tools> savedTools = srevice.getAllTolls();
		return new ResponseEntity<List<Tools>>(savedTools , HttpStatus.OK);
		
	}
	
	@PostMapping("/tool/Add")
	public ResponseEntity<Tools> addTool(@RequestBody Tools tool) {
	
		Tools savedtool = reposiotry.save(tool);
		
		return new ResponseEntity<Tools>(savedtool , HttpStatus.CREATED);
	}
	
	
}
