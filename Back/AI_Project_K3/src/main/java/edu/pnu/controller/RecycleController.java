package edu.pnu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RecycleController {
		
	// test
	@GetMapping("/restAPI")
	public String RestAPI() {
		return "hi";
	}
	
	
}
