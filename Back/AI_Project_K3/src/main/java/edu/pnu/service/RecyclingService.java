package edu.pnu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.pnu.domain.Recycling;
import edu.pnu.persistence.RecyclingRepository;

@Service
public class RecyclingService {

	@Autowired
	RecyclingRepository recycleRepo;
	
	public List<Recycling> getAllRecyclings(){
		return recycleRepo.findAll();
	}
}
