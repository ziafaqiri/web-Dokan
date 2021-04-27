package com.example.demo.MainService;

import java.util.List;

import com.example.demo.Model.Tools;

public interface ToolsSrevice {

	public List<Tools> getAllTolls();
	
	public Tools AddTool(Tools tool);
}
