package edu.pnu.controller;

import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD
import org.springframework.http.ResponseEntity;
=======
>>>>>>> b9f9eee9a81cce4f053f65698aadfd5cb3ff4b09
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

<<<<<<< HEAD
import edu.pnu.domain.UserEntity;
import edu.pnu.service.UserService;
=======
import edu.pnu.DTO.UserDTO;
import edu.pnu.service.UserService;
import lombok.AllArgsConstructor;
>>>>>>> b9f9eee9a81cce4f053f65698aadfd5cb3ff4b09

@RestController
public class UserController {
<<<<<<< HEAD
    
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
=======
    @Autowired
    private final UserService userService;

    @PostMapping("/register")
    public Integer saveUser(@RequestBody UserDTO userDTO) {
        return userService.saveUser(userDTO);
>>>>>>> b9f9eee9a81cce4f053f65698aadfd5cb3ff4b09
    }
}
