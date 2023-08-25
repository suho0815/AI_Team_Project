package edu.pnu.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.pnu.domain.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer>{
    
}
