package edu.pnu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.UserEntity;
import edu.pnu.service.UserService;

@RestController
public class UserController {
    
	@Autowired
	private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<String> signUp(@RequestBody UserEntity user) {
        try {
        	userService.createUser(user);
        	return ResponseEntity.ok("계정이 생성되었습니다.");
        }
        catch(Exception e) {
        	e.printStackTrace();
        	return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
