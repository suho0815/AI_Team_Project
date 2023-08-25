package edu.pnu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.Recycling;
import edu.pnu.service.RecyclingService;

@RestController
public class RecycleController {

	@Autowired
	RecyclingService recycleService;
	
	
	@GetMapping("readAllRecycle")
	public List<Recycling> readDB(){
		return recycleService.getAllRecyclings();
	}
		
}
