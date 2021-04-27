package com.example.demo.MainService;

import java.util.List;

import com.example.demo.Model.CrediatorModel;

public interface CrediatorSrevice {

	public List<CrediatorModel> getAllCrediator();
	
	public void savedCrediator(CrediatorModel crediator);
}
