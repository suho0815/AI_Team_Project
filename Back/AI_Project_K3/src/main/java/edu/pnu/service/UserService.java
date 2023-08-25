package edu.pnu.service;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.pnu.domain.UserEntity;

@Service
public interface UserService {
	UserEntity getUser(UserEntity user);
	void createUser(UserEntity user);
	List<UserEntity> getAllUsers();
	UserEntity authenticate(String id, String pw);
		
}
