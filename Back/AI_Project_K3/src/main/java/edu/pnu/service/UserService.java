package edu.pnu.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import edu.pnu.DTO.UserDTO;
import edu.pnu.Repository.UserRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService {
     private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public Integer saveUser(UserDTO userDTO) {
        // 패스워드 암호화
        userDTO.setUser_pw(passwordEncoder.encode(userDTO.getUser_pw()));
        userDTO.setUser_pw_chk(passwordEncoder.encode(userDTO.getUser_pw_chk()));
        userRepository.save(userDTO.toEntity());
        return userDTO.getId();
    }
}
