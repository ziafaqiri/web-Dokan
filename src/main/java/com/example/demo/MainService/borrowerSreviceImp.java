package com.example.demo.MainService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.MainRepository.borrowerRepository;
import com.example.demo.Model.borrower;

@Service
public class borrowerSreviceImp implements borrowerSrevice {
	
	@Autowired
	private borrowerRepository borrowerdrepository;

	@Override
	public List<borrower> getallborrower() {
		
		return borrowerdrepository.findAll();
	}

	@Override
	public void Saveborrower(borrower borrower) {
		
		this.borrowerdrepository.save(borrower);
		
	}

}
