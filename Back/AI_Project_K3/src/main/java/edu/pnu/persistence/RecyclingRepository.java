package edu.pnu.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.pnu.domain.Recycling;

public interface RecyclingRepository extends JpaRepository<Recycling, String> {

}
