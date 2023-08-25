package edu.pnu.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.pnu.domain.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer>{
    
}
