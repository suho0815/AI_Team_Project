package edu.pnu.config;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import edu.pnu.DTO.UserDTO;
import edu.pnu.Repository.UserRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserSecurity {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public Integer saveUser(UserDTO userDTO) {
        userDTO.setUser_pw(passwordEncoder.encode(userDTO.getUser_pw()));
        userDTO.setUser_pw(passwordEncoder.encode(userDTO.getUser_pw_chk()));
        return userDTO.getId();
    }
}
