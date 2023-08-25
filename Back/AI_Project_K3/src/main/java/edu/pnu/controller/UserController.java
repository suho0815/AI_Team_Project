package edu.pnu.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.DTO.UserDTO;
import edu.pnu.service.UserService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/user/save")
    public Integer saveUser(UserDTO userDTO) {
        return userService.saveUser(userDTO);
    }
}
