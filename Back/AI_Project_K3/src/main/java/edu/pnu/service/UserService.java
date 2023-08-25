package edu.pnu.service;

<<<<<<< HEAD
import java.util.List;

=======
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
>>>>>>> b9f9eee9a81cce4f053f65698aadfd5cb3ff4b09
import org.springframework.stereotype.Service;

import edu.pnu.domain.UserEntity;

@Service
<<<<<<< HEAD
public interface UserService {
	UserEntity getUser(UserEntity user);
	void createUser(UserEntity user);
	List<UserEntity> getAllUsers();
	UserEntity authenticate(String id, String pw);
		
=======
@AllArgsConstructor
public class UserService {
    @Autowired
    private UserRepository userRepository;

    private PasswordEncoder passwordEncoder;

    public Integer saveUser(UserDTO userDTO) {

        userDTO.setName(userDTO.getName());
        userDTO.setUser_id(userDTO.getUser_id());
        userDTO.setUser_pw(userDTO.getUser_pw());
        userDTO.setUser_pw_chk(userDTO.getUser_pw_chk());
        userDTO.setEmail(userDTO.getEmail());
        userDTO.setBirth(userDTO.getBirth()); 

        // 권한부여

        // 패스워드 암호화
        userDTO.setUser_pw(passwordEncoder.encode(userDTO.getUser_pw()));
        userDTO.setUser_pw_chk(passwordEncoder.encode(userDTO.getUser_pw_chk()));
        userRepository.save(userDTO.toEntity());
        return userDTO.getId();
    }
>>>>>>> b9f9eee9a81cce4f053f65698aadfd5cb3ff4b09
}
