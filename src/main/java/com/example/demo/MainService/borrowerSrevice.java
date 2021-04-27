package com.example.demo.MainService;

import java.util.List;

import com.example.demo.Model.borrower;

public interface borrowerSrevice {

	public List<borrower> getallborrower();
	
	public void Saveborrower(borrower borrower);
}
